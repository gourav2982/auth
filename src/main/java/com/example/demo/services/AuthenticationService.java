package com.example.demo.services;


import com.example.demo.dto.JwtAuthenticationResponse;
import com.example.demo.dto.SignInRequest;
import com.example.demo.dto.SignUpRequest;
import com.example.demo.models.Role;
import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

  private final UserRepository userRepository;
  private final UserService userService;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;

  public JwtAuthenticationResponse signup(SignUpRequest request) {
      var user = User
                  .builder()
                  .uname(request.getUname())
                  .email(request.getEmail())
                    .phone(request.getPhone())
                    .address(request.getAddress())
              .pin(request.getPin())
                  .password(passwordEncoder.encode(request.getPassword()))
                  .role(request.getRole())
                  .build();

      user = userService.save(user);
      var jwt = jwtService.generateToken(user);
      return JwtAuthenticationResponse
              .builder()
              .token(jwt)
              .id(user.getId())
              .username(user.getUname())
              .email(user.getEmail())
              .address(user.getAddress())
              .phone(user.getPhone())
              .build();
  }


  public JwtAuthenticationResponse signin(SignInRequest request) {
      authenticationManager.authenticate(
              new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
      var user = userRepository.findByEmail(request.getEmail())
              .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
      var jwt = jwtService.generateToken(user);
      return JwtAuthenticationResponse.builder().token(jwt).id(user.getId()).username(user.getUname()).email(user.getEmail()).address(user.getAddress())
              .phone(user.getPhone()).build();
  }
  
}
