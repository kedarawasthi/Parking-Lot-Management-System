package com.parkinglot.strategies.spot_assignment_strategy;

import com.parkinglot.exceptions.ParkingSpotNotFoundException;
import com.parkinglot.models.ParkingLot;
import com.parkinglot.models.ParkingSpot;
import com.parkinglot.models.VehicleType;

public interface SpotAssignmentStrategy {
    public ParkingSpot assignSpot(ParkingLot parkingLot, VehicleType vehicleType) throws ParkingSpotNotFoundException;
}
