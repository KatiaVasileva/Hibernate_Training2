package hibernate;

import hibernate.models.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

//        Account account1 = new Account("22222", "personal");
//        entityManager.persist(account1);
//        Account account2 = entityManager.find(Account.class, new AccountId("22222", "personal"));
//        System.out.println(account2);
//        Account updatedAccount = new Account("22222", "personal", "John");
//        entityManager.merge(updatedAccount);
//        Account account3 = entityManager.find(Account.class, new AccountId("44444", "personal"));
//        entityManager.remove(account3);
//        List<Account> accounts = entityManager.createQuery("SELECT account.accountNumber FROM Account account");
//                .getResultList();
//        accounts.forEach(System.out::println);

//        Account account1 = new Account(new AccountKey("77777", "business"), "David");
//        entityManager.persist(account1);
//        Account account2 = entityManager.find(Account.class, new AccountKey("22222", "personal"));
//        System.out.println(account2);
//        Account updatedAccount = new Account(new AccountKey("44445", "personal"), "Mary");
//        entityManager.merge(updatedAccount);
//        Account account3 = entityManager.find(Account.class, new AccountKey("44446", "personal"));
//        entityManager.remove(account3);
//        List<Account> accounts = entityManager.createQuery("SELECT account.accountKey.accountNumber FROM Account account")
//                .getResultList();
//        accounts.forEach(System.out::println);

        Author author1 = new Author("Charles Dickens");
        entityManager.persist(author1);
        entityManager.flush();
        Book book1 = new Book("The Pickwick Papers", author1);
        Book book2 = new Book("Oliver Twist", author1);
        entityManager.persist(book1);
        entityManager.persist(book2);

//
//        Author author2 = entityManager.find(Author.class, 26);
//        Book book3 = new Book("Carrie", author2);
//        entityManager.persist(book3);

//        List<Book> books = author2.getBooks();
//        books.forEach(System.out::println);

//        entityManager.remove(author2);

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
