import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

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
     * @param name Name of movie which will be added
     * @param actors Array of names of actors which are in the movie cast
     */
    void addMovie(String name, String[] actors) {
        ArrayList<Actor> movieCast = new ArrayList<Actor>();
        Movie movie = new Movie(name);
        /*
        TODO see if movie is in the movieList
         */
        //if it is ignore it, go though actors list of movie and add new actors while adding movie to actors movies
        //then add new actors to actorsList
        //if not create movie object, look through actorsList for actors and add them to movies actors
        //add movie to actor's movies and add new actors to MDB's actorsList
        Arrays.stream(actors)
                .filter(s -> !actorList.contains(new Actor(s)))
                .forEach(s -> {
                    Actor currentActor = new Actor(s);

                    if(!currentActor.getMovies().contains(movie)) {
                        ArrayList<Movie> movies = currentActor.getMovies();
                        movies.add(movie);
                        currentActor.setMovies(movies);
                    }

                    movieCast.add(currentActor);
                    actorList.add(currentActor);
                });

    }

    /**
     * Add a rating for this movie. Assume that the name argument will definitely be a name that is currently
     * in the database.
     * @param name Name of the movie which is going to have it's rating added
     * @param rating Double value for new rating
     */
    void addRating(String name, double rating) {

    }

    /**
     * Overwrite the current rating of a movie with this new rating. Again, assume that the name argument will
     * definitely be a name that is currently in the database.
     * @param name Name of the movie which is going to have it's rating updated
     * @param newRating Double value for new rating
     */
    void updateRating(String name, double newRating) {

    }

    /**
     * @return Returns the name of the actor that has the best average rating for their movies.
     */
    String getBestActor() {
        return null;
    }

    /**
     *
     * @return Returns the name of the movie with the highest rating.
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
