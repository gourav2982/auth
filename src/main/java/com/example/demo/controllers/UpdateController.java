package com.example.demo.controllers;

import com.example.demo.dto.UpdateRequest;
import com.example.demo.dto.UpdateResponse;
import com.example.demo.models.User;
import com.example.demo.services.ProfileUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/update")
@RequiredArgsConstructor
public class UpdateController {
    private final ProfileUpdateService profileUpdateService;
    @PutMapping("/profileUpdate")
    public UpdateResponse updateProfile(@RequestBody UpdateRequest user){
        return profileUpdateService.updateService(user);
    }
}
