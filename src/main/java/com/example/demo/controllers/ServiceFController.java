package com.example.demo.controllers;

import com.example.demo.dto.ServiceFRequest;
import com.example.demo.dto.ServiceFResponse;
import com.example.demo.services.ServiceAddService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/service")
@RequiredArgsConstructor
public class ServiceFController {
    final private ServiceAddService serviceAddService;
    @PostMapping("/addService")
    public ServiceFResponse addService(@RequestBody ServiceFRequest serviceFRequest){
        return serviceAddService.createService(serviceFRequest);
    }
}
