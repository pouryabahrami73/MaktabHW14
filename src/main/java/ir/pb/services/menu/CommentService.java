package ir.pb.services.menu;

import ir.pb.domains.Account;
import ir.pb.domains.Comment;
import ir.pb.domains.Post;
import ir.pb.domains.Comment;
import ir.pb.repositories.impl.PostRepositoryImpl;
import ir.pb.repositories.impl.CommentRepositoryImpl;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class CommentService {

    private CommentRepositoryImpl commentRepository = new CommentRepositoryImpl(Comment.class);
    private PostRepositoryImpl postRepository = new PostRepositoryImpl(Post.class);

    public void comment(Account sourceAccount, Post destPost){
        Scanner strIn = new Scanner(System.in);
        System.out.println("Please write your comment bellow :");
        String commentContent = strIn.nextLine();
        Comment transaction = new Comment(sourceAccount, destPost, commentContent);
        commentRepository.save(transaction);
    }
}
