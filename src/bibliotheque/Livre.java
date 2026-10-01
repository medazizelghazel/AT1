package bibliotheque;

public class Livre extends Document implements Empruntable{
    private boolean emprunte = false;

    public Livre(String titre, String descreption) {
        super(titre, descreption);
    }

    @Override
    public String descreptioncourte() {
        return "";
    }

    @Override
    public void emprunter() {
        emprunte=true;

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
