package models.zoo;

import models.enclosures.Enclosure;
import models.master.Master;

/**
 * Represents a zoo with enclosures managed by a master.
 */
public class Zoo {
	
	private String name;
	private Master master;
	private final int MAX_ENCLOSURE;
	private Enclosure[] enclosureList;

	/**
	 * Constructor to create a new zoo with specified parameters.
	 * 
	 * @param name
	 * @param master
	 * @param MAX_ENCLOSURE
	 * @param enclosureList
	 */
	public Zoo(
		String name,
		Master master,
		int MAX_ENCLOSURE,
		Enclosure[] enclosureList
	) {
		this.setName(name);
		this.setMaster(master);
		this.MAX_ENCLOSURE = MAX_ENCLOSURE;
		this.setEnclosureList(enclosureList);
	}

	// Getters and Setters
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Master getMaster() {
		return master;
	}

	public void setMaster(Master master) {
		this.master = master;
	}

	public Enclosure[] getEnclosureList() {
		return enclosureList;
	}

	public void setEnclosureList(Enclosure[] enclosureList) {
		this.enclosureList = enclosureList;
	}

	public int getMAX_ENCLOSURE() {
		return MAX_ENCLOSURE;
	}
}
