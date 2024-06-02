package models.creatures.eggs;

import models.creatures.reproductionType.Oviparous;

/**
 * Represents an egg laid by an oviparous creature.
 */
public class Egg {
	
	private Oviparous mother;
	private int timeBeforeHatch;
	
	/**
	 * Constructs an egg with the specified mother and time before hatching.
	 *
	 * @param mother           The oviparous creature laying the egg.
	 * @param timeBeforeHatch  The time before the egg hatches.
	 */
	public Egg(Oviparous mother, int timeBeforeHatch) {
		this.setMother(mother);
		this.setTimeBeforeHatch(timeBeforeHatch);
	}
	
	/**
	 * Gets the mother of the egg.
	 *
	 * @return The oviparous creature that laid the egg.
	 */
	public Oviparous getMother() {
		return mother;
	}
	
	/**
	 * Sets the mother of the egg.
	 *
	 * @param mother The oviparous creature that laid the egg.
	 */
	public void setMother(Oviparous mother) {
		this.mother = mother;
	}
	
	/**
	 * Gets the time before the egg hatches.
	 *
	 * @return The time before the egg hatches.
	 */
	public int getTimeBeforeHatch() {
		return timeBeforeHatch;
	}
	
	/**
	 * Sets the time before the egg hatches.
	 *
	 * @param timeBeforeHatch The time before the egg hatches.
	 */
	public void setTimeBeforeHatch(int timeBeforeHatch) {
		this.timeBeforeHatch = timeBeforeHatch;
	}
}
