package models.creatures.races;

import config.Constants;
import models.creatures.reproductionType.Viviparous;
/**
 * Represents a unicorn, which is a viviparous creature.
 */
public class Unicorn extends Viviparous {

	/**
	 * Constructor to create a new unicorn with specified parameters.
	 *
	 * @param name
	 * @param gender
	 * @param weight
	 */
	public Unicorn(
		String name, 
		Gender gender, 
		int weight,
		int age
	) {
		super(
			name, 
			gender, 
			weight, 
			Constants.Creature.Unicorn.SIZE,
			age
		);
	}
	
	/**
	 * Unicorns do not make any sound.
	 */
	public void makeSound() {
		
	}

	/**
	 * Checks if the unicorn's age exceeds the maximum age and kills it if so.
	 */
	public void checkAge() {
		if (this.age > Constants.Creature.Unicorn.MAX_AGE) {
			this.die();
		}
	}
	
	/**
	 * Heals the unicorn to its maximum health points.
	 */
	public void heal() {
		this.setHp(Constants.Creature.Unicorn.MAX_HP);
	}
}
