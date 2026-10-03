package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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

}

