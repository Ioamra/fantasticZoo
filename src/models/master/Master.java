package models.master;

import models.creatures.Creature;
import models.enclosures.Enclosure;

public class Master {
	
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

	public void examinateEnclosure(Enclosure enclosure) {
		
	}
	
	public void cleanEnclosure(Enclosure enclosure) {
		enclosure.setCleanliness(0);
	}
	
	public void feedCreatureInEnclosure(Enclosure enclosure) {
		enclosure.feedAll();
	}
	
	public void addCreatureInEnclosure(Enclosure enclosure, Creature creature) {
		
	}
	
	public void spendMoney(int moneySpend) {
		this.setMoney(this.getMoney() - moneySpend);
	}

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
