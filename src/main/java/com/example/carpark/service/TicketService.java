package com.example.carpark.service;

import com.example.carpark.entity.Ticket;
import com.example.carpark.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;
    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }
    public List<Ticket> getAllTicket(){
        return ticketRepository.findAll();
    }
    public Ticket saveTicket(Ticket ticket){
        try{
            return ticketRepository.save(ticket);
        }catch (Exception e){
            System.out.println(e);
        }return null;
    }
    public Ticket editTicket(Ticket ticket){
        try{
            ticket.setTicketId(ticket.getTicketId());
        }catch (Exception e){
            System.out.println(e);
        }return  null;
    }
    public void deleteTicket(Long ticketId){
        try {
            ticketRepository.deleteById(ticketId);
        }catch (Exception e){
            System.out.println(e);
        }
    }

}
