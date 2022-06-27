package repository;

import java.util.List;

import exception.EntityHasNoIdException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
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
        // On va chercher l'EM
        EntityManager em = PersistenceHelper.getEntityManager();
        
        // On commence une Query JPQL
        TypedQuery<Personne> tq = em.createQuery(
                // La requête JPQL
                "SELECT p FROM Personne p",
                // Le type de retour du resultat - en gros le FROM de la req
                Personne.class);
        
        // Execute la requête et retourne LISTE de resultats
        return tq.getResultList();
    }
    
    /**
     * Met à jour dans la base de donnée la personne modifiée fournie. 
     * @param personneUpdated la personne modifiée
     * @return la personne mise à jour
     */
    public static Personne update(Personne personneUpdated) {
        // utiliser merge
        // on peut aussi vérifier que la personne a bien une ID
        // et refuser la mise à jour si elle n'en a pas (optionnel)
        if (personneUpdated == null || personneUpdated.getId() == null) {
            throw new EntityHasNoIdException();
        }

        EntityManager em = PersistenceHelper.getEntityManager();
        PersistenceHelper.beginTx(em);
        Personne personneMerged = em.merge(personneUpdated);
        PersistenceHelper.commitTxAndClose(em);
        return personneMerged;
    }
    
    /**
     * Supprime en base de données la personne qui correspond à l'id fournie.
     * @param id l'id de la personne à supprimer.
     */
    public static void delete(Long id) {
        // TODO: à compléter
        

        EntityManager em = PersistenceHelper.getEntityManager();
        PersistenceHelper.beginTx(em);

        // 1ere étape est de "find" la personne
        Personne personneToDelete = em.find(Personne.class, id);
        //  et de vérifier si elle existe
        if (personneToDelete != null) {
            // 2nd étape = delete
            em.remove(personneToDelete);
        }
        PersistenceHelper.commitTxAndClose(em);
    }

}
