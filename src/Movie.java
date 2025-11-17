import java.time.LocalDate;

/**
 * Movie class represents a movie with various attributes
 * Implements Comparable for default comparison based on recommendation
 */

import java.time.LocalDate;

 public class Movie implements Comparable<Movie> {
    // attributes
    private String title;               // title of the movie
    private String genre;               // genre/category of movie
    private String rating;              // rating of the movie (G, PG, PG-13, R, etc)
    private LocalDate release_date;     // date the movie was released
    private int recommendation;         // [ 0 - 10 ]

     // default constructor
     public Movie() {
         this.title = "";
         this.genre = "";
         this.rating = "";
         this.release_date = LocalDate.now();
         this.recommendation = 0;
     }

     // constructor w/ all arguments
     public Movie( String title, String genre, String rating, LocalDate release_date, int recommendation ) {
         this.title = title;
         this.genre = genre;
         this.rating = rating;
         this.release_date = release_date;
         this.recommendation = recommendation;
     }

     // getters
     public String getTitle() { return title; }
     public String getGenre() { return genre; }
     public String getRating() { return rating; }
     public LocalDate getRelease_date() { return release_date; }
     public int getRecommendation() { return recommendation; }

     // setters
     public void setTitle( String title ) { this.title = title; }
     public void setGenre( String genre ) { this.genre = genre; }
     public void setRating( String rating ) { this.rating = rating; }
     public void setRelease_date( LocalDate release_date ) { this.release_date = release_date; }
     public void setRecommendation( int recommendation ) { this.recommendation = recommendation; }

     // toString -> display info about the movie
     @Override
     public String toString() {
         String s = "Title: " + getTitle();
         s += "\nGenre: " + getGenre();
         s += "\nRating: " + getRating();
         s += "\nRelease Date: " + getRelease_date();
         s += "\nRecommendation: " + getRecommendation() + "\n";
         return s;
     }

     // compareTo -> compare to movies based on their recommendation. (this & other)
     @Override
     public int compareTo( Movie other ) {
        return Integer.compare(other.recommendation, this.recommendation);
        // java PriorityQueue is min-heap, so 1 would be higher priority than 10 by default
        // flipped the comparison, b/c Higher recommendation == Higher Priority
     }
 }
