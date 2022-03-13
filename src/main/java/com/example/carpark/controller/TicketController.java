package com.example.carpark.controller;

import com.example.carpark.entity.Booking;
import com.example.carpark.entity.Ticket;
import com.example.carpark.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ticket")
public class TicketController {
    private final TicketService ticketService;
    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }
    @GetMapping("/all")
    public List<Ticket> getAllTicket(){
        return ticketService.getAllTicket();
    }
    @PostMapping("/save")
    public ResponseEntity createTicket(@RequestBody Ticket ticket ){
        try{
            Ticket ticket1 = ticketService.saveTicket(ticket);
            if(ticket1 == null){
                return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }else {
                return  new ResponseEntity(null,HttpStatus.OK);
            }
        }catch (Exception e){
            System.out.println(e);
            return new ResponseEntity(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity editTicket(@RequestBody Ticket ticket){
        try{
            return  new ResponseEntity(ticketService.editTicket(ticket),HttpStatus.OK);
        } catch (Exception e){
            System.out.println(e);
            return new ResponseEntity(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteTicket(@PathVariable Long ticketId){
        try {
            ticketService.deleteTicket(ticketId);
        } catch (Exception e){
            System.out.println(e);
            return  new ResponseEntity(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return  new ResponseEntity("delete succes",HttpStatus.OK);
    }

}
