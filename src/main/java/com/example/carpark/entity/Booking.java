package com.example.carpark.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;
    @Column(length = 50)
    private String bookName;
    @Column()
    private String bookPhone;
    @Column()
    private String bookPlace;
    @Column(length = 50)
    private String bookPrice;
    @Column()
    private LocalDate startContractDeadLine;
    @Column()
    private LocalDate endContractDeadLine;
    @ManyToOne
    @JoinColumn(name = "tripid")
    private Trip trip;

}
