package models.creatures.races;

import config.Constants;
import models.creatures.reproductionType.Viviparous;

/**
 * Represents a megalodon, which is a viviparous creature.
 */
public class Megalodon extends Viviparous {

	/**
	 * Constructor to create a new megalodon with specified parameters.
	 *
	 * @param name
	 * @param gender
	 * @param weight
	 */
	public Megalodon(
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
	 * Makes a sound, which megalodons do not implement.
	 */
	public void makeSound() {
		
	}
	
	/**
	 * Checks the age of the megalodon and kills it if it exceeds the maximum age.
	 */
	public void checkAge() {
		if (this.age > Constants.Creature.Megalodon.MAX_AGE) {
			this.die();
		}
	}
	
	/**
	 * Heals the megalodon to its maximum health points.
	 */
	public void heal() {
		this.setHp(Constants.Creature.Megalodon.MAX_HP);
	}
}
