package models.enclosures.biomes;

import models.creatures.Creature;
import models.enclosures.Enclosure;

public class Terrestrial extends Enclosure {

	/**
	 * Constructor to create a new terrestrial enclosure with specified parameters.
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
	public Terrestrial(
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

}
