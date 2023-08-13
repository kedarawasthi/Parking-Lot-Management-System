package com.parkinglot.services;

import com.parkinglot.models.ParkingLot;
import com.parkinglot.repositories.ParkingLotRepository;

public class ParkingLotService {
    private ParkingLotRepository parkingLotRepository;

    public ParkingLotService(ParkingLotRepository parkingLotRepository) {
        this.parkingLotRepository = parkingLotRepository;
    }

    public ParkingLot getParkingLotByGateId(int gateId) {
        return parkingLotRepository.getParkingLotByGateId(gateId);
    }
}
