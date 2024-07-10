package org.java.spring_crud3.db.repo;

import org.java.spring_crud3.db.pojo.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtenteRepo extends JpaRepository<Utente, Integer> {

}
