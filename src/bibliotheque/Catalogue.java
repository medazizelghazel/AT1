package bibliotheque;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Catalogue<T extends Document> {

    private final List<T> documents = new ArrayList<>();

    // Ajouter un document
    public void ajouter(T document) {
        documents.add(document);
    }

    // Rechercher un document par son titre
    public Optional<T> rechercherParTitre(String titre) {
        return documents.stream()
                .filter(document ->
                        document.getTitre().equalsIgnoreCase(titre)
                )
                .findFirst();
    }

    // Afficher tous les documents
    public void afficherTout() {
        if (documents.isEmpty()) {
            System.out.println("Le catalogue est vide.");
            return;
        }

        for (T document : documents) {
            System.out.println(
                    "ID : " + document.getId()
                            + " | "
                            + document.descriptionCourte()
            );
        }
    }
}