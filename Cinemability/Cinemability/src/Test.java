import java.io.IOException;
import java.util.Vector;

import Database.DataStructure.Trie.ObjectbasedTrieImplementation.Trie;
import Database.MovieDatahouse.MovieDatahouse;
import Database.UserDatahouse.UserDatahouse;
import Database.UserDatahouse.UserTrie;
import Model.Movies.Movies;
import Model.User.User;

public class Test {

    // UserDatahouse userDatahouse = new UserDatahouse(new MovieDatahouse());
   
    // void UserDataHouseTesting(){
    //     User user = new User("ramim", "ramimgc8@gmail.com", "ramim", "Admin");
    //     userDatahouse.AddUser(user);
    // }

    

    void TrieTesting(){
        UserTrie userTrie = new UserTrie();
        for (Integer i = 20; i >= 0; i--){
            System.out.println(i);
            String username = "R" + Integer.toString(i);
            String Email = username + "@gmail.com";
            String Password = Email + username;
            User user = new User(username, Email,Password, "GENERAL");
            userTrie.Insert(Email, user);
        }
        Vector <User> userList = new Vector<User>();
        userList = userTrie.ShowAllUser();
        for (User user: userList){
            System.out.println(user.UserName + " " + user.Email + " " + user.Password + " " + user.userType);
        }
    }
    
    // void movieDatahouseTesting(){
    //     MovieDatahouse movieDatahouse = new MovieDatahouse();
    // }
    // void userDatahouseTesting() throws IOException{
    //     UserDatahouse userDatahouse = new UserDatahouse(new MovieDatahouse());
    //     userDatahouse.file.DeleteContent();
    // }
   

    void Run() throws IOException{

        // UserDataHouseTesting();
        // TrieTesting();
        // movieDatahouseTesting();
        //userDatahouseTesting();
        TrieTesting();
    }
}
