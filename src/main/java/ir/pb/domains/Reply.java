package ir.pb.domains;

import ir.pb.base.domians.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Reply extends BaseEntity<Long> {
    @Column
    private String content;
    @Column
    private String time;
    @ManyToOne
    @JoinColumn(name = "fk_transaction")
    private Transaction transaction;

    public Reply(String content, Transaction transaction) {
        this.content = content;
        Date time = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        this.time = formatter.format(time);
        this.transaction = transaction;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime() {
        Date time = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        this.time = formatter.format(time);
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}
