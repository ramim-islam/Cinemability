package Model.NormalUser;
import Model.Movies.*;
import java.util.*;

public class NormalUser{
    String Name;
    String Email;
    String Password;
    Vector <Movies> favouriteMovies = new Vector <Movies> ();
    NormalUser(String Name, String Email, String Password){
        this.Name = Name;
        this.Email = Email;
        this.Password = Password;
    }
   
}