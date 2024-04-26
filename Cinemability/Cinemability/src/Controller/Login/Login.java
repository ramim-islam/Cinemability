package Controller.Login;

public class Login {
    String Email;
    String Password;
    boolean LoginStatus = false;

    boolean Validate(String Email, String Password){
        return false;
    }

    Login(String Email, String Password){
        if (Validate(Email, Password)){
            this.Email = Email;
            this.Password = Password;
            this.LoginStatus = true;
        }
    }

   
}
