package com.example.carpark.service;

import com.example.carpark.entity.Car;
import com.example.carpark.repository.CarRepository;
import com.example.carpark.repository.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private final CarRepository carRepository;
    private final ParkingRepository parkingRepository;
    @Autowired
    public CarService(CarRepository carRepository, ParkingRepository parkingRepository) {
        this.carRepository = carRepository;
        this.parkingRepository = parkingRepository;
    }
    public List<Car> getAllCar(){
        return  carRepository.findAll();
    }
    public Car saveCar(Car car){
        try{
            return carRepository.save(car);
        }catch (Exception e){
            System.out.println(e);
        }return  null;
    }
    public Car editCar(Car car) {
        try {
            car.setLicensePlate(car.getLicensePlate());
            return carRepository.save(car);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    public void deleteCar(Long licensePlate){
        try{
            carRepository.deleteById(licensePlate);
        }catch (Exception e){
            System.out.println(e);
        }
    }
//    @Transactional
//    Car saveAndP
}
