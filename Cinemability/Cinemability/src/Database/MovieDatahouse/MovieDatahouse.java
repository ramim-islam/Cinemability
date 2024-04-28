package Database.MovieDatahouse;

import java.util.Vector;

import Database.FileIO.Fileio;
import Model.Movies.Movies;
import Model.Movies.Cast.Cast;


public class MovieDatahouse extends MovieTrie{
    Fileio file;

    void InsertMovie(Movies movies){
        Insert(movies.Title, movies);
        Insert(movies.Categorey, movies);
        for (Cast cast: movies.cast){
            Insert(cast.name, movies);
        }
    }

    public MovieDatahouse(){
        this.file = new Fileio("MovieDatahouse/", "MovieDatahouse.txt");
        file.CreateFile();
        Vector<Vector<String>> movieData = file.ReadFile();
        for (Vector<String> data : movieData){
            Vector <Cast> _cast = new Vector<Cast>();
            for (int i = 2; i < data.size(); i++){
                _cast.add(new Cast(data.get(i)));
            }
            Movies movie = new Movies(data.get(0), data.get(1), _cast);
            if (movie != null)InsertMovie(movie);
        }
    }

    public void AddMovie(Movies movie){
        if (movie == null)return;
        Vector<String> movieData = new Vector<String>();
        movieData.add(movie.Title);
        movieData.add(movie.Categorey);
        for (Cast cast: movie.cast){
            movieData.add(cast.name);
        } 
        

        file.AppendData(movieData);
        if (movie != null)InsertMovie(movie);

    }


    public Vector<Movies> SearchMovie(String Keyword){
        return search(Keyword);
    }


    void DeleteUser(Movies movie){

    }
}
