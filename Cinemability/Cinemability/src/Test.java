import Controller.Login.Login;
import Database.PrimaryKey.PrimaryKey;
import Database.UsersDatahouse.UserDatahouse;
import Model.User.User;

public class Test {

    // UserDatahouse userDatahouse = new UserDatahouse();
    // void UserDataHouseTesting(){
    //     User user = new User("ramim", "ramimgc8@gmail.com", "ramim", "Admin");
    //     userDatahouse.AddUser(user);
    // }

    // void TrieTesting(){
    //     User user = userDatahouse.searchString("ramimgc8@gmail.com");
    //     if (user == null){
    //         System.out.println("Problem with Trie");
    //     }else{
    //         System.out.println("NO problem with Trie");
    //         System.out.print(user.UserName + " ");
    //         System.out.print(user.Email + " ");
    //         System.out.print(user.Password + " ");
    //         System.out.println(user.userType);
    //     }
    // }

    // void LoginTesting(){
    //     Login login = new Login();
    //     login.LoginFormView(userDatahouse);
    //     userDatahouse.isUserExist("ramimgc8@gmail.com", "ramim");
    // }

    void PrimaryKeytesting(){
        PrimaryKey pk = new PrimaryKey();
    }

    void Run(){

        // UserDataHouseTesting();
        // TrieTesting();
        // LoginTesting();
        PrimaryKeytesting();
    }
}
