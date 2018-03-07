package com.mercadolibre.dojos;

import java.util.List;

/**
 * Created by esomoza on 2/7/18.
 */
public abstract class TripCostRule {
    protected List<Condition> conditions;
    protected abstract Price addPromotion(Price tripCost);

    protected Boolean apply(TripDate currentDate, Trip trip) {
        for (Condition condition :conditions){
            if(!condition.apply(currentDate, trip)){
                return false;
            }
        }
        return true;
    }
    public Price addPromotionIfApply(TripDate currentDate, Trip trip) {
        Price totalCost = trip.getTotalCost();
        return apply(currentDate, trip) ? addPromotion(totalCost) : totalCost;
    }
}
