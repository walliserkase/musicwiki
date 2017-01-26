package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Data access object, contient les requêtes SQL
 */
public class DAO {

    private static Connection connection;
    static {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/musicWiki",
                    "root", "");
            System.out.println("connection");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static List<Groupe> getGroupes(final int maxNb) {

        String useDatabaseQuery = "USE musicWiki";
        String query = "SELECT * FROM Groupe LIMIT " + maxNb + ";";
        ResultSet results;
        List<Groupe> groupes = new ArrayList<Groupe>();


        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(useDatabaseQuery);
            results = stmt.executeQuery(query);

            while(results.next()) {
                final String nom = results.getString("nom");
                final String commentaire = results.getString("commentaire");
                groupes.add(new Groupe.Builder().setNom(nom).setCommentaire(commentaire)
                        .setStyleMusique("Awesome music style \\m/").build());
            }
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("impossible de créer un statement");
            System.out.println(query);
        }

        return groupes;
    }

    public static List<Interprete> getInterpretes(final int maxNb) {

        String useDatabaseQuery = "USE musicWiki";
        String query = "SELECT * FROM Interprete LIMIT " + maxNb + ";";
        ResultSet results;
        List<Interprete> interpretes = new ArrayList<Interprete>();


        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(useDatabaseQuery);
            results = stmt.executeQuery(query);

            while(results.next()) {
                final String nomArtiste = results.getString("nomArtiste");
                final String nom = results.getString("nom");
                final String prenom = results.getString("prenom");
                final Date dateNaissance = results.getDate("dateNaissance");
                interpretes.add(new Interprete(nomArtiste, nom, prenom, dateNaissance));
            }
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("impossible de créer un statement");
            System.out.println(query);
        }

        return interpretes;
    }

    public static List<Album> getAlbumsForGroupe(final String groupeName) {

        String useDatabaseQuery = "USE musicWiki ";
        String query = "SELECT * FROM Album album " +
                "WHERE album.noISRC IN " +
                    "(SELECT DISTINCT aJoue.noISRC FROM Groupe groupe " +
                        "JOIN RelationAJoue aJoue ON aJoue.nomGroupe = groupe.nom " +
                        "JOIN Piste piste ON aJoue.noISRC = piste.noISRC " +
                        "WHERE groupe.nom = '" + groupeName + "');";
        ResultSet results;
        List<Album> albums = new ArrayList<Album>();


        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(useDatabaseQuery);
            results = stmt.executeQuery(query);

            while(results.next()) {
                final String noISRC = results.getString("noISRC");
                final String nomAlbum = results.getString("nom");
                final String commentaire = results.getString("commentaire");
                final int anneeParution = results.getInt("anneeParution");
                final int note = results.getInt("note");
                final String nomMaisonDisque = results.getString("nomMaisonDisque");
                albums.add(new Album.Builder().setNoISRC(noISRC).setNom(nomAlbum).setAnneeParution(anneeParution)
                        .setNote(note).setStyleMusique("awesome music style").setCommentaire(commentaire)
                        .setNomMaisonDisque(nomMaisonDisque).build());
            }
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("impossible de créer un statement");
            System.out.println(query);
        }

        return albums;
    }

    public static List<Piste> getPistesForAlbum(final String albumName) {
        String useDatabaseQuery = "USE musicWiki ";
        String query = "SELECT * FROM Piste piste " +
                        "JOIN Album album on piste.noISRC = album.noISRC " +
                        "WHERE album.nom = '" + albumName + "' " +
                        "ORDER BY piste.numero ASC";
        ResultSet results;
        List<Piste> pistes = new ArrayList<Piste>();


        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(useDatabaseQuery);
            results = stmt.executeQuery(query);

            while(results.next()) {
                final String nom = results.getString("nom");
                final int numero = results.getInt("numero");
                final int note = results.getInt("note");
                final int nbVotes = results.getInt("nbVote");
                final String commentaire = results.getString("commentaire");
                final String noISRC = results.getString("noISRC");
                pistes.add(new Piste.Builder().setNom(nom).setNumero(numero).setNote(note).setNbVotes(nbVotes)
                        .setStyleMusique("awesome music style").setCommentaire(commentaire)
                        .setNoISRC(noISRC).build());
            }
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("impossible de créer un statement");
            System.out.println(query);
        }

        return pistes;
    }

    public static int[] getNoteAndNbVotesForPiste(Piste piste) {
        String useDatabaseQuery = "USE musicWiki ";
        String query = "SELECT note, nbVote FROM Piste " +
                "WHERE numero = " + piste.getNumero() +
                " AND noISRC = '" + piste.getNumeroISRC() + "';";
        ResultSet result;
        int noteAndNbVotes[] = new int[2];
        noteAndNbVotes[0] = -1;
        noteAndNbVotes[1] = -1;

        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(useDatabaseQuery);
            result = stmt.executeQuery(query);
            result.next();
            noteAndNbVotes[0] = result.getInt("note");
            noteAndNbVotes[1] = result.getInt("nbVote");
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("impossible de créer un statement");
            System.out.println(query);
        }

        return noteAndNbVotes;
    }

    public static void saveAlbum(final Album album) {
        String useDatabaseQuery = "USE musicwiki";
        String query = "INSERT INTO `Album` (`noISRC`,`nom`,`anneeParution`,`nbExemplaireVendu`,`note`,`nbVote`," +
                "`nomMaisonDisque`, `styleMusique`) VALUES (\"MX ZPD W8 12385\",\"Jean François\",1965,4324,2," +
                "8937269,\"PEERMUSIC FRANCE\", \"Rock\");";

        String query2 = "INSERT INTO `Album` (`noISRC`,`nom`,`nomMaisonDisque`,`anneeParution`,`nbExemplaireVendu`, " +
                "`styleMusique`) " +
                "VALUES (" + "\"" + album.getNoISRC() + "\"" + ',' +"\"" +  album.getNom()+"\"" + ',' +
                "\"" + album.getNomMaisonDisque() +"\"" +  ','+"\"" +  album.getAnneeParution() +"\"" +
                ','+ "\"" + album.getNbExemplairesVendus() + "\"" + ',' + "\"" + album.getStyleMusique() + "\");";

        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(useDatabaseQuery);

            stmt.executeUpdate(query2);
        }
        catch(Exception e){
            System.out.println("impossible de créer un statement");
            System.out.println(query2);
        }
    }

    public static void savePiste(final Piste piste) {
        String useDatabaseQuery = "USE musicwiki;";
        //String [] insertPiste = {"numero", "nom","style de musiqie", "noISRC de l'album"};


        final String query = "INSERT INTO `Piste` (`numero`,`nom`,`styleMusique`,`noISRC`) " +
                "VALUES (" + "\"" + piste.getNumero() + "\"" + ',' + "\"" + piste.getNom()+"\"" + ','
                + "\"" + piste.getStyleMusique() + "\"" + ','+ "\"" + piste.getNumeroISRC()+ "\");";
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(useDatabaseQuery);
            stmt.executeUpdate(query);
        }
        catch(Exception e){
            System.out.println("impossible de créer un statement");
            System.out.println(query);
        }
    }

    public static void saveNote(Piste piste, int note) {

        String useDatabaseQuery = "USE musicWiki ";
        String query = "INSERT INTO Note(numeroPiste, noISRC, note) VALUES(" +
                piste.getNumero() + ", '" + piste.getNumeroISRC() + "', " + note + ");";

        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(useDatabaseQuery);
            stmt.executeUpdate(query);
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("impossible de créer un statement");
            System.out.println(query);
        }
    }

    public static void deleteGroupe(Groupe groupe) {
        String useDatabaseQuery = "USE musicWiki ";
        String query = "DELETE FROM Groupe " +
                "WHERE nom = " + groupe.getNom() + ";";
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(useDatabaseQuery);
            stmt.executeUpdate(query);
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("impossible de créer un statement");
            System.out.println(query);
        }
    }

    public static void deleteAlbum(Album album) {
        String useDatabaseQuery = "USE musicWiki ";
        String query = "DELETE FROM Album " +
                        "WHERE noISRC = '" + album.getNoISRC() + "';";
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(useDatabaseQuery);
            stmt.executeUpdate(query);
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("impossible de créer un statement");
            System.out.println(query);
        }
    }

    public static void deletePiste(Piste piste) {
        String useDatabaseQuery = "USE musicWiki ";
        String condition = " WHERE noISRC = '" + piste.getNumeroISRC() +
                "' AND numero = " + piste.getNumero() + ";";
        String deleteRelationAJoueQuery = "DELETE FROM RelationAJoue WHERE noISRC = '"
                + piste.getNumeroISRC() + "' AND numeroPiste = " + piste.getNumero() + ";";

        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(useDatabaseQuery);
            stmt.executeUpdate(deleteRelationAJoueQuery);
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("impossible de créer un statement");
            System.out.println(deleteRelationAJoueQuery);
        }
    }

    public static void loadData() {
        final Long noISRC = 12345L;
        final Integer noPiste = 2;

        ResultSet rs;
        String useDatabaseQuery = "USE musicwiki;";
        String affichage = "";
        String stringVide = "";
        try {
            Statement stmt = connection.createStatement();
            System.out.println(noISRC);
            if(!stringVide.equals(noISRC)) {
                rs = stmt.executeQuery("SELECT * FROM album WHERE noISRC = " + "'" + noISRC + "';");
                affichage = ("Nom\t" + "annee de parution\t" + "nb d'exemplaire vendu\t" + "maison de disque\t" + "note\n");
                while (rs.next()) {
                    String nom = rs.getString("nom");
                    String anneeParution = rs.getString("anneeParution");
                    String nbExemplaireVendu = rs.getString("nbExemplaireVendu");
                    String maisonDisque = rs.getString("nomMaisonDisque");
                    String note = rs.getString("note");
                    affichage += nom + "\t" + anneeParution + "\t\t" + nbExemplaireVendu + "\t\t" + maisonDisque + "\t" + note + "\n";
                }
            }
            else if(!stringVide.equals(noPiste)){
                rs = stmt.executeQuery("SELECT * FROM piste WHERE noISRC = " + "\"" + noPiste + "\";");
                affichage = ("Nom\t\t" + "style de musique\t" + "note\n");
                while (rs.next()) {
                    String nom = rs.getString("nom");
                    String styleDeMusique = rs.getString("styleMusique");
                    String note = rs.getString("note");

                    affichage += nom + "\t\t" + styleDeMusique + "\t\t" + note + "\n";
                }
            }
        }
        catch(Exception e){
            System.out.println("impossible de créer un statement");
            System.out.println("SELECT * FROM album WHERE noISRC = " + noISRC + ";");
            System.out.println("SELECT * FROM piste WHERE noISRC = " + noPiste + ";");

        }
    }

}
