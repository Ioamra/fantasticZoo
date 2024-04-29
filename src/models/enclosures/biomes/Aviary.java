package models.enclosures.biomes;

import models.creatures.Creature;
import models.enclosures.Enclosure;

public class Aviary extends Enclosure {
	
	private int height;

	/**
	 * Constructor to create a new aviary enclosure with specified parameters.
	 * 
	 * @param position
	 * @param name
	 * @param SURFACE
	 * @param MAX_ANIMAL
	 * @param creatureList
	 * @param cleanliness
	 * @param ADD_PRICE
	 * @param SELL_PRICE
	 * @param MAINTENANCE_PRICE
	 * @param depth
	 * @param salinity
	 */
	public Aviary(
		int position,
		String name,
		int SURFACE,
		int MAX_ANIMAL,
		Creature[] creatureList,
		int cleanliness,
		int ADD_PRICE,
		int SELL_PRICE,
		int MAINTENANCE_PRICE,
		int depth,
		int salinity
	) {
		super(
			position,
			name,
			SURFACE,
			MAX_ANIMAL,
			creatureList,
			cleanliness,
			ADD_PRICE,
			SELL_PRICE,
			MAINTENANCE_PRICE
		);
	}
	
	public void cleanRoof() {
		
	}
	
	// Getters and Setters

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}
