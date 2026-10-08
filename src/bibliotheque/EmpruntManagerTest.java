package bibliotheque;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmpruntManagerTest {
    private EmpruntManager manager;

    @BeforeEach
    void init() {
        Catalogue<Document> catalogue = new Catalogue<>();
        catalogue.ajouter(new Livre("Dune", "SF"));
        catalogue.ajouter(new Revue("Science & Vie", "Magazine"));
        manager = new EmpruntManager(catalogue);
    }

    @Test
    void exceptionLeveeSeulementAuDeuxiemeEmprunt() {
        assertDoesNotThrow(() -> manager.emprunter("Dune"));
        assertThrows(DocumentIndisponibleException.class,
                () -> manager.emprunter("Dune"));
    }

    @Test
    void messageContientLeTitre() throws Exception {
        manager.emprunter("Dune");
        var ex = assertThrows(DocumentIndisponibleException.class,
                () -> manager.emprunter("Dune"));
        assertTrue(ex.getMessage().contains("Dune"));
    }

    @Test
    void titreInconnu_leveIntrouvable() {
        var ex = assertThrows(DocumentIntrouvableException.class,
                () -> manager.emprunter("Python"));
        assertTrue(ex.getMessage().contains("Python"));
    }

    @Test
    void revueNonEmpruntable() {
        assertThrows(DocumentIndisponibleException.class,
                () -> manager.emprunter("Science & Vie"));
    }

    @Test
    void causeEstChainee() {
        Throwable cause = new RuntimeException("racine");
        var ex = new DocumentIndisponibleException("Dune", cause);
        assertSame(cause, ex.getCause());
        assertTrue(ex.getMessage().contains("Dune"));
    }
}