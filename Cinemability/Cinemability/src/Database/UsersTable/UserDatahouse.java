package Database.UsersTable;
import Database.DataStructure.Trie.Trie;
import Model.User.User;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class UserDatahouse extends Trie{
    
    String filename = "UserDatahouse.txt";
    String routePath = System.getProperty("user.dir") + "/Cinemability/Cinemability/src/Database/UsersTable";
    File userDataHouse = new File(routePath, filename);


    public UserDatahouse(){
        if (!userDataHouse.exists()){
            try {userDataHouse.createNewFile();} 
            catch (IOException e) {e.printStackTrace();}
        }
        try {
            Scanner input = new Scanner(userDataHouse);
            while (input.hasNextLine()){
                String[] UserData = input.nextLine().split("\\s");
                User user = new User(UserData[0], UserData[1], UserData[2], UserData[3]);
                addString(user);
            }
        } 
        catch (FileNotFoundException e) {e.printStackTrace();}
    }

    int HashFunction(String Password){
        return 0;
    }



    public void AddUser(User user){
        String userdata = user.UserName + " " + user.Email + " " + user.Password + " " + user.userType;
        String path = routePath + "/" + filename;

        try {
            Files.write(Paths.get(path), userdata.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {}
        addString(user);

    }


    public User getUser(String Email){
        return searchString(Email);
    }



    public boolean isUserExist(String Email, String Password){
        User user = searchString(Email);
        if (user == null)return false;
        return (user.Password.compareTo(Password) == 0);
    }



    void DeleteUser(User user){

    }
}
