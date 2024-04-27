package View.RegistrationScreen;

import java.util.Scanner;

import Database.UsersDatahouse.UserDatahouse;
import Model.User.User;

public class RegistrationScreen {

    User user;
    String rPassword;
    
    public RegistrationScreen(User user){
        this.user = user;
    }

    public User RegistrationFormView(UserDatahouse userDatahouse){
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
        System.out.println("\n**** Cinemability ****\n");
        System.out.println("********   REGISTRATION   ********\n");

        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Enter you Username (Username Must be with one word) : ");
            user.UserName = input.nextLine();

            while(true){
                System.out.print("Enter your Email : ");
                user.Email = input.nextLine();
                if (userDatahouse.search(user.Email) != null){
                    System.out.println("This Email Already Exists\n");
                    continue;
                }
                break;
            }
            System.out.print("Enter your Password : ");
            user.Password = input.nextLine();

            while (true){
                System.out.print("ReType your Password : ");
                this.rPassword = input.nextLine();
                if (user.Password.compareTo(rPassword) == 0){
                    break;
                }
                System.out.println("Password doesn't match");
            }
            System.out.println("What type of user you are? (Admin or General)");
            System.out.print("If you are Admin type ADMIN otherwise type GENERAL : ");
            user.userType = input.nextLine();
            
        }
        System.out.print('\n');
        return user;
    }
}
