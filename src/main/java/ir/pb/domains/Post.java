package ir.pb.domains;


import ir.pb.base.domians.BaseEntity;


import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity
public class Post extends BaseEntity<Long> {
    @ManyToOne
    @JoinColumn(name = "fk_source_account", nullable = false)
    private Account sourceAccount;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "destPost")
    private List<Transaction> transactions;
    @Column
    private String time;
    @Column(columnDefinition = "text")
    private String content;

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

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransaction(Transaction transaction) {
        this.transactions.add(transaction);
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
