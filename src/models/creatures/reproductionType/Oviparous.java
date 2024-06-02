package models.creatures.reproductionType;
import models.creatures.Creature;
/**
 * Represents an oviparous creature, which reproduces by laying eggs.
 */
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
	
	/**
	 * Oviparous creatures mate by laying eggs.
	 *
	 * @param creature The creature to mate with.
	 */
	public void mate(Creature creature) {
		
	}

	/**
	 * Oviparous creatures lay eggs.
	 */
	public void layAnEgg() {
		
	}
}
