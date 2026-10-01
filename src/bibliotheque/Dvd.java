package bibliotheque;

public class Dvd extends Document implements Empruntable{
    private Boolean emprunte = false;
    public Dvd(String titre, String descreption) {
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

    public Boolean getEmprunte() {
        return emprunte;
    }

    public void setEmprunte(Boolean emprunte) {
        this.emprunte = emprunte;
    }
}
