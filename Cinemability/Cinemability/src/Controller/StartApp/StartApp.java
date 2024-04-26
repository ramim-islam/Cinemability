package Controller.StartApp;
import java.util.Scanner;

import Controller.Login.Login;
import Controller.Registration.Registration;
import Database.UsersTable.UserDatahouse;
import Model.User.User;

public class StartApp {

    void LoginFunctionality(UserDatahouse userDatahouse){
        
        Login login = new Login();
        User user = login.LoginFormView(userDatahouse);
        if (user == null){
            System.out.println("Login Failed. Please Enter Correct Email or Password\n");
            return;
        }
        else{
            System.out.println("Hello " + user.UserName);
        }
    }


    void RegistrationFunctionality(UserDatahouse userDatahouse, String command){
        
        Registration registration = new Registration();
        registration.RegistrationFormView(userDatahouse);
        LoginFunctionality(userDatahouse);
    }

    public void startApp(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
        System.out.println("\n**** WelCome to the Cinemability ****\n");
        System.out.println("# If do have a account Please Login otherwise Register first");
        System.out.println("1. To Login type LOGIN");
        System.out.println("2. To Register type REGISTER");

        
        UserDatahouse userDatahouse = new UserDatahouse();




        try (Scanner input = new Scanner(System.in)) {
            while (true){
                String command = input.nextLine();


                if (command.compareTo("LOGIN") == 0){
                    LoginFunctionality(userDatahouse);
                    break;
                }
                else if (command.compareTo("REGISTER") == 0){
                    RegistrationFunctionality(userDatahouse, command);
                    break;
                }
                else{
                    System.out.println("Please Give The Correct Command");
                }
            }
            System.out.println("\n");
        }
    }
}
