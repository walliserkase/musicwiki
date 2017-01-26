package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private ObservableList<String> artistNames = FXCollections.observableArrayList();

    public Main() {
        /*artistNames.add("Sting");
        artistNames.add("Nightwish");
        artistNames.add("Iron Maiden");
        artistNames.add("JJG");
        artistNames.add("Justin Bieber");*/
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("MusicWiki");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public ObservableList<String> getArtistNames() {
        return artistNames;
    }
}
