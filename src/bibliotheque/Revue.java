package bibliotheque;

public class Revue extends Document{

    public Revue(String titre, String description) {
        super(titre, description);
    }

    @Override
    public String descriptionCourte() {
        return "Revue #" + getId() + " : " + getTitre();
    }

}
