package Controller.Registration;
import Database.PrimaryKey.PrimaryKey;
import Database.UsersDatahouse.UserDatahouse;
import Model.User.User;
import View.RegistrationScreen.RegistrationScreen;

public class Registration{

    PrimaryKey PK = new PrimaryKey();
    String PrimaryKey = PK.getPrimaryKey();
    User user = new User(null, null, null, null, null);

    public void RegistrationForm(UserDatahouse userDatahouse){

        RegistrationScreen registrationScreen = new RegistrationScreen(user);
        user = registrationScreen.RegistrationFormView(userDatahouse);
        userDatahouse.AddUser(user);
    }
    
}
