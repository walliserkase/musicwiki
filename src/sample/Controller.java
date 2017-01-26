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
    private TextField noteLabel = new TextField();
    @FXML
    private ListView<Groupe> artistListView = new ListView<Groupe>();
    @FXML
    private ListView<Album> albumListView  = new ListView<Album>();
    @FXML
    private ListView<Piste> trackListView  = new ListView<Piste>();
    @FXML
    private Button saveNoteButton = new Button();

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
        final Groupe selectedGroupe = artistListView.getSelectionModel().getSelectedItem();
        trackList.clear();
        albumList.clear();
        List<Album> queryResults = DAO.getAlbumsForGroupe(selectedGroupe.getNom());
        albumList.addAll(queryResults);

        // Update label and grade
        infoLabel.setText(selectedGroupe.getInfo());
        noteLabel.setVisible(false);
        saveNoteButton.setVisible(false);

    }

    public void onAlbumListClicked(MouseEvent mouseEvent) {

        // Update lists
        trackList.clear();
        final Album selectedAlbum = albumListView.getSelectionModel().getSelectedItem();
        List<Piste> queryResults = DAO.getPistesForAlbum(selectedAlbum.getNom());
        trackList.addAll(queryResults);

        // Update label and grade
        infoLabel.setText(selectedAlbum.getInfo());
        noteLabel.setVisible(false);
        saveNoteButton.setVisible(false);
    }

    public void onTrackListClicked(MouseEvent mouseEvent) {

        // Update label and grade
        final Piste selectedPiste = trackListView.getSelectionModel().getSelectedItem();
        infoLabel.setText(selectedPiste.getInfo());
        noteLabel.setVisible(true);
        saveNoteButton.setVisible(true);
        noteLabel.setText(String.valueOf(selectedPiste.getNote()));
    }


    public void onClickSaveNote(MouseEvent mouseEvent) {
        int newNote;
        Piste selectedPiste = trackListView.getSelectionModel().getSelectedItem();

        int previousNote = selectedPiste.getNote();
        try {
           newNote = Integer.parseInt(noteLabel.getText());
        } catch (Exception e){
            System.out.println("La note doit être un chiffre");
            noteLabel.setText(previousNote + "");
            return;
        }

        if(newNote < 0 || newNote > 5) {
            noteLabel.setText(previousNote + "");
            return;
        } else {
            DAO.saveNote(selectedPiste, newNote);
        }

        // on update la liste et le label avec la nouvelle piste
        int[] updatedValues = DAO.getNoteAndNbVotesForPiste(selectedPiste);
        Piste updatedPiste =
                new Piste.Builder(selectedPiste).setNote(updatedValues[0]).setNbVotes(updatedValues[1]).build();
        int currentIndex = trackList.indexOf(selectedPiste);
        trackList.remove(selectedPiste);
        trackList.add(currentIndex, updatedPiste);
        noteLabel.setText("" + updatedPiste.getNote());
        infoLabel.setText(updatedPiste.getInfo());

        // update album
        Album selectedAlbum = albumListView.getSelectionModel().getSelectedItem();
        int[] updatedValuesAlbum = DAO.getNoteAndNbVotesForAlbum(selectedAlbum);
        Album updatedAlbum =
                new Album.Builder(selectedAlbum).
                        setNote(updatedValuesAlbum[0]).setNbVotes(updatedValuesAlbum[1]).build();
        int currentIndexAlbum = albumList.indexOf(selectedAlbum);
        albumList.remove(selectedAlbum);
        albumList.add(currentIndexAlbum, updatedAlbum);


    }


}
