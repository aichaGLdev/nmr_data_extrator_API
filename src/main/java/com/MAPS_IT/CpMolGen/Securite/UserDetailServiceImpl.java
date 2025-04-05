package com.MAPS_IT.CpMolGen.Securite;

import com.MAPS_IT.CpMolGen.role.Role;
import com.MAPS_IT.CpMolGen.role.RoleRepository;
import com.MAPS_IT.CpMolGen.user.User;
import com.MAPS_IT.CpMolGen.user.UserRepository;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {
private final UserRepository repository;


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String useremail) throws UsernameNotFoundException {
        return repository.findByEmail(useremail)
                .orElseThrow(()->new UsernameNotFoundException("User not found"));
    }
}
