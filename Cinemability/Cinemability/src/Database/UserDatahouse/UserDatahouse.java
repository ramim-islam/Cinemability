package Database.UserDatahouse;
import Model.User.User;
import java.util.Vector;
import Database.DataStructure.Trie.Trie;
import Database.FileIO.Fileio;



public class UserDatahouse extends Trie{
    Fileio file;
    public UserDatahouse(){
        this.file = new Fileio("UserDatahouse/", "UserDatahouse.txt");
        file.CreateFile();
        Vector<String[]> userData = file.ReadFile();
        for (String[] data : userData){
            User user = new User(data[1], data[2], data[3], data[4], data[0]);
            add(user.Email, user);
        }
    }

    public void AddUser(User user){
        String[] userdata = {
                                user.PrimaryKey, 
                                user.UserName, 
                                user.Email, 
                                user.Password, 
                                user.userType
                            };
        file.AppendData(userdata);
        add(user.Email, user);

    }


    public User getUser(String Email){
        return (User) search(Email);
    }

    public boolean isUserExist(String Email, String Password){
        User user = (User)search(Email);
        if (user == null)return false;
        return (user.Password.compareTo(Password) == 0);
    }



    void DeleteUser(User user){

    }
}
