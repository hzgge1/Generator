package Screens;

import Enums.Colors;
import Enums.Humidity;
import Enums.Temperature;
import Enums.Type;
import Generators.Generators;
import User.Clothes;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Generator {

    @FXML
    private ImageView complementoCima;
    @FXML
    private ImageView parteCima;
    @FXML
    private ImageView parteBaixo;
    @FXML
    private ImageView calcado;
    @FXML
    private ImageView acessorio;
    @FXML
    private Label titel;
    @FXML
    private Label labelTemperture;
    @FXML
    private Label labelHumidity;
    @FXML
    private Label labelIsRain;
    @FXML
    private Label labelColor;

    private Temperature temperature;
    private Humidity humidity;
    private boolean isRain;
    private Colors color;

    private Image imageComplementoCima = null;
    private Image imageParteCima = null;
    private Image imageParteBaixo = null;
    private Image imageCalcado = null;
    private Image imageAcessorio = null;

    @FXML
    public void initialize() throws FileNotFoundException {
        generate();
    }

    private Stage getStage(){
        return (Stage) titel.getScene().getWindow();
    }

    public void backOnClicked(MouseEvent mouseEvent) throws IOException {
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

    public void getNew() throws FileNotFoundException {
        generate();
    }

    private void generate() throws FileNotFoundException {
        geraTHRC();

        List<Clothes> closet = Login.getUser().getCloset();

        List<Clothes> selected = new ArrayList<>();
        for(Clothes c : closet){
            if(c.canBeSelected(temperature, humidity, isRain, color))
                selected.add(c);
        }

        imageComplementoCima = geraRoupas(selected,Type.COMPLEMENTO_CIMA);
        imageParteCima = geraRoupas(selected,Type.PARTE_CIMA);
        imageParteBaixo = geraRoupas(selected,Type.PARTE_BAIXO);
        imageCalcado = geraRoupas(selected,Type.CALCADO);
        imageAcessorio = geraRoupas(selected,Type.ACESSORIO);

        showImages();
    }

    private Image geraRoupas(List<Clothes> selected, Type type) {
        List<Clothes> list = new ArrayList<>();
        selected.forEach( c -> {if(c.isEventOf(UserScreen.event) && c.isTypeOf(type)) list.add(c);} );
        if(list.isEmpty()) return new Image("Images\\null.png");
        String URL = list.get(Generators.clothesGenerator(Math.random(),list.size())).getURL();
        try{
            return new Image(URL);
        }catch(IllegalArgumentException e){
            System.out.println("Problema em carregar imagem");
            return new Image("Images\\null.png");
        }
    }

    private void geraTHRC() {
        double t = Generators.temperatureGenerator(Math.random(), Math.random());
        this.temperature = Temperature.getTemperature(t);
        labelTemperture.setText("Temperatura: "+temperature.toString());

        double h = Generators.humidityGenerator(Math.random(), Math.random());
        this.humidity = Humidity.getHumidity(h);
        labelHumidity.setText("Humidade: "+humidity.toString());

        int rain = Generators.rainGenerator(Math.random());
        if(rain == 1)
            labelIsRain.setText("Chuva: Sim");
        else
            labelIsRain.setText("Chuva: Não");
            //isRain = true; else isRain = false;
        //labelIsRain.setText("Is for rain: "+isRain);

        int c = Generators.colorsGenerator(Math.random());
        this.color = Colors.getColors(c);
        labelColor.setText("Cores: "+color.toString());
    }

    private void showImages(){
        complementoCima.setImage(imageComplementoCima);
        parteCima.setImage(imageParteCima);
        parteBaixo.setImage(imageParteBaixo);
        calcado.setImage(imageCalcado);
        acessorio.setImage(imageAcessorio);
    }
}
