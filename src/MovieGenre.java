import java.util.Comparator;

/**
 * MovieGenre comparator class
 * Compares movies based on their genre alphabetically (case-insensitive)
 * Earlier alpha genres == higher priority in queue
 */

public class MovieGenre implements Comparator<Movie> {
    @Override
    public int compare( Movie a, Movie b ) {
        return a.getGenre().compareToIgnoreCase(b.getGenre());
    }
    // this compare() is not reversed because the default behavior of the min-heap is
    // already A-Z, 'smaller' ASCII values have higher priority
}
