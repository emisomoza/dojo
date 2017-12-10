package com.mercadolibre.dojos;

/**
 * Created by esomoza on 12/10/17.
 */
public class NormalStateBehavior implements StateBehavior{
    public void bumps(Pacman pacman) {
        pacman.die();
    }
}
