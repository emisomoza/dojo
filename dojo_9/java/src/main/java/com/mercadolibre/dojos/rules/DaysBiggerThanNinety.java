package com.mercadolibre.dojos.rules;

import com.mercadolibre.dojos.Condition;
import com.mercadolibre.dojos.Trip;
import com.mercadolibre.dojos.TripDate;

/**
 * Created by esomoza on 2/28/18.
 */
public class DaysBiggerThanNinety implements Condition {


    private static final int FIFTEEN = 15;

    public boolean apply(TripDate currentDay, Trip trip){
        Integer daysBetweenTodayAndTripDate = trip.daysToDeparture(currentDay);
        return  daysBetweenTodayAndTripDate > FIFTEEN;
    }
}
