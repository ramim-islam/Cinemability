package Controller.Registration;
import java.io.BufferedReader;
import java.io.IOException;

import Database.PrimaryKey.PrimaryKey;
import Database.UserDatahouse.UserDatahouse;
import Model.User.User;
import View.RegistrationScreen.RegistrationScreen;

public class Registration{

    PrimaryKey PK;
    String PrimaryKey;
    User user;

    public Registration(){
        PK = new PrimaryKey();
        PrimaryKey = PK.getPrimaryKey();
        user = new User(PrimaryKey, PrimaryKey, PrimaryKey, PrimaryKey, PrimaryKey);
    }

    public void RegistrationForm(UserDatahouse userDatahouse, BufferedReader input){

        RegistrationScreen registrationScreen = new RegistrationScreen(user);
        try {
           
            this.user = registrationScreen.RegistrationFormView(userDatahouse, input);
            this.user.PrimaryKey = PrimaryKey;
        } 
        catch (IOException e) {e.printStackTrace();}
        userDatahouse.AddUser(user);
    }
    
}
