package Model.Movies;
import java.util.*;

import Model.Movies.Cast.*;


public class Movies {

    String title;
    String Categorey;
    Vector<Cast>cast = new Vector<Cast>();

    Movies(String title, String Category, Vector<Cast> cast){
        this.title = title;
        this.Categorey = Category;
        this.cast = cast;
    }
}   