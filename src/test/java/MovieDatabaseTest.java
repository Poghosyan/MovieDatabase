import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MovieDatabaseTest {
    MovieDatabase movieDB;

    @Before
    public void setUp() throws Exception {
        movieDB = new MovieDatabase();
    }

    @Test
    public void addMovie() throws Exception {
        Movie movie = new Movie("Termnator", null, 0.0);
        movieDB.addMovie("Terminator", new String[] {"Arnold Schewarzeneger", "Fake Name"});
        ArrayList<Movie> listToCheck = movieDB.getMovieList();
        assertTrue(listToCheck.contains(movie));
    }

    @Test
    public void addRating() throws Exception {
    }

    @Test
    public void updateRating() throws Exception {
    }

    @Test
    public void getBestActor() throws Exception {
    }

    @Test
    public void getBestMovie() throws Exception {
    }
}