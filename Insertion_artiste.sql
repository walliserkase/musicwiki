insert into Interprete (nomArtiste, nom, prenom, dateNaissance) values ("Johnny Hallyday", "Johnny", "Hallyday", "1945-06-10");
insert into Interprete (nomArtiste, nom, prenom, dateNaissance) values ("Michael Jackson", "Michael", "Jackson", "1958-08-29");

insert into Groupe(nom) values ("Mireille Mathieu");
insert into Groupe(nom) values ("Crucifixion");
insert into Groupe(nom) values ("Nabila");

insert into Groupe(nom) values ("Jean-Jacques Goldman");
insert into Groupe(nom) values ("Fredericks Goldman Jones");
insert into Interprete(nomArtiste, nom, prenom, dateNaissance) values ("Jean-Jacques Goldman", "Jean-Jacques", "Goldman", 1951-10-11);
insert into Collaboration(nomGroupe, nomArtiste) values ("Jean-Jacques Goldman", "Jean-Jacques Goldman");
insert into MaisonDisque(nom) values ("JRG");

insert into Album(noISRC, nom, anneeParution, nomMaisonDisque) values ("FR-X11-12341234", "Entre gris clair et gris foncé", 1987, "JRG");
insert into Piste(numero, nom, noISRC) values (1, "À quoi tu sers ? (Intro)", "FR-X11-12341234");
insert into Piste(numero, nom, noISRC) values (2, "Il changeait la vie", "FR-X11-12341234");
insert into Piste(numero, nom, noISRC) values (3, "Tout petit monde", "FR-X11-12341234");
insert into Piste(numero, nom, noISRC) values (4, "Entre gris clair et gris foncé", "FR-X11-12341234");
insert into RelationAJoue(numero, noISRC, nom) values (1, "FR-X11-12341234", "Jean-Jacques Goldman");
insert into RelationAJoue(numero, noISRC, nom) values (2, "FR-X11-12341234", "Jean-Jacques Goldman");
insert into RelationAJoue(numero, noISRC, nom) values (3, "FR-X11-12341234", "Jean-Jacques Goldman");
insert into RelationAJoue(numero, noISRC, nom) values (4, "FR-X11-12341234", "Jean-Jacques Goldman");

insert into Album(noISRC, nom, anneeParution, nomMaisonDisque) values ("FR-X11-56785678", "En passant", 1997, "JRG");
insert into Piste(numero, nom, noISRC) values (7, "Sache que je", "FR-X11-56785678");
insert into Piste(numero, nom, noISRC) values (8, "Bonne idée", "FR-X11-56785678");
insert into Piste(numero, nom, noISRC) values (10, "Tout était dit", "FR-X11-56785678");
insert into Piste(numero, nom, noISRC) values (11, "Quand tu danses", "FR-X11-56785678");
insert into RelationAJoue(numero, noISRC, nom) values (7, "FR-X11-56785678", "Jean-Jacques Goldman");
insert into RelationAJoue(numero, noISRC, nom) values (8, "FR-X11-56785678", "Jean-Jacques Goldman");
insert into RelationAJoue(numero, noISRC, nom) values (10, "FR-X11-56785678", "Jean-Jacques Goldman");
insert into RelationAJoue(numero, noISRC, nom) values (11, "FR-X11-56785678", "Jean-Jacques Goldman");



