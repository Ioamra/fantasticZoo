package models.creatures.eggs;

import models.creatures.reproductionType.Oviparous;

public class Egg {
	
	private Oviparous mother;
	private int timeBeforeHatch;

	public Egg(Oviparous mother, int timeBeforeHatch) {
		this.setMother(mother);
		this.setTimeBeforeHatch(timeBeforeHatch);
	}

	public Oviparous getMother() {
		return mother;
	}

	public void setMother(Oviparous mother) {
		this.mother = mother;
	}

	public int getTimeBeforeHatch() {
		return timeBeforeHatch;
	}

	public void setTimeBeforeHatch(int timeBeforeHatch) {
		this.timeBeforeHatch = timeBeforeHatch;
	}

	
}
