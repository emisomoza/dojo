package com.mercadolibre.dojos;

/**
 * Created by esomoza on 2/28/18.
 */
public interface Condition {

    boolean apply(TripDate currentDay, Trip trip);
}
