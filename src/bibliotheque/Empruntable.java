package bibliotheque;

public interface Empruntable {
    void emprunter() throws DocumentIndisponibleException;

    void retourner();

    boolean estEmprunte();
}
