package model;

/**
 * Created by alex on 15.01.17.
 */
public class Album {
    private final String noISRC;
    private final String nom;
    private final int anneeParution;
    private final int nbExemplairesVendus;
    private final String styleMusique;
    private final String nomMaisonDisque;
    private final String commentaire;
    private final int note;
    private final int nbVotes;

    public Album(String noISRC, String nom, int anneeParution, int nbExemplairesVendus, String styleMusique,
                 String commentaire, int note, int nbVotes, String nomMaisonDisque) {
        this.noISRC = noISRC;
        this.nom = nom;
        this.anneeParution = anneeParution;
        this.nbExemplairesVendus = nbExemplairesVendus;
        this.styleMusique = styleMusique;
        this.commentaire = commentaire;
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

    public int getAnneeParution() {
        return anneeParution;
    }

    public int getNbExemplairesVendus() {
        return nbExemplairesVendus;
    }

    public String getStyleMusique() {
        return styleMusique;
    }

    public String getNomMaisonDisque(){ return nomMaisonDisque;}

    public String getCommentaire() {
        return commentaire;
    }

    public int getNote() {
        return note;
    }

    public int getNbVotes() {
        return nbVotes;
    }

    public String getInfo() {
        return nom + " - " + anneeParution + " - " + "Note: " + note  + "\n"
                + (commentaire == null ? "Pas encore de commentaire pour cet album" : commentaire);
    }

    @Override
    public String toString() {
        return nom;
    }

    public static class Builder {
        private String noISRC;
        private String nom;
        private int anneeParution;
        private int nbExemplairesVendus;
        private String styleMusique;
        private String nomMaisonDisque;
        private String commentaire;
        private int note;
        private int nbVotes;

        public Builder() {}

        public Builder(Album album) {
            noISRC = album.getNoISRC();
            nom = album.getNom();
            anneeParution = album.getAnneeParution();
            nbExemplairesVendus = album.getNbExemplairesVendus();
            styleMusique = album.getStyleMusique();
            commentaire = album.getCommentaire();
            note = album.getNote();
            nbVotes = album.getNbVotes();
            nomMaisonDisque = album.getNomMaisonDisque();
        }

        public Album build() {
            return new Album(noISRC, nom, anneeParution, nbExemplairesVendus, styleMusique,
                    commentaire, note, nbVotes, nomMaisonDisque);
        }

        public Builder setNoISRC(String noISRC) {
            this.noISRC = noISRC;
            return this;
        }

        public Builder setNom(String nom) {
            this.nom = nom;
            return this;
        }

        public Builder setAnneeParution(int anneeParution) {
            this.anneeParution = anneeParution;
            return this;
        }

        public Builder setNbExemplairesVendus(int nbExemplairesVendus) {
            this.nbExemplairesVendus = nbExemplairesVendus;
            return this;
        }

        public Builder setStyleMusique(String styleMusique) {
            this.styleMusique = styleMusique;
            return this;
        }

        public Builder setNomMaisonDisque(String nomMaisonDisque) {
            this.nomMaisonDisque = nomMaisonDisque;
            return this;
        }

        public Builder setCommentaire(String commentaire) {
            this.commentaire = commentaire;
            return this;
        }

        public Builder setNote(int note) {
            this.note = note;
            return this;
        }

        public Builder setNbVotes(int nbVotes) {
            this.nbVotes = nbVotes;
            return this;
        }
    }
}
