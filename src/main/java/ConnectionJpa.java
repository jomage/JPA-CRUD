import java.util.List;

import model.Genre;
import model.Personne;
import repository.PersonneRepository;

public class ConnectionJpa {
    
    public static void main(String[] args) {

        System.out.println("---------------------- CREATE x4");
        PersonneRepository.create("Balthazar", "Picsou", Genre.HOMME);
        PersonneRepository.create("Mouse", "Mickey", Genre.HOMME);
        PersonneRepository.create("Duck", "Donald", Genre.HOMME);
        PersonneRepository.create("Mouse", "Minnie", Genre.FEMME);
        

        System.out.println("---------------------- FIND ONE");
        Personne personne = PersonneRepository.findById(1L);
        System.out.println(personne);

        System.out.println("---------------------- FIND ALL");
        List<Personne> personnes = PersonneRepository.findAll();
        System.out.println(personnes);
        
        System.out.println("---------------------- UPDATE");
        System.out.println(" ----> AVANT update" + personne);
        personne.setNom("McDuck");
        Personne personneUpdated = PersonneRepository.update(personne);
        System.out.println(" ----> AFTER update" + personneUpdated);
        
        System.out.println("---------------------- DELETE");
        System.out.println(" ----> nombre AVANT delete = " + PersonneRepository.findAll().size());
        PersonneRepository.delete(1L);
        System.out.println(" ----> nombre APRES delete = " + PersonneRepository.findAll().size());
        
    }
}
