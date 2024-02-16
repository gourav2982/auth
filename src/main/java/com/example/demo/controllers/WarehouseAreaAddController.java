package com.example.demo.controllers;

import com.example.demo.dto.WhaPRequest;
import com.example.demo.dto.WhaPResponse;
import com.example.demo.services.WhaPService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class WarehouseAreaAddController {
    private final WhaPService whaPService;
    @PostMapping("/addWarehouseArea")
    public WhaPResponse addWha(@RequestBody WhaPRequest whaPRequest){
        return whaPService.addWarehouseArea(whaPRequest);
    }
}
