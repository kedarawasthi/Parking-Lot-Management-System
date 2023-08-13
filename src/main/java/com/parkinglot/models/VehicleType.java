package com.parkinglot.models;

public enum VehicleType {
    CAR,BIKE, SUV,TRUCK;
    public static VehicleType getVehicleType(String vehicleType){
        switch (vehicleType){
            case "CAR":     return CAR;
            case "BIKE":    return BIKE;
            case "SUV":     return SUV;
            case "TRUCK":   return TRUCK;
            case "":
        }
        return CAR;
    }
}
