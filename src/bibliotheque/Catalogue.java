package bibliotheque;

import java.util.ArrayList;
import java.util.List;

public class Catalogue <t extends Document>{
    private List<t> documents = new ArrayList<>();

    public void ajouter (t document){
        documents.add(document);
    }

    public void afficheTout(){
        documents.forEach(documents -> System.out.println(documents.getTitre()));
    }

    public List<t> getDocuments() {
        return documents;
    }

    public void setDocuments(List<t> documents) {
        this.documents = documents;
    }
}
