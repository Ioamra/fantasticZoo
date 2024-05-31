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
	 * @param size
	 */
	public Unicorn(
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
		if (this.age > Constants.Creature.Unicorn.MAX_AGE) {
			this.die();
		}
	}
	
	public void heal() {
		this.setHp(Constants.Creature.Unicorn.MAX_HP);
	}
}
