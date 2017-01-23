package model;

/**
 * Created by alex on 15.01.17.
 */
public class Groupe {
    private final String nom;
    private final String commentaire;
    private final String styleMusique;

    public Groupe(String nom, String commentaire, String styleMusique) {
        this.nom = nom;
        this.commentaire = commentaire;
        this.styleMusique = styleMusique;
    }

    public String getNom() {
        return nom;
    }

    public String getCommenaire() {
        return commentaire;
    }

    public String getStyleMusique() {
        return styleMusique;
    }

    public String getInfo() {
        return nom + "\n"
                + (commentaire == null ? "Pas encore de commentaire pour ce groupe" : commentaire);
    }

    @Override
    public String toString() {
        return nom;
    }
}
