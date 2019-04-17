package model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "borrowing")
@NamedQueries({
        @NamedQuery(
                name = "getAllBorrowings",
                query = "Select b from Borrowing b")
})
public class Borrowing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "borrowingid")
    private long borrowingId;

    @OneToOne
    @JoinColumn(name = "bookid")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "readerid")
    private Reader reader;

    @Column(name = "borrowingdate")
    private Date borrowingDate;

    @Column(name = "returningdate")
    private Date returningDate;

    public Borrowing() {
    }

    public Borrowing(Book book, Reader reader) {
        this.book = book;
        this.reader = reader;
    }

    public long getBorrowingId() {
        return borrowingId;
    }

    public void setBorrowingId(long borrowingId) {
        this.borrowingId = borrowingId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Date getBorrowingDate() {
        return borrowingDate;
    }

    public void setBorrowingDate(Date borrowingDate) {
        this.borrowingDate = borrowingDate;
    }

    public Date getReturningDate() {
        return returningDate;
    }

    public void setReturningDate(Date returningDate) {
        this.returningDate = returningDate;
    }

}
