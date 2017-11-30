import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    /* You create a new instance of a movieDatabase.
    Add all the movies in the file movies.txt.
    Go through the ratings of the movies in the file ratings.txt and add the ratings for the movies.
    Now call the methods that you created and print out the name of the best actor and the name of the highest rated movie.
     */
    public static void main(String[] args) {
        MovieDatabase movieDB = new MovieDatabase();
        String line;
        try(BufferedReader reader = new BufferedReader(new FileReader("movies.txt"))) {
            while((line = reader.readLine()) != null) {
                String[] inputs = line.split(", ");
                for(String movie: Arrays.copyOfRange(inputs, 1, inputs.length)) {
                    movieDB.addMovie(movie, Arrays.copyOfRange(inputs, 0, 1));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(BufferedReader reader = new BufferedReader(new FileReader("ratings.txt"))) {
            reader.readLine();
            while((line = reader.readLine()) != null) {
                String[] inputs = line.split("\t");
                movieDB.addRating(inputs[0], Double.parseDouble(inputs[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Best actor goes to " + movieDB.getBestActor() + ".");
        System.out.println("Best motion picture goes to " + movieDB.getBestMovie() + ".");
    }
}
