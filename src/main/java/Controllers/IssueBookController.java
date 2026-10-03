package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

import java.io.IOException;

public class IssueBookController {

    @FXML
    private Button btnClear;

    @FXML
    private Button btnIssueBook;

    @FXML
    private ComboBox<String> cmbBook;

    @FXML
    private ComboBox<String> cmbMember;

    @FXML
    private DatePicker dateDue;

    @FXML
    private DatePicker dateIssue;
    @FXML
    private Button btnBack;

    @FXML
    public void initialize() {

        cmbMember.getItems().addAll(
                "M001 - Kamal Perera",
                "M002 - Nimal Silva"
        );

        cmbBook.getItems().addAll(
                "B001 - Harry Potter",
                "B002 - The Alchemist",
                "B003 - Clean Code"
        );
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        cmbMember.getSelectionModel().clearSelection();
        cmbBook.getSelectionModel().clearSelection();
        dateIssue.setValue(null);
        dateDue.setValue(null);

    }

    @FXML
    void btnIssueBookOnAction(ActionEvent event) {

        if (cmbMember.getValue() == null) {
            showAlert("Please select a member.");
            return;
        }

        if (cmbBook.getValue() == null) {
            showAlert("Please select a book.");
            return;
        }

        if (dateIssue.getValue() == null) {
            showAlert("Please select the issue date.");
            return;
        }

        if (dateDue.getValue() == null) {
            showAlert("Please select the due date.");
            return;
        }

        if (dateDue.getValue().isBefore(dateIssue.getValue())) {
            showAlert("Due date cannot be before the issue date.");
            return;
        }

        showAlert("Book issued successfully!");
    }

    private void showAlert( String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Issue Book");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

   @FXML
    public void btnBackOnAction(ActionEvent actionEvent) {
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
}



