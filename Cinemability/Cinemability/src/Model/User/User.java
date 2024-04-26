package Model.User;
import Model.Movies.*;
import java.util.*;

public class User{
    public String UserName;
    public String Email;
    public String Password;
    public String userType;
    public int id;
    public Vector <Movies> favouriteMovies = new Vector <Movies> ();
    public User(String UserName, String Email, String Password, String userType){
        this.UserName = UserName;
        this.Email = Email;
        this.Password = Password;
        this.userType = userType;
    }
   
}