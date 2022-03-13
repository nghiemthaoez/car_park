package com.example.carpark.service;

import com.example.carpark.entity.Trip;
import com.example.carpark.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripService {
    private final TripRepository tripRepository;

    @Autowired
    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public List<Trip> getAllTrip() {
        return tripRepository.findAll();
    }

    public Trip getTripByID(Long tripId) {
        return tripRepository.getById(tripId);
    }
    public Trip saveTrip(Trip trip) {
        try {
            return tripRepository.save(trip);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    public Trip editTrip(Trip trip) {
        try {
            trip.setTripId(trip.getTripId());
            return tripRepository.save(trip);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    public void deleteTrip(Long tripId) throws EmptyResultDataAccessException {

        try {
            tripRepository.deleteById(tripId);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

