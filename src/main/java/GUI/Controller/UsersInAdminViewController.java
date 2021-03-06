package gui.Controller;

import gui.Model.UserModel;
import be.User;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;


import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;



public class UsersInAdminViewController implements Initializable {
    @FXML private TableView<User> userTableView;
    @FXML private TextField searchField;
    @FXML private TableColumn<User, String> userColumn;
    @FXML private JFXButton edit;
    @FXML private AnchorPane editTable;
    @FXML private AnchorPane addNewUser;
    @FXML private JFXButton add;
    @FXML private TextField editNameField;
    @FXML private TextField newNameField;
    @FXML private TextField newPasswordField;
    @FXML private Button editCancel;
    @FXML private Button newCancel;
    @FXML private JFXCheckBox createAdmin;
    @FXML private JFXCheckBox editAdmin;
    @FXML private JFXComboBox<String> allTableView;
   private FilteredList<User> filteredData;

    private UserModel userModel;

    private ObservableList<String> usersAndAdmins = FXCollections.observableArrayList("All","Users", "Admins");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.userModel = new UserModel();
        editTable.setVisible(false);
        addNewUser.setVisible(false);
        initUserTableView();
        search();
        initComboBox();

    }

    private void initUserTableView(){
        userColumn.setCellValueFactory(new PropertyValueFactory<User, String>("userName"));

        userModel.loadUsers();
        userTableView.setItems(userModel.getAllUser());
    }


    private void initComboBox() {
        allTableView.getItems().addAll(usersAndAdmins);

    }


    public void btnAddUser(ActionEvent actionEvent) {
        TranslateTransition show= new TranslateTransition();
        show.setDuration(Duration.seconds(0.4));
        show.setNode(addNewUser);
        show.setToX(0);
        show.setToY(-100);
        show.play();

        addNewUser.setTranslateX(0);
        addNewUser.setVisible(true);
        editTable.setVisible(false);
        add.setDisable(true);
        edit.setDisable(false);

        edit.setOnMouseClicked(event ->{
            show.setNode(addNewUser);
            show.setToX(0);
            show.setToY(100);
            show.play();

            addNewUser.setTranslateX(0);
        });
    }

    public void btnEditUser(ActionEvent actionEvent) {
        TranslateTransition show= new TranslateTransition();
        show.setDuration(Duration.seconds(0.4));
        show.setNode(editTable);
        show.setToX(0);
        show.setToY(100);
        show.play();

        editTable.setTranslateX(0);
       editTable.setVisible(true);
       addNewUser.setVisible(false);
       edit.setDisable(true);
        add.setDisable(false);

       add.setOnMouseClicked(event ->{
           show.setNode(editTable);
           show.setToX(0);
           show.setToY(-100);
           show.play();

           addNewUser.setTranslateX(0);
       });
    }

    public void btnCancelEdit(ActionEvent actionEvent) {
        TranslateTransition show= new TranslateTransition();
        editCancel.setOnMouseClicked(event ->{
            show.setNode(editTable);
            show.setToX(0);
            show.setToY(0);
            show.play();

            editTable.setTranslateX(0);
        });


        editTable.setTranslateX(0);
        editTable.setVisible(false);
        edit.setDisable(false);


    }

    public void btnCancelAdd(ActionEvent actionEvent) {
        TranslateTransition show= new TranslateTransition();
        newCancel.setOnMouseClicked(event ->{
            show.setNode(addNewUser);
            show.setToX(0);
            show.setToY(0);
            show.play();

            addNewUser.setTranslateX(0);
        });

        addNewUser.setTranslateX(0);
        addNewUser.setVisible(false);
        add.setDisable(false);
    }
    
    public void setCreateAdmin(boolean isAdmin) {
        User newUser = userTableView.getSelectionModel().getSelectedItem();
        newUser.setUserName(editNameField.getText());
        newUser.setAdmin(isAdmin);

        userModel.updateUser(userTableView.getSelectionModel().getSelectedItem(),newUser);
        userModel.loadUsers();
    }

    public void btnUpdate(ActionEvent actionEvent) {
       boolean isAdmin = true;
       if (editAdmin.isSelected() == false)
           isAdmin = false;
       setCreateAdmin(isAdmin);
    }

    public void setCreateAdminOrUser(boolean isAdmin,boolean isReset) {
        User newUser = new User(-1,
                newNameField.getText(),
                newPasswordField.getText(),
                isAdmin,
                isReset);
        userModel.saveUser(newUser);
    }


    public void btnCreate(ActionEvent actionEvent) {
       boolean isAdmin = false;
       boolean isReset = false;
       if (createAdmin.isSelected())
           isAdmin = true;
       setCreateAdminOrUser(isAdmin,isReset);

    }

    public void btnDeleteUser(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Are you sure about deleting this user?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.YES){
            // ... user chose OK
            User selectedUser = userTableView.getSelectionModel().getSelectedItem();
            userModel.delete(selectedUser);
        } else {
           alert.close();
        }
        userModel.loadUsers();

    }

    public void readUser(MouseEvent event) {
        editNameField.setText(userTableView.getSelectionModel().getSelectedItem().getUserName());
        editAdmin.setSelected(userTableView.getSelectionModel().getSelectedItem().isAdmin());

    }

    public void search(){
        filteredData = new FilteredList<>(FXCollections.observableList(userModel.getAllUser()));
        userTableView.setItems(filteredData);
        searchField.textProperty().addListener((observableValue, oldValue, newValue) ->
                filteredData.setPredicate(userModel.createSearch(newValue))
        );
    }

    public void comboBoxSelect(ActionEvent actionEvent) {
        JFXComboBox comboBox = (JFXComboBox) actionEvent.getSource();
        String selectedItem = (String) comboBox.getSelectionModel().getSelectedItem();
        ObservableList<User> selectedType = FXCollections.observableArrayList(userModel.returnSelectedUsers(selectedItem));

        setPredicateAgain(selectedType);
    }

    private void setPredicateAgain(ObservableList<User> selectedType) {
        searchField.clear();
        filteredData = new FilteredList<>(FXCollections.observableList(selectedType));
        userTableView.setItems(filteredData);
        searchField.textProperty().addListener((observableValue, oldValue, newValue) ->
                filteredData.setPredicate(userModel.createSearch(newValue))
        );
    }

    public void btnResetPassword(ActionEvent actionEvent) {
        User reset = userTableView.getSelectionModel().getSelectedItem();
        reset.setReset(true);
        reset.setPassword(null);
        userModel.resetPassword(userTableView.getSelectionModel().getSelectedItem(),reset);
        userModel.loadUsers();
    }
}
