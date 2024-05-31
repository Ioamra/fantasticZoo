package models.creatures.races;

import config.Constants;
import models.creatures.reproductionType.Oviparous;

public class Dragon extends Oviparous {

	/**
	 * Constructor to create a new dragon with specified parameters.
	 *
	 * @param name
	 * @param gender
	 * @param weight
	 * @param size
	 */
	public Dragon(
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
		if (this.age > Constants.Creature.Dragon.MAX_AGE) {
			this.die();
		}
	}
	
	public void heal() {
		this.setHp(Constants.Creature.Dragon.MAX_HP);
	}

}
