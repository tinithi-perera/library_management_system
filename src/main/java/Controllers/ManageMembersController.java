package Controllers;

import Model.Member;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class ManageMembersController {

    @FXML
    private TextField txtSearch;

    @FXML
    private TableView<Member> tblMembers;

    @FXML
    private TableColumn<Member, String> colMemberId;

    @FXML
    private TableColumn<Member, String> colFullName;

    @FXML
    private TableColumn<Member, String> colEmail;

    @FXML
    private TableColumn<Member, String> colPhone;

    @FXML
    private TableColumn<Member, String> colAddress;

    @FXML
    private ObservableList<Member> members =
            FXCollections.observableArrayList();
    @FXML
    private Button btnBack;


    @FXML
    public void initialize() {

        colMemberId.setCellValueFactory(
                new PropertyValueFactory<>("memberId")
        );

        colFullName.setCellValueFactory(
                new PropertyValueFactory<>("fullName")
        );

        colEmail.setCellValueFactory(
                new PropertyValueFactory<>("email")
        );

        colPhone.setCellValueFactory(
                new PropertyValueFactory<>("phone")
        );

        colAddress.setCellValueFactory(
                new PropertyValueFactory<>("address")
        );



        members.add(new Member(
                "M001",
                "Kamal Perera",
                "kamal@gmail.com",
                "0712345678",
                "Colombo"
        ));

        members.add(new Member(
                "M002",
                "Nimal Silva",
                "nimal@gmail.com",
                "0771234567",
                "Kandy"
        ));

        tblMembers.setItems(members);
    }


    @FXML
    void btnSearchOnAction(ActionEvent event) {
        String searchText = txtSearch.getText().toLowerCase();

        ObservableList<Member> searchResults =
                FXCollections.observableArrayList();

        for (Member member : members) {

            if (member.getMemberId().toLowerCase().contains(searchText)
                    || member.getFullName().toLowerCase().contains(searchText)
                    || member.getEmail().toLowerCase().contains(searchText)) {

                searchResults.add(member);
            }
        }

        tblMembers.setItems(searchResults);

    }


    @FXML
    void btnEditOnAction(ActionEvent event) {

            Member selectedMember = tblMembers.getSelectionModel().getSelectedItem();

            if (selectedMember == null) {

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Edit Member");
                alert.setHeaderText(null);
                alert.setContentText("Please select a member to edit.");
                alert.showAndWait();

                return;
            }

            TextInputDialog dialog = new TextInputDialog(selectedMember.getFullName());

            dialog.setTitle("Edit Member");
            dialog.setHeaderText("Edit Member Name");
            dialog.setContentText("Full Name:");

            dialog.showAndWait().ifPresent(newName -> {

                if (!newName.trim().isEmpty()) {

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Edit Member");
                    alert.setHeaderText(null);
                    alert.setContentText("Member details updated successfully.");
                    alert.showAndWait();
                }
            });
        }






    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        Member selectedMember = tblMembers.getSelectionModel().getSelectedItem();

        if (selectedMember == null) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Delete Member");
            alert.setHeaderText(null);
            alert.setContentText("Please select a member to delete.");
            alert.showAndWait();

            return;
        }

        Alert alert = new Alert(
                Alert.AlertType.CONFIRMATION,
                "Are you sure you want to delete this member?",
                ButtonType.YES,
                ButtonType.NO
        );

        alert.setTitle("Delete Member");
        alert.setHeaderText(null);

        alert.showAndWait();

        if (alert.getResult() == ButtonType.YES) {

            members.remove(selectedMember);

            tblMembers.setItems(members);

            Alert success = new Alert(Alert.AlertType.INFORMATION);
            success.setTitle("Delete Member");
            success.setHeaderText(null);
            success.setContentText("Member deleted successfully.");
            success.showAndWait();
        }
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
