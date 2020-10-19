package ir.pb.services.menu;

import ir.pb.domains.Account;
import ir.pb.domains.Post;
import ir.pb.domains.Transaction;
import ir.pb.repositories.impl.PostRepositoryImpl;
import ir.pb.repositories.impl.TransactionRepositoryImpl;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class TransactionService {

    private TransactionRepositoryImpl transactionRepository = new TransactionRepositoryImpl(Transaction.class);
    private PostRepositoryImpl postRepository = new PostRepositoryImpl(Post.class);
    public void like(Account sourceAccount, Post destPost){
        AtomicBoolean q = new AtomicBoolean(true);
        transactionRepository.findAllLikes(destPost).stream().forEach(like -> {
            if(like.getSourceAccount() == sourceAccount){
                System.err.println("YOU HAVE ALREADY LIKED THIS POST");
                q.set(false);
            }
        });
        if(q.get() == true){
            Transaction transaction = new Transaction(sourceAccount, destPost);
            transactionRepository.save(transaction);
        }
    }

    public void comment(Account sourceAccount, Post destPost){
        Scanner strIn = new Scanner(System.in);
        System.out.println("Please write your comment bellow :");
        String commentContent = strIn.nextLine();
        Transaction transaction = new Transaction(sourceAccount, destPost, commentContent);
        transactionRepository.save(transaction);
    }
}
