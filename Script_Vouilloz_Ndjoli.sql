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
    nbExemplaireVendu INTEGER,
    styleMusique INTEGER,
		commentaire VARCHAR(100),
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
		PRIMARY KEY (numero, noISRC),    
		nom VARCHAR(60) NOT NULL,
    duree TIME DEFAULT '00:01:00',
    styleMusique INTEGER,
		commentaire VARCHAR(100),
    note TINYINT DEFAULT 0,
    nbVote INTEGER DEFAULT 0,
    FOREIGN KEY (noISRC)
        REFERENCES Album (noISRC),
    FOREIGN KEY (styleMusique)
        REFERENCES StyleMusique (id)
);

CREATE TABLE Groupe (
    nom VARCHAR(60) PRIMARY KEY,
		commentaire VARCHAR(200),    
		styleMusique INTEGER,
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
