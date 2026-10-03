package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AddMemberController {

    @FXML
    private Button btnClear;

    @FXML
    private Button btnRegisterMember;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtFullName;

    @FXML
    private TextField txtMemberId;

    @FXML
    private TextField txtPhoneNumber;
    @FXML
    private Button btnBack;

    @FXML
    void btnClearOnAction(ActionEvent event) {
        txtMemberId.clear();
        txtFullName.clear();
        txtEmail.clear();
        txtPhoneNumber.clear();
        txtAddress.clear();
    }

    @FXML
    void btnRegisterOnAction(ActionEvent event) {
        System.out.println("Register Member button clicked");
    }
    @FXML
    public void btnbackOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/View/MainDashboard.fxml")
            );

            Scene scene = new Scene(loader.load());

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            Stage currentStage = (Stage) btnBack.getScene().getWindow();
            currentStage.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    }


