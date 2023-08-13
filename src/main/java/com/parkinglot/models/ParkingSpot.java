package com.parkinglot.models;

public class ParkingSpot extends BaseModel{
    private String name;
    private SpotStatus status;
    private VehicleType supportedVehicleType; // could be a list if more than one vehucle type allowed for a spot

    public ParkingSpot(int id, String name, SpotStatus status, VehicleType supportedVehicleType) {
        super(id);
        this.name = name;
        this.status = status;
        this.supportedVehicleType = supportedVehicleType;
    }

    public String getName() {
        return name;
    }

    public SpotStatus getStatus() {
        return status;
    }

    public VehicleType getSupportedVehicleType() {
        return supportedVehicleType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(SpotStatus status) {
        this.status = status;
    }

    public void setSupportedVehicleType(VehicleType supportedVehicleType) {
        this.supportedVehicleType = supportedVehicleType;
    }
}
