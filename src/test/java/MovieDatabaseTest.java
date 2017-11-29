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
    public void addNewMovieNoActor() throws Exception {
        Movie movie = new Movie("Termnator");
        movieDB.addMovie("Terminator", new String[] {});
        ArrayList<Movie> listToCheck = movieDB.getMovieList();
        assertTrue(listToCheck.contains(movie));
    }

    @Test
    public void addNewMovieNewActor() throws Exception {
        Movie movie = new Movie("Terminator");
        Actor actor1 = new Actor("Arnold Schwarzenegger");
        Actor actor2 = new Actor("Fake Name");

        movieDB.addMovie("Terminator", new String[] {});
        movieDB.addMovie("Terminator", new String[] {"Arnold Schwarzenegger", "Fake Name"});

        ArrayList<Actor> actorListToCheck = movieDB.getActorList();
        ArrayList<Movie> movieListToCheck = movieDB.getMovieList();

        assertTrue(movieListToCheck.contains(movie));
        assertTrue(actorListToCheck.contains(actor1));
        assertTrue(actorListToCheck.contains(actor2));
    }

    @Test
    public void addCopyOfMovie() throws Exception {
        movieDB.addMovie("Terminator", new String[] {"Arnold Schwarzenegger", "Fake Name"});
        movieDB.addMovie("Terminator", new String[] {"Arnold Schwarzenegger", "Fake Name"});
        assertEquals(1, movieDB.getMovieList().size());
        assertEquals(2, movieDB.getActorList().size());
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