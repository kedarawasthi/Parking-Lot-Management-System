package com.parkinglot.strategies.pricing_strategy;

import com.parkinglot.models.Slab;
import com.parkinglot.models.VehicleType;
import com.parkinglot.repositories.SlabRepository;
import com.parkinglot.utils.DateTimeUtils;

import java.util.Date;
import java.util.List;

public class WeekendPricingStrategy implements PricingStrategy{
    private SlabRepository slabRepository;

    public WeekendPricingStrategy(SlabRepository slabRepository) {
        this.slabRepository = slabRepository;
    }

    @Override
    public double calculateAmount(Date entryTime, Date exitTime, VehicleType vehicleType) {
        double amount=0;
        int hoursSpent= DateTimeUtils.calculateHours(entryTime,exitTime);
        List<Slab> slabs=slabRepository.getSlabByVehicleType(vehicleType);
        for(Slab slab:slabs){
            if(slab.getEndHour()<hoursSpent){
                amount += (slab.getEndHour()-slab.getStartHour()) * slab.getPrice();
            }
            else if(slab.getEndHour() < -1 || slab.getEndHour() > hoursSpent){
                amount += (hoursSpent - slab.getStartHour()) * slab.getPrice();
                break;
            }
        }
        return amount;

    }
}
