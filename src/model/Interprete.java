package model;

import java.util.Date;

/**
 * Created by alex on 22.01.17.
 */
public class Interprete {

    private final String nomArtiste;
    private final String nom;
    private final String prenom;
    private final Date dateNaissance;

    public Interprete(String nomArtiste, String nom, String prenom, Date dateNaissance) {
        this.nomArtiste = nomArtiste;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
    }

    public String getNomArtiste() {
        return nomArtiste;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }
}
