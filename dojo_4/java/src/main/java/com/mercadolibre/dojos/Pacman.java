package com.mercadolibre.dojos;

/**
 * Created by esomoza on 11/16/17.
 */
public class Pacman {
    Weight weight;

    Pacman(){
        this.weight = new Weight();
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

    public void bumps(Blinky blinky) throws PacmanDeadException {
        blinky.bumps(this);
    }

    public void die() throws PacmanDeadException {
        throw new PacmanDeadException();
    }
}
