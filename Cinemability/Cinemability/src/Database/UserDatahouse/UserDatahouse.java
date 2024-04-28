package Database.UserDatahouse;
import Model.Movies.Movies;
import Model.User.User;
import java.util.Vector;
import Database.FileIO.Fileio;
import Database.MovieDatahouse.MovieDatahouse;



public class UserDatahouse extends UserTrie{


    Fileio file;
    public UserDatahouse(MovieDatahouse movieDatahouse){
        this.file = new Fileio("UserDatahouse/", "UserDatahouse.txt");
        file.CreateFile();
        Vector<Vector<String>> userData = file.ReadFile();
        for (Vector<String> data : userData){
            User user = new User(data.get(0), data.get(1), data.get(2), data.get(3));
            for (int i = 4; i < data.size(); i++){
                Movies movie = movieDatahouse.GetMovie(data.get(i)).lastElement();
                user.favouriteMovies.Insert(movie.Title, movie);
            } 
           
            if (user != null)Insert(user.Email, user);
        }
    }

    public void AddUser(User user){
        if (user == null)return;
        Vector<String> userdata = new Vector<String>();
        userdata.add(user.UserName);
        userdata.add(user.Email);
        userdata.add(user.Password);
        userdata.add(user.userType); 
        file.AppendData(userdata);
        Insert(user.Email, user);

    }


    public User getUser(String Email){
        return search(Email);
    }

    public boolean isUserExist(String Email, String Password){
        User user = getUser(Email);
        if (user == null)return false;
        return (user.Password.compareTo(Password) == 0);
    }



    void DeleteUser(User user){

    }
}
