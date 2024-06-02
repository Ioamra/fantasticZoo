package models.enclosures.biomes;

import models.enclosures.Enclosure;

/**
 * Represents an aquarium enclosure in the zoo, specialized for aquatic creatures.
 */
public class Aquarium extends Enclosure {

	private int depth;
	private int salinity;

    /**
     * Constructor to create a new aquarium enclosure with specified parameters.
     *
     * @param position    the position
     * @param name        the name
     * @param surface     the surface
     * @param cleanliness the cleanliness
     * @param depth       the depth
     * @param salinity    the salinity
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

    /**
     * Gets depth.
     *
     * @return the depth
     */
    public int getDepth() {
		return depth;
	}

    /**
     * Sets depth.
     *
     * @param depth the depth
     */
    public void setDepth(int depth) {
		this.depth = depth;
	}

    /**
     * Gets salinity.
     *
     * @return the salinity
     */
    public int getSalinity() {
		return salinity;
	}

    /**
     * Sets salinity.
     *
     * @param salinity the salinity
     */
    public void setSalinity(int salinity) {
		this.salinity = salinity;
	}
}
