package com.parkinglot.services;

import com.parkinglot.models.Vehicle;
import com.parkinglot.models.VehicleType;
import com.parkinglot.repositories.VehicleRepository;

public class VehicleService {
    private VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Vehicle insertIfNotExists(String registrationNumber, VehicleType vehicleType) {
        Vehicle vehicle=vehicleRepository.getVehicleByRegistrationNumber(registrationNumber);
        if(vehicle == null ){
            vehicle = vehicleRepository.insertVehicle(registrationNumber,vehicleType);
        }
        return vehicle;
    }
}
