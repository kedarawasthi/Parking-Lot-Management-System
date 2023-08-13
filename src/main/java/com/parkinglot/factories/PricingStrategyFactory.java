package com.parkinglot.factories;

import com.parkinglot.strategies.pricing_strategy.PricingStrategy;
import com.parkinglot.strategies.pricing_strategy.WeekdayPricingStrategy;
import com.parkinglot.strategies.pricing_strategy.WeekendPricingStrategy;

import java.util.Calendar;
import java.util.Date;

public class PricingStrategyFactory {
    PricingStrategy weekdayPricingStrategy;
    PricingStrategy weekendPricingStrategy;

    public PricingStrategyFactory(PricingStrategy weekdayPricingStrategy, PricingStrategy weekendPricingStrategy) {
        this.weekdayPricingStrategy = weekdayPricingStrategy;
        this.weekendPricingStrategy = weekendPricingStrategy;
    }

    public PricingStrategy getPricingStrategyFactory(Date exitTime) {
        Calendar cal=Calendar.getInstance();
        cal.setTime(exitTime);
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        if(dayOfWeek == 1 || dayOfWeek == 7){
            return weekendPricingStrategy;
        }
        return weekdayPricingStrategy;

    }
}
