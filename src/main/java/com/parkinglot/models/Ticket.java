package com.parkinglot.models;

import java.util.Date;

public class Ticket extends BaseModel{
    private Vehicle vehicle;
    private Date entryTime;
    private ParkingSpot parkingSpot;
    private Gate gate;
    private ParkingAttendent parkingAttendent;

    public Ticket(int id, Vehicle vehicle, Date entryTime, ParkingSpot parkingSpot, Gate gate, ParkingAttendent parkingAttendent) {
        super(id);
        this.vehicle = vehicle;
        this.entryTime = entryTime;
        this.parkingSpot = parkingSpot;
        this.gate = gate;
        this.parkingAttendent = parkingAttendent;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public Gate getGate() {
        return gate;
    }

    public ParkingAttendent getParkingAttendent() {
        return parkingAttendent;
    }
}
