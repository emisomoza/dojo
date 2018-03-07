package com.mercadolibre.dojos;

import com.mercadolibre.dojos.rules.AvailabilityLessOrEqualsThanTen;
import com.mercadolibre.dojos.rules.DaysBiggerThanFifteen;
import com.mercadolibre.dojos.rules.DaysLessOrEqualsThanNinty;

import java.util.ArrayList;

/**
 * Created by esomoza on 2/7/18.
 */
public class ThreeMonthsBeforeAndTwoWeeksAfterAndLessThanTenPercentAvailabilityTripCostRule extends TripCostRule{

    private ApiAvailabilityService apiAvailabilityService;

    ThreeMonthsBeforeAndTwoWeeksAfterAndLessThanTenPercentAvailabilityTripCostRule(ApiAvailabilityService apiAvailabilityService){
        this.apiAvailabilityService = apiAvailabilityService;
        init();
    }

    public void init() {
        conditions = new ArrayList<Condition>();
        conditions.add(new AvailabilityLessOrEqualsThanTen(apiAvailabilityService));
        conditions.add(new DaysBiggerThanFifteen());
        conditions.add(new DaysLessOrEqualsThanNinty());
    }

    @Override
    protected Price addPromotion(Price tripCost) {
        return tripCost.addPercentage(50);
    }
}
