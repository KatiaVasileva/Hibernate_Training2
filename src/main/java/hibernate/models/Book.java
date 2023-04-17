package hibernate.models;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    public Book(String title, Author author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return  id + ", " + title + ", " + author;
    }
}
