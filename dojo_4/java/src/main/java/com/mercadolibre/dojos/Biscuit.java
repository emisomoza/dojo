package com.mercadolibre.dojos;

/**
 * Created by esomoza on 11/16/17.
 */
public class Biscuit implements Food{
    Weight weight;

    Biscuit(){
        this.weight = new Weight();
    }

    public void incrementWeight(Weight originalWeight){
        originalWeight.add(weight.quantity);
    }
}
