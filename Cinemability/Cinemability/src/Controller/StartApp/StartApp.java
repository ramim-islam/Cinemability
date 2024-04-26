package Controller.StartApp;
import java.util.Scanner;

public class StartApp {
    public void startApp(){
        System.out.println("\n**** WelCome to the Cinemability ****\n");
        System.out.println("# If do have a account Please Login otherwise Register first");
        System.out.println("1. To Login type LOGIN");
        System.out.println("2. To Register type REGISTER");

        try (Scanner input = new Scanner(System.in)) {
            while (true){
                String command = input.nextLine();
                if (command.compareTo("LOGIN") == 0){
                    System.out.println("This is loginpage");
                    break;
                }
                else if (command.compareTo("REGISTER") == 0){
                    System.out.println("This is registerPage");
                    break;
                }
                else{
                    System.out.println("Please Give The Correct Command");
                }
            }
            System.out.println("\n");
        }
    }
}
