package com.example.carpark.controller;

import com.example.carpark.entity.Trip;
import com.example.carpark.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("trip")
public class TripController {
    private final TripService tripService;
    @Autowired
    public TripController(TripService tripService) {
        this.tripService = tripService;
    }
    @GetMapping("/all")
    public  List<Trip> getAllTrip(){
        return tripService.getAllTrip();
    }
    @PostMapping("/save")
    public  ResponseEntity createTrip(@RequestBody Trip trip ){
        try{
            Trip trip1 = tripService.saveTrip(trip);
            if(trip1 == null){
                return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }else {
                return  new ResponseEntity(null,HttpStatus.OK);
            }
        }catch (Exception e){
            System.out.println(e);
            return new ResponseEntity(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/{tripId}")
    public ResponseEntity editTrip(@RequestBody Trip trip){
        try{
            return  new ResponseEntity(tripService.editTrip(trip),HttpStatus.OK);
        } catch (Exception e){
            System.out.println(e);
            return new ResponseEntity(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/{tripId}")
   public ResponseEntity deleteTrip(@PathVariable Long tripId){
        try {
            tripService.deleteTrip(tripId);
        } catch (Exception e){
            System.out.println(e);
            return  new ResponseEntity(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return  new ResponseEntity("delete succes",HttpStatus.OK);
    }
}
