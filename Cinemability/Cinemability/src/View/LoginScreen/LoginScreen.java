package View.LoginScreen;
import java.util.Scanner;
import Controller.Login.Login;

public class LoginScreen {

    Login login = new Login();
    public Login LoginScreenView(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
        System.out.println("\n**** Cinemability ****\n");
        System.out.println("********   LOGIN   ********\n");
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Enter your Email : ");
            login.Email = input.nextLine();

            System.out.print("Enter your Password : ");
            login.Password = input.nextLine();
        }
        return login;
    }
}
