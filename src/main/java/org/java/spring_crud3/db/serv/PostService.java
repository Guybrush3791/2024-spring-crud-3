package org.java.spring_crud3.db.serv;

import java.util.List;
import java.util.Optional;

import org.java.spring_crud3.db.pojo.Post;
import org.java.spring_crud3.db.repo.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepo postRepo;

    public List<Post> findAll() {

        return postRepo.findAll();
    }

    public Optional<Post> findById(int id) {

        return postRepo.findById(id);
    }

    public void save(Post post) {

        postRepo.save(post);
    }

    public void delete(Post post) {

        postRepo.delete(post);
    }
}
