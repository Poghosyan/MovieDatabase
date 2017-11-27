import java.util.ArrayList;

public class Actor {
    private String name;
    //an Arraylist that has movies that this actor has acted in, not necessarily all the movies
    private ArrayList<Movie> movies;

    public Actor(String name, ArrayList<Movie> movies) {
        this.name = name;
        this.movies = movies;
    }

    public String getName() {
        return name;
    }

    public void getName(String name) {
        this.name = name;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Actor actor = (Actor) o;

        if (!getName().equals(actor.getName())) return false;
        return getMovies().equals(actor.getMovies());
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getMovies().hashCode();
        return result;
    }
}
