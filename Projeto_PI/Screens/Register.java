package Screens;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import User.User;

import java.io.FileNotFoundException;
import java.io.IOException;


public class Register {

    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordTextField;
    @FXML
    private Label errorLabel;


    public void register(MouseEvent mouseEvent) throws IOException {
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();

        if(username.isEmpty() || password.isEmpty())
            errorLabel.setText("Username/Password não preenchidos");
        else if(!User.canBeUser(username) || username.split(" ").length > 1)
            errorLabel.setText("Username inválido");
        else{
            User.registerUser(username, password);
            errorLabel.setText("Registo bem sucedido");
        }
        clearTextFields();
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
