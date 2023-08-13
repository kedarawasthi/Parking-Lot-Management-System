package com.parkinglot.models;

import java.util.Date;
import java.util.List;

public class ParkingLot extends BaseModel{
    private List<ParkingFloor> parkingFloors;
    private List<Gate> gates;
    private String name;
    private String address;

    //st and en time for now will be fixed as we are keeping them with parking lot but there should be provision to chnge it on weekends
    private Date startTime;
    private Date endTime;

    public ParkingLot(int id, List<ParkingFloor> parkingFloors, List<Gate> gates, String name, String address, Date startTime, Date endTime) {
        super(id);
        this.parkingFloors = parkingFloors;
        this.gates = gates;
        this.name = name;
        this.address = address;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }
}
