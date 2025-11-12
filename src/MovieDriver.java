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
        ...
    }

    private static void createPQueue() {
        ...
    }

    private static void insertSampleMovies() {
        ...
    }

    private static void peekMovie() {
        ...
    }

    private static void printQueue() {
        ...
    }

    private static void removeMovie() {
        ...
    }

    private static void displayMenu() {
        ...
    }

    private static void insertMovie() {
        ...
    }

    private static void menuManager() {
        ...
    }
}
