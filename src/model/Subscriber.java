package model;

public class Subscriber {

	// Attributes
	private String id;
	private String fullName;
	private int age;
	private int hoursToConsume;
	private boolean active;

	//Relation
	private SubscriberType type;

	/**
	 * Constructor of the subscriber class. The active state and the type are set by default in active and NORMAL respectively
	 * @param id identification of the new subscriber
	 * @param fullName full name of the new subscriber
	 * @param age age of the new subscriber
	 * @param hoursToConsume hours that the new subscriber is willing to consume
	 */
	public Subscriber(String id, String fullName, int age, int hoursToConsume) {
		this.id = id;
		this.setFullName(fullName);
		this.age = age;
		this.hoursToConsume = hoursToConsume;
		this.active = true;
		type = SubscriberType.NORMAL;
	}

	/**
	 * Returns the id
	 * @return id of the subscriber
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * Sets the id 
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Returns the full name
	 * @return full name of the subscriber
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * Sets the full name
	 * @param fullName the full name to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * Returns the age
	 * @return age of the subscriber
	 */
	public int getAge() {
		return this.age;
	}

	/**
	 * Sets the age
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Returns the hours to consume
	 * @return hours that the subscriber is willing to consume 
	 */
	public int getHoursToConsume() {
		return this.hoursToConsume;
	}

	/**
	 * Sets the hours to consume
	 * @param hoursToConsume the hours to consume that will be set
	 */
	public void setHoursToConsume(int hoursToConsume) {
		this.hoursToConsume = hoursToConsume;
	}

	/**
	 * Returns the activity state
	 * @return activity state of the subscriber (true : active, false : inactive)
	 */
	public boolean isActive() {
		return this.active;
	}

	/**
	 * Sets the activity state
	 * @param active a boolean that determines the activity state (true : active, false : inactive)
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * Returns the type
	 * @return type of the subscriber
	 */
	public SubscriberType getType() {
		return type;
	}

	/**
	 * Sets the type
	 * @param selection the number that determines the type to set (<code>1</code>: Normal, <code>2</code>: Gold, <code>3</code>: Platinum, <code>4</code>: Diamond)
	 */
	public void setType(int selection) {
		switch (selection) {
			case 1:
				type = SubscriberType.NORMAL;
				break;
			case 2:
				type = SubscriberType.GOLD;
				break;
			case 3:
				type = SubscriberType.PLATINUM;
				break;
			case 4:
				type = SubscriberType.DIAMOND;
				break;
		}
	}

	/**
	 * Synthesizes the information of the subscriber in a String
	 * @return a string representation of the object
	 */
	public String toString() {
		String info = "";
		String status = active ? "Active" : "Inactive";

		info = "id: " + id + " | " + status + " | Type: " + type + " | Full name: " + fullName + " | Age: " + age + " | Hours willing to Consume: " + hoursToConsume;

		return info;
	}
}