package models.creatures.reproductionType;

import models.creatures.Creature;

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
	
	public void giveBirth() {
		
	}

	public int getTimeBeforeGestation() {
		return timeBeforeGestation;
	}

	public void setTimeBeforeGestation(int timeBeforeGestation) {
		this.timeBeforeGestation = timeBeforeGestation;
	}
}
