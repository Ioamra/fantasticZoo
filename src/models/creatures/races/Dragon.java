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
     * @param name   the name
     * @param gender the gender
     * @param weight the weight
     * @param age    the age
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
			age,
			Constants.Creature.Dragon.MAX_HP
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
			this.setHp(0);
		}
	}
	
	/**
	 * Heals the dragon to its maximum health points.
	 */
	public void heal() {
		this.setState(State.HEALTHY);
		this.setHp(Constants.Creature.Dragon.MAX_HP);
	}

}
