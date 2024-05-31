package models.creatures;

import config.Constants;

public abstract class Creature {
	
	public enum Gender { M, F };
	private enum State {DEAD, SICK, HEALTHY};
	
	private String name;
	private Gender gender;
	private int weight;
	private int size;
	protected int age;
	private int hunger;
	private boolean sleep;
	private int stamina;
	private State state;
	private int hp;
	
	/**
	 * Constructor to create a new creature with specified parameters.
	 * 
	 * @param name
	 * @param gender
	 * @param weight
	 * @param size
	 * @param age
	 */
	public Creature(
		String name, 
		Gender gender, 
		int weight, 
		int size,
		int age
	) {
		this.setName(name);
		this.setGender(gender);
		this.setWeight(weight);
		this.setSize(size);
		this.setAge(age);
		this.setHunger(Constants.Creature.MAX_HUNGER);
		this.setStamina(Constants.Creature.MAX_STAMINA);
		this.setSleep(false);
		this.setState(State.HEALTHY);
	}
	
	/**
	 * Change the hunger to MAX_HUNGER.
	 */
	public void eat() {
		this.setHunger(Constants.Creature.MAX_HUNGER);
	}
	
	/**
	 * Toggles the sleep state of the creature.
	 */
	public void toggleSleep() {
		this.setSleep(!this.sleep);
	}
	
	/**
	 * Sets the state of the creature to DEAD.
	 */
	public void die() {
		this.setState(State.DEAD);
	}

	/**
	 * Restores the creature's health points (HP) to its maximum value.
	 */
	public abstract void heal();
	
	/**
	 * Checks if the creature's age exceeds the maximum age limit and triggers death if so.
	 */
	public abstract void checkAge();
	
	/**
	 * Produces a sound specific to the creature.
	 */
	public abstract void makeSound();
	
	/**
	 * Initiates the mating process with another creature.
	 *
	 * @param mate The creature to mate with.
	 */
	public abstract void mate(Creature mate);

	// Getters and Setters
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public double getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getHunger() {
		return hunger;
	}

	public void setHunger(int hunger) {
		this.hunger = hunger;
	}

	public boolean isSleep() {
		return sleep;
	}

	public void setSleep(boolean sleep) {
		this.sleep = sleep;
	}

	public int getStamina() {
		return stamina;
	}

	public void setStamina(int stamina) {
		this.stamina = stamina;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}
}
