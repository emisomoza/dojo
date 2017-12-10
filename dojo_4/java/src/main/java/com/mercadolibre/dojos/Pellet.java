package com.mercadolibre.dojos;

/**
 * Created by esomoza on 11/16/17.
 */
public class Pellet implements Food{
    Phantom phantom;

    Pellet(Phantom phantom){
        this.phantom = phantom;
    }

    public void incrementWeight(Weight originalWeight){
        phantom.pelletEffect();
    }
}
