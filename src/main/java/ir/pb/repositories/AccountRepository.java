package ir.pb.repositories;

import ir.pb.base.repositories.BaseRepository;
import ir.pb.domains.Account;
import ir.pb.domains.Post;

public interface AccountRepository extends BaseRepository<Account, Long> {
    Account findByEmailAddress(String emailAddress);
    void deleteFollower(Account account, Account follower);
    void deleteFollowing(Account account, Account following);
    void addFollowing(Account account, Account following);
    void addFollower(Account account, Account follower);
    void addPost(Account account, Post post);
    void deletePost(Account account, Post post);
}
