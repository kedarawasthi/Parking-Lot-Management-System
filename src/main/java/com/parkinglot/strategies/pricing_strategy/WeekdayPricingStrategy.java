package com.parkinglot.strategies.pricing_strategy;

import com.parkinglot.models.VehicleType;
import com.parkinglot.utils.DateTimeUtils;

import java.util.Date;

public class WeekdayPricingStrategy implements PricingStrategy{
    @Override
    public double calculateAmount(Date entryTime, Date exitTime, VehicleType vehicleType) {
        int hoursSpent = DateTimeUtils.calculateHours(entryTime,exitTime);
        return hoursSpent * 10;
    }
}
