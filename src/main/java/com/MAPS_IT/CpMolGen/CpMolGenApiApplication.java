package com.MAPS_IT.CpMolGen;

import com.MAPS_IT.CpMolGen.role.Role;
import com.MAPS_IT.CpMolGen.role.RoleRepository;
import com.MAPS_IT.CpMolGen.user.User;
import com.MAPS_IT.CpMolGen.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootApplication
@EnableJpaAuditing
@EnableAsync
public class CpMolGenApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CpMolGenApiApplication.class, args);
	}
	@Bean
	public CommandLineRunner runner(RoleRepository roleRepository ,
									UserRepository userRepository , PasswordEncoder passwordEncoder) {
		return args -> {
			if (roleRepository.findByName("USER").isEmpty()) {
				roleRepository.save(Role.builder().name("USER").build());
			}
			if (roleRepository.findByName("ROLE_ADMIN").isEmpty()) {
				roleRepository.save(Role.builder().name("ROLE_ADMIN").build());
			}
			if (!userRepository.findByEmail("admin@example.com").isPresent()) {

				var adminRole = roleRepository.findByName("ROLE_ADMIN")
						// todo - better exception handling
						.orElseThrow(() -> new IllegalStateException("ROLE_ADMIN was not initiated"));

				User adminUser = new User();
				adminUser.setFirstname("Admin");
				adminUser.setLastname("User");
				adminUser.setEmail("admin@example.com");
				adminUser.setPassword(passwordEncoder.encode("adminpassword"));
				adminUser.setEnabled(true);
				adminUser.setAccountLocked(false);
				adminUser.setRoles(List.of(adminRole));
				userRepository.save(adminUser);
			}
		};
	}
}
