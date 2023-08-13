package com.parkinglot.repositories;

import com.parkinglot.models.Gate;

import java.util.HashMap;
import java.util.Map;

public class GateRepository {
    private Map<Integer, Gate> map;

    public GateRepository() {
        map=new HashMap<>();
    }

    public GateRepository(Map<Integer, Gate> map) {
        this.map = map;
    }

    public Map<Integer, Gate> getMap() {
        return map;
    }

    public Gate getGateById(int gateId){
        return map.get(gateId);
    }
}
