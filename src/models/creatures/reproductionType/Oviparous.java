package models.creatures.reproductionType;
import models.creatures.Creature;

public abstract class Oviparous extends Creature {
	
	/**
	 * Constructor to create a new oviparous creature with specified parameters.
	 *
	 * @param name
	 * @param gender
	 * @param weight
	 * @param size
	 */
	public Oviparous(
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
	
	public void mate(Creature creature) {
		
	}
	
	public void layAnEgg() {
		
	}
}
