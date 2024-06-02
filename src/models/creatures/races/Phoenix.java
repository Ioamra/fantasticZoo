package models.creatures.races;

import config.Constants;
import models.creatures.reproductionType.Oviparous;
/**
 * Represents a phoenix, which is an oviparous creature.
 */
public class Phoenix extends Oviparous {

	/**
	 * Constructor to create a new phoenix with specified parameters.
	 *
	 * @param name
	 * @param gender
	 * @param weight
	 */
	public Phoenix(
		String name, 
		Gender gender, 
		int weight,
		int age
	) {
		super(
			name, 
			gender, 
			weight, 
			Constants.Creature.Phoenix.SIZE,
			age
		);
	}
	
	/**
	 * Phoenixes do not make any sound.
	 */
	public void makeSound() {
		
	}
	
	/**
	 * Checks if the phoenix's age exceeds the maximum age and kills it if so.
	 */
	public void checkAge() {
		if (this.age > Constants.Creature.Phoenix.MAX_AGE) {
			this.die();
		}
	}

	/**
	 * Heals the phoenix to its maximum health points.
	 */
	public void heal() {
		this.setHp(Constants.Creature.Phoenix.MAX_HP);
	}
}
