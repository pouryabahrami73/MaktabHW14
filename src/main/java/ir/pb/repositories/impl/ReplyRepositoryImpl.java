package ir.pb.repositories.impl;

import ir.pb.base.repositories.impl.BaseRepositoryImpl;
import ir.pb.domains.Reply;
import ir.pb.repositories.ReplyRepository;

public class ReplyRepositoryImpl extends BaseRepositoryImpl<Reply, Long> implements ReplyRepository {
    public ReplyRepositoryImpl(Class<Reply> clazz) {
        super(clazz);
    }
}
