-- Procedure pour facilit� l'acquisiton des donn�es relative aux votes concernant une piste en particulier
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


-- Trigger qui met � jour la note d'une piste � chaque fois qu'une note est ajout� dans la table note
delimiter $$
CREATE TRIGGER mise_a_jour_note_piste
AFTER INSERT ON note
FOR EACH ROW
BEGIN
	CALL info_note_piste(NEW.noISRC, NEW.numeroPiste, @moyenne, @nb_vote);
    UPDATE piste set note = @moyenne, nbVote = @nb_Vote
    WHERE piste.noISRC = NEW.noISRC AND piste.numero = NEW.numeroPiste;
END;
$$
delimiter ;


