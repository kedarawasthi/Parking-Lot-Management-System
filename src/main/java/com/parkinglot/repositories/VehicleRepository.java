package com.parkinglot.repositories;

import com.parkinglot.models.Vehicle;
import com.parkinglot.models.VehicleType;

import java.util.HashMap;
import java.util.Map;

public class VehicleRepository {
    private Map<Integer, Vehicle> map;
    private static int id=0;

    public VehicleRepository() {
        this.map = new HashMap<>();
    }
    public VehicleRepository(Map<Integer, Vehicle> map) {
        this.map = map;
    }

    public Vehicle getVehicleByRegistrationNumber(String registrationNumber) {
        for(Map.Entry<Integer,Vehicle> en:map.entrySet()){
            if(en.getValue().getRegistrationNumber().equals(registrationNumber)){
                return en.getValue();
            }
        }
        return null;
    }

    public Vehicle insertVehicle(String registrationNumber, VehicleType vehicleType) {
        id++;
        Vehicle vehicle = new Vehicle(this.id,registrationNumber,vehicleType);
        map.put(id,vehicle);
        return vehicle;
    }
}
