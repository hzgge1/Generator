import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {


    public static void main(String[] args){
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Virtual Wardrobe");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Screens/Menu.fxml"));

        Parent mainViewRoot = loader.load();

        Scene scene = new Scene(mainViewRoot);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
