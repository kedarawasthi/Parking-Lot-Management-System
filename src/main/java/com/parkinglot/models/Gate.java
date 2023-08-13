package com.parkinglot.models;

public class Gate extends BaseModel {
    private String name;
    private GateStatus gateStatus;
    private ParkingAttendent parkingAttendent;
    private GateType gateType;

    public Gate(int id, String name, GateStatus gateStatus, ParkingAttendent parkingAttendent, GateType gateType) {
        super(id);
        this.name = name;
        this.gateStatus = gateStatus;
        this.parkingAttendent = parkingAttendent;
        this.gateType = gateType;
    }

    public String getName() {
        return name;
    }

    public GateStatus getGateStatus() {
        return gateStatus;
    }

    public ParkingAttendent getParkingAttendent() {
        return parkingAttendent;
    }

    public GateType getGateType() {
        return gateType;
    }
}
