package bibliotheque;

import java.util.Objects;

public class EmpruntManager {
    private final Catalogue<Document> catalogue;   // COMPOSITION

    public EmpruntManager(Catalogue<Document> catalogue) {
        this.catalogue = Objects.requireNonNull(catalogue);
    }

    public void emprunter(String titre)
            throws DocumentIntrouvableException, DocumentIndisponibleException {

        Document doc = catalogue.rechercherParTitre(titre)       // DÉLÉGATION
                .orElseThrow(() -> new DocumentIntrouvableException(titre));

        if (!(doc instanceof Empruntable e)) {                   // ex : une Revue
            throw new DocumentIndisponibleException(titre);
        }
        e.emprunter();   // lève DocumentIndisponibleException si déjà emprunté
    }
}