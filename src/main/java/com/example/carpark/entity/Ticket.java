package com.example.carpark.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketId;
    @Column(length = 50)
    private String customerName;
    @Column()
    private LocalDate bookingTime;
    @ManyToOne
    private Car car;
    @ManyToOne
    private Trip trip;
}
