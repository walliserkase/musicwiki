package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import model.Album;
import model.DAO;
import model.Groupe;
import model.Piste;

import java.util.List;
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

        List<Groupe> queryResults = DAO.getGroupes(20);
        artistNames.addAll(queryResults.stream().map(groupe -> groupe.getNom()).
                collect(Collectors.toList()));
    }



    public void onArtistListClicked(MouseEvent mouseEvent) {

        albumNames.clear();
        trackNames.clear();
        final String selectedGroupe = artistListView.getSelectionModel().getSelectedItem();
        List<Album> queryResults = DAO.getAlbumsForGroupe(selectedGroupe);
        albumNames.addAll(queryResults.stream().map(album -> album.getNom()).
                collect(Collectors.toList()));

    }

    public void onAlbumListClicked(MouseEvent mouseEvent) {

        trackNames.clear();
        final String selectedAlbum = albumListView.getSelectionModel().getSelectedItem();
        List<Piste> queryResults = DAO.getPistesForAlbum(selectedAlbum);
        trackNames.addAll(queryResults.stream().map(album -> album.getNom()).
                collect(Collectors.toList()));
        System.out.println();
    }

    public void onTrackListClicked(MouseEvent mouseEvent) {
    }


}
