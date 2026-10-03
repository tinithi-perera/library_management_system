package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;


public class ReturnBookController {

    @FXML
    private Button btnClear;

    @FXML
    private Button btnReturn;

    @FXML
    private DatePicker dateBorrowed;

    @FXML
    private DatePicker dateDue;

    @FXML
    private DatePicker dateReturn;

    @FXML
    private Label lblStatus;

    @FXML
    private ComboBox<String> cmbBook;

    @FXML
    private TextField txtMember;
    @FXML
    public void initialize() {

        cmbBook.getItems().addAll(
                "B001 - Harry Potter",
                "B002 - The Alchemist",
                "B003 - Clean Code"
        );

    }


    @FXML
    void btnClearOnAction(ActionEvent event) {
        cmbBook.getSelectionModel().clearSelection();
        txtMember.clear();
        dateBorrowed.setValue(null);
        dateDue.setValue(null);
        dateReturn.setValue(null);
        lblStatus.setText("");


    }

    @FXML
    void btnReturnOnAction(ActionEvent event) {
        if (cmbBook.getValue() == null) {
            showAlert("Please select a book.");
            return;
        }

        if (txtMember.getText().isEmpty()) {
            showAlert("Please enter the member.");
            return;
        }

        if (dateBorrowed.getValue() == null) {
            showAlert("Please select the borrowed date.");
            return;
        }

        if (dateDue.getValue() == null) {
            showAlert("Please select the due date.");
            return;
        }

        if (dateReturn.getValue() == null) {
            showAlert("Please select the return date.");
            return;
        }

        if (dateReturn.getValue().isBefore(dateBorrowed.getValue())) {
            showAlert("Return date cannot be before the borrowed date.");
            return;
        }

        // Check overdue status
        if (dateReturn.getValue().isAfter(dateDue.getValue())) {
            lblStatus.setText("Overdue");
        } else {
            lblStatus.setText("Returned");
        }

        showAlert("Book returned successfully!");


    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Return Book");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}
