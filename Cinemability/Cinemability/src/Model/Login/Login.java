package Model.Login;

import Database.UsersTable.UserDatahouse;

public class Login extends UserDatahouse{
    String Email;
    String Password;
    boolean LoginStatus = false;

    Login(String Email, String Password){
        if (SearchUser(Email, Password)){
            this.Email = Email;
            this.Password = Password;
            this.LoginStatus = true;
        }
    }

   
}
