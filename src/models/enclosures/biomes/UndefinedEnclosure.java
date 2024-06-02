package models.enclosures.biomes;

import models.enclosures.Enclosure;

/**
 * Represents an undefined enclosure, which is used as a placeholder for empty enclosure positions.
 */
public class UndefinedEnclosure extends Enclosure {
	
	/**
	 * Constructs a new undefined enclosure with the specified position.
	 *
	 * @param position The position of the undefined enclosure.
	 */
	public UndefinedEnclosure(int position) {
		super(position, "", 0, 0);
	}

}