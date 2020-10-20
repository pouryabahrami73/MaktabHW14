package ir.pb.repositories.impl;

import ir.pb.base.repositories.impl.BaseRepositoryImpl;
import ir.pb.domains.Post;
import ir.pb.domains.Comment;
import ir.pb.repositories.CommentRepository;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class CommentRepositoryImpl extends BaseRepositoryImpl<Comment, Long> implements CommentRepository {
    public CommentRepositoryImpl(Class<Comment> clazz) {
        super(clazz);
    }


    public List<Comment> findAllComments(Post destPost){
        TypedQuery<Comment> query = super.entityManager.createQuery("SELECT t FROM Transaction t WHERE" +
                "t.fk_destPost =: id", Comment.class);
        List<Comment> transactions = query.setParameter("id", destPost).getResultList();
        List<Comment> transactions1 = new ArrayList<>();
        transactions.stream().forEach(transaction ->{
            if(transaction.getType().equals("Comment")){
                transactions1.add(transaction);
            }
        });
        return transactions1;
    }
}
