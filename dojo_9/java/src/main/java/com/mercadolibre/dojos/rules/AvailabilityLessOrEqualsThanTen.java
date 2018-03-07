package com.mercadolibre.dojos.rules;

import com.mercadolibre.dojos.ApiAvailabilityService;
import com.mercadolibre.dojos.Condition;
import com.mercadolibre.dojos.Trip;
import com.mercadolibre.dojos.TripDate;

/**
 * Created by esomoza on 2/28/18.
 */
public class AvailabilityLessOrEqualsThanTen implements Condition {

    private static final int TEN = 10;
    private ApiAvailabilityService apiAvailabilityService;

    public AvailabilityLessOrEqualsThanTen(ApiAvailabilityService apiAvailabilityService) {
        this.apiAvailabilityService = apiAvailabilityService;
    }

    public boolean apply(TripDate currentDay, Trip trip){
        return  apiAvailabilityService.getAvailability() <= TEN;
    }
}
