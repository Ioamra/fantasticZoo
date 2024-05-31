package models.creatures.races;

import config.Constants;
import models.creatures.reproductionType.Viviparous;

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

	public void makeSound() {
		
	}

	public void checkAge() {
		if (this.age > Constants.Creature.Mermaid.MAX_AGE) {
			this.die();
		}
	}
	
	public void heal() {
		this.setHp(Constants.Creature.Mermaid.MAX_HP);
	}
}
