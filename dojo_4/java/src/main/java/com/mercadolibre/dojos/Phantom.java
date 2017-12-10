package com.mercadolibre.dojos;

/**
 * Created by esomoza on 11/23/17.
 */
public class Phantom {
    PhantomState state;

    Phantom(){
        state = new PhantomState();
    }

    public void bumps(Pacman pacman){
        state.bumps(pacman);
    }

    public void pelletEffect(){
        state.changeToPelletState();
    }
}
