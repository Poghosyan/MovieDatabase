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
        Movie movie = new Movie("Terminator");
        movieDB.addMovie("Terminator", new String[] {});
        movieDB.addRating("Terminator", 5.0);
        int index = movieDB.getMovieList().indexOf(movie);
        assertNotEquals(-1, index);
        Movie toCheck = movieDB.getMovieList().get(index);
        assertEquals(5.0, toCheck.getRating(), .099);
    }

    @Test
    public void updateRating() throws Exception {
        Movie movie = new Movie("Terminator");
        movieDB.addMovie("Terminator", new String[] {});
        movieDB.updateRating("Terminator", 4.8);
        int index = movieDB.getMovieList().indexOf(movie);
        assertNotEquals(-1, index);
        Movie toCheck = movieDB.getMovieList().get(index);
        assertEquals(4.8, toCheck.getRating(), .099);
    }

    @Test
    public void getBestActor() throws Exception {
        movieDB.addMovie("My movie", new String[] {"Me"});
        movieDB.addMovie("Terminator", new String[] {"Arnold Schwarzenegger", "Fake Name", "Name 2"});
        movieDB.addMovie("Test Movie", new String[] {"Fake Name", "Name 2"});
        movieDB.addRating("Terminator", 5.0);
        movieDB.addRating("Test Movie", 4.0);
        movieDB.addRating("My movie", 5.0);
        String bestActor = movieDB.getBestActor();
        assertTrue(bestActor.equals("Arnold Schwarzenegger") || bestActor.equals("Me"));
    }

    @Test
    public void getBestMovie() throws Exception {
        movieDB.addMovie("My movie", new String[] {"Me"});
        movieDB.addMovie("Terminator", new String[] {"Arnold Schwarzenegger", "Fake Name", "Name 2"});
        movieDB.addMovie("Test Movie", new String[] {"Fake Name", "Name 2"});
        movieDB.addRating("Terminator", 5.0);
        movieDB.addRating("Test Movie", 4.0);
        movieDB.addRating("My movie", 5.0);
        String bestMovie = movieDB.getBestMovie();
        assertTrue(bestMovie.equals("Terminator") || bestMovie.equals("My movie"));
    }
}