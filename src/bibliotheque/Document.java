package bibliotheque;

public abstract class Document {
    private String titre;
    private String descreption;

    public Document(String titre, String descreption) {
        this.titre = titre;
        this.descreption = descreption;
    }

    public String getDescreption() {
        return descreption;
    }

    public String getTitre() {
        return titre;
    }
    public abstract String descreptioncourte();
}
