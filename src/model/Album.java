package model;

/**
 * Created by alex on 15.01.17.
 */
public class Album {
    private final String noISRC;
    private final String nom;
    private final Integer anneeParution;
    private final Integer nbExemplairesVendus;
    private final String styleMusique;
    private final String nomMaisonDisque;
    private final Long note;
    private final Long nbVotes;

    public Album(String noISRC, String nom, Integer anneeParution, Integer nbExemplairesVendus, String styleMusique,
                 Long note, Long nbVotes, String nomMaisonDisque) {
        this.noISRC = noISRC;
        this.nom = nom;
        this.anneeParution = anneeParution;
        this.nbExemplairesVendus = nbExemplairesVendus;
        this.styleMusique = styleMusique;
        this.note = note;
        this.nbVotes = nbVotes;
        this.nomMaisonDisque = nomMaisonDisque;
    }

    public String getNoISRC() {
        return noISRC;
    }

    public String getNom() {
        return nom;
    }

    public Integer getAnneeParution() {
        return anneeParution;
    }

    public Integer getNbExemplairesVendus() {
        return nbExemplairesVendus;
    }

    public String getStyleMusique() {
        return styleMusique;
    }

    public String getNomMaisonDisque(){ return nomMaisonDisque;}

    public Long getNote() {
        return note;
    }

    public Long getNbVotes() {
        return nbVotes;
    }

}
