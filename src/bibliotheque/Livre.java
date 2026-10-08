package bibliotheque;

public class Livre extends Document implements Empruntable{
    private boolean emprunte = false;

    public Livre(String titre, String descreption) {
        super(titre, descreption);
    }

    @Override
    public String descriptionCourte() {
        return "Livre #" + getId() + " : " + getTitre();
    }

    @Override
    public void emprunter() throws DocumentIndisponibleException {
        if (emprunte) {
            throw new DocumentIndisponibleException(getTitre());
        }
        emprunte = true;
    }

    @Override
    public void retourner() {
        emprunte =false;
    }

    @Override
    public boolean estEmprunte() {
        return emprunte;
    }

}
