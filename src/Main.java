import bibliotheque.Bibliothecaire;
import bibliotheque.Catalogue;
import bibliotheque.Document;
import bibliotheque.DocumentIndisponibleException;
import bibliotheque.DocumentIntrouvableException;
import bibliotheque.Dvd;
import bibliotheque.EmpruntManager;
import bibliotheque.Livre;
import bibliotheque.MediathequeException;
import bibliotheque.RapportEmprunts;
import bibliotheque.Revue;

void main() throws Exception {

    Livre livre1 = new Livre("Java pour débutants", "Introduction à la programmation Java");
    Livre livre2 = new Livre("Programmation Java avancée", "Java niveau avancé");
    Dvd dvd1 = new Dvd("Inception", "Film de science-fiction");
    Dvd dvd2 = new Dvd("The Matrix", "Film de science-fiction");
    Revue revue1 = new Revue("Science & Vie", "Magazine scientifique");
    Revue revue2 = new Revue("National Geographic", "Magazine sur la nature");

    System.out.println("========== DOCUMENTS ==========");
    System.out.println(livre1.descriptionCourte());
    System.out.println(dvd1.descriptionCourte());
    System.out.println(revue1.descriptionCourte());
    verifier("ids uniques", livre1.getId() != livre2.getId() && livre2.getId() != dvd1.getId());

    System.out.println("\n========== EMPRUNT LIVRE ==========");
    verifier("livre libre au départ", !livre1.estEmprunte());
    livre1.emprunter();
    verifier("livre emprunté", livre1.estEmprunte());

    try {
        livre1.emprunter();
        verifier("double emprunt refusé", false);
    } catch (DocumentIndisponibleException e) {
        verifier("double emprunt refusé", true);
        verifier("message contient le titre", e.getMessage().contains("Java pour débutants"));
        verifier("getTitre()", e.getTitre().equals("Java pour débutants"));
    }

    livre1.retourner();
    verifier("livre rendu", !livre1.estEmprunte());
    livre1.emprunter();
    verifier("réemprunt après retour", livre1.estEmprunte());

    System.out.println("\n========== EMPRUNT DVD ==========");
    dvd1.emprunter();
    verifier("dvd emprunté", dvd1.estEmprunte());
    try {
        dvd1.emprunter();
        verifier("double emprunt dvd refusé", false);
    } catch (DocumentIndisponibleException e) {
        verifier("double emprunt dvd refusé", e.getMessage().contains("Inception"));
    }

    System.out.println("\n========== CATALOGUES ==========");
    Catalogue<Livre> catalogueLivres = new Catalogue<>();
    catalogueLivres.ajouter(livre1);
    catalogueLivres.ajouter(livre2);
    afficher(catalogueLivres);

    Catalogue<Dvd> catalogueDvd = new Catalogue<>();
    catalogueDvd.ajouter(dvd1);
    catalogueDvd.ajouter(dvd2);
    afficher(catalogueLivres);

    Catalogue<Revue> catalogueRevues = new Catalogue<>();
    catalogueRevues.ajouter(revue1);
    catalogueRevues.ajouter(revue2);
    afficher(catalogueLivres);


    System.out.println("\n========== RECHERCHE ==========");
    verifier("titre trouvé", catalogueLivres.rechercherParTitre("Java pour débutants").isPresent());
    verifier("casse ignorée", catalogueLivres.rechercherParTitre("JAVA POUR DÉBUTANTS").isPresent());
    verifier("titre absent", catalogueLivres.rechercherParTitre("Python").isEmpty());

    System.out.println("\n========== EMPRUNT MANAGER ==========");
    Catalogue<Document> catalogue = new Catalogue<>();
    catalogue.ajouter(new Livre("Dune", "Science-fiction"));
    catalogue.ajouter(new Dvd("Alien", "Film d'horreur"));
    catalogue.ajouter(new Revue("Wired", "Magazine tech"));
    EmpruntManager manager = new EmpruntManager(catalogue);

    manager.emprunter("Dune");
    verifier("emprunt par titre", true);

    try {
        manager.emprunter("Dune");
        verifier("déjà emprunté", false);
    } catch (DocumentIndisponibleException e) {
        verifier("déjà emprunté", e.getMessage().contains("Dune"));
    }

    try {
        manager.emprunter("Inconnu");
        verifier("titre introuvable", false);
    } catch (DocumentIntrouvableException e) {
        verifier("titre introuvable", e.getMessage().contains("Inconnu"));
    }

    try {
        manager.emprunter("Wired");
        verifier("revue non empruntable", false);
    } catch (DocumentIndisponibleException e) {
        verifier("revue non empruntable", e.getMessage().contains("Wired"));
    }

    manager.emprunter("Alien");
    verifier("dvd empruntable via manager", true);

    System.out.println("\n========== EXCEPTIONS ==========");
    Throwable cause = new RuntimeException("racine");
    DocumentIndisponibleException chaine = new DocumentIndisponibleException("Dune", cause);
    verifier("cause chaînée", chaine.getCause() == cause);
    verifier("catch via la classe mère", attrapeParLaMere(manager));

    System.out.println("\n========== BIBLIOTHECAIRE ==========");
    Catalogue<Document> catalogueBiblio = new Catalogue<>();
    Bibliothecaire biblio = new Bibliothecaire("Sarah", catalogueBiblio);
    biblio.accueillir();
    biblio.enregistrer(livre2);
    verifier("document enregistré", biblio.chercher("Programmation Java avancée").isPresent());
    verifier("document absent", biblio.chercher("Rien").isEmpty());
    verifier("catalogue partagé", catalogueBiblio.rechercherParTitre("Programmation Java avancée").isPresent());

    System.out.println("\n========== RAPPORT ==========");
    Catalogue<Document> catalogueRapport = new Catalogue<>();
    catalogueRapport.ajouter(new Livre("Clean Code", "Bonnes pratiques"));
    EmpruntManager managerRapport = new EmpruntManager(catalogueRapport);

    try (RapportEmprunts rapport = new RapportEmprunts()) {
        managerRapport.emprunter("Clean Code");
        rapport.noter("Clean Code");
        managerRapport.emprunter("Clean Code");
        rapport.noter("jamais atteint");
    } catch (MediathequeException e) {
        System.out.println("Erreur : " + e.getMessage());
    }

    System.out.println("\n========== TERMINÉ ==========");
}

void verifier(String nom, boolean condition) {
    System.out.println((condition ? "[OK]    " : "[ECHEC] ") + nom);
}
void afficher(Catalogue<? extends Document> catalogue) {
    if (catalogue.estVide()) {
        System.out.println("Le catalogue est vide.");
    }
    for (Document d : catalogue) {
        System.out.println("ID : " + d.getId() + " | " + d.descriptionCourte());
    }
}

boolean attrapeParLaMere(EmpruntManager manager) {
    try {
        manager.emprunter("Dune");
        return false;
    } catch (MediathequeException e) {
        return true;
    }
}