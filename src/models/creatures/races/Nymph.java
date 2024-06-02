package models.creatures.races;

import config.Constants;
import models.creatures.reproductionType.Oviparous;

/**
 * Represents a nymph, which is an oviparous creature.
 */
public class Nymph extends Oviparous {

	/**
	 * Constructor to create a new nymph with specified parameters.
	 *
	 * @param name
	 * @param gender
	 * @param weight
	 */
	public Nymph(
		String name, 
		Gender gender,  
		int weight,
		int age
	) {
		super(
			name, 
			gender, 
			weight, 
			Constants.Creature.Nymph.SIZE,
			age
		);
	}
	
	/**
	 * Nymphs do not make any sound.
	 */
	public void makeSound() {
		
	}
	
	/**
	 * Checks if the nymph's age exceeds the maximum age and kills it if so.
	 */
	public void checkAge() {
		if (this.age > Constants.Creature.Nymph.MAX_AGE) {
			this.die();
		}
	}

	/**
	 * Heals the nymph to its maximum health points.
	 */
	public void heal() {
		this.setHp(Constants.Creature.Nymph.MAX_HP);
	}
}
