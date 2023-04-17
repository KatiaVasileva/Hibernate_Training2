package hibernate.models;

import javax.persistence.*;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

@Entity
//@Cacheable
//@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private int id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //@OneToMany(mappedBy = "author")
    @JoinColumn(name = "author_id")
    @OrderColumn(name = "book_order")
    //@OrderBy("title")
    private List<Book> books;

    public Author(String name) {
        this.name = name;
        books = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "#" + id + ": " + name;
    }
}