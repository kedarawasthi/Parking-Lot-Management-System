package com.parkinglot.models;

import java.util.List;

public class ParkingFloor extends BaseModel {
    private List<ParkingSpot> spots;
    private int floorNumber;
    private FloorStatus status;

    public ParkingFloor(int id, List<ParkingSpot> spots, int floorNumber, FloorStatus status) {
        super(id);
        this.spots = spots;
        this.floorNumber = floorNumber;
        this.status = status;
    }

    public List<ParkingSpot> getSpots() {
        return spots;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public FloorStatus getStatus() {
        return status;
    }
}
