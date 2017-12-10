package com.mercadolibre.dojos;

/**
 * Created by esomoza on 12/10/17.
 */
public class PhantomState {
    StateBehavior stateBehavior;

    PhantomState(){
        this.stateBehavior = new NormalStateBehavior();
    }
    public void bumps(Pacman pacman){
        stateBehavior.bumps(pacman);
    }

    public void changeToPelletState(){
        stateBehavior = new PelletStateBehavior();
    }

}
