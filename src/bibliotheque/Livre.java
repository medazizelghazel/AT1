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

    }

    @Override
    public void retourner() {

    }

    @Override
    public boolean estEmprunte() {
        return false;
    }

}
