package model;

/**
 * Created by alex on 15.01.17.
 */
public class Album {
    private final Long noISSN;
    private final String nom;
    private final Integer anneeParution;
    private final Integer nbExemplairesVendus;
    private final String styleMusique;
    private final Long note;
    private final Long nbVotes;

    public Album(Long noISSN, String nom, Integer anneeParution, Integer nbExemplairesVendus, String styleMusique,
                 Long note, Long nbVotes) {
        this.noISSN = noISSN;
        this.nom = nom;
        this.anneeParution = anneeParution;
        this.nbExemplairesVendus = nbExemplairesVendus;
        this.styleMusique = styleMusique;
        this.note = note;
        this.nbVotes = nbVotes;
    }

    public Long getNoISSN() {
        return noISSN;
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

    public Long getNote() {
        return note;
    }

    public Long getNbVotes() {
        return nbVotes;
    }

}
