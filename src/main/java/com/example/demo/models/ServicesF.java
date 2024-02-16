package com.example.demo.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "Services")
public class ServicesF {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String ownedBy;
    String address;
    String pin;
    String serviceType;

}
