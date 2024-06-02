package models.enclosures;

import config.Constants;
import models.creatures.Creature;

/**
 * Represents an enclosure where creatures are housed.
 */
public abstract class Enclosure {
	
	private int position;
	private String name;
	private int surface;
	private Creature[] creatureList;
	private int cleanliness;

    /**
     * Constructor to create a new enclosure with specified parameters.
     *
     * @param position    the position
     * @param name        the name
     * @param surface     the surface
     * @param cleanliness the cleanliness
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
     * set the Cleanliness of the enclosure to 100
     */
    public void clean() {
		this.setCleanliness(Constants.Enclosure.MAX_CLEANLINESS);
	}

    /**
     * Heal all creatures in the creature list.
     */
    public void healAll() {
		for (Creature creature: creatureList) {
			creature.heal();
		}
	}

    /**
     * Add a creatures in the creature list.
     *
     * @param creature the creature
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
     *
     * @param creature the creature
     */
    public void removeCreature(Creature creature) {
	    for (int i = 0; i < creatureList.length; i++) {
	        if (creatureList[i].equals(creature)) {
	        	Creature[] newCreatureList = new Creature[creatureList.length - 1];
		        System.arraycopy(creatureList, 0, newCreatureList, 0, i);
		        System.arraycopy(creatureList, i + 1, newCreatureList, i, creatureList.length - i - 1);
		        creatureList = newCreatureList;
		        break;
	        }
	    }
	}

	// Getters and Setters

    /**
     * Get creature list creature [ ].
     *
     * @return the creature [ ]
     */
    public Creature[] getCreatureList() {
		return creatureList;
	}

    /**
     * Sets creature list.
     *
     * @param creatureList the creature list
     */
    public void setCreatureList(Creature[] creatureList) {
		this.creatureList = creatureList;
	}

    /**
     * Gets cleanliness.
     *
     * @return the cleanliness
     */
    public int getCleanliness() {
		return cleanliness;
	}

    /**
     * Sets cleanliness.
     *
     * @param cleanliness the cleanliness
     */
    public void setCleanliness(int cleanliness) {
		this.cleanliness = cleanliness;
	}

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
		return name;
	}

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
		this.name = name;
	}

    /**
     * Gets position.
     *
     * @return the position
     */
    public int getPosition() {
		return position;
	}

    /**
     * Sets position.
     *
     * @param position the position
     */
    public void setPosition(int position) {
		this.position = position;
	}

    /**
     * Gets surface.
     *
     * @return the surface
     */
    public int getSurface() {
		return surface;
	}

    /**
     * Sets surface.
     *
     * @param surface the surface
     */
    public void setSurface(int surface) {
		this.surface = surface;
	}
}
