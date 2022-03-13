package com.example.carpark.controller;

//import com.example.carpark.dto.BookingDto;
import com.example.carpark.entity.Booking;
import com.example.carpark.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("booking")
public class BookingController {
    private final BookingService bookingService;
    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/all")
    public List<Booking> getAllBooking(){
        return bookingService.getAllBooking();
    }
    @PostMapping("/save")
    public ResponseEntity createTrip(@RequestBody Booking booking ){
        try{
            Booking booking1 = bookingService.saveBooking(booking);
            if(booking1 == null){
                return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }else {
                return  new ResponseEntity(null,HttpStatus.OK);
            }
        }catch (Exception e){
            System.out.println(e);
            return new ResponseEntity(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//    @PostMapping("/save")
//    public ResponseEntity createBooking(@RequestBody BookingDto bookingDto){
//        return new ResponseEntity(bookingService.saveBooking(bookingDto),HttpStatus.OK);
//    }
    @PutMapping("/{id}")
    public ResponseEntity editBooking(@RequestBody Booking booking){
        try{
            return  new ResponseEntity(bookingService.editBooking(booking),HttpStatus.OK);
        } catch (Exception e){
            System.out.println(e);
            return new ResponseEntity(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteTrip(@PathVariable Long bokingId){
        try {
            bookingService.deleteBooking(bokingId);
        } catch (Exception e){
            System.out.println(e);
            return  new ResponseEntity(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return  new ResponseEntity("delete succes",HttpStatus.OK);
    }
}
