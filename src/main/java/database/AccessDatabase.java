package database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AccessDatabase {
    private static final AccessDatabase instance = new AccessDatabase();
    private EntityManager entityManager;
    public static AccessDatabase getInstance()
    {
        return instance;
    }

    private AccessDatabase() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("SOA-Library");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

}
