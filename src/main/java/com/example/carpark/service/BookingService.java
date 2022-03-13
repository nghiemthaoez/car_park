package com.example.carpark.service;

//import com.example.carpark.dto.BookingDto;
import com.example.carpark.entity.Booking;
//import com.example.carpark.entity.Trip;
import com.example.carpark.repository.BookingRepository;
//import com.example.carpark.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;
//    private final TripRepository tripRepository;
//    @Autowired
//    public BookingService(BookingRepository bookingRepository, TripRepository tripRepository) {
//        this.bookingRepository = bookingRepository;
//        this.tripRepository = tripRepository;
//    }
    @Autowired
    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }
    public List<Booking> getAllBooking(){
        return bookingRepository.findAll();

    }
//    public Booking saveBooking(BookingDto bookingDto){
//        try{
//            Optional<Trip> trip =tripRepository.findById(bookingDto.getTrip());
//            Booking booking1 = new Booking(
//                    bookingDto.getBookId(),
//                    bookingDto.getBookName(),
//                    bookingDto.getBookPhone(),
//                    bookingDto.getBookPlace(),
//                    bookingDto.getBookPrice(),
//                    bookingDto.getEndContractDeadLine(),
//                    bookingDto.getStartContractDeadLine(),
//                    trip.get());
//            return bookingRepository.save(booking1);
//        }catch (Exception e){
//            System.out.println(e);
//        } return null;
//    }

    public Booking saveBooking(Booking booking){
        try{
            return bookingRepository.save(booking);
        }catch (Exception e){
            System.out.println(e);
        }return null;
    }
    public Booking editBooking(Booking booking){
        try{
            booking.setBookId(booking.getBookId());
        }catch (Exception e){
            System.out.println(e);
        }return  null;
    }
    public void deleteBooking(Long bookingId){
        try {
            bookingRepository.deleteById(bookingId);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
