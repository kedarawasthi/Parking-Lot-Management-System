package com.parkinglot.services;

import com.parkinglot.models.Gate;
import com.parkinglot.repositories.GateRepository;

public class GateService {
    private GateRepository gateRepository;

    public GateService(GateRepository gateRepository) {
        this.gateRepository = gateRepository;
    }

    public Gate getGateById(int gateId) {
        return gateRepository.getGateById(gateId);
    }
}
