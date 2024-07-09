package org.java.spring_crud3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringCrud3Application {

	/**
	 * TODO:
	 * 
	 * In nuovo esercizio implementare la gestione di utenti e post,
	 * Definiti come segue:
	 * Utente:
	 * - id : INT
	 * - realname : String
	 * - username : String
	 * - password : String
	 * 
	 * Post:
	 * - id : INT
	 * - title : String
	 * - content : String
	 * - likeCount : INT
	 * 
	 * Verificare la corretta creazione della tabella in database.
	 * Successivamente, aggiungere la relazione uno-a-molti tra
	 * Utente e Post, dove un Utente può avere molti Post, ma
	 * ogni Post è associato a un solo Utente.
	 * 
	 * Implementare e testare le operazioni CRUD per entrambe
	 * le entità, assicurandosi che sia possibile inserire,
	 * recuperare, aggiornare ed eliminare utenti e post,
	 * mantenendo la correttezza delle relazioni.
	 * 
	 */

	public static void main(String[] args) {
		SpringApplication.run(SpringCrud3Application.class, args);
	}

}
