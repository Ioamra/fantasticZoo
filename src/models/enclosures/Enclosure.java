package models.enclosures;

import models.creatures.Creature;

public abstract class Enclosure {
	
	private int position;
	private String name;
	private int surface;
	private Creature[] creatureList;
	private int cleanliness;
	
	/**
	 * Constructor to create a new enclosure with specified parameters.
	 *
	 * @param position	
	 * @param name
	 * @param surface
	 * @param cleanliness
	 */
	public Enclosure(
			int position,
			String name,
			int surface,
			int cleanliness
	) {
		this.setPosition(position);
		this.setName(name);
		this.setSurface(surface);
		setCreatureList(new Creature[0]);
		setCleanliness(cleanliness);
	}

	/**
	 * Feeds all creatures in the creature list.
	 */
	public void feedAll() {
		for (Creature creature: creatureList) {
			creature.eat();
		}
	}
	
	/**
	 * Add a creatures in the creature list.
	 */
	public void addCreature(Creature creature) {
		Creature[] creatureListTmp = new Creature[creatureList.length + 1];
		 for (int i = 0; i < creatureList.length; i++) {
			 creatureListTmp[i] = creatureList[i];
		 }
		 creatureListTmp[creatureList.length] = creature;
		 setCreatureList(creatureListTmp);
	}
	
	/**
	 * Remove a creatures in the creature list.
	 */
	public void removeCreature(Creature creature) {
		
	}

	// Getters and Setters

	public Creature[] getCreatureList() {
		return creatureList;
	}

	public void setCreatureList(Creature[] creatureList) {
		this.creatureList = creatureList;
	}

	public int getCleanliness() {
		return cleanliness;
	}

	public void setCleanliness(int cleanliness) {
		this.cleanliness = cleanliness;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
	
	public int getSurface() {
		return surface;
	}

	public void setSurface(int surface) {
		this.surface = surface;
	}
}
