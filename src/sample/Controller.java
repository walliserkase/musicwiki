package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import model.Album;
import model.DAO;
import model.Groupe;
import model.Piste;

import java.util.List;

public class Controller {

    @FXML
    private Label infoLabel = new Label();
    @FXML
    private ListView<Groupe> artistListView = new ListView<Groupe>();
    @FXML
    private ListView<Album> albumListView  = new ListView<Album>();
    @FXML
    private ListView<Piste> trackListView  = new ListView<Piste>();

    private ContextMenu modifyMenu = new ContextMenu();

    private ObservableList<Groupe> artistList = FXCollections.observableArrayList();
    private ObservableList<Album> albumList = FXCollections.observableArrayList();
    private ObservableList<Piste> trackList = FXCollections.observableArrayList();

    public void initialize() {
        // Create right-click menu
        createModifyMenu();

        //
        artistListView.setItems(artistList);
        albumListView.setItems(albumList);
        trackListView.setItems(trackList);

        // Pre-load band list
        List<Groupe> queryResults = DAO.getGroupes(20);
        artistList.addAll(queryResults);
    }

    private void createModifyMenu() {
        MenuItem ajouterMenuItem = new MenuItem("Ajouter");
        MenuItem modifierMenuItem = new MenuItem("Modifier");
        MenuItem supprimerMenuItem = new MenuItem("Supprimer");
        modifyMenu.getItems().addAll(ajouterMenuItem, modifierMenuItem, supprimerMenuItem);

        ajouterMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Cut...");
            }
        });

        modifierMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Cut...");
            }
        });

        supprimerMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Piste clickedPiste = trackListView.getSelectionModel().getSelectedItem();
                DAO.deletePiste(clickedPiste);
                trackList.remove(clickedPiste);
            }
        });

        artistListView.setContextMenu(modifyMenu);
        albumListView.setContextMenu(modifyMenu);
        trackListView.setContextMenu(modifyMenu);
    }

    public void onArtistListClicked(MouseEvent mouseEvent) {

        // Update lists
        albumList.clear();
        trackList.clear();
        final Groupe selectedGroupe = artistListView.getSelectionModel().getSelectedItem();
        List<Album> queryResults = DAO.getAlbumsForGroupe(selectedGroupe.getNom());
        albumList.addAll(queryResults);

        // Update label
        infoLabel.setText(selectedGroupe.getInfo());

    }

    public void onAlbumListClicked(MouseEvent mouseEvent) {

        // Update lists
        trackList.clear();
        final Album selectedAlbum = albumListView.getSelectionModel().getSelectedItem();
        List<Piste> queryResults = DAO.getPistesForAlbum(selectedAlbum.getNom());
        trackList.addAll(queryResults);

        // Update label
        infoLabel.setText(selectedAlbum.getInfo());

    }

    public void onTrackListClicked(MouseEvent mouseEvent) {

        // Update label
        final Piste selectedPiste = trackListView.getSelectionModel().getSelectedItem();
        infoLabel.setText(selectedPiste.getInfo());
    }


}
