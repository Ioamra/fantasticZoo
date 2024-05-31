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
	 * @param size
	 */
	public Mermaid(
		String name, 
		Gender gender, 
		double weight, 
		double size
	) {
		super(
			name, 
			gender, 
			weight, 
			size
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
