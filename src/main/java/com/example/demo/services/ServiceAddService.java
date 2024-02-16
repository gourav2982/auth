package com.example.demo.services;

import com.example.demo.dto.ServiceFRequest;
import com.example.demo.dto.ServiceFResponse;
import com.example.demo.models.ServicesF;
import com.example.demo.repositories.ServiceFRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServiceAddService {
    final private ServiceFRepo serviceFRepo;
    public ServiceFResponse createService(ServiceFRequest serviceFRequest){
        ServiceFResponse serviceFResponse = ServiceFResponse.builder()
                .ownedBy(serviceFRequest.getOwnedBy())
                .address(serviceFRequest.getAddress())
                .serviceType(serviceFRequest.getServiceType())
                .pin(serviceFRequest.getPin())
                .build();
        ServicesF servicesF = ServicesF.builder()
                        .ownedBy(serviceFRequest.getOwnedBy())
                                .pin(serviceFRequest.getPin())
                                        .serviceType(serviceFRequest.getServiceType())
                                                .address(serviceFRequest.getAddress())
                                                        .build();
        serviceFRepo.save(servicesF);
        return serviceFResponse;
    }
}
