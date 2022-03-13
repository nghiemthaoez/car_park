package com.example.carpark.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Parking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long parkId;
    @Column(length = 50,nullable = false )
    private String parkName;
    @Column(length = 50)
    private String parkPlace;
    @Column(length = 20)
    private String parkArea;
    @Column(length = 50)
    private String parkPrice;
    @Column(length = 20)
    private String parkStatus;
}
