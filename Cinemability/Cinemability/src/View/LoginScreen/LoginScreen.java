package View.LoginScreen;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class LoginScreen {

 
    String Email;
    String Password;
    public LoginScreen(BufferedReader input) throws IOException{
        input = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
        System.out.println("\n**** Cinemability ****\n");
        System.out.println("********   LOGIN   ********\n");
        
            System.out.print("Enter you Email : ");
            this.Email = input.readLine();
            
            System.out.print("Enter your Password : ");
            this.Password = input.readLine();        
    }

    public String getEmail(){
        return this.Email;
    }
    public String getPassword(){
        return this.Password;
    }
}
