package model;

import java.time.LocalDate;

public class Season {
    // Attributes
    private int seasonNumber;
    private int scheduledEpisodes;
    private int publishedEpisodes;
    private LocalDate premierDate;
    private String trailerUrl;

    /**
     * Constructor of the season class. The published episodes are set as 0
     * 
     * @param seasonNumber number of the season
     * @param scheduledEpisodes scheduled episodes for the season
     * @param premierDate premier date of the season
     * @param trailerUrl trailer URL of the season
     */
    public Season(int seasonNumber, int scheduledEpisodes, LocalDate premierDate, String trailerUrl) {
        this.seasonNumber = seasonNumber;
        this.scheduledEpisodes = scheduledEpisodes;
        this.premierDate = premierDate;
        this.trailerUrl = trailerUrl;
    }

    /**
     * Returns the season number
     * @return the number of the season
     */
    public int getSeasonNumber() {
        return seasonNumber;
    }

    /**
     * Sets the season number
     * @param seasonNumber the season number to set
     */
    public void setSeasonNumber(int seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    /**
     * Returns the scheduled episodes
     * @return the scheduled episodes of the season
     */
    public int getScheduledEpisodes() {
        return scheduledEpisodes;
    }

    /**
     * Sets the scheduled episodes
     * @param scheduledEpisodes the scheduled episodes to set
     */
    public void setScheduledEpisodes(int scheduledEpisodes) {
        this.scheduledEpisodes = scheduledEpisodes;
    }

    /**
     * Returns the published episodes
     * @return the published episodes of the season
     */
    public int getPublishedEpisodes() {
        return publishedEpisodes;
    }

    /**
     * Sets the published episodes
     * @param publishedEpisodes the published episodes to set
     */
    public void setPublishedEpisodes(int publishedEpisodes) {
        this.publishedEpisodes = publishedEpisodes;
    }

    /**
     * Returns the premier date
     * @return the premier date of the season
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
     * Returns the trailer URL
     * @return the trailer URL of the season
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
	 * Synthesizes the information of the show in a String
	 * @return a string representation of the object
	 */
    public String toString() {
        return "Season number: " + seasonNumber + " | Scheduled episodes: " + scheduledEpisodes + " | Published episodes: " + publishedEpisodes + " | Premier date: " + premierDate + " | Trailer URL: " + trailerUrl;
    }
}
