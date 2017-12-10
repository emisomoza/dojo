package com.mercadolibre.dojos;

/**
 * Created by esomoza on 11/16/17.
 */
public class Weight implements Cloneable{
    Integer quantity;

    Weight(){
        this.quantity = 1;
    }

    Weight(Integer quantity){
        this.quantity = quantity;
    }

    public void duplicate(){
        this.quantity *= 2;
    }

    public Integer getQuantity(){
        return this.quantity;
    }

    public boolean isDoubleThan(Weight weight){
        return this.quantity == weight.getQuantity() * 2;
    }

    private void setQuantity(Integer quantity){
        this.quantity = quantity;
    }

    public void add(Integer quantity){
        this.quantity += quantity;
    }

    @Override
    public Weight clone(){
        Weight weight = new Weight();
        weight.setQuantity(this.quantity);
        return weight;
    }
}
