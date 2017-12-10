package com.mercadolibre.dojos;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests for the dojo.
 */
public class DojoTest {

	@Test
	public void testPacman_ShouldGetFatWhetherItEatsBiscuits() {
		
		Biscuit biscuit = new Biscuit();
		Pacman pacman = new Pacman();
		Weight initialWeight = pacman.getWeight();

		pacman.eat(biscuit);
		
		assertTrue( pacman.isFatterThan(initialWeight) );
	}

	@Test
	public void testPacman_ShouldDuplicateWeightWhenItEatsCherry() {

		Cherry cherry = new Cherry();
		Pacman pacman = new Pacman();
		Weight initialWeight = pacman.getWeight();

		pacman.eat(cherry);

		assertTrue( pacman.hasDuplicateWeight(initialWeight) );
	}

	@Test
	public void testPacman_PacmanShouldNotDuplicateWeight() {
		Pacman pacman = new Pacman();
		Weight initialWeight = pacman.getWeight();

		assertFalse( pacman.hasDuplicateWeight(initialWeight) );
	}

	@Test
	public void test_pacman_should_die_whether_it_bumps_into_phantom() {
		Pacman pacman = new Pacman();
		Blinky blinky = new Blinky();

		pacman.bumps(blinky);

		assertFalse(pacman.isAlive());
	}

	@Test
	public void test_pacman_should_weaken_phantom_whether_it_eats_pellet() {
		Pacman pacman = new Pacman();
		Inky inky = new Inky();
		Pellet pellet = new Pellet(inky);

		pacman.eat(pellet);
		pacman.bumps(inky);

		assertTrue( pacman.isAlive() );
	}

	@Test
	@Ignore
	public void test_pacman_should_kill_weakened_phantom_when_hit_it() {

		// ...
		// Code here!
		// ...

	}

}
