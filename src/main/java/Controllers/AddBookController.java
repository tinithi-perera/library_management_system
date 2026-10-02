package Controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;

public class AddBookController {

    @FXML
    private Button btnAddBook;

    @FXML
    private Button btnClear;

    @FXML
    private ComboBox<String> cmbCategory;

    @FXML
    private TextField txtAuthor;

    @FXML
    private TextField txtBookId;

    @FXML
    private TextField txtBookTitle;

    @FXML
    private TextField txtPublishedYear;

    @FXML
    private TextField txtQuantity;
    @FXML
    public void initialize() {

        cmbCategory.getItems().addAll(
                "Fiction",
                "Non-Fiction",
                "Science",
                "Technology",
                "History",
                "Children",
                "Other"
        );
    }

    @FXML
    void btnAddBookOnAction(ActionEvent event) {

            if (txtBookId.getText().isEmpty()) {
                showAlert("Please enter Book ID / ISBN.");
                return;
            }

            if (txtBookTitle.getText().isEmpty()) {
                showAlert("Please enter Book Title.");
                return;
            }

            if (txtAuthor.getText().isEmpty()) {
                showAlert("Please enter Author.");
                return;
            }

            if (cmbCategory.getValue() == null) {
                showAlert("Please select a Category.");
                return;
            }

            if (txtPublishedYear.getText().isEmpty()) {
                showAlert("Please enter Published Year.");
                return;
            }

            if (txtQuantity.getText().isEmpty()) {
                showAlert("Please enter Quantity.");
                return;
            }

            try {
                Integer.parseInt(txtPublishedYear.getText());
                Integer.parseInt(txtQuantity.getText());
            } catch (NumberFormatException e) {
                showAlert("Published Year and Quantity must be numbers.");
                return;
            }

            showAlert("Book added successfully!");
        }




    @FXML
    void btnClearOnAction(ActionEvent event) {
        txtBookId.clear();
        txtBookTitle.clear();
        txtAuthor.clear();
        txtPublishedYear.clear();
        txtQuantity.clear();

        cmbCategory.getSelectionModel().clearSelection();
    }
    private void showAlert(String message) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Add Book");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}
