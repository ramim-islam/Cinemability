package Model.Movies;
import java.util.*;

import Model.Movies.Cast.*;


public class Movies {

    public int id;
    public String Title;
    public String Categorey;
    public Vector<Cast>cast = new Vector<Cast>();

    public Movies(String Title, String Category, Vector<Cast> cast){
        this.Title = Title;
        this.Categorey = Category;
        this.cast = cast;
    }
}   