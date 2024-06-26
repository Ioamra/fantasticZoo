package models.creatures.races;

import config.Constants;
import models.creatures.Creature.State;
import models.creatures.reproductionType.Viviparous;

/**
 * Represents a unicorn, which is a viviparous creature.
 */
public class Unicorn extends Viviparous {

    /**
     * Constructor to create a new unicorn with specified parameters.
     *
     * @param name   the name
     * @param gender the gender
     * @param weight the weight
     * @param age    the age
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
			age,
			Constants.Creature.Unicorn.MAX_HP
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
			this.setHp(0);
		}
	}
	
	/**
	 * Heals the unicorn to its maximum health points.
	 */
	public void heal() {
		this.setState(State.HEALTHY);
		this.setHp(Constants.Creature.Unicorn.MAX_HP);
	}
}
