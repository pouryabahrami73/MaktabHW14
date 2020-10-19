package ir.pb.services.menu;

import ir.pb.base.services.impl.BaseServiceImpl;
import ir.pb.domains.Account;
import ir.pb.domains.Post;
import ir.pb.repositories.PostRepository;
import ir.pb.repositories.impl.AccountRepositoryImpl;
import ir.pb.repositories.impl.PostRepositoryImpl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class PostService  {
    private AccountRepositoryImpl accountRepository;
    private PostRepositoryImpl postRepository;
    private Account account = null;
    public PostService(Account account){
        this.accountRepository = new AccountRepositoryImpl(Account.class);
        this.postRepository = new PostRepositoryImpl(Post.class);
        this.account = account;
    }


    public void addPost(){
        Scanner strIn = new Scanner(System.in);
        System.out.println("Type your new post bellow :");
        String newPostContent = strIn.nextLine();
        Post post = new Post(newPostContent, account);
        accountRepository.addPost(account, post);
        postRepository.save(post);
        accountRepository.save(account);
    }

    private List<Post> showPosts(){
        List<Post> posts = account.getPosts();
        int i = 1;
        for (Post post : posts) {
            System.out.println(i + ". " + post.getContent());
            i++;
        }
        return posts;
    }

    public void deletePost(){
        Scanner intIn = new Scanner(System.in);
        System.out.println("Please select which post of yours do you want to delete :");
        List<Post> posts = showPosts();
        try{
            int choice = intIn.nextInt();
            choice -= 1;
            accountRepository.deletePost(account, posts.get(choice));
        }catch (NoSuchElementException exception){
            System.err.println("TRY AGAIN");
            deletePost();
        }
    }

    public void editPost(){
        System.out.println("Please select which post of yours you want to be edited :");
        List<Post> posts = showPosts();
        Scanner intIn = new Scanner(System.in);
        Scanner strIn = new Scanner(System.in);
        try{
            int choice = intIn.nextInt();
            choice -= 1;
            accountRepository.deletePost(account, posts.get(choice));
            System.out.println("Enter the new content");
            Post post = new Post(strIn.nextLine(), account);
            accountRepository.addPost(account, post);
        }catch (NoSuchElementException exception){
            System.err.println("TRY AGAIN");
            editPost();
        }
    }
}
