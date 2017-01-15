package model;

/**
 * Created by alex on 15.01.17.
 */
public class Piste {

    private final String nom;
    private final Integer numero;
    private final Long duree;
    private final String styleMusique;
    private final Integer note;
    private final Long nbVotes;

    public Piste(String nom, Integer numero, Long duree, String styleMusique, Integer note, Long nbVotes) {
        this.nom = nom;
        this.numero = numero;
        this.duree = duree;
        this.styleMusique = styleMusique;
        this.note = note;
        this.nbVotes = nbVotes;
    }

    public String getNom() {

        return nom;
    }

    public Integer getNumero() {
        return numero;
    }

    public Long getDuree() {
        return duree;
    }

    public String getStyleMusique() {
        return styleMusique;
    }

    public Integer getNote() {
        return note;
    }

    public Long getNbVotes() {
        return nbVotes;
    }
}
