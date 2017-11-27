import java.util.ArrayList;

public class MovieDatabase {
    private ArrayList<Movie> movieList;
    private ArrayList<Actor> actorList;

    public MovieDatabase() {
        movieList = new ArrayList<Movie>();
        actorList = new ArrayList<Actor>();
    }

    /**
     * This method takes in the name of a movie that is not currently in the database along with a list of actors for
     * that movie. If the movie is already in the database, your code ignores this request (this specification is
     * an oversimplification). If the movie is a new movie, a movie object is created and added to the movieList.
     * If any of the actors happen to be new, they will be added to the actorList.
     * @param name
     * @param actors
     */
    void addMovie(String name, String[] actors) {

    }

    /**
     * Add a rating for this movie. Assume that the name argument will definitely be a name that is currently
     * in the database.
     * @param name
     * @param rating
     */
    void addRating(String name, double rating) {

    }

    /**
     * Overwrite the current rating of a movie with this new rating. Again, assume that the name argument will
     * definitely be a name that is currently in the database.
     * @param name
     * @param newRating
     */
    void updateRating(String name, double newRating) {

    }

    /**
     * Returns the name of the actor that has the best average rating for their movies.
     * @return
     */
    String getBestActor() {
        return null;
    }

    /**
     * Returns the name of the movie with the highest rating.
     * @return
     */
    String getBestMovie() {
        return null;
    }

    public ArrayList<Movie> getMovieList() {
        return movieList;
    }

    public ArrayList<Actor> getActorList() {
        return actorList;
    }
}
