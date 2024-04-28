package View.FeatureView.SearchScreen;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Vector;

import Database.MovieDatahouse.MovieDatahouse;
import Model.Movies.Movies;
import Model.Movies.Cast.Cast;
import Model.User.User;

public class SearchScreen {

    static void baseDisplay(User user){
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
        System.out.println("\n**** Cinemability ****\n");
        System.out.print("Home     *Search_Movies     Favourite_List     " + user.UserName);
        if (user.userType.compareTo("ADMIN") == 0){
            System.out.println("(Admin)");
        }else System.out.println();
        System.out.println();
    }

    public static String display(User user, BufferedReader input, MovieDatahouse movieDatahouse) throws IOException{
        
        
        baseDisplay(user);

        while(true){
            baseDisplay(user);
            System.out.println("Search for Movies by Movie_Title, Categorey or Cast_Name");
            System.out.println("...................................................\n");
            System.out.print("Title / Categorey / Cast : ");
            String keyword = input.readLine();
            if (keyword.compareTo("DONE") == 0){
                break;
            }
            Vector <Movies> Movie = movieDatahouse.SearchMovie(keyword);
            if (Movie.isEmpty()){
                System.out.println("Try Again ?\n");
            }else{
                for(Movies movie: Movie){
                    System.out.println("--------------------------------------------------------------------------");
                    System.out.println("| Movie Title : " + movie.Title);
                    System.out.println("| Categorey   : " + movie.Categorey);
                    System.out.print("| Casts       : ");
                    for (Cast cast: movie.cast){
                        System.out.print(cast.name + " , ");
                    }
                    System.out.println("\n--------------------------------------------------------------------------");
                    System.out.println("\n");
                
                    System.out.print("Add this Movie to your favouriteList ? (YES) / (NO) : ");
                    String addmovie = input.readLine();
                    if (addmovie.compareTo("YES") == 0){
                        user.favouriteMovies.add(movie);
                        System.out.println("\n(" + movie.Title + ")" + " is added to your Favourite Movie List");
                    }
                }
            }

            System.out.println("# Continue Searching? (CONTINUE) / (DONE) #");
            System.out.print("Command : ");
            String command = "";

            while(true){
                command = input.readLine();
                if (command.compareTo("DONE") == 0 || command.compareTo("CONTINUE") == 0)break;
                else System.out.println("Give a Valid Command\n");
            }
            if (command.compareTo("DONE") == 0)break;
            else if (command.compareTo("CONTINUE") == 0)continue;
            
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
