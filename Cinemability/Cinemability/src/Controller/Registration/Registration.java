package Controller.Registration;
import java.io.BufferedReader;
import java.io.IOException;

import Database.PrimaryKey.PrimaryKey;
import Database.UserDatahouse.UserDatahouse;
import Model.User.User;
import View.RegistrationScreen.RegistrationScreen;

public class Registration{

    PrimaryKey PK = new PrimaryKey();
    String PrimaryKey = PK.getPrimaryKey();
    User user = new User(null, null, null, null, null);

    public void RegistrationForm(UserDatahouse userDatahouse, BufferedReader input){

        RegistrationScreen registrationScreen = new RegistrationScreen(user);
        try {
            user = registrationScreen.RegistrationFormView(userDatahouse, input);
        } 
        catch (IOException e) {e.printStackTrace();}
        userDatahouse.AddUser(user);
    }
    
}
