/**
 * MovieDriver - Main driver class for movie priority queue system
 * Allows users to create and manage a priority queue of movies
 * with different comparison methods
 */

import java.time.LocalDate;         // LocalDate object to represent data
import java.util.PriorityQueue;     // java API data structure
import java.util.Scanner;           // handles user input

public class MovieDriver {

    private static Scanner scanner = new Scanner((System.in));
    private static PriorityQueue<Movie> moviePriorityQueue;

    public static void main(String[] args) {
        // getChoice() -> ask the user how they wish to organize
        //                their movie queue

        // createQueue() -> based on their choice, generate a PQueue,
        //                use java API

        // insertSampleMovies() -> insert some movie objects into queue

        // peek() -> display the movie with the 1st priority in the queue. !(delete)

        // printQueue() -> display the contents of the queue -> loop(toString)

        // removeMovie() -> remove the movie object with first priority

        // re: printQueue() - display the contents of the queue

        // Test the code...assert equivalent in Java?

        // main will become ineligible - too long, parse into methods:
        // get the user's choice of queue priority rules
        // create the desired queue
        // insert movie objects
        // display the contents of the queue
        // enhanced menu w/ options: insert, peek, print, delete, exit
            // display the menu -> method
            // enact the option: all possible w/ API + existing methods
        // test_* assert equivalent in java...look for how when done w/ implementation
    }

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
                if (choice > 0 && choice < 4) {
                    done = true;
                } else {
                    System.out.println("Enter a number between 1 and 3 inclusive.");
                }
            }
            catch (Exception e) {
                System.out.println("Invalid input. Must be a number");
                scanner.nextLine();
            }
        }
        return choice;
    }

    private static void createPQueue() {
        ...
    }

    private static void insertSampleMovies() {
        System.out.println("\n|****** INSERTING SAMPLE MOVIES INTO QUEUE ******|");

        // instantiate some Movie objects
        Movie m1 = new Movie("Title1", "Drama", "R",
                LocalDate.of(2000, 1, 1), 1);
        Movie m2 = new Movie("Title2", "Drama", "R",
                LocalDate.of(2000, 2, 2), 9);
        Movie m3 = new Movie("Title3", "Comedy", "PG-13",
                LocalDate.of(20012, 1, 1), 7);
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

    private static void printQueue() {
        System.out.println("\n|****** MOVIE QUEUE CONTENTS ******|");

        // check if queue is empty, if so let user know and return to call
        if (moviePriorityQueue.isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        // TODO - print the queue...use toString in a loop?
    }

    private static void removeMovie() {
        System.out.println("\n|****** DELETE FIRST PRIORITY MOVIE ******|");

        // check if queue is empty, if so let user know and return to call
        if (moviePriorityQueue.isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        Movie rm = moviePriorityQueue.remove();
        System.out.println("\nRemoved Movie: ");
        System.out.println(rm);                         // use toString if format is goofy
    }

    private static void displayMenu() {
        System.out.println("\n|****** MOVIE QUEUE MENU ******|");
        System.out.println("1. Insert a new movie");
        System.out.println("2. To peek at the next movie in the queue");
        System.out.println("3. Print the queue");
        System.out.println("4. Delete the first priority movie");
        System.out.println("5. Exit");
    }

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

        System.out.println("Enter release date year: ");
        int yr = scanner.nextInt();

        System.out.println("Enter release date month: ");
        int m = scanner.nextInt();

        System.out.println("Enter release date day: ");
        int d = scanner.nextInt();
        // TODO - Validate days are valid for the given month

        System.out.println("Enter recommendation( 0 - 10 ): ");
        int recommendation = scanner.nextInt();

        LocalDate date = LocalDate.of(yr, m, d);
        Movie movie = new Movie( title, genre, rating, date, recommendation );

        moviePriorityQueue.add(movie);
        System.out.println("\nAdded Movie: ");
        System.out.println(movie);                         // use toString if format is goofy
    }

    private static void menuManager() {
        ...
    }
}
