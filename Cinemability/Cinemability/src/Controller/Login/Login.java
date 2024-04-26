package Controller.Login;
import java.util.Scanner;

import Database.UsersTable.UserDatahouse;
import Model.User.User;


public class Login{

    String Email;
    String Password;
    boolean LoginStatus = false;

    public User LoginFormView(UserDatahouse userdatahouse){
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
        System.out.println("\n**** Cinemability ****\n");
        System.out.println("********   LOGIN   ********\n");
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Enter your Email : ");
            this.Email = input.nextLine();

            System.out.print("Enter your Password : ");
            this.Password = input.nextLine();
        }

        User user = null;
        if (userdatahouse.isUserExist(Email, Password)){
            user = userdatahouse.getUser(Email);
        }   
        return user;             

    }

   
}
