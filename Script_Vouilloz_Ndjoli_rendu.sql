DROP DATABASE IF EXISTS musicWiki;

CREATE DATABASE musicWiki;
USE musicWiki;

SET FOREIGN_KEY_CHECKS = 0;

CREATE TABLE MaisonDisque (
    nom VARCHAR(20) PRIMARY KEY
);


CREATE TABLE Album (
    noISRC VARCHAR(20) PRIMARY KEY,
    nom VARCHAR(60) NOT NULL,
    anneeParution INTEGER,
    nbExemplaireVendu INTEGER DEFAULT 0,
    styleMusique INTEGER DEFAULT 1,
	commentaire VARCHAR(200) DEFAULT "",
    note TINYINT DEFAULT 0,
    nbVote INTEGER DEFAULT 0,
    nomMaisonDisque VARCHAR(20) NOT NULL,
    FOREIGN KEY (nomMaisonDisque)
        REFERENCES MaisonDisque (nom),
    FOREIGN KEY (styleMusique)
        REFERENCES StyleMusique (id)
);

CREATE TABLE Piste (
    numero INTEGER,
    noISRC VARCHAR(20),
    PRIMARY KEY (numero , noISRC),
    nom VARCHAR(60) NOT NULL,
    duree TIME DEFAULT '00:01:00',
    styleMusique INTEGER DEFAULT 1,
    commentaire VARCHAR(200) DEFAULT '',
    note TINYINT DEFAULT 0,
    nbVote INTEGER DEFAULT 0,
    FOREIGN KEY (noISRC)
        REFERENCES Album (noISRC),
    FOREIGN KEY (styleMusique)
        REFERENCES StyleMusique (id)
);

CREATE TABLE Groupe (
    nom VARCHAR(60) PRIMARY KEY,
	commentaire VARCHAR(200) DEFAULT "",    
	styleMusique INTEGER DEFAULT 1,
    FOREIGN KEY (styleMusique)
        REFERENCES StyleMusique (id)
);

CREATE TABLE RelationAJoue (
    numeroPiste INTEGER,
	noISRC VARCHAR(20) NOT NULL,    
	nomGroupe VARCHAR(20) NOT NULL,
    PRIMARY KEY (numeroPiste , nomGroupe, noISRC),
    FOREIGN KEY (nomGroupe)
        REFERENCES Groupe (nom)
);

ALTER TABLE RelationAJoue
  ADD FOREIGN KEY RelationAJoue_fk (numeroPiste, noISRC)
  REFERENCES Piste (numero, noISRC);

CREATE TABLE Interprete (
    nomArtiste VARCHAR(20) PRIMARY KEY,
    nom VARCHAR(20),
    prenom VARCHAR(20),
    dateNaissance DATE
);

CREATE TABLE TypeVoix (
    nomArtiste VARCHAR(20),
    voix VARCHAR(20),
    PRIMARY KEY (nomArtiste , voix),
    FOREIGN KEY (nomArtiste)
        REFERENCES Interprete(nomArtiste)
);

CREATE TABLE TypeInstrument (
    nomArtiste VARCHAR(20),
    instrument VARCHAR(20),
    PRIMARY KEY (nomArtiste , instrument),
    FOREIGN KEY (nomArtiste)
        REFERENCES Interprete (nomArtiste)
);

CREATE TABLE Collaboration (
    nomGroupe VARCHAR(20),
    nomArtiste VARCHAR(20),
    dateDebut DATE,
    dateFin DATE,
    PRIMARY KEY (nomGroupe , nomArtiste),
    FOREIGN KEY (nomGroupe)
        REFERENCES Groupe(nom),
    FOREIGN KEY (nomArtiste)
        REFERENCES Interprete(nomArtiste)
);

CREATE TABLE StyleMusique (
	id INTEGER AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(40) 
);

CREATE TABLE Note (
    id INTEGER NOT NULL AUTO_INCREMENT,
    numeroPiste INTEGER NOT NULL,
	noISRC VARCHAR(20) NOT NULL,
    note TINYINT NOT NULL CHECK (note BETWEEN 0 AND 5),
    PRIMARY KEY (id),
    FOREIGN KEY (numeroPiste)
        REFERENCES piste (numero),
	FOREIGN KEY (noISRC)
		REFERENCES piste (noISRC)
);

SET FOREIGN_KEY_CHECKS = 1;

-- ********************* Ajout des procédures et trigger ********************************

delimiter $$
CREATE TRIGGER delete_piste_after_relation_deleted
AFTER DELETE ON RelationAJoue
FOR EACH ROW
BEGIN
	DELETE FROM Piste 
	WHERE numero = OLD.numeroPiste AND noISRC = OLD.noISRC;
END;
$$
delimiter ;


-- Procedure pour facilité l'acquisiton des données relative aux votes concernant une piste en particulier
DELIMITER $$
CREATE PROCEDURE info_note_piste (IN noISRC VARCHAR(20),IN numero_piste INTEGER, OUT moyenne INTEGER, OUT nb_vote INTEGER)
BEGIN
	SELECT 
    AVG(note), COUNT(note)  INTO moyenne, nb_vote
	FROM
		note
	WHERE
		note.noISRC = noIsrc AND note.numeroPiste = numero_piste;	
END;
$$
DELIMITER ;

-- Trigger qui met à jour la note d'une piste à chaque fois qu'une note est ajouté dans la table note
delimiter $$
CREATE TRIGGER mise_a_jour_note_piste
AFTER INSERT ON Note
FOR EACH ROW
BEGIN
	CALL info_note_piste(NEW.noISRC, NEW.numeroPiste, @moyenne, @nb_vote);
    UPDATE piste set note = @moyenne, nbVote = @nb_Vote
    WHERE piste.noISRC = NEW.noISRC AND piste.numero = NEW.numeroPiste;
END;
$$
delimiter ;

-- Procedure pour facilité l'acquisiton des données relative aux votes concernant une piste en particulier
DELIMITER $$
CREATE PROCEDURE info_note_album (IN noISRC VARCHAR(20), OUT moyenne INTEGER, OUT nb_vote LONG)
BEGIN
	SELECT 
    AVG(note), SUM(nbVote)  INTO moyenne, nb_vote
	FROM
		piste
	WHERE
		piste.noISRC = noISRC;	
END;
$$
DELIMITER ;

-- Trigger qui met à jour les note des albums en fonctions des note atribuées aux pistes
delimiter $$
CREATE TRIGGER mise_a_jour_note_album
AFTER UPDATE ON Piste
FOR EACH ROW
BEGIN
	CALL info_note_album(NEW.noISRC, @moyenne, @nb_vote);
UPDATE album 
SET 
    note = @moyenne,
    nbVote = @nb_Vote
WHERE
    album.noISRC = NEW.noISRC;
END;
$$
delimiter ;

