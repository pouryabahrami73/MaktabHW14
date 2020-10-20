package ir.pb.domains;


import ir.pb.base.domians.BaseEntity;


import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Post extends BaseEntity<Long> {
    @ManyToOne
    @JoinColumn(name = "fk_source_account", nullable = false)
    private Account sourceAccount;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "destPost")
    private List<Comment> Comments;
    @Column
    private String time;
    @Column(columnDefinition = "text")
    private String content;
    @ManyToMany
    @JoinTable(name = "post_likes", joinColumns = {@JoinColumn(name = "fk_post")},
            inverseJoinColumns = {@JoinColumn(name = "fk_account")})
    private List<Account> likes = new ArrayList<>();

    public Post() {
    }

    public Post(String content, Account account) {
        Date time = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        this.time = formatter.format(time);
        this.content = content;
        this.sourceAccount = account;
    }

    public Account getSourceAccount() {
        return sourceAccount;
    }

    public void setSourceAccount(Account sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    public List<Comment> getTransactions() {
        return Comments;
    }

    public void setTransaction(Comment transaction) {
        this.Comments.add(transaction);
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
