package Controllers;

import Model.Member;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

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


        ObservableList<Member> members = FXCollections.observableArrayList();

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

    }


    @FXML
    void btnEditOnAction(ActionEvent event) {

    }


    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }
}