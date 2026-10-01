import bibliotheque.Catalogue;
import bibliotheque.Dvd;
import bibliotheque.Livre;
import bibliotheque.Revue;


void main() {
    Livre livre = new Livre( "Java pour débutants", "Introduction aux Java" );
    Dvd dvd = new Dvd( "Inception", "Film de science-fiction" );
    Revue revue = new Revue( "Science & Vie", "Magazine scientifique" );

    System.out.println("===== DOCUMENTS =====");
    System.out.println(livre.getTitre());
    System.out.println(dvd.getTitre());
    System.out.println(revue.getTitre());

    System.out.println("\n===== EMPRUNT LIVRE =====");
    System.out.println("Avant emprunt : " + livre.estEmprunte());
    livre.emprunter();
    System.out.println("Après emprunt : " + livre.estEmprunte());

    System.out.println("\n===== RETOUR LIVRE =====");
    livre.retourner();
    System.out.println( "Après retour : " + livre.estEmprunte() );
    
    System.out.println("\n===== CATALOGUE LIVRES =====");
    Catalogue<Livre> catalogueLivres = new Catalogue<>();
    catalogueLivres.ajouter(livre);
    catalogueLivres.ajouter( new Livre( "Programmation Java avancée", "Java niveau avancé" ) );
    catalogueLivres.ajouter( new Livre( "Design Patterns", "Les patrons de conception" ) );
    catalogueLivres.afficheTout();
}
