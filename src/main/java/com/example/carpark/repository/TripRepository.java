package com.example.carpark.repository;

import com.example.carpark.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TripRepository extends JpaRepository <Trip,Long> {

//    Optional<Trip> findById(Trip trip);
}
