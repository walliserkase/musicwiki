# musicwiki

Au démarrage, on charge disons les 50 premiers éléments en base, indépendemment pour chaque liste.

* Clic gauche sur un artiste -> affichage des albums et des pistes de l'artiste
* Clic gauche sur un album -> affichage des pistes de l'album
* Clic gauche sur un piste -> -

Les infos de l'ếlément cliqué sont affichées en-bas.

Consultation de la base
=======================
Pour l'instant on peut faire une simple recherche où le résultat doit correspondre exactement et à tous les champs entrés.

Modification de la base
=======================
Clic droit sur l'élément concerné -> menu contextuel avec "Modifier", "Ajouter" et "Supprimer"
* modifier -> affichage d'une pop-up avec les champs pré-remplis avec les valeurs actuelles, boutons "Valider" et "Annuler"
* supprimer -> suppression directe (on peut ajouter par la suite une pop-up avec demande de confirmation)
* ajouter -> en fonction de la liste où on a cliqué, pop-up avec les champs vides correspondants à la liste, 
            boutons "Valider" et "Annuler"
            si on crée un album, l'artiste est pré-rempli
            si on crée une piste, l'artiste et l'album sont pré-remplis
