package repositories;

import database.AccessDatabase;
import model.Author;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class AuthorRepository {
    private static EntityManager entityManager = AccessDatabase.getInstance().getEntityManager();

    public static void addAuthor(Author author){
        entityManager.getTransaction().begin();
        entityManager.persist(author);
        entityManager.getTransaction().commit();
    }

    public static List<Author> readAllAuthors(){
        TypedQuery<Author> queryBooks = (TypedQuery<Author>) entityManager.createNamedQuery("getAllAuthors", Author.class);
        return queryBooks.getResultList();
    }
}
