package hibernate;

import hibernate.models.Author;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Author author = entityManager.find(Author.class, 1);
        entityManager.clear();
        Author author2 = entityManager.find(Author.class, 1);

        transaction.commit();
        entityManager.close();

        entityManager = entityManagerFactory.createEntityManager();
        transaction = entityManager.getTransaction();
        transaction.begin();

        Author author1 = entityManager.find(Author.class, 1);

        transaction.commit();
        entityManager.close();

        entityManager = entityManagerFactory.createEntityManager();
        transaction = entityManager.getTransaction();
        transaction.begin();

        List<Author> authors = findAllAuthors(entityManager);
        List<Author> authors1 = findAllAuthors(entityManager);

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();

        authors.forEach(System.out::println);
    }

    private static List<Author> findAllAuthors(EntityManager entityManager) {
        return entityManager.createQuery("select a from Author a")
                .setHint("org.hibernate.cacheable", true)
                .getResultList();

    }
}
