package com.example.carpark.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tripId;
    @Column(length = 50)
    private String carDestination;
    @Column(length = 50)
    private String carDepartureTime;
    @Column(length = 50)
    private String carDriver;
    @Column(length = 50)
    private String carType;
    @Column(length = 50)
    private String maximumOnlineTicketNumber;
    @Column(columnDefinition = "Date")
    private LocalDate carDepartureDate;
}
