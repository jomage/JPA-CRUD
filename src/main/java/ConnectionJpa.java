import model.Genre;
import model.Personne;
import repository.PersonneRepository;

public class ConnectionJpa {
    
    public static void main(String[] args) {

        PersonneRepository.create("Balthazar", "Picsou", Genre.HOMME);
        PersonneRepository.create("Mouse", "Mickey", Genre.HOMME);
        PersonneRepository.create("Duck", "Donald", Genre.HOMME);
        PersonneRepository.create("Mouse", "Minnie", Genre.FEMME);
        
        Personne personnes = PersonneRepository.findById(1L);
        
    }
}
