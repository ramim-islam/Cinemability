package Database.UsersTable;
import Database.DataStructure.Trie.Trie;
import Model.User.User;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class UserDatahouse extends Trie{
    
    String filename = "UserDataHouse.txt";
    String routePath = System.getProperty("user.dir") + "/Cinemability/Cinemability/src/Database/UsersTable";
    File userDataHouse = new File(routePath, filename);
    
    public UserDatahouse(){
        if (!userDataHouse.exists()){
            try {
                userDataHouse.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    int HashFunction(String Password){
        return 0;
    }
    public void AddUser(User user){
        
        String userdata = user.Name + " " + user.Email + " " + user.Password + " " + user.isAdmin;
        String path = routePath + "/" + filename;

        try {
            Files.write(Paths.get(path), userdata.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {}
        addString(user.Email, HashFunction(user.Password));

    }

    protected boolean SearchUser(String Email, String Password){
       return (searchString(Email) == HashFunction(Password));
    }

    void DeleteUser(User user){

    }
}
