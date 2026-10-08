package bibliotheque;

import java.util.Objects;
import java.util.Optional;

public class Bibliothecaire {
    private final String nom;
    private final Catalogue<Document> catalogue;   // COMPOSITION

    public Bibliothecaire(String nom, Catalogue<Document> catalogue) {
        this.nom = nom;
        this.catalogue = Objects.requireNonNull(catalogue);
    }

    public void accueillir() {
        System.out.println("Bonjour, je suis " + nom);
    }

    // On n'expose que ce qui a un sens métier
    public void enregistrer(Document d) { catalogue.ajouter(d); }

    public Optional<Document> chercher(String titre) {
        return catalogue.rechercherParTitre(titre);
    }
}