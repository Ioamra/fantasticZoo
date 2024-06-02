package models.enclosures.biomes;

import models.enclosures.Enclosure;

/**
 * Represents a terrestrial enclosure in the zoo, specialized for land-dwelling creatures.
 */
public class Terrestrial extends Enclosure {

	/**
	 * Constructor to create a new terrestrial enclosure with specified parameters.
	 * 
	 * @param position
	 * @param name
	 * @param surface
	 * @param cleanliness
	 */
	public Terrestrial(
		int position,
		String name,
		int surface,
		int cleanliness
	) {
		super(
			position,
			name,
			surface,
			cleanliness
		);
	}

}
