package com.parkinglot.repositories;

import com.parkinglot.models.Gate;
import com.parkinglot.models.ParkingSpot;
import com.parkinglot.models.Ticket;
import com.parkinglot.models.Vehicle;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TicketRepository {
    private Map<Integer,Ticket> map;
    private static int id=0;
    public TicketRepository(Map<Integer, Ticket> map) {
        this.map = map;
    }
    public TicketRepository() {
        this.map = new HashMap<>();
    }

    public Ticket insertTicket(Vehicle vehicle, Gate gate, ParkingSpot parkingSpot, Date date) {
        this.id++;
        Ticket ticket=new Ticket(id,vehicle,date,parkingSpot,gate,gate.getParkingAttendent());
        map.put(id,ticket);
        return ticket;
    }

    public Ticket getTicketById(int ticketId) {
        return map.get(ticketId);
    }
}
