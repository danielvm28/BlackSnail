package model;

import java.time.LocalDate;

public class Movie extends Product{
    // Attributes
    private String producer;
    private int minimumWatchAge;
    private String trailerUrl;

    // Relation
    private MovieCategory category;

    /**
     * Constructor of the movie class
     * 
     * @param name name of the movie
     * @param nameOfDirector name of the director of the movie
     * @param synopsis synopsis of the movie
     * @param premierDate premier date of the movie
     * @param producer producer of the movie
     * @param minimumWatchAge the minimum age required to watch the movie
     * @param trailerUrl the URL in which the trailer for the movie can be found
     * @param movieCategorySelection a selection of the movie category (<code>1</code>: Romantic, <code>2</code>: Action, <code>3</code>: Suspense, <code>4</code>: Horror, <code>5</code>: Comedy)
     */
    public Movie(String name, String nameOfDirector, String synopsis, LocalDate premierDate, String producer,
            int minimumWatchAge, String trailerUrl, int movieCategorySelection) {
        super(name, nameOfDirector, synopsis, premierDate);
        this.producer = producer;
        this.minimumWatchAge = minimumWatchAge;
        this.trailerUrl = trailerUrl;
        setCategory(movieCategorySelection);
    }

    /**
	 * Returns the producer
	 * @return producer of the movie
	 */
    public String getProducer() {
        return producer;
    }

    /**
	 * Sets the producer
	 * @param producer the producer to set
	 */
    public void setProducer(String producer) {
        this.producer = producer;
    }

    /**
     * Returns the minimum age to watch
     * @return minimum age to watch the movie
     */
    public int getMinimumWatchAge() {
        return minimumWatchAge;
    }

    /**
     * Sets the minimum age to watch
     * @param minimumWatchAge the minimum age to set
     */
    public void setMinimumWatchAge(int minimumWatchAge) {
        this.minimumWatchAge = minimumWatchAge;
    }

    /**
     * Returns the trailer URL
     * @return the trailer URL of the movie
     */
    public String getTrailerUrl() {
        return trailerUrl;
    }

    /**
     * Sets the trailer URL
     * @param trailerUrl the trailer URL to set
     */
    public void setTrailerUrl(String trailerUrl) {
        this.trailerUrl = trailerUrl;
    }

    /**
     * Retruns the category
     * @return the category of the movie
     */
    public MovieCategory getCategory() {
        return category;
    }

    /**
     * Sets the category
     * @param movieCategorySelection the selection of the movie category (<code>1</code>: Romantic, <code>2</code>: Action, <code>3</code>: Suspense, <code>4</code>: Horror, <code>5</code>: Comedy)
     */
    public void setCategory(int movieCategorySelection) {
        switch (movieCategorySelection) {
            case 1:
                category = MovieCategory.ROMANTIC;
                break;
            case 2:
                category = MovieCategory.ACTION;
                break;
            case 3:
                category = MovieCategory.SUSPENSE;
                break;
            case 4:
                category = MovieCategory.HORROR;
                break;
            case 5:
                category = MovieCategory.COMEDY;
                break;
        }
    }

    /**
	 * Synthesizes the information of the movie in a String
	 * @return a string representation of the object
	 */
    @Override
    public String toString(){
        String message = super.toString();
        message += " | Producer: " + producer + " | Minimum age to watch: " + minimumWatchAge + " | Trailer URL: " + trailerUrl + " | Category: " + category;

        return message;
    }
}
