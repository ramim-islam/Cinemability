package View.RegistrationScreen;
import java.io.BufferedReader;
import java.io.IOException;
import Database.UserDatahouse.UserDatahouse;
import Model.User.User;

public class RegistrationScreen {

    User user;
    String rPassword;
    
    public RegistrationScreen(User user){
        this.user = user;
    }

    public User RegistrationFormView(UserDatahouse userDatahouse, BufferedReader input) throws IOException{
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
        System.out.println("\n**** Cinemability ****\n");
        System.out.println("********   REGISTRATION   ********\n");

        
        System.out.print("Enter you Username (Username Must be with one word) : ");
        user.UserName = input.readLine();

        while(true){
            System.out.print("Enter your Email : ");
            user.Email = input.readLine();
            if (userDatahouse.Search(user.Email) != null){
                System.out.println("This Email Already Exists\n");
                continue;
            }
            break;
        }
        System.out.print("Enter your Password : ");
        user.Password = input.readLine();

        while (true){
            System.out.print("ReType your Password : ");
            this.rPassword = input.readLine();
            if (user.Password.compareTo(rPassword) == 0){
                break;
            }
            System.out.println("Password doesn't match");
        }
        System.out.println("What type of user you are? (Admin or General)");
        System.out.print("If you are Admin type ADMIN otherwise type GENERAL : ");
        user.userType = input.readLine();
        
        System.out.print('\n');
        return user;
    }
}
