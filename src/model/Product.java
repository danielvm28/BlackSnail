package model;

import java.time.LocalDate;

public abstract class Product {
    // Attributes
    private String name;
    private String nameOfDirector;
    private String synopsis;
    private LocalDate premierDate;

    /**
     * Constructor of the product class. This is an abstract class and parent of Show and Movie, it cannot be instantiated
     * @param name name of the product
     * @param nameOfDirector name of the director of the product
     * @param synopsis synopsis of the product
     * @param premierDate premier date of the product
     */
    public Product(String name, String nameOfDirector, String synopsis, LocalDate premierDate) {
        this.name = name;
        this.nameOfDirector = nameOfDirector;
        this.synopsis = synopsis;
        this.setPremierDate(premierDate);
    }

    /**
	 * Returns the name
	 * @return name of the product
	 */
    public String getName() {
        return name;
    }

    /**
	 * Sets the name
	 * @param name the name to set
	 */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the name of the director
	 * @return name of the director of the product
     */
    public String getNameOfDirector() {
        return nameOfDirector;
    }

    /**
     * Sets the name of the director
     * @param nameOfDirector the name of the director to set
     */
    public void setNameOfDirector(String nameOfDirector) {
        this.nameOfDirector = nameOfDirector;
    }

    /**
     * Returns the synopsis
	 * @return synopsis of the product
     */
    public String getSynopsis() {
        return synopsis;
    }

    /**
     * Sets the synopsis
     * @param synopsis the synopsis to set
     */
    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    /**
     * Returns the premier date
     * @return premier date of the product
     */
    public LocalDate getPremierDate() {
        return premierDate;
    }

    /**
     * Sets the premier date
     * @param premierDate the premier date to set
     */
    public void setPremierDate(LocalDate premierDate) {
        this.premierDate = premierDate;
    }

    /**
	 * Synthesizes the information of the product in a String
	 * @return a string representation of the object
	 */
    public String toString() {
        return "Name: " + name + " | Name of Director: " + nameOfDirector + " | Synopsis: " + synopsis + " | Premier date: " + premierDate;
    }
}
