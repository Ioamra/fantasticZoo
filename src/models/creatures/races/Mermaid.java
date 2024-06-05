package models.creatures.races;

import config.Constants;
import models.creatures.Creature.State;
import models.creatures.reproductionType.Viviparous;

/**
 * Represents a mermaid, which is a viviparous creature.
 */
public class Mermaid extends Viviparous {

    /**
     * Constructor to create a new mermaid with specified parameters.
     *
     * @param name   the name
     * @param gender the gender
     * @param weight the weight
     * @param age    the age
     */
    public Mermaid(
		String name, 
		Gender gender,  
		int weight,
		int age
	) {
		super(
			name, 
			gender, 
			weight, 
			Constants.Creature.Mermaid.SIZE,
			age,
			Constants.Creature.Mermaid.MAX_HP
		);
	}

	/**
	 * Makes a sound, which mermaids do not implement.
	 */
	public void makeSound() {
		
	}
	
	/**
	 * Checks the age of the mermaid and kills it if it exceeds the maximum age.
	 */
	public void checkAge() {
		if (this.age > Constants.Creature.Mermaid.MAX_AGE) {
			this.die();
			this.setHp(0);
		}
	}
	
	/**
	 * Heals the mermaid to its maximum health points.
	 */
	public void heal() {
		this.setState(State.HEALTHY);
		this.setHp(Constants.Creature.Mermaid.MAX_HP);
	}
}
