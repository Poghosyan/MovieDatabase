import java.util.ArrayList;

public class Movie implements Comparable<Movie> {
    private String name;
    private ArrayList<Actor> actors;
    private double rating;

    public Movie(String name, String[] actors, double rating) {
        this.name = name;
        this.rating = rating;
        for (String actorName : actors) {
            Actor current = new Actor(actorName, );
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Actor> getActors() {
        return actors;
    }

    public void setActors(ArrayList<Actor> actors) {
        this.actors = actors;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (name != null ? !name.equals(movie.name) : movie.name != null) return false;
        return actors != null ? actors.equals(movie.actors) : movie.actors == null;
    }

    public int compareTo(Movie o) {
        return 0;
    }
}
