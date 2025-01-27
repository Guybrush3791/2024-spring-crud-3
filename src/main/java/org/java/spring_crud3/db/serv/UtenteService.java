package org.java.spring_crud3.db.serv;

import java.util.List;
import java.util.Optional;

import org.hibernate.Hibernate;
import org.java.spring_crud3.db.pojo.Utente;
import org.java.spring_crud3.db.repo.UtenteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class UtenteService {

    @Autowired
    private UtenteRepo utenteRepo;

    public List<Utente> findAll() {

        return utenteRepo.findAll();
    }

    @Transactional
    public List<Utente> findAllWPosts() {

        List<Utente> utenti = utenteRepo.findAll();

        for (Utente utente : utenti) {

            Hibernate.initialize(utente.getPosts());
        }

        return utenti;
    }

    public Optional<Utente> findById(int id) {

        return utenteRepo.findById(id);
    }

    public void save(Utente utente) {

        utenteRepo.save(utente);
    }

    public void delete(Utente utente) {

        utenteRepo.delete(utente);
    }
}
