package com.mercadolibre.dojos;

/**
 * Created by esomoza on 2/7/18.
 */
public class SixMonthsBeforeAndThreeMonthsAfterAndMoreThanEightyPercentAvailabilityTripCostRule extends TripCostRule{

    private ApiAvailabilityService apiAvailabilityService;

    SixMonthsBeforeAndThreeMonthsAfterAndMoreThanEightyPercentAvailabilityTripCostRule(ApiAvailabilityService apiAvailabilityService){
        this.apiAvailabilityService = apiAvailabilityService;
    }



    @Override
    protected Boolean apply(Integer daysBetweenTodayAndTripDate) {
        Integer availability = apiAvailabilityService.getAvailability();
        return daysBetweenTodayAndTripDate <= 180 && daysBetweenTodayAndTripDate > 90 && availability >= 80;
    }

    @Override
    protected Price addPromotion(Price tripCost) {
        return tripCost.addPercentage(20);
    }
}
