package com.parkinglot.strategies.spot_assignment_strategy;

import com.parkinglot.exceptions.ParkingSpotNotFoundException;
import com.parkinglot.models.*;

import java.util.List;

public class NearestFirstParkingAssignmentStrategy implements SpotAssignmentStrategy{

    @Override
    public ParkingSpot assignSpot(ParkingLot parkingLot, VehicleType vehicleType) throws ParkingSpotNotFoundException {
        for(ParkingFloor parkingFloor: parkingLot.getParkingFloors()){
            if(parkingFloor.getStatus().equals(FloorStatus.OPERATIONAL)){
                for(ParkingSpot parkingSpot: parkingFloor.getSpots()){
                    if(parkingSpot.getStatus().equals(SpotStatus.AVAILABLE) &&
                       parkingSpot.getSupportedVehicleType().equals(vehicleType) ){
                       parkingSpot.setStatus(SpotStatus.OCCUPIED);
                       return parkingSpot;
                    }
                }
            }
        }
        throw  new ParkingSpotNotFoundException("Parking Spot for vehicle type " + vehicleType + "is not available");
    }
}
