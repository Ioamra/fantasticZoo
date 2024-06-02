package models.creatures.races;

import config.Constants;
import models.creatures.reproductionType.Viviparous;

/**
 * Represents a mermaid, which is a viviparous creature.
 */
public class Mermaid extends Viviparous {

	/**
	 * Constructor to create a new mermaid with specified parameters.
	 *
	 * @param name
	 * @param gender
	 * @param weight
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
			age
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
		}
	}
	
	/**
	 * Heals the mermaid to its maximum health points.
	 */
	public void heal() {
		this.setHp(Constants.Creature.Mermaid.MAX_HP);
	}
}
