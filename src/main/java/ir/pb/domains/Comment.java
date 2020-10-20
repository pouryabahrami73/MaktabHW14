package ir.pb.domains;

import ir.pb.base.domians.BaseEntity;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity
public class Comment extends BaseEntity<Long> {
    @ManyToOne
    @JoinColumn(name = "fk_sourceAccount", nullable = false)
    private Account sourceAccount;
    @ManyToOne
    @JoinColumn(name = "fk_destPost", nullable = false)
    private Post destPost;
    @Column
    private String time;
    @Column(columnDefinition = "text")
    private String content;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transaction")
    private List<Comment> reply;

    /*public Transaction(Account sourceAccount, Post destPost, String content, String type) {
        this.sourceAccount = sourceAccount;
        this.destPost = destPost;
        Date time = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        this.time = formatter.format(time);
        this.content = content;
        this.type = "Comment";
    }*/

    public Comment() {
    }


    public Comment(Account sourceAccount, Post destPost, String content) {
        this.sourceAccount = sourceAccount;
        this.destPost = destPost;
        Date time = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        this.time = formatter.format(time);
        this.content = content;
    }

    public Account getSourceAccount() {
        return sourceAccount;
    }

    public void setSourceAccount(Account sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    public Post getDestPost() {
        return destPost;
    }

    public void setDestPost(Post destPost) {
        this.destPost = destPost;
    }

    public String getTime() {
        return time;
    }

    public void setTime() {
        Date time = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        this.time = formatter.format(time);
    }


    public List<Comment> getReply() {
        return reply;
    }

    public void setReply(Comment reply) {
        this.reply.add(reply);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
