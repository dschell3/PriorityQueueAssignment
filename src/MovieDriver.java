/**
 * MovieDriver - Main driver class for movie priority queue system
 * Allows users to create and manage a priority queue of movies
 * with different comparison methods. Kind of uses Strategy Design pattern.
 *
 * Group Members: Darren Schell, Aws Khaleel
 */

import java.time.DateTimeException; // provides DateTime exception - error check days valid
import java.time.LocalDate;         // LocalDate object to represent data
import java.util.PriorityQueue;     // java API data structure
import java.util.Scanner;           // handles user input

public class MovieDriver {

    private static final Scanner scanner = new Scanner((System.in));
    private static PriorityQueue<Movie> moviePriorityQueue;

    public static void main(String[] args) {
        System.out.println("|****** MOVIE PRIORITY QUEUE APP ******|");

        /**     Step 1
        *   getChoice() -> ask the user how they wish to organize their movie queue */
        int choice = getChoice();

        /**     Step 2
        *   createQueue() -> based on their choice, generate a PQueue, use java API */
        createPQueue( choice );

        /**     Step 3
        *   insertSampleMovies() -> insert some movie objects into queue */
        insertSampleMovies();

        /**     Step 4
        *   peek() -> display the movie with the 1st priority in the queue. !(delete) */
        peekMovie();

        /**     Step 5
        *   printQueue() -> display the contents of the queue -> loop(toString) */
        printQueue();

        /**     Step 6
        *   removeMovie() -> remove the movie object with first priority */
        removeMovie();

        /**     Step 7
        *   re: printQueue() - display the contents of the queue */
        printQueue();

        /**     Step 8
        *   enter enhanced interactive menu loop next */
        menuManager();
    }

    // method gets the users choice on how to organize the priority queue
    private static int getChoice() {
        System.out.println("How do you want to organize your Priority Queue?");
        System.out.println("1. Recommendation (Highest first)");
        System.out.println("2. Release Date (Oldest first)");
        System.out.println("3. Genre (Alphabetically)");
        System.out.println("Enter [1-3] to select your choice.");

        int choice = -1;            // assign an impossible value
        boolean done = false;       // flag to determine if input is valid

        while (!done) {
            try {
                choice = scanner.nextInt();
                if (choice > 0 && choice < 4) {                         // choice must be [1-3]
                    done = true;
                } else {
                    System.out.println("Enter a number between 1 and 3 inclusive.");
                }
            }
            catch (Exception e) {
                System.out.println("Invalid input. Must be a number");  // error checking, want int
                scanner.nextLine();                                     // clear buffer
            }
        }
        return choice;                                                  // valid input returned
    }

    // method creates the priority queue based on the users choice. Strategy design structure
    private static void createPQueue( int choice ) {
        if ( choice == 1 ) {
            System.out.println("Queue Priority based on: Recommendation");
            moviePriorityQueue = new PriorityQueue<>();     // default is recommendation
        }
        else if ( choice == 2) {
            System.out.println("Queue Priority is based on: Release Date with Earliest release date first");
            moviePriorityQueue = new PriorityQueue<>( new MovieReleaseDate() );
        }
        else { // choice == 3
            System.out.println("Queue Priority is based on: Genre");
            moviePriorityQueue = new PriorityQueue<>( new MovieGenre() );
        }
    }

    // fills the queue with sample movie data for testing + demo
    private static void insertSampleMovies() {
        System.out.println("\n|****** INSERTING SAMPLE MOVIES INTO QUEUE ******|");

        // instantiate some Movie objects
        Movie m1 = new Movie("Title1", "Drama", "R",
                LocalDate.of(2000, 1, 1), 1);
        Movie m2 = new Movie("Title2", "Drama", "R",
                LocalDate.of(2000, 2, 2), 9);
        Movie m3 = new Movie("Title3", "Comedy", "PG-13",
                LocalDate.of(2012, 1, 1), 7);
        Movie m4 = new Movie("Title4", "Romantic Comedy", "PG",
                LocalDate.of(2002, 2, 2), 7);
        Movie m5 = new Movie("Title5", "Comedy", "R",
                LocalDate.of(2001, 1, 1), 10);
        Movie m6 = new Movie("Title6", "Family", "G",
                LocalDate.of(2010, 2, 2), 4);

        // insert them into the queue...don't use insertMovie() b/c object details already defined
        moviePriorityQueue.add(m1);
        moviePriorityQueue.add(m2);
        moviePriorityQueue.add(m3);
        moviePriorityQueue.add(m4);
        moviePriorityQueue.add(m5);
        moviePriorityQueue.add(m6);

        // let user know, sample movies were successfully added to the queue
        System.out.println("6 Sample movies were successfully added");
    }

    // used to check for the next movie (highest priority) in the queue without removing it
    private static void peekMovie() {
        System.out.println("\n|****** FIRST PRIORITY MOVIE ******|");

        // check if queue is empty, if so let user know and return to call
        if (moviePriorityQueue.isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        // queue is not empty, take a peek; execution falls off, no return needed
        System.out.println(moviePriorityQueue.peek());
    }

    /**
     * java priority queue is implemented as a min-heap, so doesn't support iteration through
     * all movies in order. It instead sorts them in heap array order.
     * I wanted the list to display completely sorted, so I used a temporary queue and remove()
     * to display the movie queue sorted fully from highest to lowest priority.
     * Could have converted to array -> sort -> display, but wanted to show queue behaviors.
     */
    // prints the queue based on its priority (highest to lowest)
    private static void printQueue() {
        System.out.println("\n|****** MOVIE QUEUE CONTENTS ******|");

        // check if queue is empty, if so let user know and return to call
        if (moviePriorityQueue.isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        // make a temp copy of the queue, to not destroy data
        PriorityQueue<Movie> temp;

        // default comparator == null, otherwise assign correct comparator to copy queue
        if (moviePriorityQueue.comparator() == null) { temp = new PriorityQueue<>(); }
        else { temp = new PriorityQueue<>(moviePriorityQueue.comparator()); }
        temp.addAll(moviePriorityQueue);

        // will now print the contents of the movie priority queue completely sorted
        int count = 1;
        while ( !temp.isEmpty() ) {     // loop until empty
            System.out.println(count + ".");
            System.out.println(temp.remove());
            ++count;
        }
    }

    // removes the highest priority movie from the queue, displays the deleted movie
    private static void removeMovie() {
        System.out.println("\n|****** DELETE FIRST PRIORITY MOVIE ******|");

        // check if queue is empty, if so let user know and return to call
        if (moviePriorityQueue.isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        Movie rm = moviePriorityQueue.remove();
        System.out.println("\nRemoved Movie: ");
        System.out.println(rm);
    }

    // displays the enhanced interactive menu for the movie queue
    private static void displayMenu() {
        System.out.println("\n|****** MOVIE QUEUE MENU ******|");
        System.out.println("1. Insert a new movie");
        System.out.println("2. To peek at the next movie in the queue");
        System.out.println("3. Print the queue");
        System.out.println("4. Delete the first priority movie");
        System.out.println("5. Exit");
    }

    // inserts a movie into the priority queue
    private static void insertMovie() {
        // Movie : title, genre, rating, date(yr, m, d), recommendation
        System.out.println("\n|****** INSERT MOVIE ******|");

        scanner.nextLine();   // clear buffer

        System.out.println("Enter title: ");
        String title = scanner.nextLine();

        System.out.println("Enter genre: ");
        String genre = scanner.nextLine();

        System.out.println("Enter rating( G, PG, PG-13, R ): ");
        String rating = scanner.nextLine();

        // Date input with validation
        LocalDate date = null;
        boolean validDate = false;

        while (!validDate) {
            try {
                System.out.println("Enter release date year: ");
                int yr = scanner.nextInt();

                System.out.println("Enter release date month (1-12): ");
                int m = scanner.nextInt();

                System.out.println("Enter release date day: ");
                int d = scanner.nextInt();

                // try to create the date - will throw exception if invalid
                date = LocalDate.of(yr, m, d);
                validDate = true;  // if we reach here, date is valid

            } catch (DateTimeException e) {
                // invalid date entered (e.g., Feb 30, month 13, day 32)
                System.out.println("Invalid date. " + e.getMessage());
                System.out.println("Please try again.");
                scanner.nextLine();  // clear buffer
            } catch (Exception e) {
                // handle non-integer input
                System.out.println("Invalid input. Please enter numbers only.");
                scanner.nextLine();  // clear buffer
            }
        }

        System.out.println("Enter recommendation( 0 - 10 ): ");
        int recommendation = scanner.nextInt();

        Movie movie = new Movie( title, genre, rating, date, recommendation );

        moviePriorityQueue.add(movie);
        System.out.println("\nAdded Movie: ");
        System.out.println(movie);
    }

    // manages the enhanced interactive menu loop for queue operations
    private static void menuManager() {
        // runs the menu loop for the enhanced queue operations
        boolean done = false;

        while ( !done ) {
            displayMenu();
            int choice;
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {     // handles non-int input
                System.out.println( "Invalid input. Must be a number." );
                scanner.nextLine();     // clear buffer
                continue;               // continue to the next iteration
            }
            // execute the operation based on the user choice
            switch (choice) {
                case 1:
                    insertMovie();
                    break;
                case 2:
                    peekMovie();
                    break;
                case 3:
                    printQueue();
                    break;
                case 4:
                    removeMovie();
                    break;
                case 5:     // exit entered; leaving menu
                    done = true;
                    System.out.println("Leaving Movie Queue Menu");
                    break;
                default:    // Number was not in valid range
                    System.out.println("Number must be between 1 and 5 inclusive.");
            }
        }
    }
}
