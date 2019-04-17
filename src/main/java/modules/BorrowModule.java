package modules;

import repositories.BookRepository;
import repositories.BorrowingRepository;
import repositories.ReaderRepository;
import model.Book;
import model.Borrowing;
import model.Reader;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "borrowModule",eager = true)
@ApplicationScoped
public class BorrowModule {
    private Borrowing borrowingEntity = new Borrowing();
    private List<Borrowing> borrowings;

    private long readerId;
    private long bookId;

    @PostConstruct
    public void init() {
        borrowings = new ArrayList<>(BorrowingRepository.readAllBorrowings());
    }

    public String saveBorrowing(){
        Book book = BookRepository.getBookById(bookId);
        Reader reader = ReaderRepository.getReaderById(readerId);
        borrowingEntity.setBook(book);
        borrowingEntity.setReader(reader);
        BorrowingRepository.addBorrowing(borrowingEntity);

        return "index?faces-reditect=true";
    }

    public Borrowing getBorrowingEntity() {
        return borrowingEntity;
    }

    public void setBorrowingEntity(Borrowing borrowingEntity) {
        this.borrowingEntity = borrowingEntity;
    }

    public long getReaderId() {
        return readerId;
    }

    public void setReaderId(long readerId) {
        this.readerId = readerId;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public List<Borrowing> getBorrowings() {
        return borrowings;
    }

    public void setBorrowings(List<Borrowing> borrowings) {
        this.borrowings = borrowings;
    }

    public List<Borrowing> getAllBorrowings(){
        return BorrowingRepository.readAllBorrowings();
    }
}
