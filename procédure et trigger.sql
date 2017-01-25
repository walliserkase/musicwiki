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
    UPDATE album set note = @moyenne, nbVote = @nb_Vote
    WHERE album.noISRC = NEW.noISRC;
END;
$$
delimiter ;

