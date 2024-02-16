package com.example.demo.models;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "WarehouseArea")
public class WarehouseArea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String storageType;
    String totalCapacity;
    String averageTemp;
    String rate;
}
