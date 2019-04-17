package repositories;

import database.AccessDatabase;
import model.Author;
import model.Book;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class BookRepository {
    private static EntityManager entityManager = AccessDatabase.getInstance().getEntityManager();

    public static void addBook(Book book){
        entityManager.getTransaction().begin();
        Author author = entityManager.find(Author.class, book.getAuthor().getAuthorId());
        author.getBooks().add(book);
        book.setAuthor(author);
        entityManager.persist(book);
        entityManager.getTransaction().commit();
    }

    public static List<Book> readAllBooks(){
        TypedQuery<Book> queryBooks = (TypedQuery<Book>) entityManager.createNamedQuery("getAllBooks", Book.class);
        return queryBooks.getResultList();
    }

    public static Book getBookById(long id){
        return entityManager.find(Book.class, id);
    }
}
