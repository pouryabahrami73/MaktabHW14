package ir.pb.services.menu;


import ir.pb.domains.Post;
import ir.pb.domains.Reply;
import ir.pb.domains.Transaction;
import ir.pb.repositories.impl.ReplyRepositoryImpl;
import ir.pb.repositories.impl.TransactionRepositoryImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class ReplyService {

    private TransactionRepositoryImpl transactionRepository = new TransactionRepositoryImpl(Transaction.class);
    private ReplyRepositoryImpl replyRepository = new ReplyRepositoryImpl(Reply.class);
    public void reply(Post post){
        List<Transaction> comments = transactionRepository.findAllComments(post);
        HashMap<Integer, Transaction> commentsMap = new HashMap<>();
        AtomicInteger i = new AtomicInteger(1);
        Scanner intIn = new Scanner(System.in);
        Scanner strIn = new Scanner(System.in);
        System.out.println("Select the comment you want to reply :");
        comments.stream().forEach(comment -> {
            commentsMap.put(i.getAndIncrement(), comment);
            System.out.println(i + ". " + comment.getContent());
        });
        int choice = 0;
        try{
            choice = intIn.nextInt();
            System.out.println("Please write your reply below :");
            String replyContent = strIn.nextLine();
            Reply reply = new Reply(replyContent, commentsMap.get(choice));
            transactionRepository.save(commentsMap.get(choice));
            replyRepository.save(reply);
        }catch (Exception exception){
            System.err.println("WRONG CHOICE !!!");
            return;
        }
    }
}
