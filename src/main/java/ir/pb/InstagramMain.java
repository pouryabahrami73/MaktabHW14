package ir.pb;

import ir.pb.domains.Account;

import ir.pb.domains.Post;
import ir.pb.domains.Reply;
import ir.pb.services.menu.AccountService;
import ir.pb.services.menu.PostService;
import ir.pb.services.menu.ReplyService;
import ir.pb.services.menu.TransactionService;


import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class InstagramMain {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException,
            InvocationTargetException {
        AccountService accountService = new AccountService();
        TransactionService transactionService = new TransactionService();
        ReplyService replyService = new ReplyService();

        System.out.println("\u001B[33m" + "WELCOME TO pb INSTAGRAM BEING REVERSED ENGINEER APPLICATION" + "\u001B[0m");
        System.out.println("\u001B[36mplease be careful you can write word \"back\"" +
                " in any menu to go back to previous menu\u001B[0m");
        int choice = 0;
        lable1:
        do {
            lable5:
            do {
                System.out.println("Please enter one of the alternatives bellow :\n1. Sign in\n2. Sign up");
                try {
                    Scanner intIn = new Scanner(System.in);
                    choice = intIn.nextInt();
                    break lable5;
                } catch (NoSuchElementException exception) {
                    System.err.println("WRONG CHOICE !!!");
                    continue lable1;
                }
            } while (true);
            if (choice == 1) {
                int sortMode = 0;
                lable10 : do {
                    System.out.println("Please choose your account mode :\n1. Sort posts by likes\n2. Sort posts by time");
                    try {
                        Scanner intIn = new Scanner(System.in);
                        String choiceHelper = intIn.nextLine();
                        if (choiceHelper.equals("back")) {
                            continue lable1;
                        } else {
                            sortMode = Integer.parseInt(choiceHelper);
                            break lable10;
                        }
                    } catch (NoSuchElementException exception) {
                        System.err.println("WRONG CHOICE !!!");
                        continue lable1;
                    }
                } while (true);
                Account account = new AccountService().signIn();
                if (account == null) {
                    continue;
                }
                HashMap<Integer, Post> postsOfFollowings = null;
                if(true) {
                    postsOfFollowings = accountService.showFollowingsPosts(account);
                }else {
                }
                int choice2 = 0;
                lable2:
                do {
                    lable6:
                    do {
                        System.out.println("1. Edit your Account\n2. Search an account\n3. Post\n4. Reply a comment\n" +
                                "5. write a comment\n6. like a post");
                        try {
                            Scanner intIn = new Scanner(System.in);
                            String choiceHelper = intIn.nextLine();
                            if (choiceHelper.equals("back")) {
                                continue lable1;
                            } else {
                                choice2 = Integer.parseInt(choiceHelper);
                                break lable6;
                            }
                        } catch (Exception exception) {
                            System.err.println("WRONG CHOICE !!!");
                            continue lable2;
                        }
                    } while (true);
                    if (choice2 == 2) {
                        accountService.searchAnAccount();
                        continue lable2;
                    } else if (choice2 == 1) {
                        lable3:
                        do {
                            System.out.println("1. Account setting\n2. Follow setting");
                            int choice3 = 0;
                            try {
                                Scanner intIn = new Scanner(System.in);
                                String choiceHelper = intIn.nextLine();
                                if (choiceHelper.equals("back")) {
                                    continue lable2;
                                } else {
                                    choice3 = Integer.parseInt(choiceHelper);
//                                    break lable3;
                                }
                            } catch (NoSuchElementException exception) {
                                System.err.println("WRONG CHOICE !!!");
                            }
                            if (choice3 == 1) {
                                accountService.accountSetting(account);
                                continue lable2;
                            } else if (choice3 == 2) {
                                accountService.followSetting(account);
                                continue lable2;
                            }
                        } while (true);
                    } else if (choice2 == 3) {
                        PostService postService = new PostService(account);
                        lable4:
                        do {
                            System.out.println("1. Add new post\n2. Edit post\n3. Delete post");
                            int choice4 = 0;
                            try {
                                Scanner intIn = new Scanner(System.in);
                                String choiceHelper = intIn.nextLine();
                                if (choiceHelper.equals("back")) {
                                    continue lable2;
                                } else {
                                    choice4 = Integer.parseInt(choiceHelper);
                                }
                            } catch (Exception exception) {
                                System.err.println("WRONG CHOICE !!!");
                            }
                            if (choice4 == 1) {
                                postService.addPost();
                                continue lable4;
                            } else if (choice4 == 2) {
                                postService.editPost();
                                continue lable4;
                            } else if (choice4 == 3) {
                                postService.deletePost();
                                continue lable4;
                            }
                        } while (true);
                    }else if(choice2 == 4){
                        int postsChoice = 0;
                        lable7 : do {
                            System.out.println("Select one of the posts above :");
                            try {
                                Scanner intIn = new Scanner(System.in);
                                String choiceHelper = intIn.nextLine();
                                if(choiceHelper.equals("back")){
                                    continue lable2;
                                }else{
                                    postsChoice = Integer.parseInt(choiceHelper);
                                }
                            }catch (Exception exception){
                                System.err.println("TRY AGAIN !!!");
                            }
                            transactionService.like(account, postsOfFollowings.get(postsChoice));
                            continue lable2;
                        }while(true);
                    }else if (choice2 == 5){
                        int postsChoice = 0;
                        lable8 : do {
                            System.out.println("Select one of the posts above :");
                            try {
                                Scanner intIn = new Scanner(System.in);
                                String choiceHelper = intIn.nextLine();
                                if(choiceHelper.equals("back")){
                                    continue lable2;
                                }else{
                                    postsChoice = Integer.parseInt(choiceHelper);
                                }
                            }catch (Exception exception){
                                System.err.println("TRY AGAIN !!!");
                            }
                            transactionService.comment(account, postsOfFollowings.get(postsChoice));
                            continue lable2;
                        }while(true);
                    }else if (choice2 == 6) {
                        int postsChoice = 0;
                        lable9 : do {
                            System.out.println("Select one of the posts above :");
                            try {
                                Scanner intIn = new Scanner(System.in);
                                String choiceHelper = intIn.nextLine();
                                if(choiceHelper.equals("back")){
                                    continue lable2;
                                }else{
                                    postsChoice = Integer.parseInt(choiceHelper);
                                }
                            }catch (Exception exception){
                                System.err.println("TRY AGAIN !!!");
                            }
                            replyService.reply(postsOfFollowings.get(postsChoice));
                            continue lable2;
                        }while(true);
                    }
                } while (true);
            } else if (choice == 2) {
                Account account = accountService.signUp();
                System.out.println("\u001B[36mPlease login agian to use your account !!!\u001B[0m");
                accountService.finisher();
                continue lable1;
                /*PostService postService = new PostService(account);

                int choice4 = 0;
                lable7 : do {
                    System.out.println("1. Add new post\n2. Edit your Account\n3. Search an account");
                    try {
                        Scanner intIn = new Scanner(System.in);
                        String choiceHelper = intIn.nextLine();
                        choice4 = intIn.nextInt();
                        if (choiceHelper.equals("back")) {
                            continue lable1;
                        }else {
                            choice4 = Integer.parseInt(choiceHelper);
                            break lable7;
                        }
                    } catch (NoSuchElementException exception) {
                        System.err.println("WRONG CHOICE !!!");
                    }
                }while(true);
                if (choice4 == 1) {
                    postService.addPost();
                } else if (choice4 == 2) {
                    postService.editPost();
                } else if (choice4 == 3) {
                    postService.deletePost();
                }*/
            }
        } while (true);
    }
}

