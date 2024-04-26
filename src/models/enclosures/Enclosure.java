package models.enclosures;

import models.creatures.Creature;

// Abstract class for enclosure
public abstract class Enclosure {
	private int[] position;
	private String name;
	private final int SURFACE;
	private final int MAX_ANIMAL;
	private Creature[] creatureList;
	private int cleanliness;
	private int ADD_PRICE;
	private int SELL_PRICE;
	private int MAINTENANCE_PRICE;
	/**
	 * Constructor to create a new creature with specified parameters.
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
	 */

	// Enclosure's constructor
	public Enclosure(
			int position,
			String name,
			int SURFACE,
			int MAX_ANIMAL,
			Creature[] creatureList,
			int cleanliness,
			int ADD_PRICE,
			int SELL_PRICE,
			int MAINTENANCE_PRICE
	) {
		this.setPosition(position);
		this.setName(name);
		this.SURFACE = SURFACE;
		this.MAX_ANIMAL = MAX_ANIMAL;
		this.creatureList = creatureList;
		this.cleanliness = cleanliness;
		this.ADD_PRICE = ADD_PRICE;
		this.SELL_PRICE = SELL_PRICE;
		this.MAINTENANCE_PRICE = MAINTENANCE_PRICE;


	}
	// Public Methods
	public void feedAll() {

	}
	public void addCreature() {

	}

	// Getter and setter for Enclosure

	public int getSurface() {
		return SURFACE;
	}

	public int getMAX_ANIMAL() {
		return MAX_ANIMAL;
	}

	public Creature[] getCreatureList() {
		return creatureList;
	}

	public void setCreatureList(Creature[] creatureList) {
		this.creatureList = creatureList;
	}

	public int getCleanliness() {
		return cleanliness;
	}

	public void setCleanliness(int cleanliness) {
		this.cleanliness = cleanliness;
	}

	public int getAddPrice() {
		return ADD_PRICE;
	}

	public void setAddPrice(int ADD_PRICE) {
		this.ADD_PRICE = ADD_PRICE;
	}

	public int getSellPrice() {
		return SELL_PRICE;
	}

	public void setSellPrice(int SELL_PRICE) {
		this.SELL_PRICE = SELL_PRICE;
	}

	public int getMaintenancePrice() {
		return MAINTENANCE_PRICE;
	}

	public void setMaintenancePrice(int MAINTENANCE_PRICE) {
		this.MAINTENANCE_PRICE = MAINTENANCE_PRICE;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int[] getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = new int[]{position};
	}
}



