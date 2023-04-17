package hibernate.models;

import javax.persistence.*;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor

@Entity
//@IdClass(AccountId.class)
@Table(name = "accounts")
public class Account {

    @EmbeddedId
    private AccountKey accountKey;
//    @Id
//    private String accountNumber;
//
//    @Id
//    private String accountType;

    private String name;

//    public Account(String accountNumber, String accountType) {
//        this.accountNumber = accountNumber;
//        this.accountType = accountType;
//    }
//
//    public Account(String accountNumber, String accountType, String name) {
//        this.accountNumber = accountNumber;
//        this.accountType = accountType;
//        this.name = name;
//    }


    public Account(AccountKey accountKey) {
        this.accountKey = accountKey;
    }

    public Account(AccountKey accountKey, String name) {
        this.accountKey = accountKey;
        this.name = name;
    }

//    @Override
//    public String toString() {
//        return accountNumber + " " + accountType + " " + name;
//    }

    @Override
    public String toString() {
        return  accountKey + ", " + name;
    }
}
