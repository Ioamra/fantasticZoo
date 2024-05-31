package models.creatures.races;

import config.Constants;
import models.creatures.reproductionType.Oviparous;

public class Nymph extends Oviparous {

	/**
	 * Constructor to create a new nymph with specified parameters.
	 *
	 * @param name
	 * @param gender
	 * @param weight
	 * @param size
	 */
	public Nymph(
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
		if (this.age > Constants.Creature.Nymph.MAX_AGE) {
			this.die();
		}
	}
	
	public void heal() {
		this.setHp(Constants.Creature.Nymph.MAX_HP);
	}
}
