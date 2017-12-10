package com.mercadolibre.dojos;

/**
 * Created by esomoza on 11/16/17.
 */
public class Biscuit implements Food{
    Weight weight;

    Biscuit(){
        Integer quantity = 10;
        this.weight = new Weight(quantity);
    }

    public void incrementWeight(Weight originalWeight){
        originalWeight.add(weight.quantity);
    }
}
