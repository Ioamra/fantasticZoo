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
			age
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
