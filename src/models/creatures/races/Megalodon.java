package models.creatures.races;

import config.Constants;
import models.creatures.reproductionType.Viviparous;

public class Megalodon extends Viviparous {

	/**
	 * Constructor to create a new megalodon with specified parameters.
	 *
	 * @param name
	 * @param gender
	 * @param weight
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
			Constants.Creature.Lycanthropes.SIZE,
			age
		);
	}

	public void makeSound() {
		
	}
	
	public void checkAge() {
		if (this.age > Constants.Creature.Megalodon.MAX_AGE) {
			this.die();
		}
	}
	
	public void heal() {
		this.setHp(Constants.Creature.Megalodon.MAX_HP);
	}
}
