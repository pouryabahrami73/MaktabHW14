package ir.pb.repositories.impl;

import ir.pb.base.repositories.impl.BaseRepositoryImpl;
import ir.pb.domains.Post;
import ir.pb.domains.Transaction;
import ir.pb.repositories.TransactionRepository;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class TransactionRepositoryImpl extends BaseRepositoryImpl<Transaction, Long> implements TransactionRepository {
    public TransactionRepositoryImpl(Class<Transaction> clazz) {
        super(clazz);
    }

    public List<Transaction> findAllLikes(Post destPost){
        TypedQuery<Transaction> query = super.entityManager.createQuery("SELECT t FROM Transaction t WHERE" +
                "t.fk_destPost =: id", Transaction.class);
        List<Transaction> transactions = query.setParameter("id", destPost).getResultList();
        List<Transaction> transactions1 = new ArrayList<>();
        transactions.stream().forEach(transaction ->{
                if(transaction.getType().equals("Like")){
                    transactions1.add(transaction);
                }
        });
        return transactions1;
    }

    public List<Transaction> findAllComments(Post destPost){
        TypedQuery<Transaction> query = super.entityManager.createQuery("SELECT t FROM Transaction t WHERE" +
                "t.fk_destPost =: id", Transaction.class);
        List<Transaction> transactions = query.setParameter("id", destPost).getResultList();
        List<Transaction> transactions1 = new ArrayList<>();
        transactions.stream().forEach(transaction ->{
            if(transaction.getType().equals("Comment")){
                transactions1.add(transaction);
            }
        });
        return transactions1;
    }
}
