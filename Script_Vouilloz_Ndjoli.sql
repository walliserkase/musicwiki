DROP DATABASE IF EXISTS musicWiki;

CREATE DATABASE musicWiki;
USE musicWiki;

SET FOREIGN_KEY_CHECKS = 0;

CREATE TABLE MaisonDisque (
    nom VARCHAR(20) PRIMARY KEY
);


CREATE TABLE Album (
    noISRC VARCHAR(20) PRIMARY KEY,
    nom VARCHAR(20) NOT NULL,
    anneeParution INTEGER,
    nbExemplaireVendu INTEGER,
    styleMusique INTEGER,
    note TINYINT DEFAULT 0,
    nbVote INTEGER DEFAULT 0,
    nomMaisonDisque VARCHAR(20) NOT NULL,
    FOREIGN KEY (nomMaisonDisque)
        REFERENCES MaisonDisque (nom),
    FOREIGN KEY (styleMusique)
        REFERENCES StyleMusique (id)
);

CREATE TABLE Piste (
    numero INTEGER PRIMARY KEY,
    nom VARCHAR(60) NOT NULL,
    duree TIME DEFAULT '00:01:00',
    styleMusique INTEGER,
    note TINYINT DEFAULT 0,
    nbVote INTEGER DEFAULT 0,
    noISRC VARCHAR(20),
    FOREIGN KEY (noISRC)
        REFERENCES Album (noISRC),
    FOREIGN KEY (styleMusique)
        REFERENCES StyleMusique (id)
);

CREATE TABLE Groupe (
    nom VARCHAR(60) PRIMARY KEY,
    styleMusique INTEGER,
    FOREIGN KEY (styleMusique)
        REFERENCES StyleMusique (id)
);

CREATE TABLE RelationAJoue (
    numero INTEGER,
    nom VARCHAR(20) NOT NULL,
    PRIMARY KEY (numero , nom),
    FOREIGN KEY (numero)
        REFERENCES Piste (numero),
    FOREIGN KEY (nom)
        REFERENCES Groupe (nom)
);

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
	id INTEGER NOT NULL AUTO_INCREMENT,
    nom VARCHAR(40) PRIMARY KEY
);

CREATE TABLE Note (
    id INTEGER NOT NULL AUTO_INCREMENT,
    numeroPiste INTEGER,
	noISRC VARCHAR(20) NOT NULL,
    note TINYINT UNSIGNED CHECK (note <= 5),
    PRIMARY KEY (id),
    FOREIGN KEY (numeroPiste)
        REFERENCES piste (numero),
	FOREIGN KEY (noISRC)
		REFERENCES piste (noISRC)
);

SET FOREIGN_KEY_CHECKS = 1;