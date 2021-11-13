package ui;

import java.time.LocalDate;
import java.util.*;

import model.Channel;

/**
 * Program to manage all the functionalities of the streaming application of
 * Black Snail incluiding:
 * 
 * <ul>
 * <li>Management of subscribers
 * <li>Management of the product catalog
 * <li>Creation of services
 * </ul>
 * 
 * @author Daniel Valencia - A00372845
 */
public class Main {

	public static Scanner s = new Scanner(System.in);
	public static Channel blackSnail;

	/**
	 * Manages all of the interactions with the subscribers and contains the option menu that allows it
	 * 
	 * <p>
	 * <b>Precondition: </b> The user selected the option to manage subscribers in the initial menu
	 * <p>
	 * <b>Postcondition: </b> An interaction with the subscribers
	 */
	public static void manageSubscribers() {
		boolean exit = false;
		int selection = 0;

		while (!exit) {
			System.out.println("\n---------------------------------------------------\n");
			System.out.println("1. Register a new subscriber");
			System.out.println("2. Deactivate a subscriber");
			System.out.println("3. Show the active subscribers by type");
			System.out.println("4. Show minor subscriber with the most hours willing to consume");
			System.out.println("5. Exit subscriber menu");
			System.out.println("\n---------------------------------------------------\n");
			selection = s.nextInt();

			// Switch case for each selection. Methods that require at least one subscriber
			// check that this condition is met
			switch (selection) {
			case 1:
				registerSubscriber();
				break;
			case 2:
				if (blackSnail.checkSubscriberExistence()) {
					deactivateSubscriber();
				} else {
					System.out.println("There are no subscribers yet");
					System.out.println("Press enter to continue...");
					s.nextLine();
					s.nextLine();
				}
				break;
			case 3:
				if (blackSnail.checkSubscriberExistence()) {
					showActiveSubscribersByType();
				} else {
					System.out.println("There are no subscribers yet");
					System.out.println("Press enter to continue...");
					s.nextLine();
					s.nextLine();
				}
				break;
			case 4:
				if (blackSnail.checkSubscriberExistence()) {
					showMinorMostHoursSub();
				} else {
					System.out.println("There are no subscribers yet");
					System.out.println("Press enter to continue...");
					s.nextLine();
					s.nextLine();
				}
				break;
			case 5:
				exit = true;
				break;
			default:
				System.out.println("Error, invalid input");
				System.out.println("Press enter to continue...");
				s.nextLine();
				s.nextLine();
				break;
			}
		}

	}

	/**
	 * Registers a new subscriber
	 * 
	 * <p>
	 * <b>Precondition: </b> The user selected the option to add a new subscriber in
	 * the menu
	 * <p>
	 * <b>Postcondition: </b> A message that may indicate the creation of a new
	 * subscriber inside the subscriber array or not
	 */
	public static void registerSubscriber() {
		// Initialize subscriber attributes to ask
		String id = "";
		String fullName = "";
		int age = 0;
		int hoursToConsume = 0;

		// Ask for the student attributes
		System.out.print("\nInput the id of the new subscriber: ");
		s.nextLine();
		id = s.nextLine();
		System.out.print("Input the full name of the new subscriber: ");
		fullName = s.nextLine();
		System.out.print("Input the age of the new subscriber: ");
		age = s.nextInt();
		System.out.print("Input the hours that the new user is willing to consume: ");
		hoursToConsume = s.nextInt();

		// Create the new subscriber (if there is space and the id is not repeated) and
		// print the result of the operation
		System.out.println("\n" + blackSnail.addSubscriber(id, fullName, age, hoursToConsume));
		System.out.println("Press enter to continue...");
		s.nextLine();
		s.nextLine();
	}

	/**
	 * Deactivates the desired subscriber
	 * 
	 * <p>
	 * <b>Precondition: </b> The user selected the option to deactivate a subscriber
	 * in the menu and at least one subscriber exists
	 * <p>
	 * <b>Postcondition: </b> A message that may indicate the deactivation of the
	 * subscriber or not
	 */
	public static void deactivateSubscriber() {
		int pos = 0;

		// Prints all the subscribers in a numbered list and asks for the number of the
		// subscriber that will be deactivated
		System.out.println("\n" + blackSnail.printSubscribers());
		System.out.print("Input the number of the subscriber that will be deactivated or input 0 to cancel: ");
		pos = s.nextInt();

		// If the user decided not to cancel, proceed with the deactivation
		if (pos != 0) {
			System.out.println("\n" + blackSnail.deactivateSubscriber(pos - 1));
			System.out.println("Press enter to continue...");
			s.nextLine();
			s.nextLine();
		}
	}

	/**
	 * Shows how many subscribers are active by type
	 * 
	 * <p>
	 * <b>Precondition: </b> The user selected the option to show the active
	 * subscribers by type in the menu and at least one subscriber exists
	 * <p>
	 * <b>Postcondition: </b> A displayed list with the active subscribers by type
	 */
	public static void showActiveSubscribersByType() {
		// Print the active subscribers by type
		System.out.println("\n" + blackSnail.printActiveSubscribersByType());
		System.out.println("\nPress enter to continue...");
		s.nextLine();
		s.nextLine();
	}

	/**
	 * Shows the name of an under-aged subscriber with the most hours willing to
	 * consume
	 * 
	 * <p>
	 * <b>Precondition: </b> The user selected the option to minor subscriber with
	 * the most hours willing to consume in the menu, and at least one subscriber
	 * exists
	 * <p>
	 * <b>Postcondition: </b> The name of the subscriber or a message indicating the
	 * abscence of minor subscribers
	 */
	public static void showMinorMostHoursSub() {
		// Print the minor subscriber with most hours willing to consume
		System.out.println("\nName of minor subscriber with the most hours willing to consume: \n\n"
				+ blackSnail.printMinorMostHoursSub());
		System.out.println("\nPress enter to continue...");
		s.nextLine();
		s.nextLine();
	}

	/**
	 * Manages all of the interactions with the products and contains the option menu that allows it
	 * 
	 * <p>
	 * <b>Precondition: </b> The user selected the option to manage products in the initial menu
	 * <p>
	 * <b>Postcondition: </b> An interaction with the products
	 */
	public static void manageProducts() {
		boolean exit = false;
		int selection = 0;

		while (!exit) {
			System.out.println("\n---------------------------------------------------\n");
			System.out.println("1. Register a product");
			System.out.println("2. Show specific product information");
			System.out.println("3. Add season to show");
			System.out.println("4. List movies according to category");
			System.out.println("5. List shows and display last season information");
			System.out.println("6. Exit product menu");
			System.out.println("\n---------------------------------------------------\n");
			selection = s.nextInt();

			// Switch case for each selection. Methods that require at least one product
			// check that this condition is met
			switch (selection) {
			case 1:
				registerProduct();
				break;
			case 2:
				if (blackSnail.checkProductExistence()) {
					showProductInfo();
				} else {
					System.out.println("There are no products yet");
					System.out.println("Press enter to continue...");
					s.nextLine();
					s.nextLine();
				}
				break;
			case 3:
				if (blackSnail.checkProductExistence()) {
					registerSeason();
				} else {
					System.out.println("There are no products yet");
					System.out.println("Press enter to continue...");
					s.nextLine();
					s.nextLine();
				}
				break;
			case 4:
				if (blackSnail.checkProductExistence()) {
					listMoviesOfCategory();
				} else {
					System.out.println("There are no products yet");
					System.out.println("Press enter to continue...");
					s.nextLine();
					s.nextLine();
				}
				break;
			case 5:
				if (blackSnail.checkProductExistence()) {
					listShows();
				} else {
					System.out.println("There are no products yet");
					System.out.println("Press enter to continue...");
					s.nextLine();
					s.nextLine();
				}
				break;
			case 6:
				exit = true;
				break;
			default:
				System.out.println("Error, invalid input");
				System.out.println("Press enter to continue...");
				s.nextLine();
				s.nextLine();
				break;
			}
		}
	}

	/**
	 * Registers a product. The user decides if it will be a movie or a show
	 * 
	 * <p>
	 * <b>Precondition: </b> The user selected the option to register a product in the menu
	 * <p>
	 * <b>Postcondition: </b> A message that may indicate the creation of a new
	 * product inside the product array or not
	 */
	public static void registerProduct() {
		// General product variables
		int additionSelection = 0;
		String name = "";
		String nameOfDirector = "";
		String synopsis = "";
		int year = 0;
		int month = 0;
		int dayOfMonth = 0;
		LocalDate premierDate;

		// Select the type of product to add
		System.out.println("\n1. Add a show");
		System.out.println("2. Add a movie");
		additionSelection = s.nextInt();

		// Switch case according to the product selection to ask for the information
		switch (additionSelection) {
		case 1:
			// Specific show information
			int amountOfProtagonists = 0;
			String[] protagonists;
			String censoredResponse = "";
			boolean censored = false;
			String censorMotif = "";

			System.out.print("\nIntroduce the name of the show: ");
			s.nextLine();
			name = s.nextLine();

			System.out.print("Introduce the name of the director: ");
			nameOfDirector = s.nextLine();

			System.out.print("Introduce the synopsis of the show: ");
			synopsis = s.nextLine();

			System.out.print("Introduce year in which the show premiered: ");
			year = s.nextInt();

			System.out.print("Introduce month in which the show premiered: ");
			month = s.nextInt();

			System.out.print("Introduce day of the month in which the show premiered: ");
			dayOfMonth = s.nextInt();

			premierDate = LocalDate.of(year, month, dayOfMonth);

			System.out.print("How many protagonists does this series have? ");
			amountOfProtagonists = s.nextInt();

			protagonists = new String[amountOfProtagonists];

			s.nextLine();

			// For loop to get the names of the protagonists
			for (int i = 0; i < amountOfProtagonists; i++) {
				System.out.print("Introduce the name of the protagonist Nº" + (i + 1) + ": ");
				protagonists[i] = s.nextLine();
			}

			// Do while loop to determine if the show is censored or not
			do {
				System.out.println("Is this show censored? (y / n)");
				censoredResponse = s.nextLine();
			} while (!censoredResponse.equalsIgnoreCase("y") && !censoredResponse.equalsIgnoreCase("n"));

			censored = censoredResponse.equalsIgnoreCase("y") ? true : false;

			// If the show is censored, ask for the censor motif
			if (censored) {
				System.out.print("Indicate the censor motif: ");
				censorMotif = s.nextLine();
			}

			// Display message indicating the result of the addition of the show
			System.out.println("\n" + blackSnail.addProduct(name, nameOfDirector, synopsis, premierDate, protagonists,
					censored, censorMotif));

			System.out.println("\nPress enter to continue to the creation of the first season...");
			s.nextLine();

			// Continue with the creation of the first season of this show
			registerSeason(name);
			break;
		case 2:
			// Specific movie information
			String producer = "";
			int minimumWatchAge = 0;
			String trailerUrl = "";
			int movieCategorySelection = 0;

			System.out.print("\nIntroduce the name of the movie: ");
			s.nextLine();
			name = s.nextLine();

			System.out.print("Introduce the name of the director: ");
			nameOfDirector = s.nextLine();

			System.out.print("Introduce the synopsis of the movie: ");
			synopsis = s.nextLine();

			System.out.print("Introduce year in which the movie premiered: ");
			year = s.nextInt();

			System.out.print("Introduce month in which the movie premiered: ");
			month = s.nextInt();

			System.out.print("Introduce day of the month in which the movie premiered: ");
			dayOfMonth = s.nextInt();

			premierDate = LocalDate.of(year, month, dayOfMonth);

			System.out.print("Introduce the name of the producer: ");
			s.nextLine();
			producer = s.nextLine();

			System.out.print("Introduce the minimum age to watch this movie: ");
			minimumWatchAge = s.nextInt();

			System.out.print("Introduce the trailer URL of the movie: ");
			s.nextLine();
			trailerUrl = s.nextLine();

			// Do while loop to ensure the selection of a valid category
			do {
				System.out.println("\nSelect the category of the movie:");
				System.out.println("1. Romantic");
				System.out.println("2. Action");
				System.out.println("3. Suspense");
				System.out.println("4. Horror");
				System.out.println("5. Comedy");
				movieCategorySelection = s.nextInt();

				if (movieCategorySelection <= 0 || movieCategorySelection > 5) {
					System.out.println("Error, try again");
					System.out.println("Press enter to continue...");
					s.nextLine();
					s.nextLine();
				}
			} while (movieCategorySelection <= 0 || movieCategorySelection > 5);

			// Display message indicating the result of the addition of the movie
			System.out.println("\n" + blackSnail.addProduct(name, nameOfDirector, synopsis, premierDate, producer,
					minimumWatchAge, trailerUrl, movieCategorySelection));

			System.out.println("\nPress enter to continue...");
			s.nextLine();
			s.nextLine();
			break;
		default:
			// In case of a valid input, return to the product menu
			System.out.println("Error, redirecting to product menu...");
			System.out.println("Press enter to continue...");
			s.nextLine();
			s.nextLine();
			break;
		}
	}

	/**
	 * Shows the product information according to the given name
	 * 
	 * <p>
	 * <b>Precondition: </b> The user selected the option to print a specific product in the menu
	 * <p>
	 * <b>Postcondition: </b> The printed product or a message indicating that the product was not found
	 */
	public static void showProductInfo() {
		String name = "";

		// Ask for the product name
		System.out.print("\nIntroduce the name of the product to print: ");
		s.nextLine();
		name = s.nextLine();

		// Print the product or the message indicating that the product was not found
		System.out.println("\n" + blackSnail.printProductInfo(name));

		System.out.println("\nPress enter to continue...");
		s.nextLine();
	}

	/**
	 * Registers a season inside a show according to the given name
	 * 
	 * <p>
	 * <b>Precondition: </b> The user selected the option to register a season in the menu
	 * <p>
	 * <b>Postcondition: </b> A message indicating the result of the operation
	 */
	public static void registerSeason() {
		// Season information
		String nameOfShow = "";
		int scheduledEpisodes = 0;
		int year = 0;
		int month = 0;
		int dayOfMonth = 0;
		LocalDate premierDate;
		String trailerUrl = "";

		// First, ask for the name of the show
		System.out.print("\nIntruduce the name of the show: ");
		s.nextLine();
		nameOfShow = s.nextLine();

		System.out.print("Introduce the scheduled episodes for this season: ");
		scheduledEpisodes = s.nextInt();

		System.out.print("Introduce year in which the season premiered: ");
		year = s.nextInt();

		System.out.print("Introduce month in which the season premiered: ");
		month = s.nextInt();

		System.out.print("Introduce day of the month in which the season premiered: ");
		dayOfMonth = s.nextInt();

		premierDate = LocalDate.of(year, month, dayOfMonth);

		System.out.print("Introduce the trailer URL of the season: ");
		s.nextLine();
		trailerUrl = s.nextLine();

		// Display a message indicating the result of the addition of the season to the show
		System.out.println("\n" + blackSnail.addSeasonToShow(nameOfShow, scheduledEpisodes, premierDate, trailerUrl));

		System.out.println("\nPress enter to continue...");
		s.nextLine();
	}

	/**
	 * An overloaded method that is used to register the first season of a show just after it is created
	 * 
	 * <p>
	 * <b>Precondition: </b> The user created a new show
	 * <p>
	 * <b>Postcondition: </b> An addition of a first season to the new show
	 * 
	 * @param nameOfShow name of the show that has been created
	 */
	public static void registerSeason(String nameOfShow) {
		int scheduledEpisodes = 0;
		int year = 0;
		int month = 0;
		int dayOfMonth = 0;
		LocalDate premierDate;
		String trailerUrl = "";

		System.out.print("Introduce the scheduled episodes for this season: ");
		scheduledEpisodes = s.nextInt();

		System.out.print("Introduce year in which the season premiered: ");
		year = s.nextInt();

		System.out.print("Introduce month in which the season premiered: ");
		month = s.nextInt();

		System.out.print("Introduce day of the month in which the season premiered: ");
		dayOfMonth = s.nextInt();

		premierDate = LocalDate.of(year, month, dayOfMonth);

		System.out.print("Introduce the trailer URL of the season: ");
		s.nextLine();
		trailerUrl = s.nextLine();

		System.out.println("\n" + blackSnail.addSeasonToShow(nameOfShow, scheduledEpisodes, premierDate, trailerUrl));

		System.out.println("\nPress enter to continue...");
		s.nextLine();
	}

	/**
	 * List the movies that match a corresponding category
	 * 
	 * <p>
	 * <b>Precondition: </b> The user selected the option to list the movies according to a category in the menu
	 * <p>
	 * <b>Postcondition: </b> The printed information of the movies or a message indicating that the movies by this category do not exist
	 */
	public static void listMoviesOfCategory() {
		int categorySelection = 0;

		// Get the category selection
		System.out.println("\nIntroduce the number of the chosen category:");
		System.out.println("1. Romantic");
		System.out.println("2. Action");
		System.out.println("3. Suspense");
		System.out.println("4. Horror");
		System.out.println("5. Comedy");
		categorySelection = s.nextInt();

		// Print the movies or a message indicating its absence
		System.out.println("\n" + blackSnail.printMoviesOfCategory(categorySelection));

		System.out.println("Press enter to continue...");
		s.nextLine();
		s.nextLine();
	}

	/**
	 * List all of the existing shows with their last season information
	 * 
	 * <p>
	 * <b>Precondition: </b> The user selected the option to list the shows and display last season information in the menu
	 * <p>
	 * <b>Postcondition: </b> The printed information of the shows or a message indicating that there are no shows yet
	 */
	public static void listShows() {
		// Print the shows or a message indicating its absence
		System.out.println("\n" + blackSnail.printShowsWithLastSeasons());

		System.out.println("Press enter to continue...");
		s.nextLine();
		s.nextLine();
	}

	/**
	 * Calls the principal methods, creates the channel and shows the main menu
	 * 
	 * <p>
	 * <b>Precondition: </b> The program is executed
	 * <p>
	 * <b>Postcondition: </b> Redirection to the system functionalities
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Initialize channel data, exit boolean and selection integer for the menu
		String nit = "";
		String address = "";
		String website = "";
		boolean exit = false;
		int selection = 0;

		// Ask for the relevant channel information
		System.out.println("\n---------------------------------------------------\n");
		System.out.println("Welcome to the Streaming management program of Black Snail!");
		System.out.println("Please enter the data of the channel");
		System.out.print("NIT: ");
		nit = s.nextLine();
		System.out.print("Address: ");
		address = s.nextLine();
		System.out.print("Website: ");
		website = s.nextLine();

		// Create an instance of channel with the given information
		blackSnail = new Channel(nit, address, website);

		System.out.println(blackSnail.printProductInfo("name"));
		// While loop that shows the menu and continues to be shown after an action
		// until the user wants to exit
		while (!exit) {
			System.out.println("\n---------------------------------------------------\n");
			System.out.println("Input a number according to the desired action: ");
			System.out.println("1. Manage Subscribers");
			System.out.println("2. Manage Products");
			System.out.println("3. Exit program");
			System.out.println("\n---------------------------------------------------\n");
			selection = s.nextInt();

			// Switch case for each selection. Methods that require at least one subscriber
			// check that this condition is met
			switch (selection) {
			case 1:
				manageSubscribers();
				break;
			case 2:
				manageProducts();
				break;
			case 3:
				System.out.println("Exiting program...");
				exit = true;
				break;
			default:
				System.out.println("Error, invalid input");
				System.out.println("Press enter to continue...");
				s.nextLine();
				s.nextLine();
				break;
			}
		}
	}
}