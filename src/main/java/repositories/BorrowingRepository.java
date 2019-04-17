package repositories;

import database.AccessDatabase;
import model.Borrowing;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class BorrowingRepository {
    private static EntityManager entityManager = AccessDatabase.getInstance().getEntityManager();

    public static void addBorrowing(Borrowing borrowing){
        entityManager.getTransaction().begin();
        entityManager.persist(borrowing);
        entityManager.getTransaction().commit();
    }

    public static List<Borrowing> readAllBorrowings(){
        TypedQuery<Borrowing> queryBorrowings = (TypedQuery<Borrowing>) entityManager.createNamedQuery("getAllBorrowings", Borrowing.class);
        return queryBorrowings.getResultList();
    }

}
