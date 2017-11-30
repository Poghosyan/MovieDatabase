import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
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
     *
     * @param name   Name of movie which will be added
     * @param actors Array of names of actors which are in the movie cast
     */
    void addMovie(String name, String[] actors) {
        //TODO Implement in the regular way and then refactor using streams
        ArrayList<Actor> movieCast = new ArrayList<Actor>();
        ArrayList<Movie> flixCastIn = new ArrayList<Movie>();
        Movie movie = new Movie(name);

        if (!movieList.contains(movie)) {
            movieCast = addToActorList(movie, actors);
            movie.setActors(movieCast);
            movieList.add(movie);
        }

        for (Actor actorToAdd : movieCast) {
            if (actorList.contains(actorToAdd)) {
                int index = actorList.indexOf(actorToAdd);
                actorToAdd = actorList.get(index);
                flixCastIn = actorToAdd.getMovies();
                if (!flixCastIn.contains(movie)) {
                    flixCastIn.add(movie);
                    actorToAdd.setMovies(flixCastIn);
                }
                actorList.set(index, actorToAdd);
            } else {
                actorList.add(actorToAdd);
            }
        }
    }

    private ArrayList<Actor> addToActorList(Movie movie, String[] actors) {
        Actor actor;
        ArrayList<Actor> result = new ArrayList<Actor>();
        for (String actorName : actors) {
            actor = new Actor(actorName);
            if (actorList.contains(actor)) {
                actor = actorList.get(actorList.indexOf(actor));
                actor = addMovieToList(actor, movie);
            } else {
                actor = addMovieToList(actor, movie);
            }
            result.add(actor);
        }
        return result;
    }

    private Actor addMovieToList(Actor actor, Movie movie) {
        ArrayList<Movie> actorMovies;
        actorMovies = actor.getMovies();
        actorMovies.add(movie);
        actor.setMovies(actorMovies);
        return actor;
    }

    /**
     * Add a rating for this movie. Assume that the name argument will definitely be a name that is currently
     * in the database.
     *
     * @param name   Name of the movie which is going to have it's rating added
     * @param rating Double value for new rating
     */
    void addRating(String name, double rating) {
        int index = movieList.indexOf(new Movie(name));
        if(index != -1) {
            Movie movie = movieList.get(index);
            movie.setRating(rating);
            movieList.set(index, movie);
        }
    }

    /**
     * Overwrite the current rating of a movie with this new rating. Again, assume that the name argument will
     * definitely be a name that is currently in the database.
     *
     * @param name      Name of the movie which is going to have it's rating updated
     * @param newRating Double value for new rating
     */
    void updateRating(String name, double newRating) {
        int index = movieList.indexOf(new Movie(name));
        if(index != -1) {
            Movie movie = movieList.get(index);
            movie.setRating(newRating);
            movieList.set(index, movie);
        };
    }

    /**
     * @return Returns the name of the actor that has the best average rating for their movies.
     */
    String getBestActor() {
        if (actorList.isEmpty()) {
            return null;
        }

        Actor result = actorList.get(0);
        for (Actor actor : actorList) {
            if (avgRating(actor.getMovies()) > avgRating(result.getMovies())) {
                result = actor;
            }
        }
        return result.getName();
    }

    private double avgRating(ArrayList<Movie> movies) {
        return movies.stream().collect(Collectors.averagingDouble(Movie::getRating));
    }

    /**
     * @return Returns the name of the movie with the highest rating.
     */
    String getBestMovie() {
        if (movieList.isEmpty()) {
            return null;
        }

        Movie result = movieList.get(0);
        for (Movie movie : movieList) {
            if (result.getRating() < movie.getRating()) {
                result = movie;
            }
        }
        return result.getName();
    }

    public ArrayList<Movie> getMovieList() {
        return movieList;
    }

    public ArrayList<Actor> getActorList() {
        return actorList;
    }
}
