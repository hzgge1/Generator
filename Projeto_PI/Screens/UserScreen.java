package Screens;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import Enums.Event;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class UserScreen {

    ObservableList<Event> events = FXCollections.observableList(Event.getListOfEvents());

    @FXML
    private ChoiceBox eventBox;
    public static Event event;
    @FXML
    private Label errorLabel;

    @FXML
    public void initialize(){
        eventBox.setItems(events);
    }

    public void findOptions(MouseEvent mouseEvent) throws IOException {
        File file = new File(Login.getUser().getUername() + ".txt");
        event = (Event) eventBox.getValue();
        if(event == null)
            errorLabel.setText("Nenhum evento selecionado");
        else if(!file.exists())
            errorLabel.setText("User não possui nenhuma peça de roupa");
        else
            changeToFindOptions();
    }

    public void addNewPiece(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddPiece.fxml"));
        Parent mainViewRoot = loader.load();
        Scene scene = new Scene(mainViewRoot);

        Stage s = new Stage();
        s.setTitle("Virtual Wardrobe");
        s.setScene(scene);
        getStage().close();
        s.setResizable(false);
        s.show();
    }

    private void changeToFindOptions() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Generator.fxml"));
        Parent mainViewRoot = loader.load();
        Scene scene = new Scene(mainViewRoot);

        Stage s = new Stage();
        s.setTitle("Virtual Wardrobe");
        s.setScene(scene);
        getStage().close();
        s.setResizable(false);
        s.show();
    }

    public void goBack(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
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
        return (Stage) eventBox.getScene().getWindow();
    }
}
