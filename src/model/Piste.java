package model;

/**
 * Created by alex on 15.01.17.
 */
public class Piste {

    private final String nom;
    private final int numero;
    private final int duree;
    private final String styleMusique;
    private final String commentaire;
    private final int note;
    private final int nbVotes;
    private final String noISRC;

    public Piste(String nom, int numero, int duree, String styleMusique, String commentaire,
                 int note, int nbVotes, String noISRC) {
        this.nom = nom;
        this.numero = numero;
        this.duree = duree;
        this.styleMusique = styleMusique;
        this.commentaire = commentaire;
        this.note = note;
        this.nbVotes = nbVotes;
        this.noISRC = noISRC;
    }

    public String getNom() {

        return nom;
    }

    public int getNumero() {
        return numero;
    }

    public int getDuree() {
        return duree;
    }

    public String getStyleMusique() {
        return styleMusique;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public int getNote() {
        return note;
    }

    public int getNbVotes() {
        return nbVotes;
    }

    public String getNumeroISRC(){ return noISRC;}

    public String getInfo() {
        return nom + " - " + "Note: " + note  + "\n"
                + (commentaire == null ? "Pas encore de commentaire pour cette piste" : commentaire);
    }

    @Override
    public String toString() {
        return nom;
    }

    static public class Builder {

        private String nom;
        private int numero;
        private int duree;
        private String styleMusique;
        private String commentaire;
        private int note;
        private int nbVotes;
        private String noISRC;

        public Builder() {}

        public Builder(Piste piste) {
            nom = piste.getNom();
            numero = piste.getNumero();
            duree = piste.getDuree();
            styleMusique = piste.getStyleMusique();
            commentaire = piste.getCommentaire();
            note = piste.getNote();
            nbVotes = piste.getNbVotes();
            noISRC = piste.getNumeroISRC();
        }

        public Piste build() {
            return new Piste(nom, numero, duree, styleMusique, commentaire,
                    note, nbVotes, noISRC);
        }

        public Builder setNom(String nom) {
            this.nom = nom;
            return this;
        }

        public Builder setNumero(int numero) {
            this.numero = numero;
            return this;
        }

        public Builder setDuree(int duree) {
            this.duree = duree;
            return this;
        }

        public Builder setStyleMusique(String styleMusique) {
            this.styleMusique = styleMusique;
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

        public Builder setNoISRC(String noISRC) {
            this.noISRC = noISRC;
            return this;
        }
    }
}
