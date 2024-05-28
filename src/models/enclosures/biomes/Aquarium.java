package models.enclosures.biomes;

import models.enclosures.Enclosure;

public class Aquarium extends Enclosure {

	private int depth;
	private int salinity;

	/**
	 * Constructor to create a new aquarium enclosure with specified parameters.
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
	public Aquarium(
			int position,
			String name,
			int SURFACE,
			int MAX_ANIMAL,
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
			cleanliness,
			ADD_PRICE,
			SELL_PRICE,
			MAINTENANCE_PRICE
		);
		this.setDepth(depth);
		this.setSalinity(salinity);
	}
	
	// Getters and Setters
	
	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getSalinity() {
		return salinity;
	}

	public void setSalinity(int salinity) {
		this.salinity = salinity;
	}
}
