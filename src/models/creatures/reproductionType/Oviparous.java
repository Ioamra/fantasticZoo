package models.creatures.reproductionType;
import models.creatures.Creature;

/**
 * Represents an oviparous creature, which reproduces by laying eggs.
 */
public abstract class Oviparous extends Creature {

    /**
     * Constructor to create a new oviparous creature with specified parameters.
     *
     * @param name   the name
     * @param gender the gender
     * @param weight the weight
     * @param size   the size
     * @param age    the age
     */
    public Oviparous(
		String name, 
		Gender gender, 
		int weight, 
		int size,
		int age,
		int hp
	) {
		super(
			name, 
			gender, 
			weight, 
			size,
			age,
			hp
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
