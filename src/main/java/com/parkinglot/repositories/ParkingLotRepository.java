package com.parkinglot.repositories;

import com.parkinglot.models.Gate;
import com.parkinglot.models.ParkingLot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotRepository {
    private Map<Integer,ParkingLot> map;

    public ParkingLotRepository() {
        this.map = new HashMap<>();
    }
    public ParkingLotRepository(Map<Integer, ParkingLot> map) {
        this.map = map;
    }
    public ParkingLot getParkingLotByGateId(int gateId) {
        for(Map.Entry<Integer,ParkingLot> en: map.entrySet()){
            for(Gate gate:en.getValue().getGates()){
                if(gate.getId() == gateId){
                    return en.getValue();
                }
            }
        }
        return null;
    }
}
