insert into Interprete (nomArtiste, nom, prenom, dateNaissance) values ("Johnny Hallyday", "Johnny", "Hallyday", "1945-06-10");
insert into Interprete (nomArtiste, nom, prenom, dateNaissance) values ("Michael Jackson", "Michael", "Jackson", "1958-08-29");

insert into StyleMusique(nom) value ("Tout style");
insert into StyleMusique(nom) value ("Rock");
insert into StyleMusique(nom) value ("Dance");
insert into StyleMusique(nom) value ("Soul");
insert into StyleMusique(nom) value ("Folk");
insert into StyleMusique(nom) value ("K-pop");
insert into StyleMusique(nom) value ("Hip Hop");

insert into Groupe(nom) values ("Mireille Mathieu");
insert into Groupe(nom) values ("Tales Of Northern Puppy Crucifixion");
insert into Groupe(nom) values ("Nabila");
insert into Groupe(nom) values ("Michael Jackson");

insert into Groupe(nom, commentaire) values ("Jean-Jacques Goldman", "Jean-Jacques Goldman, né le 11 octobre 1951 dans le 19e arrondissement de Paris, est un auteur-compositeur-interprète français, également producteur, de variété et de pop rock principalement.");
insert into Groupe(nom) values ("Fredericks Goldman Jones");
insert into Interprete(nomArtiste, nom, prenom, dateNaissance) values ("Jean-Jacques Goldman", "Jean-Jacques", "Goldman", "1951-10-11");
insert into Interprete(nomArtiste, nom, prenom, dateNaissance) values ("Nabila", "Nabila", "Nabila", "1980-02-01");

insert into Collaboration(nomGroupe, nomArtiste) values ("Jean-Jacques Goldman", "Jean-Jacques Goldman");
insert into Collaboration(nomGroupe, nomArtiste) values ("Nabila", "Nabila");
insert into Collaboration(nomGroupe, nomArtiste) values ("Michael Jackson", "Michael Jackson");
insert into MaisonDisque(nom) values ("JRG");
insert into MaisonDisque(nom) values ("Bimbo");
insert into MaisonDisque(nom) values ("Universal");

insert into Album(noISRC, nom, anneeParution, nomMaisonDisque, commentaire) values ("FG-X41-78941234", "Super Hit", 2000, "Bimbo", "recommandé pour toutes les pepettes");
insert into Piste(numero, nom, noISRC) values (1, "Pourquoi moi (Intro)", "FG-X41-78941234");
insert into Piste(numero, nom, noISRC) values (2, "Ma meilleur amie", "FG-X41-78941234");
insert into Piste(numero, nom, noISRC) values (3, "piste 3", "FG-X41-78941234");
insert into Piste(numero, nom, noISRC) values (4, "piste 4", "FG-X41-78941234");
insert into Piste(numero, nom, noISRC) values (5, "Fin d'album", "FG-X41-78941234");
insert into RelationAJoue(numeroPiste, noISRC, nomGroupe) values (1, "FG-X41-78941234", "Nabila");
insert into RelationAJoue(numeroPiste, noISRC, nomGroupe) values (2, "FG-X41-78941234", "Nabila");
insert into RelationAJoue(numeroPiste, noISRC, nomGroupe) values (3, "FG-X41-78941234", "Nabila");
insert into RelationAJoue(numeroPiste, noISRC, nomGroupe) values (4, "FG-X41-78941234", "Nabila");

insert into Album(noISRC, nom, anneeParution, nomMaisonDisque, commentaire) values ("FG-X00-78941278", "Got To Be There", 1972, "Universal", "recommandé aux fins connaisseurs");
insert into Piste(numero, nom, duree, noISRC) values (1, "Ain't No Sunshine", "00:04:09", "FG-X00-78941278");
insert into Piste(numero, nom, duree, noISRC) values (2, "I Wanna Be Where You Are", "00:03:00", "FG-X00-78941278");
insert into Piste(numero, nom, duree, noISRC) values (3, "Girl Don't Take Your Love From Me", "00:03:46", "FG-X00-78941278");
insert into Piste(numero, nom, duree, noISRC) values (4, "In Our Small Way", "00:03:34", "FG-X00-78941278");
insert into Piste(numero, nom, duree, noISRC) values (5, "Got To Be There", "00:03:23", "FG-X00-78941278");
insert into RelationAJoue(numeroPiste, noISRC, nomGroupe) values (1, "FG-X00-78941278", "Michael Jackson");
insert into RelationAJoue(numeroPiste, noISRC, nomGroupe) values (2, "FG-X00-78941278", "Michael Jackson");
insert into RelationAJoue(numeroPiste, noISRC, nomGroupe) values (3, "FG-X00-78941278", "Michael Jackson");
insert into RelationAJoue(numeroPiste, noISRC, nomGroupe) values (4, "FG-X00-78941278", "Michael Jackson");
insert into RelationAJoue(numeroPiste, noISRC, nomGroupe) values (5, "FG-X00-78941278", "Michael Jackson");

insert into Album(noISRC, nom, anneeParution, nomMaisonDisque, commentaire) values ("FR-X11-12341234", "Entre gris clair et gris foncé", 1987, "JRG", "Entre gris clair et gris foncé est un double album de Jean-Jacques Goldman sorti en 5 novembre 1987. C'est le cinquième album studio de l'artiste en solo.");
insert into Piste(numero, nom, noISRC) values (1, "À quoi tu sers ? (Intro)", "FR-X11-12341234");
insert into Piste(numero, nom, noISRC, commentaire) values (2, "Il changeait la vie", "FR-X11-12341234", "Il changeait la vie est une chanson de Jean-Jacques Goldman, parue sur l''album Entre gris clair et gris foncé, en 1987.");
insert into Piste(numero, nom, noISRC) values (3, "Tout petit monde", "FR-X11-12341234");
insert into Piste(numero, nom, noISRC) values (4, "Entre gris clair et gris foncé", "FR-X11-12341234");
insert into RelationAJoue(numeroPiste, noISRC, nomGroupe) values (1, "FR-X11-12341234", "Jean-Jacques Goldman");
insert into RelationAJoue(numeroPiste, noISRC, nomGroupe) values (2, "FR-X11-12341234", "Jean-Jacques Goldman");
insert into RelationAJoue(numeroPiste, noISRC, nomGroupe) values (3, "FR-X11-12341234", "Jean-Jacques Goldman");
insert into RelationAJoue(numeroPiste, noISRC, nomGroupe) values (4, "FR-X11-12341234", "Jean-Jacques Goldman");

insert into Album(noISRC, nom, anneeParution, nomMaisonDisque, commentaire) values ("FR-X11-56785678", "En passant", 1997, "JRG", "En passant est le sixième album studio de Jean-Jacques Goldman sorti le 26 août 1997. Parmi les titres les plus connus, on peut citer Sache que je, Bonne idée ou On ira.");
insert into Piste(numero, nom, noISRC) values (7, "Sache que je", "FR-X11-56785678");
insert into Piste(numero, nom, noISRC) values (8, "Bonne idée", "FR-X11-56785678");
insert into Piste(numero, nom, noISRC) values (10, "Tout était dit", "FR-X11-56785678");
insert into Piste(numero, nom, noISRC) values (11, "Quand tu danses", "FR-X11-56785678");
insert into RelationAJoue(numeroPiste, noISRC, nomGroupe) values (7, "FR-X11-56785678", "Jean-Jacques Goldman");
insert into RelationAJoue(numeroPiste, noISRC, nomGroupe) values (8, "FR-X11-56785678", "Jean-Jacques Goldman");
insert into RelationAJoue(numeroPiste, noISRC, nomGroupe) values (10, "FR-X11-56785678", "Jean-Jacques Goldman");
insert into RelationAJoue(numeroPiste, noISRC, nomGroupe) values (11, "FR-X11-56785678", "Jean-Jacques Goldman");

insert into TypeInstrument(nomArtiste, instrument) values ("Jean-Jacques Goldman", "Guitare");
insert into TypeVoix(nomArtiste, voix) value ("Jean-Jacques Goldman", "Soprano");

insert into Note(numeroPiste, noISRC, note) values (1, "FR-X11-12341234", 1);
insert into Note(numeroPiste, noISRC, note) values (2, "FR-X11-12341234", 2);
insert into Note(numeroPiste, noISRC, note) values (3, "FR-X11-12341234", 3);
insert into Note(numeroPiste, noISRC, note) values (4, "FR-X11-12341234", 4);

insert into Note(numeroPiste, noISRC, note) values (7, "FR-X11-56785678", 1);
insert into Note(numeroPiste, noISRC, note) values (8, "FR-X11-56785678", 0);
insert into Note(numeroPiste, noISRC, note) values (10, "FR-X11-56785678", 3);
insert into Note(numeroPiste, noISRC, note) values (11, "FR-X11-56785678", 2);
