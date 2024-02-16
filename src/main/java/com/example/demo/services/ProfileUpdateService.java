package com.example.demo.services;

import com.example.demo.dto.UpdateRequest;
import com.example.demo.dto.UpdateResponse;
import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileUpdateService {
    private final UserRepository userRepository;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    public UpdateResponse updateService(UpdateRequest updateRequest){

        var user = userRepository.findByEmail(updateRequest.getEmail()).get();
        user.setProfilePic(updateRequest.getProfilePic());
        user.setAddress(updateRequest.getAddress());
        user.setUname(updateRequest.getUname());
        user.setPhone(updateRequest.getPhone());
        user.setPin(updateRequest.getPin());
        userService.save(user);
        return UpdateResponse.builder().message("Update Successful").build();
    }
}
