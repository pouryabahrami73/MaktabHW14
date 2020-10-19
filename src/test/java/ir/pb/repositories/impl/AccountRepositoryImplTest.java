package ir.pb.repositories.impl;

import com.google.common.hash.Hashing;
import ir.pb.domains.Account;
import ir.pb.domains.Post;
import ir.pb.repositories.AccountRepository;
import ir.pb.services.impl.EntityManagerMaker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

class AccountRepositoryImplTest {
    EntityManager entityManager = EntityManagerMaker.getEntityManager();
    TypedQuery<Account> query = entityManager.createQuery("SELECT a FROM Account a WHERE a.emailAddress =" +
                    "\'pooria.bahrami73@gmail.com\'", Account.class);
    Account account = query.getSingleResult();
    @BeforeAll
    static void beforeAll(){
        EntityManager entityManager = EntityManagerMaker.getEntityManager();
        entityManager.getTransaction().begin();
        Account account = new Account("pourya", "1234asd", "pooria.bahrami73@gmail.com",
                "09122154172");
        Account account2 = new Account("ali", "1234asd", "ali.vahedi60@gmail.com",
                "09123434344");
        Account account3 = new Account("mahmood", "1234asd", "m.javaheri@yahoo.com",
                "09121212122");
        Account account4 = new Account("saman", "1234asd", "sgooran@hotmail.com",
                "09125656565");
        Post post = new Post("Ma mellate Emam HOSSEIN im!!!", account);
        Post post2 = new Post("Salam Rofagha", account);
        Post post3 = new Post("Salam 2", account2);
        Post post4 = new Post("Salam 3", account3);
        Post post5 = new Post("Salam 4", account4);
        // question should be asked!!!
        account.setPost(post2);
        account.setPost(post);
        account2.setPost(post3);
        account3.setPost(post4);
        account4.setPost(post5);
        account.setFollowers(account2);
        account.setFollowers(account3);
        account.setFollowers(account4);
        account.setFollowings(account2);
        account2.setFollowers(account3);
        account2.setFollowings(account3);
        account3.setFollowings(account4);
        account4.setFollowers(account2);
        entityManager.persist(account);
        entityManager.persist(account2);
        entityManager.persist(account3);
        entityManager.persist(account4);
        entityManager.getTransaction().commit();
    }

    @Test
    void findByEmailAddress() {
        AccountRepositoryImpl accountRepository = new AccountRepositoryImpl(Account.class);
        Assertions.assertEquals(account, accountRepository.findByEmailAddress("pooria.bahrami73@gmail.com"));
    }

    @Test
    void findById(){
        AccountRepositoryImpl accountRepository = new AccountRepositoryImpl(Account.class);
        Assertions.assertEquals(account, accountRepository.findById(2L));
    }

    @Test
    void deleteFollower() {
    }

    @Test
    void deleteFollowing() {
    }

    @Test
    void addFollowing() {
    }

    @Test
    void addFollower() {
    }

    @Test
    void addPost() {
    }

    @Test
    void deletePost() {
    }
}