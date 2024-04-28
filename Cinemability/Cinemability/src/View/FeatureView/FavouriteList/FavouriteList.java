package View.FeatureView.FavouriteList;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Vector;

import Database.MovieDatahouse.MovieDatahouse;
import Model.Movies.Movies;
import Model.Movies.Cast.Cast;
import Model.User.User;

public class FavouriteList {
    
    static void baseDisplay(User user){
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
        System.out.println("\n**** Cinemability ****\n");
        System.out.print("Home     Search_Movies     *Favourite_List     " + user.UserName);
        if (user.userType.compareTo("ADMIN") == 0){
            System.out.println("(Admin)");
        }else System.out.println();
        System.out.println();
    }

    public static String display(User user, BufferedReader input, MovieDatahouse movieDatahouse) throws IOException{
        
        
        baseDisplay(user);

       
        Vector <Movies> movies = user.favouriteMovies.ShowAllMoviesSortedBasedOnMovieTitle();
        for(Movies movie: movies){
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("| Movie Title : " + movie.Title);
            System.out.println("| Categorey   : " + movie.Categorey);
            System.out.print("| Casts       : ");
            for (Cast cast: movie.cast){
                System.out.print(cast.name + " , ");
            }
            System.out.println("\n--------------------------------------------------------------------------");
            System.out.println("\n");
        }
       

        System.out.println("1. To move to Homepage type   : HOME");
        System.out.println("2. To See Favourite_List type : FAV_LIST");
        System.out.println("3. To Logout type             : LOGOUT");
        System.out.println("...................................................\n");

        System.out.print("Command : ");
        String command = input.readLine();
        

         
        return command;
        

    }

}
