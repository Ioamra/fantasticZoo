package models.enclosures.biomes;

import models.enclosures.Enclosure;

/**
 * Represents an aviary enclosure, which is a type of enclosure for birds.
 */
public class Aviary extends Enclosure {
	
	private int height;

	/**
	 * Constructor to create a new aviary enclosure with specified parameters.
	 * 
	 * @param position
	 * @param name
	 * @param surface
	 * @param cleanliness
	 * @param height
	 */
	public Aviary(
		int position,
		String name,
		int surface,
		int cleanliness,
		int height
	) {
		super(
			position,
			name,
			surface,
			cleanliness
		);
		this.setHeight(height);
	}
	
	/**
	 * Cleans the roof of the aviary.
	 */
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
