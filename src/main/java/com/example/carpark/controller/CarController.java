package com.example.carpark.controller;

import com.example.carpark.entity.Car;
import com.example.carpark.repository.CarRepository;
import com.example.carpark.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("car")
public class CarController {
    private final CarService carService;
    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }
    @GetMapping("/all")
    public List<Car> getAllCar(){
        return  carService.getAllCar();
    }
    @PostMapping("/save")
    public ResponseEntity createCar(@PathVariable Car car){
        try{
            Car car1 = carService.saveCar(car);
            if(car1 == null){
                return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }else {
                return  new ResponseEntity(null,HttpStatus.OK);
            }
        }catch (Exception e){
            System.out.println(e);
            return new ResponseEntity(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/{carId}")
    public ResponseEntity editCar(@RequestBody Car car){
        try{
            return  new ResponseEntity(carService.editCar(car),HttpStatus.OK);
        } catch (Exception e){
            System.out.println(e);
            return new ResponseEntity(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/{tripId}")
    public ResponseEntity deleteTrip(@PathVariable Long tripId){
        try {
            carService.deleteCar(tripId);
        } catch (Exception e){
            System.out.println(e);
            return  new ResponseEntity(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return  new ResponseEntity("delete succes",HttpStatus.OK);
    }
}
