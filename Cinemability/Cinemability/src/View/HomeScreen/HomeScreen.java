package View.HomeScreen;
import java.io.BufferedReader;
import java.io.IOException;

import Model.User.User;

public class HomeScreen {
    public static String display(User user, BufferedReader input) throws IOException{
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
        System.out.println("\n**** Cinemability ****\n");
        System.out.print("*Home     Search_Movies     Favourite_List     " + user.UserName);
        if (user.userType.compareTo("ADMIN") == 0){
            System.out.println("(Admin)");
        }else System.out.println();
        System.out.println();
        System.out.println("1. To move to Homepage type   : HOME");
        System.out.println("2. To Search_Movie type       : SEARCH");
        System.out.println("3. To See Favourite_List type : FAV_LIST");
        System.out.println("4. To Logout type             : LOGOUT");
        System.out.println("...................................................\n");

        System.out.print("Command : ");
        String command = input.readLine();
        
        return command;
    }
}
