package Screens;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import Enums.*;
import Enums.Event;
import User.Clothes;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.IOException;

public class AddPiece {

    ObservableList<Temperature> temperatures = FXCollections.observableList(Temperature.getListOfTemperatures());
    ObservableList<Humidity> humidity= FXCollections.observableList(Humidity.getListOfHumidity());
    ObservableList<Type> types = FXCollections.observableList(Type.getListOfTypes());
//  Nome
    @FXML
    private TextField namePiece;
//  Eventos
    @FXML
    private CheckBox casamentoButton;
    @FXML
    private CheckBox formalButton;
    @FXML
    private CheckBox desportoButton;
    @FXML
    private CheckBox funeralButton;
    @FXML
    private CheckBox praiaButton;
    @FXML
    private CheckBox casualButton;

//  Cores
    @FXML
    private CheckBox blueButton;
    @FXML
    private CheckBox greenButton;
    @FXML
    private CheckBox blackButton;
    @FXML
    private CheckBox orangeButton;
    @FXML
    private CheckBox redButton;
    @FXML
    private CheckBox yellowButton;
    @FXML
    private CheckBox whiteButton;
    @FXML
    private CheckBox purpleButton;
    @FXML
    private CheckBox pinkButton;
//  Temperatura
    @FXML
    private CheckBox muitoFrioButton;
    @FXML
    private CheckBox frioButton;
    @FXML
    private CheckBox amenoButton;
    @FXML
    private CheckBox calorButton;
//  Humidade
    @FXML
    private CheckBox menosHumidoButton;
    @FXML
    private CheckBox humidoButton;
    @FXML
    private CheckBox meioHumidoButton;
    @FXML
    private CheckBox muitoHumidoButton;
//  Tipo
    @FXML
    private ChoiceBox typeBox;
//  Chuva
    @FXML
    private CheckBox rainCheckBox;
//  URL do imagem
    @FXML
    private Button findFileButton;
    @FXML
    private TextField nameURL;
//  Erro label
    @FXML
    private Label errorLabel;

    private List<CheckBox> checkBoxes= new ArrayList<>();

    public AddPiece() {
    }

    @FXML
    public void initialize(){
//      a guardar o comboBox do tipo da roupa
        typeBox.setItems(types);
//      a guardar os botoes da eventos
        checkBoxes.add(casamentoButton);
        checkBoxes.add(formalButton);
        checkBoxes.add(desportoButton);
        checkBoxes.add(funeralButton);
        checkBoxes.add(praiaButton);
        checkBoxes.add(casualButton);
//      a guardar os botoes da cores
        checkBoxes.add(blueButton);
        checkBoxes.add(greenButton);
        checkBoxes.add(blackButton);
        checkBoxes.add(orangeButton);
        checkBoxes.add(redButton);
        checkBoxes.add(yellowButton);
        checkBoxes.add(whiteButton);
        checkBoxes.add(purpleButton);
        checkBoxes.add(pinkButton);
//      a guardar os botoes da temperatura
        checkBoxes.add(muitoFrioButton);
        checkBoxes.add(frioButton);
        checkBoxes.add(amenoButton);
        checkBoxes.add(calorButton);
//      a guardar os botoes da humidades
        checkBoxes.add(menosHumidoButton);
        checkBoxes.add(humidoButton);
        checkBoxes.add(meioHumidoButton);
        checkBoxes.add(muitoHumidoButton);
//      a guardar o botao da chuva
        checkBoxes.add(rainCheckBox);

    }

    private Stage getStage(){
        return (Stage) typeBox.getScene().getWindow();
    }

    public void BackOnMouseClicked(MouseEvent mouseEvent) throws IOException {
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
//  Obter uma lista que indica os botoes das cores foram selecionados
    private List<Colors> getColorsList(){
        List<Colors> colors=new ArrayList<>();
        if(blueButton.isSelected() || orangeButton.isSelected())
            colors.add(Colors.GAMA1);
        if(greenButton.isSelected() || pinkButton.isSelected())
            colors.add(Colors.GAMA2);
        if(blackButton.isSelected() || whiteButton.isSelected())
            colors.add(Colors.GAMA6);
        if(redButton.isSelected() || greenButton.isSelected())
            colors.add(Colors.GAMA3);
        if(yellowButton.isSelected() || purpleButton.isSelected())
            colors.add(Colors.GAMA4);
        if(orangeButton.isSelected() || blackButton.isSelected() || whiteButton.isSelected())
            colors.add(Colors.GAMA5);
        return colors;
    }

//  Obter uma lista que indica os botoes das temperaturas foram selecionados
    private List<Temperature> getTemperatureList(){
        List<Temperature> temperatures = new ArrayList<>();
        if(muitoFrioButton.isSelected())
            temperatures.add(Temperature.MUITO_FRIO);
        if(frioButton.isSelected())
            temperatures.add(Temperature.FRIO);
        if(amenoButton.isSelected())
            temperatures.add(Temperature.AMENO);
        if(calorButton.isSelected())
            temperatures.add(Temperature.CALOR);
        return temperatures;
    }

//    Obter uma lista que indica os botoes dos humidades foram selecionados
    private List<Humidity> getHumidityList(){
        List<Humidity> humidities = new ArrayList<>();
        if(meioHumidoButton.isSelected())
            humidities.add(Humidity.MENOS_HUMIDO);
        if(humidoButton.isSelected())
            humidities.add(Humidity.HUMIDO);
        if(meioHumidoButton.isSelected())
            humidities.add(Humidity.MEIO_HUMIDO);
        if(muitoHumidoButton.isSelected())
            humidities.add(Humidity.MUITO_HUMIDO);
        return humidities;
    }
//    Obter uma lista que indica os botoes das eventos foram selecionados
    private List<Event> getEventList(){
        List<Event> events = new ArrayList<>();
        if(casamentoButton.isSelected())
            events.add(Event.CASAMENTO);
        if(formalButton.isSelected())
            events.add(Event.FORMAL);
        if(desportoButton.isSelected())
            events.add(Event.DESPORTO);
        if(funeralButton.isSelected())
            events.add(Event.FUNERAL);
        if(praiaButton.isSelected())
            events.add(Event.PRAIA);
        if(casualButton.isSelected())
            events.add(Event.CASUAL);
        return events;
    }

    public void findFile(){
        FileChooser fileChooser = new FileChooser();
        findFileButton.setOnAction(e ->{
            File file = fileChooser.showOpenDialog(typeBox.getScene().getWindow());
            nameURL.setText(file.getPath());
        });
    }

    public void AddOnMouseClicked(MouseEvent mouseEvent) throws IOException {

        if(namePiece.getText().isEmpty() || getColorsList().isEmpty() ||
                nameURL.getText().isEmpty() || getTemperatureList().isEmpty() ||
                getHumidityList().isEmpty() || getEventList().isEmpty() ||typeBox.getValue()==null){
            errorLabel.setText("Nada selecionado");
            return;
        }
        System.out.println("-----Creat new Clothes-----" +
                "Name Piece: "+namePiece.getText()+"\n" +
                "Eventos:"+getEventList()+"\n"+
                "Temperature: "+getTemperatureList()+"\n" +
                "Colors: "+getColorsList()+"\n" +
                "Humidity: "+getHumidityList()+"\n" +
                "Is for rain: "+rainCheckBox.isSelected()+"\n" +
                "Type: "+typeBox.getValue()+"\n" +
                "Event: "+getEventList()+"\n"+
                "URL: "+nameURL.getText());

        Login.getUser().registerClothes(new Clothes(namePiece.getText(),getTemperatureList(),getColorsList(),getHumidityList(),
                rainCheckBox.isSelected(),(Type) typeBox.getValue(),getEventList(),nameURL.getText()));

        errorLabel.setText("Foi criado com sucesso");
        /*namePiece.setText("");
        checkBoxes.forEach(c -> c.setSelected(false));
        typeBox.setValue(null);
        nameURL.setText("");*/



        //errorLabel.setText(Login.getUser().getUername());
    }



}
