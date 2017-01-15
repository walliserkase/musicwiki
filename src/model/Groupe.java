package model;

/**
 * Created by alex on 15.01.17.
 */
public class Groupe {
    private final String nom;
    private final String styleMusique;

    public Groupe(String nom, String styleMusique) {
        this.nom = nom;
        this.styleMusique = styleMusique;
    }

    public String getNom() {
        return nom;
    }

    public String getStyleMusique() {
        return styleMusique;
    }
}
