/**
 * MovieReleaseDate comparator class
 * Compares movies based on their release date
 * Earlier dates have higher priority
 */

import java.util.Comparator;

 public class MovieReleaseDate implements Comparator<Movie> {
     @Override
     public int compare(Movie a, Movie b) {
        return a.getRelease_date().compareTo(b.getRelease_date());
         // if < 0 ; a was released before b
         // if > 0 ; b was released before a
         // if = 0 ; a was released at the same time as b
     }
}
