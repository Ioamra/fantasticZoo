package models.creatures.races;

import config.Constants;
import models.creatures.reproductionType.Viviparous;

public class Unicorn extends Viviparous {

	/**
	 * Constructor to create a new unicorn with specified parameters.
	 *
	 * @param name
	 * @param gender
	 * @param weight
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
			age
		);
	}

	public void makeSound() {
		
	}
	
	public void checkAge() {
		if (this.age > Constants.Creature.Unicorn.MAX_AGE) {
			this.die();
		}
	}
	
	public void heal() {
		this.setHp(Constants.Creature.Unicorn.MAX_HP);
	}
}
