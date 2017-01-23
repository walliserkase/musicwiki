package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import model.DAO;

import java.util.stream.Collectors;

public class Controller {

    @FXML
    private ListView<String> artistListView = new ListView<String>();
    @FXML
    private ListView<String> albumListView  = new ListView<String>();;
    @FXML
    private ListView<String> trackListView  = new ListView<String>();;

    private ObservableList<String> artistNames = FXCollections.observableArrayList();
    private ObservableList<String> albumNames = FXCollections.observableArrayList();
    private ObservableList<String> trackNames = FXCollections.observableArrayList();

    public void initialize() {
        artistListView.setItems(artistNames);
        albumListView.setItems(albumNames);
        trackListView.setItems(trackNames);

        artistNames.addAll(DAO.getGroupes(20).stream().map(groupe -> groupe.getNom()).
                collect(Collectors.toList()));
    }



    public void onArtistListClicked(MouseEvent mouseEvent) {

        albumNames.clear();
        final String selectedGroupe = artistListView.getSelectionModel().getSelectedItem();
        albumNames.addAll(DAO.getAlbumsForGroupe(selectedGroupe).stream().map(album -> album.getNom()).
                collect(Collectors.toList()));

    }

    public void onAlbumListClicked(MouseEvent mouseEvent) {
        // par exemple: DAO.loadData();
    }

    public void onTrackListClicked(MouseEvent mouseEvent) {
    }


}
