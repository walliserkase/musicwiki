package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
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
    private Label infoLabel = new Label();
    @FXML
    private ListView<Groupe> artistListView = new ListView<Groupe>();
    @FXML
    private ListView<Album> albumListView  = new ListView<Album>();
    @FXML
    private ListView<Piste> trackListView  = new ListView<Piste>();;

    private ObservableList<Groupe> artistNames = FXCollections.observableArrayList();
    private ObservableList<Album> albumNames = FXCollections.observableArrayList();
    private ObservableList<Piste> trackNames = FXCollections.observableArrayList();

    public void initialize() {
        artistListView.setItems(artistNames);
        albumListView.setItems(albumNames);
        trackListView.setItems(trackNames);

        List<Groupe> queryResults = DAO.getGroupes(20);
        artistNames.addAll(queryResults);
    }



    public void onArtistListClicked(MouseEvent mouseEvent) {

        // Update lists
        albumNames.clear();
        trackNames.clear();
        final Groupe selectedGroupe = artistListView.getSelectionModel().getSelectedItem();
        List<Album> queryResults = DAO.getAlbumsForGroupe(selectedGroupe.getNom());
        albumNames.addAll(queryResults);

        // Update label
        infoLabel.setText(selectedGroupe.getInfo());

    }

    public void onAlbumListClicked(MouseEvent mouseEvent) {

        // Update lists
        trackNames.clear();
        final Album selectedAlbum = albumListView.getSelectionModel().getSelectedItem();
        List<Piste> queryResults = DAO.getPistesForAlbum(selectedAlbum.getNom());
        trackNames.addAll(queryResults);

        // Update label
        infoLabel.setText(selectedAlbum.getInfo());

    }

    public void onTrackListClicked(MouseEvent mouseEvent) {

        // Update label
        final Piste selectedPiste = trackListView.getSelectionModel().getSelectedItem();
        infoLabel.setText(selectedPiste.getInfo());
    }


}
