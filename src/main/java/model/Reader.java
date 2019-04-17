package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "reader")
@NamedQueries({
        @NamedQuery(
                name = "getAllReaders",
                query = "Select r from Reader r")
})
public class Reader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "readerid")
    private long readerId;

    @Column
    private String name;

    @Column
    private String surname;

    @OneToMany(mappedBy = "reader")
    List<Borrowing> borrowings = new ArrayList<>();

    public Reader() {
    }

    public Reader(String name, String surname, List<Borrowing> borrowings) {
        this.name = name;
        this.surname = surname;
        this.borrowings = borrowings;
    }

    public long getReaderId() {
        return readerId;
    }

    public void setReaderId(long readerId) {
        this.readerId = readerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Borrowing> getBorrowings() {
        return borrowings;
    }

    public void setBorrowings(List<Borrowing> borrowings) {
        this.borrowings = borrowings;
    }
}
