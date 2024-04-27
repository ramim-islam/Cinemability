package Controller.Login;
import Database.UsersDatahouse.UserDatahouse;
import Model.User.User;
import View.LoginScreen.LoginScreen;


public class Login{

    public String Email;
    public String Password;
    boolean LoginStatus = false;

    public User LoginFormView(UserDatahouse userdatahouse){
        
        LoginScreen loginScreen = new LoginScreen(); 
        Login login = loginScreen.LoginScreenView();
        User user = null;
        if (userdatahouse.isUserExist(login.Email, login.Password)){
            user = userdatahouse.getUser(login.Email);
        }   
        return user;             

    }

   
}
