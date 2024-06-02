package models.master;

import models.creatures.Creature;
import models.enclosures.Enclosure;

/**
 * Represents a master who manages enclosures and creatures in the zoo.
 */
public class Master {

    /**
     * Enumeration for gender.
     */
    public enum Gender {
        /**
         * M gender.
         */
        M,
        /**
         * F gender.
         */
        F };
	
	private String name;
	private int age;
	private Gender gender;
	private int money;

    /**
     * Constructor to create a new master with specified parameters.
     *
     * @param name   the name
     * @param age    the age
     * @param gender the gender
     * @param money  the money
     */
    public Master(
		String name,
		int age,
		Gender gender,
		int money
	) {
		this.setName(name);
		this.setAge(age);
		this.setGender(gender);
		this.setMoney(money);
	}

    /**
     * Examines the given enclosure.
     *
     * @param enclosure The enclosure to examine.
     */
    public void examinateEnclosure(Enclosure enclosure) {
		
	}

    /**
     * Cleans the given enclosure.
     *
     * @param enclosure The enclosure to clean.
     */
    public void cleanEnclosure(Enclosure enclosure) {
		enclosure.setCleanliness(0);
	}

    /**
     * Feeds all creatures in the given enclosure.
     *
     * @param enclosure The enclosure containing creatures to feed.
     */
    public void feedCreatureInEnclosure(Enclosure enclosure) {
		enclosure.feedAll();
	}

    /**
     * Adds a creature to the given enclosure.
     *
     * @param enclosure The enclosure to add the creature to.
     * @param creature  The creature to add.
     */
    public void addCreatureInEnclosure(Enclosure enclosure, Creature creature) {
		enclosure.addCreature(creature);
	}

    /**
     * Decreases the master's money by the specified amount.
     *
     * @param moneySpend The amount of money to spend.
     */
    public void spendMoney(int moneySpend) {
		this.setMoney(this.getMoney() - moneySpend);
	}

    /**
     * Increases the master's money by the specified amount.
     *
     * @param earnedMoney The amount of money earned.
     */
    public void earnMoney(int earnedMoney) {
		this.setMoney(this.getMoney() + earnedMoney);
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
     * Gets age.
     *
     * @return the age
     */
    public int getAge() {
		return age;
	}

    /**
     * Sets age.
     *
     * @param age the age
     */
    public void setAge(int age) {
		this.age = age;
	}

    /**
     * Gets gender.
     *
     * @return the gender
     */
    public Gender getGender() {
		return gender;
	}

    /**
     * Sets gender.
     *
     * @param gender the gender
     */
    public void setGender(Gender gender) {
		this.gender = gender;
	}

    /**
     * Gets money.
     *
     * @return the money
     */
    public int getMoney() {
		return money;
	}

    /**
     * Sets money.
     *
     * @param money the money
     */
    public void setMoney(int money) {
		this.money = money;
	}

}
