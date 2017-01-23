insert into Interprete (nomArtiste, nom, prenom, dateNaissance) values ("Johnny Hallyday", "Johnny", "Hallyday", "1945-06-10");
insert into Interprete (nomArtiste, nom, prenom, dateNaissance) values ("Michael Jackson", "Michael", "Jackson", "1958-08-29");

insert into Groupe(nom) values ("Mireille Mathieu");
insert into Groupe(nom) values ("Crucifixion");
insert into Groupe(nom) values ("Nabila");

insert into Groupe(nom, commentaire) values ("Jean-Jacques Goldman", "Jean-Jacques Goldman, né le 11 octobre 1951 dans le 19e 			arrondissement de Paris, est un auteur-compositeur-interprète français, également producteur, de variété et de pop rock principalement.");
insert into Groupe(nom) values ("Fredericks Goldman Jones");
insert into Interprete(nomArtiste, nom, prenom, dateNaissance) values ("Jean-Jacques Goldman", "Jean-Jacques", "Goldman", 1951-10-11);
insert into Collaboration(nomGroupe, nomArtiste) values ("Jean-Jacques Goldman", "Jean-Jacques Goldman");
insert into MaisonDisque(nom) values ("JRG");

insert into Album(noISRC, nom, anneeParution, nomMaisonDisque, commentaire) values ("FR-X11-12341234", "Entre gris clair et gris foncé", 1987, "JRG", "Entre gris clair et gris foncé est un double album de Jean-Jacques Goldman sorti en 5 novembre 1987. C'est le cinquième album studio de l'artiste en solo.");
insert into Piste(numero, nom, noISRC, note) values (1, "À quoi tu sers ? (Intro)", "FR-X11-12341234", 3);
insert into Piste(numero, nom, noISRC, note, commentaire) values (2, "Il changeait la vie", "FR-X11-12341234", 4, "Il changeait la vie est une chanson de Jean-Jacques Goldman, parue sur l''album Entre gris clair et gris foncé, en 1987.");
insert into Piste(numero, nom, noISRC, note) values (3, "Tout petit monde", "FR-X11-12341234", 5);
insert into Piste(numero, nom, noISRC, note) values (4, "Entre gris clair et gris foncé", "FR-X11-12341234", 5);
insert into RelationAJoue(numero, noISRC, nom) values (1, "FR-X11-12341234", "Jean-Jacques Goldman");
insert into RelationAJoue(numero, noISRC, nom) values (2, "FR-X11-12341234", "Jean-Jacques Goldman");
insert into RelationAJoue(numero, noISRC, nom) values (3, "FR-X11-12341234", "Jean-Jacques Goldman");
insert into RelationAJoue(numero, noISRC, nom) values (4, "FR-X11-12341234", "Jean-Jacques Goldman");

insert into Album(noISRC, nom, anneeParution, nomMaisonDisque, commentaire) values ("FR-X11-56785678", "En passant", 1997, "JRG", "En passant est le sixième album studio de Jean-Jacques Goldman sorti le 26 août 1997. Parmi les titres les plus connus, on peut citer Sache que je, Bonne idée ou On ira.");
insert into Piste(numero, nom, noISRC, note) values (7, "Sache que je", "FR-X11-56785678", 3);
insert into Piste(numero, nom, noISRC, note) values (8, "Bonne idée", "FR-X11-56785678", 5);
insert into Piste(numero, nom, noISRC, note) values (10, "Tout était dit", "FR-X11-56785678", 5);
insert into Piste(numero, nom, noISRC, note) values (11, "Quand tu danses", "FR-X11-56785678", 5);
insert into RelationAJoue(numero, noISRC, nom) values (7, "FR-X11-56785678", "Jean-Jacques Goldman");
insert into RelationAJoue(numero, noISRC, nom) values (8, "FR-X11-56785678", "Jean-Jacques Goldman");
insert into RelationAJoue(numero, noISRC, nom) values (10, "FR-X11-56785678", "Jean-Jacques Goldman");
insert into RelationAJoue(numero, noISRC, nom) values (11, "FR-X11-56785678", "Jean-Jacques Goldman");

insert into TypeInstrument(nomArtiste, instrument) values ("Jean-Jacques Goldman", "Guitare");
insert into TypeVoix(nomArtiste, voix) value ("Jean-Jacques Goldman", "Soprano");

insert into note(numeroPiste, noISRC, note) values (1, "FR-X11-12341234", 1);
insert into note(numeroPiste, noISRC, note) values (2, "FR-X11-12341234", 2);
insert into note(numeroPiste, noISRC, note) values (3, "FR-X11-12341234", 3);
insert into note(numeroPiste, noISRC, note) values (4, "FR-X11-12341234", 4);

insert into note(numeroPiste, noISRC, note) values (1, "FR-X11-12341234", 1);
insert into note(numeroPiste, noISRC, note) values (2, "FR-X11-12341234", 0);
insert into note(numeroPiste, noISRC, note) values (3, "FR-X11-12341234", 3);
insert into note(numeroPiste, noISRC, note) values (4, "FR-X11-12341234", 2);
