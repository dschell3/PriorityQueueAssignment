import java.time.LocalDate;

/**
 * Movie class represents a movie with various attributes
 * Implements Comparable for default comparison based on recommendation
 */

import java.time.LocalDate

 public class Movie {
    // attributes
    private String title;
    private String genre;
    private String rating;
    private LocalDate release_date;
    private int recommendation;  // [ 0 - 10 ]

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


 }
