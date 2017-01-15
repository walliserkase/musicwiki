package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Data access object, contient les requêtes SQL
 */
public class DAO {

    private static Connection connection;
    {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/musicWiki",
                    "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static List<String> getBandNamesDummy() {
        List<String> artistNames = new ArrayList<>();
        artistNames.add("Sting");
        artistNames.add("Nightwish");
        artistNames.add("Iron Maiden");
        artistNames.add("JJG");
        artistNames.add("Justin Bieber");
        artistNames.add("Henri Dès");
        return artistNames;
    }

    public static void saveAlbum(final Album album) {
        String useDatabaseQuery = "USE musicwiki_bis;";
        String query = "INSERT INTO `Album` (`noISRC`,`nom`,`anneeParution`,`nbExemplaireVendu`,`note`,`nbVote`," +
                "`nomMaisonDisque`, `styleMusique`) VALUES (\"MX ZPD W8 12385\",\"Jean François\",1965,4324,2," +
                "8937269,\"PEERMUSIC FRANCE\", \"Rock\");";

        String query2 = "INSERT INTO `Album` (`noISRC`,`nom`,`nomMaisonDisque`,`anneeParution`,`nbExemplaireVendu`, " +
                "`styleMusique`) " +
                "VALUES (" + "\"" + album.getNoISSN() + "\"" + ',' +"\"" +  album.getNom()+"\"" + ',' +
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
        String useDatabaseQuery = "USE musicwiki_bis;";
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

    public static void loadData() {
        final Long noISRC = 12345L;
        final Integer noPiste = 2;

        ResultSet rs;
        String useDatabaseQuery = "USE musicwiki_bis;";
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
