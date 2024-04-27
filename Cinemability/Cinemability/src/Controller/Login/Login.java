package Controller.Login;
import java.io.BufferedReader;
import java.io.IOException;
import Database.UserDatahouse.UserDatahouse;
import Model.User.User;
import View.LoginScreen.LoginScreen;


public class Login{

    public String Email;
    public String Password;
    boolean LoginStatus = false;
   
    public User LoginFormView(UserDatahouse userdatahouse, BufferedReader input) throws IOException{
        
        LoginScreen loginScreen = new LoginScreen(input); 
        this.Email = loginScreen.getEmail();
        this.Password = loginScreen.getPassword();
        User user = null;
        if (userdatahouse.isUserExist(this.Email, this.Password)){
            user = userdatahouse.getUser(this.Email);
        }   
        return user;             

    }

   
}
