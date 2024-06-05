package models.creatures.races;

import config.Constants;
import models.creatures.Creature.State;
import models.creatures.reproductionType.Oviparous;

/**
 * Represents a phoenix, which is an oviparous creature.
 */
public class Phoenix extends Oviparous {

    /**
     * Constructor to create a new phoenix with specified parameters.
     *
     * @param name   the name
     * @param gender the gender
     * @param weight the weight
     * @param age    the age
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
			age,
			Constants.Creature.Phoenix.MAX_HP
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
			this.setHp(0);
		}
	}

	/**
	 * Heals the phoenix to its maximum health points.
	 */
	public void heal() {
		this.setState(State.HEALTHY);
		this.setHp(Constants.Creature.Phoenix.MAX_HP);
	}
}
