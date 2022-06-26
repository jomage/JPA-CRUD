package repository;

import java.util.List;

import jakarta.persistence.EntityManager;
import model.Genre;
import model.Personne;

/**
 * Cette classe regroupe les méthodes effectuant des opérations sur notre
 * entité Personne.
 * 
 * @author jomage
 *
 */
public class PersonneRepository {
    
    /**
     * Crée une personne qui portera le nom et le prénom donné, et du 
     * genre donné.
     * @param nom Le nom de la nouvelle personne
     * @param prenom Le prénom de la nouvelle personne
     * @param genre Le genre de la nouvelle personne
     * @param l'entité Personne crée
     */
    public static Personne create(String nom, String prenom, Genre genre) {
        Personne personneToCreate = new Personne(nom, prenom, genre);

        EntityManager em = PersistenceHelper.getEntityManager();
        PersistenceHelper.beginTx(em);
        em.persist(personneToCreate);
        PersistenceHelper.commitTxAndClose(em);
        
        return personneToCreate;
    }

    /**
     * Retourne la personne avec l'id donnée si elle existe, null sinon.
     * @param id L'id de la personne
     */
    public static Personne findById(Long id) {
        return PersistenceHelper.getEntityManager().find(Personne.class, id);
    }
    
    /**
     * Retourne toutes les personnes enregistrées en base de données.
     * @return une liste de toutes les personnes enregistrées en base de données.
     */
    public static List<Personne> findAll() {
        // TODO: à compléter
        
        // Utiliser une requête JPQL (exemple présent dans les slides)
        return null;
    }
    
    /**
     * Met à jour dans la base de donnée la personne modifiée fournie. 
     * @param personneUpdated la personne modifiée
     * @return la personne mise à jour
     */
    public static Personne update(Personne personneUpdated) {
        // TODO: à compléter
        
        // utiliser merge
        // on peut aussi vérifier que la personne a bien une ID
        // et refuser la mise à jour si elle n'en a pas (optionnel)
        return null;
    }
    
    /**
     * Supprime en base de données la personne qui correspond à l'id fournie.
     * @param id l'id de la personne à supprimer.
     */
    public static void delete(Long id) {
        // TODO: à compléter
        
        // 1ere étape est de "find" la personne et de vérifier si elle existe
        // 2nd étape = delete
        return;
    }

}
