package com.example.carpark.service;
import com.example.carpark.entity.Parking;
import com.example.carpark.repository.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ParkingService {
    private final ParkingRepository parkingRepository;
    @Autowired
    public ParkingService(ParkingRepository parkingRepository) {
        this.parkingRepository = parkingRepository;
    }
    public List<Parking> getAllPark(){
        return parkingRepository.findAll();
    }
    public Parking savePark(Parking parking){
        try{
            return parkingRepository.save(parking);
        }catch (Exception e){
            System.out.println(e);
        }return null;
    }
    public Parking editPark(Parking parking){
        try{
            parking.setParkId(parking.getParkId());
        }catch (Exception e){
            System.out.println(e);
        }return  null;
    }
    public void deletePark(Long parkId){
        try {
            parkingRepository.deleteById(parkId);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}

