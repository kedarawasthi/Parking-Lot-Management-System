package com.parkinglot.strategies.pricing_strategy;

import com.parkinglot.models.VehicleType;

import java.util.Date;

public interface PricingStrategy {
    double calculateAmount(Date entryTime, Date exitTime, VehicleType vehicleType);
}
