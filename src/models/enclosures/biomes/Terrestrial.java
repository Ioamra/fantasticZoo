package models.enclosures.biomes;

import models.enclosures.Enclosure;

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
