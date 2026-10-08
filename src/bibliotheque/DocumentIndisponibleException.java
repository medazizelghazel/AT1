package bibliotheque;

public class DocumentIndisponibleException extends MediathequeException {
    private final String titre;

    public DocumentIndisponibleException(String titre) {
        super("Document indisponible : " + titre);
        this.titre = titre;
    }

    public DocumentIndisponibleException(String titre, Throwable cause) {
        super("Document indisponible : " + titre, cause);
        this.titre = titre;
    }

    public String getTitre() { return titre; }
}
