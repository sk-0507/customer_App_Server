package com.example.demo.customerServices;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.customerRepository.UserInterface;
import com.example.demo.dtos.LoginUserDto;
import com.example.demo.dtos.RegisterUserDto;
import com.example.demo.model.User;

@Service
public class AuthenticationService {
    private final  UserInterface userRepository;
    
    private final PasswordEncoder passwordEncoder;
    
    private final AuthenticationManager authenticationManager;
    
    public AuthenticationService(
    		UserInterface userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
        ) {
            this.authenticationManager = authenticationManager;
            this.userRepository = userRepository;
            this.passwordEncoder = passwordEncoder;
        }

        public User signup(RegisterUserDto input) {
            User user = new User();
                  user.setFullName(input.getFullName());
                    user.setEmail(input.getEmail());
                    user.setPassword(passwordEncoder.encode(input.getPassword()));

            return userRepository.save(user);
        }

        public User authenticate(LoginUserDto input) {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            input.getEmail(),
                            input.getPassword()
                    )
            );

            return userRepository.findByEmail(input.getEmail())
                    .orElseThrow();
        }
}
