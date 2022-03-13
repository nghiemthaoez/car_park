package com.example.carpark.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long licensePlate;
    @Column(length = 50)
    private String carType;
    @Column(length = 20)
    private String carColor;
    @Column(length = 50)
    private String carCompany;
    @ManyToOne
    private Parking parking;
}
