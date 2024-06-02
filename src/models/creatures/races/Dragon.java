package models.creatures.races;

import config.Constants;
import models.creatures.reproductionType.Oviparous;

/**
 * Represents a dragon, which is an oviparous creature.
 */
public class Dragon extends Oviparous {

	/**
	 * Constructor to create a new dragon with specified parameters.
	 *
	 * @param name
	 * @param gender
	 * @param weight
	 */
	public Dragon(
		String name, 
		Gender gender,  
		int weight,
		int age
	) {
		super(
			name, 
			gender, 
			weight,
			Constants.Creature.Dragon.SIZE,
			age
		);
	}
	
	/**
	 * Makes a sound, which dragons do not implement.
	 */
	public void makeSound() {
		
	}
	
	/**
	 * Checks the age of the dragon and kills it if it exceeds the maximum age.
	 */
	public void checkAge() {
		if (this.age > Constants.Creature.Dragon.MAX_AGE) {
			this.die();
		}
	}
	
	/**
	 * Heals the dragon to its maximum health points.
	 */
	public void heal() {
		this.setHp(Constants.Creature.Dragon.MAX_HP);
	}

}
