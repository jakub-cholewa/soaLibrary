package repositories;

import database.AccessDatabase;
import model.Reader;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ReaderRepository {
    private static EntityManager entityManager = AccessDatabase.getInstance().getEntityManager();

    public static void addReader(Reader reader){
        entityManager.getTransaction().begin();
        entityManager.persist(reader);
        entityManager.getTransaction().commit();
    }

    public static List<Reader> readAllReaders(){
        TypedQuery<Reader> queryReaders = (TypedQuery<Reader>) entityManager.createNamedQuery("getAllReaders", Reader.class);
        return queryReaders.getResultList();
    }

    public static Reader getReaderById(long id){
        return entityManager.find(Reader.class, id);
    }
}
