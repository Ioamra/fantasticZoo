package models.creatures.races;

import config.Constants;
import models.creatures.reproductionType.Oviparous;

/**
 * Represents a kraken, which is an oviparous creature.
 */
public class Kraken extends Oviparous {

    /**
     * Constructor to create a new kraken with specified parameters.
     *
     * @param name   the name
     * @param gender the gender
     * @param weight the weight
     * @param age    the age
     */
    public Kraken(
		String name, 
		Gender gender,  
		int weight,
		int age
	) {
		super(
			name, 
			gender, 
			weight, 
			Constants.Creature.Kraken.SIZE,
			age
		);
	}
	
	/**
	 * Makes a sound, which krakens do not implement.
	 */
	public void makeSound() {
		
	}
	
	/**
	 * Checks the age of the kraken and kills it if it exceeds the maximum age.
	 */
	public void checkAge() {
		if (this.age > Constants.Creature.Kraken.MAX_AGE) {
			this.die();
		}
	}
	
	/**
	 * Heals the kraken to its maximum health points.
	 */
	public void heal() {
		this.setHp(Constants.Creature.Kraken.MAX_HP);
	}
}
