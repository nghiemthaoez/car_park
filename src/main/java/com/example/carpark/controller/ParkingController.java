package com.example.carpark.controller;

import com.example.carpark.entity.Parking;
import com.example.carpark.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("parking")
public class ParkingController {
    private final ParkingService parkingService;
    @Autowired
    public ParkingController(ParkingService parkingService){
        this.parkingService =parkingService;
    }
    @GetMapping("/all")
    public List<Parking> getAllParking(){
        return parkingService.getAllPark();
    }
    @PostMapping("/save")
    public ResponseEntity createTrip(@RequestBody Parking parking ){
        try{
            Parking parking1 = parkingService.savePark(parking);
            if(parking1 == null){
                return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }else {
                return  new ResponseEntity(null,HttpStatus.OK);
            }
        }catch (Exception e){
            System.out.println(e);
            return new ResponseEntity(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/{parkingId}")
    public ResponseEntity editTrip(@RequestBody Parking parking){
        try{
            return  new ResponseEntity(parkingService.editPark(parking),HttpStatus.OK);
        } catch (Exception e){
            System.out.println(e);
            return new ResponseEntity(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/{parkingId}")
    public ResponseEntity de(@PathVariable Long parkId){
        try {
            parkingService.deletePark(parkId);
        } catch (Exception e){
            System.out.println(e);
            return  new ResponseEntity(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return  new ResponseEntity("delete succes",HttpStatus.OK);
    }
}
