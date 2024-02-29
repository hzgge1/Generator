package Screens;

import User.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class Login {

    private static User user;

    public static User getUser(){
        return user;
    }

    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordTextField;
    @FXML
    private Label errorLabel;


    public void login(MouseEvent mouseEvent) throws IOException {
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();

        if(username.isEmpty() || password.isEmpty())
            errorLabel.setText("Username/Password não preenchidos");
        else if(!User.isUser(username, password))
            errorLabel.setText("Username/Password inválidos");
        else{
            user = new User(username, password);
            changeScreen();
        }
        clearTextFields();
    }

    private void changeScreen() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("UserScreen.fxml"));
        Parent mainViewRoot = loader.load();
        Scene scene = new Scene(mainViewRoot);

        Stage s = new Stage();
        s.setTitle("Virtual Wardrobe");
        s.setScene(scene);
        getStage().close();
        s.setResizable(false);
        s.show();
    }

    private void clearTextFields(){
        usernameTextField.setText("");
        passwordTextField.setText("");
    }

    public void goBack(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
        Parent mainViewRoot = loader.load();
        Scene scene = new Scene(mainViewRoot);

        Stage s = new Stage();
        s.setTitle("Virtual Wardrobe");
        s.setScene(scene);
        getStage().close();
        s.setResizable(false);
        s.show();
    }

    private Stage getStage(){
        return (Stage) usernameTextField.getScene().getWindow();
    }
}
