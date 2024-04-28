package Controller.StartApp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Controller.Login.Login;
import Controller.Registration.Registration;
import Database.MovieDatahouse.MovieDatahouse;
import Database.UserDatahouse.UserDatahouse;
import Model.User.User;
import View.FeatureView.FavouriteList.FavouriteList;
import View.FeatureView.SearchScreen.SearchScreen;
import View.HomeScreen.HomeScreen;

public class StartApp {

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

            MovieDatahouse movieDatahouse = new MovieDatahouse();
            System.out.println("Hello " + user.UserName);
            String command = HomeScreen.display(user, input);
            while(true){
                if (command.compareTo("HOME") == 0){
                    command = HomeScreen.display(user, input);
                }
                else if (command.compareTo("SEARCH") == 0){
                    command = SearchScreen.display(user, input, movieDatahouse);
                }
                else if (command.compareTo("FAV_LIST") == 0){
                    command = FavouriteList.display(user, input);
                }
                else if (command.compareTo("LOGOUT") == 0){
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

    public void startApp() throws IOException{
        
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
        System.out.println("\n**** WelCome to the Cinemability ****\n");
        System.out.println("# If do have a account Please Login otherwise Register first");
        System.out.println("1. To Login type LOGIN");
        System.out.println("2. To Register type REGISTER");

        
        UserDatahouse userDatahouse = new UserDatahouse();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));



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
