package Model.User;
import Model.Movies.*;
import java.util.*;

public class User{
    public String Name;
    public String Email;
    public String Password;
    public boolean isAdmin;
    public Vector <Movies> favouriteMovies = new Vector <Movies> ();
    public User(String Name, String Email, String Password, boolean isAdmin){
        this.Name = Name;
        this.Email = Email;
        this.Password = Password;
        this.isAdmin = isAdmin;
    }
   
}