package models.creatures.races;

import config.Constants;
import models.creatures.Creature.State;
import models.creatures.reproductionType.Viviparous;

/**
 * Represents a megalodon, which is a viviparous creature.
 */
public class Megalodon extends Viviparous {

    /**
     * Constructor to create a new megalodon with specified parameters.
     *
     * @param name   the name
     * @param gender the gender
     * @param weight the weight
     * @param age    the age
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
			Constants.Creature.Megalodon.SIZE,
			age,
			Constants.Creature.Megalodon.MAX_HP
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
			this.setHp(0);
		}
	}
	
	/**
	 * Heals the megalodon to its maximum health points.
	 */
	public void heal() {
		this.setState(State.HEALTHY);
		this.setHp(Constants.Creature.Megalodon.MAX_HP);
	}
}
