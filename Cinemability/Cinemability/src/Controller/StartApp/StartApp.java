package Controller.StartApp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

import Controller.Login.Login;
import Controller.Registration.Registration;
import Database.MovieDatahouse.MovieDatahouse;
import Database.UserDatahouse.UserDatahouse;
import Model.Movies.Movies;
import Model.Movies.Cast.Cast;
import Model.User.User;
import View.FeatureView.FavouriteList.FavouriteList;
import View.FeatureView.SearchScreen.SearchScreen;
import View.HomeScreen.HomeScreen;

public class StartApp {

    MovieDatahouse movieDatahouse;
    UserDatahouse userDatahouse;
    BufferedReader input;

    public StartApp(){
        movieDatahouse = new MovieDatahouse();
        userDatahouse = new UserDatahouse(movieDatahouse);
        input = new BufferedReader(new InputStreamReader(System.in));
    }

    void LoginFunctionality(UserDatahouse userDatahouse, BufferedReader input) throws IOException{
        
        System.out.println("I am HGeres");
        Login login = new Login();
        User user = null;
        try {
            user = login.LoginFormView(userDatahouse, input);
        } 
        catch (IOException e) {e.printStackTrace();}
        if (user == null){
            System.out.println("Login Failed. Please Enter Correct Email or Password\n");
            return;
        }
        else{

           
            String command = HomeScreen.display(user, input);
            while(true){
                
                
                if (command.compareTo("HOME") == 0){
                    command = HomeScreen.display(user, input);
                }
                
                
                else if (command.compareTo("SEARCH") == 0){
                    command = SearchScreen.display(user, input, movieDatahouse);
                }
                
                
                else if (command.compareTo("FAV_LIST") == 0){
                    command = FavouriteList.display(user, input, movieDatahouse);
                }


                else if (command.compareTo("LOGOUT") == 0){
                    
                    Vector <User> userList = userDatahouse.ShowAllUser();
                    userDatahouse.file.DeleteContent();
                    for (User usr: userList){
                        Vector <String> userData = new Vector<String>();
                        userData.add(usr.UserName);
                        userData.add(usr.Email);
                        userData.add(usr.Password);
                        Vector <Movies> favmovie = usr.favouriteMovies.ShowAllMoviesSortedBasedOnMovieTitle();
                        for (Movies movie: favmovie){
                            userData.add(movie.Title);
                        }
                        userDatahouse.file.AppendData(userData);
                    }


                    Vector <Movies> movieList = movieDatahouse.ShowAllMoviesSortedBasedOnMovieTitle();
                    movieDatahouse.file.DeleteContent();
                    for (Movies movie: movieList){
                        Vector <String> movieData = new Vector<String>();
                        movieData.add(movie.Title);
                        movieData.add(movie.Categorey);
                        for (Cast cast: movie.cast)movieData.add(cast.name);
                        movieDatahouse.file.AppendData(movieData);
                    }



                    break;
                }
            }
        }
    }


    void RegistrationFunctionality(UserDatahouse userDatahouse, BufferedReader input) throws IOException{
       
        Registration registration = new Registration();
        registration.RegistrationForm(userDatahouse, input);
        LoginFunctionality(userDatahouse, input);
    }

    void baseDisplay(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
        System.out.println("\n**** WelCome to the Cinemability ****\n");
        System.out.println("# If do have a account Please Login otherwise Register first");
        System.out.println("1. To Login type LOGIN");
        System.out.println("2. To Register type REGISTER");
    }

    public void startApp() throws IOException{
        
       
        baseDisplay();
        
        



        while (true){
            String command = input.readLine();
            if (command.compareTo("LOGIN") == 0){
                LoginFunctionality(userDatahouse, input);
                break;
            }
            else if (command.compareTo("REGISTER") == 0){
                RegistrationFunctionality(userDatahouse, input);
                break;
            }
            else{
                System.out.println("Please Give The Correct Command");
            }
        }
        System.out.println("\n");
    }
}
