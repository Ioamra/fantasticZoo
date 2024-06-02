package models.creatures;

import config.Constants;

/**
 * Represents a creature in the zoo, with various attributes and behaviors.
 */
public abstract class Creature {

    /**
     * The enum Gender.
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
	private enum State {
        /**
         * Dead state.
         */
        DEAD,
        /**
         * Sick state.
         */
        SICK,
        /**
         * Healthy state.
         */
        HEALTHY};
	
	private String name;
	private Gender gender;
	private int weight;
	private int size;
    /**
     * The Age.
     */
    protected int age;
	private int hunger;
	private boolean sleep;
	private int stamina;
	private State state;
	private int hp;

    /**
     * Constructor to create a new creature with specified parameters.
     *
     * @param name   the name
     * @param gender the gender
     * @param weight the weight
     * @param size   the size
     * @param age    the age
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
     * Gets weight.
     *
     * @return the weight
     */
    public double getWeight() {
		return weight;
	}

    /**
     * Sets weight.
     *
     * @param weight the weight
     */
    public void setWeight(int weight) {
		this.weight = weight;
	}

    /**
     * Gets size.
     *
     * @return the size
     */
    public double getSize() {
		return size;
	}

    /**
     * Sets size.
     *
     * @param size the size
     */
    public void setSize(int size) {
		this.size = size;
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
     * Gets hunger.
     *
     * @return the hunger
     */
    public int getHunger() {
		return hunger;
	}

    /**
     * Sets hunger.
     *
     * @param hunger the hunger
     */
    public void setHunger(int hunger) {
		this.hunger = hunger;
	}

    /**
     * Is sleep boolean.
     *
     * @return the boolean
     */
    public boolean isSleep() {
		return sleep;
	}

    /**
     * Sets sleep.
     *
     * @param sleep the sleep
     */
    public void setSleep(boolean sleep) {
		this.sleep = sleep;
	}

    /**
     * Gets stamina.
     *
     * @return the stamina
     */
    public int getStamina() {
		return stamina;
	}

    /**
     * Sets stamina.
     *
     * @param stamina the stamina
     */
    public void setStamina(int stamina) {
		this.stamina = stamina;
	}

    /**
     * Gets state.
     *
     * @return the state
     */
    public State getState() {
		return state;
	}

    /**
     * Sets state.
     *
     * @param state the state
     */
    public void setState(State state) {
		this.state = state;
	}

    /**
     * Gets hp.
     *
     * @return the hp
     */
    public int getHp() {
		return hp;
	}

    /**
     * Sets hp.
     *
     * @param hp the hp
     */
    public void setHp(int hp) {
		this.hp = hp;
	}
}
