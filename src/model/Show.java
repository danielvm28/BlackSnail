package model;

import java.time.LocalDate;

public class Show extends Product{
    // Constants
    public static final int MAX_SEASONS = 10;

    // Attributes
    private String[] protagonists;
    private boolean censored;
    private String censorMotif;

    // Relation
    private Season[] seasons;
    
    /**
     * Constructor of the show class
     * 
     * @param name name of the show
     * @param nameOfDirector name of the director of the show
     * @param synopsis synopsis of the show
     * @param premierDate premier date of the show
     * @param protagonists a string array indicating the protagonists of the show
	 * @param censored boolean to determine if the show has been censored or not
	 * @param censorMotif the censor motif of the show
     */
    public Show(String name, String nameOfDirector, String synopsis, LocalDate premierDate,
            String[] protagonists, boolean censored, String censorMotif) {
        super(name, nameOfDirector, synopsis, premierDate);
        this.protagonists = protagonists;
        this.censored = censored;
        this.censorMotif = censorMotif;
        seasons = new Season[MAX_SEASONS];
    }

    /**
	 * Returns the protagonists
	 * @return protagonists of the show
	 */
    public String[] getProtagonists() {
        return protagonists;
    }

    /**
	 * Sets the protagonists
	 * @param protagonists the protagonists to set
	 */
    public void setProtagonists(String[] protagonists) {
        this.protagonists = protagonists;
    }

    /**
     * Returns if the show is censored or not
     * @return a true or false value
     */
    public boolean isCensored() {
        return censored;
    }

    /**
     * Sets the censored value
     * @param censored the censored value to set
     */
    public void setCensored(boolean censored) {
        this.censored = censored;
    }

    /**
     * Returns the censor motif
     * @return the censor motif of the show
     */
    public String getCensorMotif() {
        return censorMotif;
    }

    /**
     * Sets the censor motif
     * @param censorMotif the censor motif to set
     */
    public void setCensorMotif(String censorMotif) {
        this.censorMotif = censorMotif;
    }

    /**
     * Adds a season to the show
     * 
     * @param newSeason the season object
     * @return a message indicating the result of the operation
     */
    public String addSeason(Season newSeason) {
        String message = "";
        int pos = searchSeasonsAvailableSpace();

        // Identify if the seasons are already full or not. Return a message accordingly
        if (pos == -1) {
            message = "Error, the seasons are full";
        } else {
            seasons[pos] = newSeason;
            message = "The season has been added successfully";
        }

        return message;
    }

    /**
     * Returns the season array
     * @return the season array of the show
     */
    public Season[] getSeasons(){
        return seasons;
    }

    /**
     * Gets the index of an available space of the season array
     * @return the index of the free space. Returns <code>-1</code> if the array is full
     */
    public int searchSeasonsAvailableSpace() {
        // Goes over the array and returns the index that contains a null value
        for (int i = 0; i < seasons.length; i++) {
            if (seasons[i] == null) {
                return i;
            }
        }

        // If not found, the array is full, so return -1
        return -1;
    }

    /**
	 * Synthesizes the information of the show in a String
	 * @return a string representation of the object
	 */
    @Override
    public String toString() {
        String message = super.toString();
        String censoredString = (censored) ? "Censored" : "Not censored";

        message += " | " + censoredString;
        message += censored ? " | Censor Motif: " + censorMotif : "";
        message += "\nProtagonists:";

        // For loop to add the protagonists
        for (int i = 0; i < protagonists.length; i++) {
            if (i == 0) {
                message += " " + protagonists[i];
            } else {
                message += ", " + protagonists[i];
            }
        }

        return message;
    }

}
