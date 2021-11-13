package model;

import java.time.LocalDate;

public class Channel {
	// Constants
	public static final int MAX_SUBS = 50;
	public static final int MAX_PRODUCTS = 85;

	// Attributes
	private String nit;
	private String address;
	private String website;

	// Relation
	private Subscriber[] subscribers;
	private Product[] products;

	/**
	 * Constructor of the channel class
	 * 
	 * @param nit     NIT of the channel
	 * @param address address of the channel
	 * @param website website of the channel
	 */
	public Channel(String nit, String address, String website) {
		this.nit = nit;
		this.address = address;
		this.website = website;
		subscribers = new Subscriber[MAX_SUBS];
		products = new Product[MAX_PRODUCTS];
	}

	/**
	 * Returns the NIT
	 * 
	 * @return NIT of the channel
	 */
	public String getNit() {
		return this.nit;
	}

	/**
	 * Sets the NIT
	 * 
	 * @param nit the NIT to set
	 */
	public void setNit(String nit) {
		this.nit = nit;
	}

	/**
	 * Returns the address
	 * 
	 * @return address of the channel
	 */
	public String getAddress() {
		return this.address;
	}

	/**
	 * Sets the address
	 * 
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Returns the website
	 * 
	 * @return website of the channel
	 */
	public String getWebsite() {
		return this.website;
	}

	/**
	 * Sets the website
	 * 
	 * @param website the website to set
	 */
	public void setWebsite(String website) {
		this.website = website;
	}

	/**
	 * Method that creates a subscriber with all its settable attributes
	 * 
	 * <p>
	 * <b>Precondition: </b> The user selected the option to add a new subscriber in
	 * the menu and entered all the relevant data to the program
	 * <p>
	 * <b>Postcondition: </b> A message that may indicate the creation of a new
	 * subscriber inside the subscriber array or not
	 * 
	 * @param id             identification of the new subscriber
	 * @param fullName       full name of the new subscriber
	 * @param age            age of the new subscriber
	 * @param hoursToConsume hours that the new subscriber is willing to consume
	 * @return a message indicating the result of the operation
	 */
	public String addSubscriber(String id, String fullName, int age, int hoursToConsume) {
		// A message that will notify the result of the operation
		String message = "";

		// Check if there is space in the array and if there is already a subscriber
		// with the same id as the one that will be created
		if (!checkSubscriberAvailability()) {
			message = "Error, there is no room for more subscribers";
		} else if (searchSubscriber(id) != null) {
			message = "Error, there is already a subscriber with the same id";
		} else {
			// If a certain position in the subscriber array is empty, create a new
			// subscriber inside and break out of the loop
			for (int i = 0; i < subscribers.length; i++) {
				if (subscribers[i] == null) {
					subscribers[i] = new Subscriber(id, fullName, age, hoursToConsume);
					break;
				}
			}

			message = "Subscriber added successfully";
		}

		// Return the result of the operation
		return message;
	}

	/**
	 * Deactivates a subscriber according to user input and returns a message
	 * indicating the result of the operation
	 * 
	 * <p>
	 * <b>Precondition: </b> At least one subscriber exists. The user selected the
	 * option to deactivate a subscriber in the menu, and entered the position of
	 * the subscriber according to a list that contains all of the subscribers
	 * <p>
	 * <b>Postcondition: </b> A message indicates if the subscriber is deactivated
	 * or not. This meaning that the active value would be set to false and the type
	 * set to NORMAL
	 * 
	 * @param pos the position of the list that indicates the subscriber that will
	 *            be deactivated
	 * @return a message indicating the result of the operation
	 */
	public String deactivateSubscriber(int pos) {
		String message = "";

		// Set the activity to false and the type to NORMAL (the selection for NORMAL is
		// 1)
		if (subscribers[pos] != null) {
			subscribers[pos].setActive(false);
			subscribers[pos].setType(1);

			message = "Subscriber deactivated successfully";
		} else {
			message = "Error, subscriber does not exist";
		}

		return message;
	}

	/**
	 * Checks the availability of the subscriber array in order to add more
	 * subscribers
	 * 
	 * <p>
	 * <b>Precondition: </b> The method is called in addSubscriber
	 * <p>
	 * <b>Postcondition: </b> The availability of the subscriber array is stated
	 * 
	 * @return a boolean indicating the availability of the subscriber array
	 */
	public boolean checkSubscriberAvailability() {
		boolean availability = false;

		// Goes over the subscriber array and checks if at least one position is null
		for (int i = 0; i < subscribers.length && !availability; i++) {
			if (subscribers[i] == null) {
				availability = true;
			}
		}

		return availability;
	}

	/**
	 * Checks the existence of at least one subscriber in the subscriber array
	 * 
	 * <p>
	 * <b>Precondition: </b> The user wants to interact with methods that require at
	 * least one subscriber
	 * <p>
	 * <b>Postcondition: </b> The existence of at least one subscriber is stated
	 * 
	 * @return a boolean indicating the existence of at least one subscriber in the
	 *         subscriber array
	 */
	public boolean checkSubscriberExistence() {
		boolean existence = false;

		// Goes over the subscriber array and checks if at least one position is not
		// null
		for (int i = 0; i < subscribers.length && !existence; i++) {
			if (subscribers[i] != null) {
				existence = true;
			}
		}

		return existence;
	}

	/**
	 * Looks for a subscriber by its id and returns it
	 * 
	 * <p>
	 * <b>Precondition: </b> At least one subscriber exists and the user is going to
	 * modify or interact in a certain way with a specific subscriber
	 * <p>
	 * <b>Postcondition: </b> A reference to the subscriber is returned
	 * 
	 * @param id the id of the subscriber to be found
	 * @return a subscriber that has the same id as the one that was entered
	 */
	public Subscriber searchSubscriber(String id) {
		// For-each loop that checks the if any subscriber has an id that matches the id
		// in the parameter
		for (Subscriber subscriber : subscribers) {
			if (subscriber != null && subscriber.getId().equals(id)) {
				// If so, it returns the subscriber
				return subscriber;
			}
		}

		// If not found, then return null
		return null;
	}

	/**
	 * Returns total active subscribers and a list stating the number of active
	 * subscribers by type
	 * 
	 * <p>
	 * <b>Precondition: </b> At least one subscriber exists and the user selected
	 * the option to print the active subscribers by type in the menu
	 * <p>
	 * <b>Postcondition: </b> The list is returned
	 * 
	 * @return total active subscribers and a list with the active subscribers by
	 *         type
	 */
	public String printActiveSubscribersByType() {
		// Integers that will store the active subscribers by type and total
		int activeSubs = 0;
		int activeNormalSubs = 0;
		int activeGoldSubs = 0;
		int activePlatinumSubs = 0;
		int activeDiamondSubs = 0;
		String activeSubsByType = "";

		// For-each loop that checks the null value and activity of the subscribers
		// before counting by the type
		for (Subscriber subscriber : subscribers) {
			if (subscriber != null && subscriber.isActive()) {
				activeSubs++;
				// Switch case to count by type
				switch (subscriber.getType()) {
				case NORMAL:
					activeNormalSubs++;
					break;
				case GOLD:
					activeGoldSubs++;
					break;
				case PLATINUM:
					activePlatinumSubs++;
					break;
				case DIAMOND:
					activeDiamondSubs++;
					break;
				}
			}
		}

		// Declaration of the list to be returned
		activeSubsByType = "There are " + activeSubs + " active subscribers distributed like this: \nNormal: "
				+ activeNormalSubs + "\nGold: " + activeGoldSubs + "\nPlatinum: " + activePlatinumSubs + "\nDiamond: "
				+ activeDiamondSubs;

		return activeSubsByType;
	}

	/**
	 * Returns the name of under-aged user with the most hours willing to consume
	 * 
	 * <p>
	 * <b>Precondition: </b> At least one subscriber exists and the user selected
	 * the option to print the minor user with most hours to consume in the menu
	 * <p>
	 * <b>Postcondition: </b> The name of the requested subscriber is returned
	 * 
	 * @return the name of the under-aged subscriber with the most hours willing to
	 *         consume
	 */
	public String printMinorMostHoursSub() {
		// Initialize the name with a message in case no minor subscriber is found
		String name = "*No minor subscriber found*";
		int mostHours = 0;

		// For-each loop to evaluate the age and hours to consume of every subscriber
		for (Subscriber subscriber : subscribers) {
			if (subscriber != null && subscriber.getAge() < 18 && subscriber.getHoursToConsume() > mostHours) {
				// If found, save the name
				name = subscriber.getFullName() + " - Hours: " + subscriber.getHoursToConsume();
				// And most hours in case another one containing more hours is found
				mostHours = subscriber.getHoursToConsume();
			}
		}

		return name;
	}

	/**
	 * Returns a list containing all of the subscribers at the moment with their
	 * respective information
	 * 
	 * <p>
	 * <b>Precondition: </b> The user selected an option that requires the
	 * subscribers to be shown in the menu (e.g. deactivate a subscriber)
	 * <p>
	 * <b>Postcondition: </b> The list is returned
	 * 
	 * @return a list with all of the current subscribers represented in Strings
	 */
	public String printSubscribers() {
		String subs = "";

		// Look for all of the subscribers that contain information and add them to a
		// String
		for (int i = 0; i < subscribers.length; i++) {
			if (subscribers[i] != null) {
				subs += (i + 1) + ". " + subscribers[i].toString() + "\n";
			}
		}

		return subs;
	}

	/**
	 * An overloaded method to add a product. In this case, it is used to add a show
	 * 
	 * <p>
	 * <b>Precondition: </b> The user selected the option to add a new show in
	 * the menu and entered all the relevant data to the program
	 * <p>
	 * <b>Postcondition: </b> A message that may indicate the creation of a new
	 * show inside the product array or not
	 * 
	 * @param name name of the new show
	 * @param nameOfDirector name of the director of the new show
	 * @param synopsis synopsis of the new show
	 * @param premierDate date in which the show premiered (first emission)
	 * @param protagonists a string array indicating the protagonists of the new show
	 * @param censored boolean to determine if the new show has been censored or not
	 * @param censorMotif the censor motif of the new show
	 * @return a message indicating the result of the operation
	 */
	public String addProduct(String name, String nameOfDirector, String synopsis, LocalDate premierDate,
			String[] protagonists, boolean censored, String censorMotif) {
		// A message that will notify the result of the operation
		String message = "";

		// Check if there is space in the array and if there is already a product
		// with the same name as the one that will be created
		if (!checkProductAvailability()) {
			message = "Error, there is no room for more products";
		} else if (searchProduct(name) != null) {
			message = "Error, there is already a product with the same name";
		} else {
			// If a certain position in the product array is empty, create a new
			// show inside and break out of the loop
			for (int i = 0; i < products.length; i++) {
				if (products[i] == null) {
					products[i] = new Show(name, nameOfDirector, synopsis, premierDate, protagonists, censored,
							censorMotif);
					break;
				}
			}

			message = "Show added successfully";
		}

		// Return the result of the operation
		return message;
	}

	/**
	 * An overloaded method to add a product. In this case, it is used to add a movie
	 * 
	 * <p>
	 * <b>Precondition: </b> The user selected the option to add a new movie in
	 * the menu and entered all the relevant data to the program
	 * <p>
	 * <b>Postcondition: </b> A message that may indicate the creation of a new
	 * movie inside the product array or not
	 * 
	 * @param name name of the new movie
	 * @param nameOfDirector name of the director of the new movie
	 * @param synopsis synopsis of the new movie
	 * @param premierDate date in which the movie premiered (first emission)
	 * @param producer the name of the producer of the new movie
	 * @param minimumWatchAge the minimum age required to watch the new movie
	 * @param trailerUrl the URL in which the trailer for the new movie can be found
	 * @param movieCategorySelection a selection of the movie category (<code>1</code>: Romantic, <code>2</code>: Action, <code>3</code>: Suspense, <code>4</code>: Horror, <code>5</code>: Comedy)
	 * @return a message indicating the result of the operation
	 */
	public String addProduct(String name, String nameOfDirector, String synopsis, LocalDate premierDate,
			String producer, int minimumWatchAge, String trailerUrl, int movieCategorySelection) {
		// A message that will notify the result of the operation
		String message = "";

		// Check if there is space in the array and if there is already a product
		// with the same name as the one that will be created
		if (!checkProductAvailability()) {
			message = "Error, there is no room for more products";
		} else if (searchProduct(name) != null) {
			message = "Error, there is already a product with the same name";
		} else {
			// If a certain position in the product array is empty, create a new
			// movie inside and break out of the loop
			for (int i = 0; i < products.length; i++) {
				if (products[i] == null) {
					products[i] = new Movie(name, nameOfDirector, synopsis, premierDate, producer, minimumWatchAge,
							trailerUrl, movieCategorySelection);
					break;
				}
			}

			message = "Movie added successfully";
		}

		// Return the result of the operation
		return message;
	}

	/**
	 * Adds a season to a specified show
	 * 
	 * <p>
	 * <b>Precondition: </b> At least one show exists and the user selected the option to add a new season to a show in
	 * the menu and entered all the relevant data to the program
	 * <p>
	 * <b>Postcondition: </b> A message that may indicate the creation of a new
	 * season inside the show or not
	 * 
	 * @param nameOfShow name of the show in which the season will be stored
	 * @param scheduledEpisodes number of the scheduled episodes
	 * @param premierDate premier date of the new season
	 * @param trailerUrl the URL in which the trailer for the new season can be found
	 * @return a message indicating the result of the opertation
	 */
	public String addSeasonToShow(String nameOfShow, int scheduledEpisodes, LocalDate premierDate, String trailerUrl) {
		String message = "";
		Product foundProduct = searchProduct(nameOfShow); //Get the product that matches the given product name

		// Check if the found product is null and if it corresponds to a show or not
		if (foundProduct == null) {
			message = "Error, there is no show by that name";
		} else if (foundProduct instanceof Show) {
			// Downcast the found product to a show
			Show foundShow = (Show) foundProduct;

			// Create a new season with the given information, inferring the season number
			Season newSeason = new Season(foundShow.searchSeasonsAvailableSpace() + 1, scheduledEpisodes, premierDate,
					trailerUrl);

			// Store in the message, the result of the season addition
			message = foundShow.addSeason(newSeason);
		} else {
			// In case it is a product
			message = "The introduced name of product does not correspond to a show";
		}

		return message;
	}

	/**
	 * Checks the availability of the product array in order to add more products
	 * 
	 * <p>
	 * <b>Precondition: </b> The method is called in addProduct
	 * <p>
	 * <b>Postcondition: </b> The availability of the product array is stated
	 * 
	 * @return a boolean indicating the availability of the product array
	 */
	public boolean checkProductAvailability() {
		boolean availability = false;

		// Goes over the product array and checks if at least one position is null
		for (int i = 0; i < products.length && !availability; i++) {
			if (products[i] == null) {
				availability = true;
			}
		}

		return availability;
	}

	/**
	 * Checks the existence of at least one product in the product array
	 * 
	 * <p>
	 * <b>Precondition: </b> The user wants to interact with methods that require at
	 * least one product
	 * <p>
	 * <b>Postcondition: </b> The existence of at least one product is stated
	 * 
	 * @return a boolean indicating the existence of at least one product in the
	 *         product array
	 */
	public boolean checkProductExistence() {
		boolean existence = false;

		// Goes over the product array and checks if at least one position is not
		// null
		for (int i = 0; i < products.length && !existence; i++) {
			if (products[i] != null) {
				existence = true;
			}
		}

		return existence;
	}

	/**
	 * Looks for a product by its name and returns it
	 * 
	 * <p>
	 * <b>Precondition: </b> At least one product exists and the user is going to
	 * modify or interact in a certain way with a specific product
	 * <p>
	 * <b>Postcondition: </b> A reference to the product is returned
	 * 
	 * @param name the name of the product to be found
	 * @return a product that has the same name as the one that was entered
	 */
	public Product searchProduct(String name) {
		// For-each loop that checks the if any product has name that matches the name
		// in the parameter
		for (Product product : products) {
			if (product != null && product.getName().equalsIgnoreCase(name)) {
				// If so, return the product
				return product;
			}
		}

		// If not found, return null
		return null;
	}

	/**
	 * Returns the information of the given product name
	 * 
	 * <p>
	 * <b>Precondition: </b> At least one product exists and the user selected
	 * the option to show a specific product information in the menu
	 * <p>
	 * <b>Postcondition: </b> The product information is returned or a message indicating that the product does not exist
	 * 
	 * @param name name of the product to print
	 * @return the product information or a message indicating that the product was not found
	 */
	public String printProductInfo(String name) {
		Product productToPrint = searchProduct(name); // Identify the product to print
		String result = "";

		// Check if the product is null or not
		if (searchProduct(name) != null) {
			// Identify if the found product is a show or a movie and ossign the toString value to the result
			result = (productToPrint instanceof Show) ? "Found Show:" : "Found movie:";
			result += "\n" + productToPrint.toString();
		} else {
			// If null, the product was not found
			result = "*Product not found*";
		}

		return result;
	}

	/**
	 * Returns a list with the information of movies according to a category
	 * 
	 * <p>
	 * <b>Precondition: </b> At least one product exists and the user selected
	 * the option to print the movies by category in the menu
	 * <p>
	 * <b>Postcondition: </b> The list is returned or a messsage indicating that there are no movies matching the category
	 * 
	 * @param categorySelection the selection of the movie category
	 * @return a list with the information of the movies matching the category or a message indicating its absence
	 */
	public String printMoviesOfCategory(int categorySelection) {
		MovieCategory selectedCategory = null;
		String printedMovies = "";
		boolean foundAMovieOfCategory = false;

		// Set a MovieCategory value to selectedCategory in order to make the comparisons with the movies
		switch (categorySelection) {
			case 1:
				selectedCategory = MovieCategory.ROMANTIC;
				break;
			case 2:
				selectedCategory = MovieCategory.ACTION;
				break;
			case 3:
				selectedCategory = MovieCategory.SUSPENSE;
				break;
			case 4: 
				selectedCategory = MovieCategory.HORROR;
				break;
			case 5:
				selectedCategory = MovieCategory.COMEDY;
				break;
			default:
				return "Error, invalid selection";
		}

		// If the selection is not considered as invalid, continue with the program.
		// Get through the array and search for a movie
		for (Product product : products) {
			if (product != null && product instanceof Movie) {
				Movie aMovie = (Movie) product;

				// Just add the movie to the resultant string if it meets the category condition
				if (aMovie.getCategory() == selectedCategory) {
					foundAMovieOfCategory = true;
					printedMovies += "\n" + aMovie.toString() + "\n";
				}
			}
		}

		// Return the printed movies or a message indicating the absence of the movies by the category
		return foundAMovieOfCategory ? printedMovies : "*There are no movies by this category*";
	}

	/**
	 * Returns the seasons information along with the information of their last seasons
	 * 
	 * <p>
	 * <b>Precondition: </b> At least one product exists and the user selected
	 * the option to print shows in the menu
	 * <p>
	 * <b>Postcondition: </b> The list is returned or a message indicating that there are no shows yet
	 * 
	 * @return a list with the information of the shows and their last seasons, or a message indicating its absence
	 */
	public String printShowsWithLastSeasons() {
		String printedShows = "";
		boolean foundAShow = false;
		int lastSeasonIndex = 0;

		// For-each loop to determine which product corresponds to a show and print its information
		for (Product product : products) {
			if (product != null && product instanceof Show) {
				// At least one show has been found
				foundAShow = true;

				// Downcast the found product
				Show aShow = (Show) product;

				// Determine the index of the last season
				if (aShow.searchSeasonsAvailableSpace() == -1) {
					lastSeasonIndex = Show.MAX_SEASONS - 1;
				} else {
					lastSeasonIndex = aShow.searchSeasonsAvailableSpace() - 1;
				}

				// Get the seasons of the found show
				Season[] showSeasons = aShow.getSeasons(); 

				// Add to the printed shows, the found show with its last season information
				printedShows += "\n" + aShow.toString() + "\nLast Season Info: " + showSeasons[lastSeasonIndex].toString() + "\n";
			}
		}

		// Return the printed shows or the message if at least a show was found or not
		return foundAShow ? printedShows : "*There are no shows yet*";
	}
}