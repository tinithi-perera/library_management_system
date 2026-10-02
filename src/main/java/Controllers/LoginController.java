package Controllers;

public class LoginController {

    public boolean checkUsernameandPassword(String userName, String password) {
        if(userName.equals("Tinithi")&&password.equals("1234")){
            return true;
        }
        return  false;
    }
}
