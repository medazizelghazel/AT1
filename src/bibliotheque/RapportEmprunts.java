package bibliotheque;

public class RapportEmprunts implements AutoCloseable {
    private final StringBuilder lignes = new StringBuilder();

    public void noter(String titre) {
        lignes.append("Emprunté : ").append(titre).append('\n');
    }

    @Override
    public void close() {
        System.out.println("=== Rapport ===\n" + lignes);
    }
}