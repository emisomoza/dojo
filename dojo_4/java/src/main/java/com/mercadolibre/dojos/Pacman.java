package com.mercadolibre.dojos;

/**
 * Created by esomoza on 11/16/17.
 */
public class Pacman {
    Weight weight;
    PackmanState state;

    Pacman(){
        this.weight = new Weight();
        this.state = new StateNormal();
    }

    public Weight getWeight(){
        return this.weight.clone();
    }

    public void eat(Food food){
        food.incrementWeight(this.weight);
    }

    public boolean isFatterThan(Weight weight) {
        return this.weight.quantity > weight.quantity;
    }

    public boolean hasDuplicateWeight(Weight weight){
        return this.weight.isDoubleThan(weight);
    }

    public void bumps(Phantom phantom) {
        phantom.bumps(this);
    }

    public void die() {
        this.state = new StateDead();
    }

    public boolean isAlive() {
        return this.state.isAlive() ;
    }
}
