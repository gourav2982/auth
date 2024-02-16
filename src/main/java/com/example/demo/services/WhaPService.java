package com.example.demo.services;

import com.example.demo.dto.WhaPRequest;
import com.example.demo.dto.WhaPResponse;
import com.example.demo.models.WarehouseArea;
import com.example.demo.repositories.WarehouseAreaRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WhaPService {
    final private WarehouseAreaRepo warehouseAreaRepo;
    public WhaPResponse addWarehouseArea(WhaPRequest whaPRequest){
        WarehouseArea warehouseArea = WarehouseArea.builder()
                .rate(whaPRequest.getRate())
                .averageTemp(whaPRequest.getAverageTemp())
                .totalCapacity(whaPRequest.getTotalCapacity())
                .storageType(whaPRequest.getStorageType())
                .build();
        warehouseAreaRepo.save(warehouseArea);
        WhaPResponse whaPResponse = WhaPResponse.builder()
                .rate(whaPRequest.getRate())
                .averageTemp(whaPRequest.getAverageTemp())
                .totalCapacity(whaPRequest.getTotalCapacity())
                .storageType(whaPRequest.getStorageType())
                .build();
        return whaPResponse;
    }
}
