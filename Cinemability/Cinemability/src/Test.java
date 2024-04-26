import java.io.IOException;

import Database.DataStructure.Trie.Trie;
import Database.UsersTable.UserDatahouse;
import Model.User.User;

public class Test {

    void UserDataHouseTesting(){
        User user = new User("ramim", "ramimgc8@gmail.com", "ramim", true);
        UserDatahouse usdh;
        usdh = new UserDatahouse();
        usdh.AddUser(user);
    }

    void Run(){

        //    UserDataHouseTesting();
           
        
    }
}
