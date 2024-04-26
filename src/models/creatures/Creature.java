package models.creatures;

public abstract class Creature {
	
	public enum Gender { M, F };
	private enum State {DEAD, SICK, HEALTHY};
	
	private String name;
	private Gender gender;
	private double weight;
	private double size;
	private final int MAX_AGE;
	private int age;
	private final int MAX_HUNGER;
	private int hunger;
	private boolean sleep;
	private final int MAX_STAMINA;
	private int stamina;
	private State state;
	private final int MAX_HP;
	private int hp;
	private final int ADD_PRICE;
	private final int SELL_PRICE;
	private final int MAINTENANCE_PRICE;
	private final int MONEY_GAIN;
	
	/**
	 * Constructor to create a new creature with specified parameters.
	 * 
	 * @param name
	 * @param gender
	 * @param weight
	 * @param size
	 * @param MAX_AGE
	 * @param MAX_HUNGER
	 * @param MAX_STAMINA
	 * @param MAX_HP
	 * @param ADD_PRICE
	 * @param SELL_PRICE
	 * @param MAINTENANCE_PRICE
	 * @param MONEY_GAIN
	 */
	public Creature(
		String name, 
		Gender gender, 
		double weight, 
		double size, 
		int MAX_AGE, 
		int MAX_HUNGER, 
		int MAX_STAMINA, 
		int MAX_HP, 
		int ADD_PRICE, 
		int SELL_PRICE, 
		int MAINTENANCE_PRICE, 
		int MONEY_GAIN
	) {
		this.setName(name);
		this.setGender(gender);
		this.setWeight(weight);
		this.setSize(size);
		this.MAX_AGE = MAX_AGE;
		this.MAX_HUNGER = MAX_HUNGER;
		this.MAX_STAMINA = MAX_STAMINA;
		this.MAX_HP = MAX_HP; 
		this.ADD_PRICE = ADD_PRICE; 
		this.SELL_PRICE = SELL_PRICE;
		this.MAINTENANCE_PRICE = MAINTENANCE_PRICE;
		this.MONEY_GAIN = MONEY_GAIN;
		this.setAge(0);
		this.setHunger(MAX_HUNGER);
		this.setStamina(MAX_STAMINA);
		this.setHp(MAX_HP);
		this.setSleep(false);
		this.setState(State.HEALTHY);
	}
	
	/**
	 * Change the hunger to MAX_HUNGER.
	 */
	public void eat() {
		this.setHunger(this.MAX_HUNGER);
	}
	
	/**
	 * Restores the creature's health points (HP) to its maximum value.
	 */
	public void heal() {
		this.setHp(this.MAX_HP);
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
	 * Checks if the creature's age exceeds the maximum age limit and triggers death if so.
	 */
	public void checkAge() {
		if (this.age > this.MAX_AGE) {
			this.die();
		}
	}
	
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

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
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

	public int getMAX_AGE() {
		return MAX_AGE;
	}

	public int getMAX_HUNGER() {
		return MAX_HUNGER;
	}

	public int getMAX_STAMINA() {
		return MAX_STAMINA;
	}

	public int getMAX_HP() {
		return MAX_HP;
	}

	public int getADD_PRICE() {
		return ADD_PRICE;
	}

	public int getSELL_PRICE() {
		return SELL_PRICE;
	}

	public int getMAINTENANCE_PRICE() {
		return MAINTENANCE_PRICE;
	}

	public int getMONEY_GAIN() {
		return MONEY_GAIN;
	}

}
