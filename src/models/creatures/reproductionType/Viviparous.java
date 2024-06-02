package models.creatures.reproductionType;

import models.creatures.Creature;
/**
 * Represents a viviparous creature, which gives birth to live offspring.
 */
public abstract class Viviparous extends Creature {
	private int timeBeforeGestation;
	
	/**
	 * Constructor to create a new viviparous creature with specified parameters.
	 *
	 * @param name
	 * @param gender
	 * @param weight
	 * @param size
	 */
	public Viviparous(
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
	 * Viviparous creatures mate to reproduce.
	 *
	 * @param creature The creature to mate with.
	 */
	public void mate(Creature creature) {
		
	}
	
	/**
	 * Viviparous creatures give birth to live offspring.
	 */
	public void giveBirth() {
		
	}
	
	/**
	 * Gets the time before gestation for the viviparous creature.
	 *
	 * @return The time before gestation.
	 */
	public int getTimeBeforeGestation() {
		return timeBeforeGestation;
	}
	
	/**
	 * Sets the time before gestation for the viviparous creature.
	 *
	 * @param timeBeforeGestation The time before gestation to set.
	 */
	public void setTimeBeforeGestation(int timeBeforeGestation) {
		this.timeBeforeGestation = timeBeforeGestation;
	}
}
