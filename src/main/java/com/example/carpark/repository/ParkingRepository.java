package com.example.carpark.repository;
import com.example.carpark.entity.Parking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingRepository extends JpaRepository<Parking,Long> {
}
