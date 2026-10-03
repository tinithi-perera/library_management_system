package Controllers;
import Model.Borrowing;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class BorrowingHistoryController {

        @FXML
        private TextField txtMemberId;

        @FXML
        private TableView<Borrowing> tblHistory;

        @FXML
        private TableColumn<Borrowing, String> colMemberId;

        @FXML
        private TableColumn<Borrowing, String> colBookTitle;

        @FXML
        private TableColumn<Borrowing, String> colIssueDate;

        @FXML
        private TableColumn<Borrowing, String> colDueDate;

        @FXML
        private TableColumn<Borrowing, String> colReturnDate;

        @FXML
        private TableColumn<Borrowing, String> colStatus;

        private ObservableList<Borrowing> history =
                FXCollections.observableArrayList();
         @FXML
        private Button btnBack;


        @FXML
        public void initialize() {

            colMemberId.setCellValueFactory(
                    new PropertyValueFactory<>("memberId"));

            colBookTitle.setCellValueFactory(
                    new PropertyValueFactory<>("bookTitle"));

            colIssueDate.setCellValueFactory(
                    new PropertyValueFactory<>("issueDate"));

            colDueDate.setCellValueFactory(
                    new PropertyValueFactory<>("dueDate"));

            colReturnDate.setCellValueFactory(
                    new PropertyValueFactory<>("returnDate"));

            colStatus.setCellValueFactory(
                    new PropertyValueFactory<>("status"));


            history.add(new Borrowing(
                    "M001",
                    "Harry Potter",
                    "01/10/2026",
                    "08/10/2026",
                    "05/10/2026",
                    "Returned"
            ));

            history.add(new Borrowing(
                    "M002",
                    "The Alchemist",
                    "02/10/2026",
                    "09/10/2026",
                    "",
                    "Borrowed"
            ));

            history.add(new Borrowing(
                    "M001",
                    "Clean Code",
                    "01/09/2026",
                    "08/09/2026",
                    "",
                    "Overdue"
            ));

            tblHistory.setItems(history);
        }


        @FXML
        void btnSearchOnAction(ActionEvent event) {

            String searchText = txtMemberId.getText().toLowerCase();

            ObservableList<Borrowing> searchResults =
                    FXCollections.observableArrayList();

            for (Borrowing borrowing : history) {

                if (borrowing.getMemberId()
                        .toLowerCase()
                        .contains(searchText)) {

                    searchResults.add(borrowing);
                }
            }

            tblHistory.setItems(searchResults);
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

