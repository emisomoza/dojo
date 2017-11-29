package com.mercadolibre.dojos;

/**
 * Created by esomoza on 11/16/17.
 */
public class Cherry implements Food{
    Cherry(){
    }

    public void incrementWeight(Weight originalWeight){
        originalWeight.duplicate();
    }
}
