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
        emprunte= true;
    }

    @Override
    public void retourner() {
        emprunte= false;
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
