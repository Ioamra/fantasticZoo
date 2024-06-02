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
     * @param name          the name
     * @param master        the master
     * @param MAX_ENCLOSURE the max enclosure
     * @param enclosureList the enclosure list
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
     * Gets master.
     *
     * @return the master
     */
    public Master getMaster() {
		return master;
	}

    /**
     * Sets master.
     *
     * @param master the master
     */
    public void setMaster(Master master) {
		this.master = master;
	}

    /**
     * Get enclosure list enclosure [ ].
     *
     * @return the enclosure [ ]
     */
    public Enclosure[] getEnclosureList() {
		return enclosureList;
	}

    /**
     * Sets enclosure list.
     *
     * @param enclosureList the enclosure list
     */
    public void setEnclosureList(Enclosure[] enclosureList) {
		this.enclosureList = enclosureList;
	}

    /**
     * Gets max enclosure.
     *
     * @return the max enclosure
     */
    public int getMAX_ENCLOSURE() {
		return MAX_ENCLOSURE;
	}
}
