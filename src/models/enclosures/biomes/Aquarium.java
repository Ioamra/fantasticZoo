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
	 * @param surface
	 * @param cleanliness
	 * @param depth
	 * @param salinity
	 */
	public Aquarium(
			int position,
			String name,
			int surface,
			int cleanliness,
			int depth,
			int salinity
	) {
		super(
			position,
			name,
			surface,
			cleanliness
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
