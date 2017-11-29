package com.mercadolibre.dojos;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests for the dojo.
 */
public class DojoTest {
	//"should weaken phantom whether it eats a pellet", () => {
	
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

	@Test(expected = PacmanDeadException.class)
	public void test_pacman_should_die_whether_it_bumps_into_phantom() throws PacmanDeadException {
		Pacman pacman = new Pacman();
		Blinky blinky = new Blinky();

		pacman.bumps(blinky);
	}

}
