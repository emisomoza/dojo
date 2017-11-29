package com.mercadolibre.dojos;

/**
 * Created by esomoza on 11/16/17.
 */
public class Pacman {
    Weight weight;
    PackmanState state;

    Pacman(){
        this.weight = new Weight();
        this.state = PackmanState.ALIVE;
    }

    public Weight getWeight(){
        return this.weight.clone();
    }

    public void eat(Food food){
        food.incrementWeight(this.weight);
    }

    public boolean isFatterThan(Weight weight) {
        return true;
    }

    public boolean hasDuplicateWeight(Weight weight){
        return this.weight.isDoubleThan(weight);
    }

    public void bumps(Blinky blinky) {
        blinky.bumps(this);
    }

    public void die() {
        this.state = PackmanState.DEAD;
    }

    public boolean isAlive() {
        return this.state == PackmanState.ALIVE;
    }
}
