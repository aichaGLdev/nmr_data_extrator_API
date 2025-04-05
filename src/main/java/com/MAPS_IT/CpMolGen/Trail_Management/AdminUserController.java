package com.MAPS_IT.CpMolGen.Trail_Management;

import com.MAPS_IT.CpMolGen.auth.RegistrationRequest;
import com.MAPS_IT.CpMolGen.role.Role;
import com.MAPS_IT.CpMolGen.role.RoleRepository;
import com.MAPS_IT.CpMolGen.user.User;
import com.MAPS_IT.CpMolGen.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin/users")
//@PreAuthorize("hasRole('USER')")
@RequiredArgsConstructor
public class AdminUserController {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/GetAll")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Endpoint pour ajouter un nouvel utilisateur par l'administrateur
    @PostMapping("/add")
    public ResponseEntity<String> addUserByAdmin(@RequestBody RegistrationRequest registrationRequest) {
        // Vérifier si l'email est déjà utilisé
        if (userRepository.findByEmail(registrationRequest.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("Email already in use");
        }

        // Récupérer le rôle USER depuis la base de données
        Role userRole = roleRepository.findByName("ROLE_USER")
                .orElseThrow(() -> new RuntimeException("Role not found"));

        // Créer un nouvel utilisateur avec le rôle USER
        User user = User.builder()
                .firstname(registrationRequest.getFirstname())
                .lastname(registrationRequest.getLastname())
                .email(registrationRequest.getEmail())
                .password(passwordEncoder.encode(registrationRequest.getPassword()))
                .roles(Collections.singletonList(userRole))
                .enabled(true)
                .accountLocked(false)
                .build();

        userRepository.save(user);

        return ResponseEntity.ok("User added successfully");
    }

    // Endpoint pour supprimer un utilisateur par l'administrateur
    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUserByAdmin(@PathVariable Integer userId) {
        // Vérifier si l'utilisateur existe dans la base de données
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        // Supprimer l'utilisateur
        userRepository.delete(optionalUser.get());

        return ResponseEntity.ok("User deleted successfully");
    }
}
