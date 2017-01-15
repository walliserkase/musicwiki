package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import model.DAO;

public class Controller {

    @FXML
    private ListView<String> artistListView = new ListView<String>();

    public void initialize() {
        ObservableList<String> artistNames = FXCollections.observableArrayList();
        artistNames.addAll(DAO.getBandNamesDummy());


        artistListView.setItems(artistNames);
    }



    public void onArtistListClicked(MouseEvent mouseEvent) {
    }

    public void onAlbumListClicked(MouseEvent mouseEvent) {
        // par exemple: DAO.loadData();
    }

    public void onTrackListClicked(MouseEvent mouseEvent) {
    }


}
