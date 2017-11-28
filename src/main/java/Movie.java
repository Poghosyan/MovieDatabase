import java.util.ArrayList;

public class Movie implements Comparable<Movie> {
    private String name;
    private ArrayList<Actor> actors;
    private double rating;

    public Movie(String name) {
        this.name = name;
        this.rating = 0.0;
        actors = new ArrayList<Actor>();
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

        return name != null ? name.equals(movie.name) : movie.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    public int compareTo(Movie o) {
        return 0;
    }
}
