import bibliotheque.Catalogue;
import bibliotheque.Dvd;
import bibliotheque.Livre;
import bibliotheque.Revue;


void main() {

    System.out.println("========== TEST 1 : DOCUMENTS ==========");

    Livre livre1 = new Livre(
            "Java pour débutants",
            "Introduction à la programmation Java"
    );

    Livre livre2 = new Livre(
            "Programmation Java avancée",
            "Java niveau avancé"
    );

    Dvd dvd1 = new Dvd(
            "Inception",
            "Film de science-fiction"
    );

    Dvd dvd2 = new Dvd(
            "The Matrix",
            "Film de science-fiction"
    );

    Revue revue1 = new Revue(
            "Science & Vie",
            "Magazine scientifique"
    );

    Revue revue2 = new Revue(
            "National Geographic",
            "Magazine sur la nature"
    );

    System.out.println(livre1.descriptionCourte());
    System.out.println(livre2.descriptionCourte());
    System.out.println(dvd1.descriptionCourte());
    System.out.println(dvd2.descriptionCourte());
    System.out.println(revue1.descriptionCourte());
    System.out.println(revue2.descriptionCourte());

    System.out.println("\n========== TEST 2 : ID ==========");

    System.out.println("ID Livre 1 : " + livre1.getId());
    System.out.println("ID Livre 2 : " + livre2.getId());
    System.out.println("ID DVD 1   : " + dvd1.getId());
    System.out.println("ID DVD 2   : " + dvd2.getId());
    System.out.println("ID Revue 1 : " + revue1.getId());
    System.out.println("ID Revue 2 : " + revue2.getId());


    System.out.println("\n========== TEST 3 : EMPRUNT NOMINAL ==========");

    System.out.println(
            "Avant emprunt : " + livre1.estEmprunte()
    );

    livre1.emprunter();

    System.out.println(
            "Après emprunt : " + livre1.estEmprunte()
    );

    System.out.println("\n========== TEST 4 : DOUBLE EMPRUNT ==========");

    try {

        livre1.emprunter();

        System.out.println(
                "ERREUR : le double emprunt est accepté !"
        );

    } catch (IllegalStateException e) {

        System.out.println(
                "SUCCÈS : exception détectée."
        );

        System.out.println(
                "Message : " + e.getMessage()
        );
    }

    System.out.println("\n========== TEST 5 : RETOUR ==========");

    System.out.println(
            "Avant retour : " + livre1.estEmprunte()
    );

    livre1.retourner();

    System.out.println(
            "Après retour : " + livre1.estEmprunte()
    );


    System.out.println(
            "\n========== TEST 6 : RÉEMPRUNT =========="
    );

    try {

        livre1.emprunter();

        System.out.println(
                "SUCCÈS : le livre peut être réemprunté."
        );

        System.out.println(
                "État : " + livre1.estEmprunte()
        );

    } catch (IllegalStateException e) {

        System.out.println(
                "ERREUR : impossible de réemprunter le livre."
        );
    }

    System.out.println("\n========== TEST 7 : EMPRUNT DVD ==========");

    dvd1.emprunter();

    System.out.println(
            dvd1.descriptionCourte()
    );

    System.out.println(
            "DVD emprunté : " + dvd1.estEmprunte()
    );

    System.out.println(
            "\n========== TEST 8 : DOUBLE EMPRUNT DVD =========="
    );

    try {

        dvd1.emprunter();

        System.out.println(
                "ERREUR : double emprunt accepté !"
        );

    } catch (IllegalStateException e) {

        System.out.println(
                "SUCCÈS : IllegalStateException détectée."
        );
    }

    System.out.println(
            "\n========== TEST 9 : CATALOGUE LIVRES =========="
    );

    Catalogue<Livre> catalogueLivres = new Catalogue<>();

    catalogueLivres.ajouter(livre1);
    catalogueLivres.ajouter(livre2);

    catalogueLivres.afficherTout();

    System.out.println(
            "\n========== TEST 10 : CATALOGUE DVD =========="
    );

    Catalogue<Dvd> catalogueDvd = new Catalogue<>();

    catalogueDvd.ajouter(dvd1);
    catalogueDvd.ajouter(dvd2);

    catalogueDvd.afficherTout();


    System.out.println(
            "\n========== TEST 11 : CATALOGUE REVUES =========="
    );

    Catalogue<Revue> catalogueRevues = new Catalogue<>();

    catalogueRevues.ajouter(revue1);
    catalogueRevues.ajouter(revue2);

    catalogueRevues.afficherTout();


    System.out.println(
            "\n========== TEST 12 : RECHERCHE =========="
    );

    catalogueLivres
            .rechercherParTitre("Java pour débutants")
            .ifPresentOrElse(

                    document -> System.out.println(
                            "Document trouvé : "
                                    + document.descriptionCourte()
                    ),

                    () -> System.out.println(
                            "Document introuvable."
                    )
            );


    System.out.println(
            "\n========== TEST 13 : RECHERCHE INFRUCTUEUSE =========="
    );

    catalogueLivres
            .rechercherParTitre("Python")
            .ifPresentOrElse(

                    document -> System.out.println(
                            "Document trouvé : "
                                    + document.descriptionCourte()
                    ),

                    () -> System.out.println(
                            "SUCCÈS : Document introuvable."
                    )
            );

    System.out.println(
            "\n========== TEST 14 : REVUE =========="
    );

    System.out.println(
            revue1.descriptionCourte()
    );

    System.out.println(
            "Une revue est consultée sur place."
    );


    System.out.println("\n========== TOUS LES TESTS TERMINÉS ==========");
}
