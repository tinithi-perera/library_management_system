package Controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Label;

import java.io.IOException;

public class LoginPageController {
    LoginController loginController = new LoginController();

    @FXML
    private Button btnLogin;

    @FXML
    private Label lblError;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUsername;



    public void btnLoginOnAction(ActionEvent actionEvent) {
        if (loginController.checkUsernameandPassword(txtUsername.getText(), txtPassword.getText())) {
            Stage stage = new Stage();
            try {
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/MainDashboard.fxml"))));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage.show();
            Stage currentStage = (Stage) txtUsername.getScene().getWindow();
            currentStage.close();
        }else{
            lblError.setText("Invalid username or password.");
        }
    }


}





