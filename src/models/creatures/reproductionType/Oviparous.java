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
	 * @param age
	 */
	public Oviparous(
		String name, 
		Gender gender, 
		int weight, 
		int size,
		int age
	) {
		super(
			name, 
			gender, 
			weight, 
			size,
			age
		);
	}
	
	public void mate(Creature creature) {
		
	}
	
	public void layAnEgg() {
		
	}
}
