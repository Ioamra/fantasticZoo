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
	public enum Gender { M, F };
	
	private String name;
	private int age;
	private Gender gender;
	private int money;

	/**
	 * Constructor to create a new master with specified parameters.
	 * 
	 * @param name
	 * @param age
	 * @param gender
	 * @param money
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
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

}
