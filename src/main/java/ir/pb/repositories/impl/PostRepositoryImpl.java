package ir.pb.repositories.impl;

import ir.pb.base.repositories.impl.BaseRepositoryImpl;
import ir.pb.domains.Post;
import ir.pb.repositories.PostRepository;

public class PostRepositoryImpl extends BaseRepositoryImpl<Post, Long> implements PostRepository {
    public PostRepositoryImpl(Class<Post> clazz) {
        super(clazz);
    }


}
