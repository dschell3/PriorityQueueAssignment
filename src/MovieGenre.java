import java.util.Comparator;

/**
 * MovieGenre comparator class
 * Compares movies based on their genre alphabetically
 */

public class MovieGenre implements Comparator<Movie> {
    @Override
    public int compare( Movie a, Movie b ) {
        return a.getGenre().compareToIgnoreCase(b.getGenre());
    }
}
