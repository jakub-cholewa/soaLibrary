package modules;

import repositories.AuthorRepository;
import repositories.BookRepository;
import model.Author;
import model.Book;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "bookModule",eager = true)
@ApplicationScoped
public class BookModule {
    private Book bookEntity = new Book(new Author());

    private List<SelectItem> books;
    private List<SelectItem> authors;

    @PostConstruct
    public void init() {
        authors = new ArrayList<>();
        for(Author author: AuthorRepository.readAllAuthors()){
            authors.add(new SelectItem(author.getAuthorId(), author.getSurname()));
        }

        books = new ArrayList<>();
        for(Book book: BookRepository.readAllBooks()){
            books.add(new SelectItem(book.getIdBook(), book.getTitle()));
        }
    }

    public String saveBook(){
        BookRepository.addBook(bookEntity);
        return "index?faces-reditect=true";
    }

    public Book getBookEntity() {
        return bookEntity;
    }

    public void setBookEntity(Book bookEntity) {
        this.bookEntity = bookEntity;
    }

    public List<SelectItem> getAuthors() {
        return authors;
    }

    public void setAuthors(List<SelectItem> authors) {
        this.authors = authors;
    }

    public List<SelectItem> getBooks() {
        return books;
    }

    public void setBooks(List<SelectItem> books) {
        this.books = books;
    }

    public List<Book> getAllBooks(){
        return BookRepository.readAllBooks();
    }
}
