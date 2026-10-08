package bibliotheque;

public class DocumentIntrouvableException extends MediathequeException {
    public DocumentIntrouvableException(String titre) {
        super("Document introuvable : " + titre);
    }

    public DocumentIntrouvableException(String titre, Throwable cause) {
        super("Document introuvable : " + titre, cause);
    }
}
