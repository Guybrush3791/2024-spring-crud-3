package org.java.spring_crud3.db.serv;

import java.util.List;
import java.util.Optional;

import org.hibernate.Hibernate;
import org.java.spring_crud3.db.pojo.Tag;
import org.java.spring_crud3.db.repo.TagRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class TagService {

    @Autowired
    private TagRepo tagRepo;

    public List<Tag> findAll() {

        return tagRepo.findAll();
    }

    public Optional<Tag> findById(int id) {

        return tagRepo.findById(id);
    }

    @Transactional
    public Optional<Tag> findByIdWithPosts(int id) {

        Optional<Tag> optTag = tagRepo.findById(id);

        if (optTag.isEmpty())
            return Optional.empty();

        Tag tag = optTag.get();
        Hibernate.initialize(tag.getPosts());

        return Optional.of(tag);

    }

    public void save(Tag tag) {

        tagRepo.save(tag);
    }

    public void delete(Tag tag) {

        tagRepo.delete(tag);
    }
}
