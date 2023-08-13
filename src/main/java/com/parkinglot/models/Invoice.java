package com.parkinglot.models;

import java.util.Date;

public class Invoice extends BaseModel {
    private Ticket ticket;
    private Gate gate;
    private Date exitTime;
    private ParkingAttendent parkingAttendent;


    public Invoice(int id, Ticket ticket, Gate gate, Date exitTime, ParkingAttendent parkingAttendent) {
        super(id);
        this.ticket = ticket;
        this.gate = gate;
        this.exitTime = exitTime;
        this.parkingAttendent = parkingAttendent;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public Gate getGate() {
        return gate;
    }

    public Date getExitTime() {
        return exitTime;
    }

    public ParkingAttendent getParkingAttendent() {
        return parkingAttendent;
    }

}
