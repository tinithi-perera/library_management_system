package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainDashboardController {

    @FXML
    private Button btnAddBook;

    @FXML
    private Button btnAddMember;

    @FXML
    private Button btnHistory;

    @FXML
    private Button btnIssue;

    @FXML
    private Button btnLogout;

    @FXML
    private Button btnMembers;

    @FXML
    private Button btnReturn;

    @FXML
    void btnAddBookOnAction(ActionEvent event) {

            try {
                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource("/View/AddBook.fxml")
                );

                Scene scene = new Scene(loader.load());

                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();

            } catch (IOException e) {
                e.printStackTrace();
            }



    }

    @FXML
    void btnAddMemberOnAction(ActionEvent event) {

            try {
                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource("/View/AddMember.fxml")
                );

                Scene scene = new Scene(loader.load());

                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();

            } catch (IOException e) {
                e.printStackTrace();
            }

    }

    @FXML
    void btnHistoryOnAction(ActionEvent event) {

    }

    @FXML
    void btnIssueOnAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/View/IssueBook.fxml")
            );

            Scene scene = new Scene(loader.load());

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void btnLogoutOnAction(ActionEvent event) {

    }

    @FXML
    void btnMembersOnAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/View/ManageMembers.fxml")
            );

            Scene scene = new Scene(loader.load());

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void btnReturnOnAction(ActionEvent event) {

    }

}
