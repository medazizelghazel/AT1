package bibliotheque;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Catalogue<T extends Document> implements Iterable<T> {

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

    // Indique si le catalogue est vide
    public boolean estVide() {
        return documents.isEmpty();
    }

    // Iterator : permet le for-each côté client
    @Override
    public Iterator<T> iterator() {
        return Collections.unmodifiableList(documents).iterator();
    }
    public Stream<T> stream() {
        return documents.stream();
    }
}