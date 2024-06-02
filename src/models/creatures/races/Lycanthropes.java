package models.creatures.races;

import config.Constants;
import models.creatures.reproductionType.Viviparous;

/**
 * Represents lycanthropes, which are viviparous creatures.
 */
public class Lycanthropes extends Viviparous {

    /**
     * Constructor to create a new lycanthropes with specified parameters.
     *
     * @param name   the name
     * @param gender the gender
     * @param weight the weight
     * @param age    the age
     */
    public Lycanthropes(
		String name, 
		Gender gender, 
		int weight,
		int age
	) {
		super(
			name, 
			gender, 
			weight, 
			Constants.Creature.Lycanthropes.SIZE,
			age
		);
	}

	/**
	 * Makes a sound, which lycanthropes do not implement.
	 */
	public void makeSound() {
		
	}
	
	/**
	 * Checks the age of the lycanthrope and kills it if it exceeds the maximum age.
	 */
	public void checkAge() {
		if (this.age > Constants.Creature.Lycanthropes.MAX_AGE) {
			this.die();
		}
	}
	
	/**
	 * Heals the lycanthrope to its maximum health points.
	 */
	public void heal() {
		this.setHp(Constants.Creature.Lycanthropes.MAX_HP);
	}
}
