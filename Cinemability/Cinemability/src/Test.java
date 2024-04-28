import java.util.Vector;
import Database.MovieDatahouse.MovieDatahouse;
import Database.UserDatahouse.UserDatahouse;
import Model.Movies.Movies;
import Model.User.User;

public class Test {

    UserDatahouse userDatahouse = new UserDatahouse(new MovieDatahouse());
   
    void UserDataHouseTesting(){
        User user = new User("ramim", "ramimgc8@gmail.com", "ramim", "Admin");
        userDatahouse.AddUser(user);
    }

    void TrieTesting(){
        User user = userDatahouse.search("ramimgc8@gmail.com");
        if (user == null){
            System.out.println("Problem with Trie");
        }else{
            System.out.println("NO problem with Trie");
            System.out.print(user.UserName + " ");
            System.out.print(user.Email + " ");
            System.out.print(user.Password + " ");
            System.out.println(user.userType);
        }
    }

    
    void movieDatahouseTesting(){
        MovieDatahouse movieDatahouse = new MovieDatahouse();
    }
   

    void Run(){

        // UserDataHouseTesting();
        // TrieTesting();
        movieDatahouseTesting();
    }
}
