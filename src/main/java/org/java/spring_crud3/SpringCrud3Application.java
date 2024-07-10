package org.java.spring_crud3;

import java.util.List;
import java.util.Optional;

import org.java.spring_crud3.db.pojo.Post;
import org.java.spring_crud3.db.pojo.Tag;
import org.java.spring_crud3.db.pojo.Utente;
import org.java.spring_crud3.db.serv.PostService;
import org.java.spring_crud3.db.serv.TagService;
import org.java.spring_crud3.db.serv.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringCrud3Application
		implements CommandLineRunner {

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

	@Autowired
	private UtenteService utenteService;

	@Autowired
	private PostService postService;

	@Autowired
	private TagService tagService;

	public static void main(String[] args) {
		SpringApplication.run(SpringCrud3Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Hello, World!");

		// noRelationalTest();
		relationalTest();
		// crudTest();
		manyToManyTest();

		System.out.println("The end");
	}

	public void noRelationalTest() {

		Utente u1 = new Utente("Mario Rossi", "Guybrush", "my-code-pws");
		Utente u2 = new Utente("Luigi Bianchi", "Luigi", "luigi-pws");
		Utente u3 = new Utente("Paperino", "Paperino", "paperino-pws");

		Post p1 = new Post("Primo post", "Contenuto del primo post", u1);
		Post p2 = new Post("Secondo post", "Contenuto del secondo post", u1);
		Post p3 = new Post("Terzo post", "Contenuto del terzo post", u2);

		utenteService.save(u1);
		utenteService.save(u2);
		utenteService.save(u3);

		postService.save(p1);
		postService.save(p2);
		postService.save(p3);
	}

	public void relationalTest() {

		Utente u1 = new Utente("Mario Rossi", "Guybrush", "my-code-pws");
		Utente u2 = new Utente("Luigi Bianchi", "Luigi", "luigi-pws");
		Utente u3 = new Utente("Paperino", "Paperino", "paperino-pws");

		Post p1 = new Post("Primo post", "Contenuto del primo post", u1);
		Post p2 = new Post("Secondo post", "Contenuto del secondo post", u1);
		Post p3 = new Post("Terzo post", "Contenuto del terzo post", u2);

		utenteService.save(u1);
		utenteService.save(u2);
		utenteService.save(u3);

		postService.save(p1);
		postService.save(p2);
		postService.save(p3);
	}

	public void crudTest() {

		System.out.println("-------------------------------------------------------");

		List<Utente> utenti = utenteService.findAll();
		List<Post> posts = postService.findAll();

		utenti.forEach(System.out::println);
		System.out.println("-------------------------------------------------------");
		posts.forEach(System.out::println);
		System.out.println("-------------------------------------------------------");

		int deleteUserId = 2;
		Optional<Utente> optU1 = utenteService.findById(deleteUserId);
		if (optU1.isEmpty()) {
			System.out.println("User with id " + deleteUserId + " not found");
			return;
		}

		Utente u1 = optU1.get();
		utenteService.delete(u1);

		System.out.println("User with id " + deleteUserId + " deleted");
		System.out.println("-------------------------------------------------------");

		posts = postService.findAll();
		posts.forEach(System.out::println);
		System.out.println("-------------------------------------------------------");

		int deletePostId = 1;
		Optional<Post> optP1 = postService.findById(deletePostId);
		if (optP1.isEmpty()) {

			System.out.println("Post with id " + deletePostId + " not found");
			return;
		}

		Post p1 = optP1.get();
		postService.delete(p1);

		System.out.println("Post with id " + deletePostId + " deleted");
		System.out.println("-------------------------------------------------------");

		posts = postService.findAll();
		posts.forEach(System.out::println);
		System.out.println("-------------------------------------------------------");

		int updateUserId = 3;
		Optional<Utente> optU3 = utenteService.findById(updateUserId);

		if (optU3.isEmpty()) {
			System.out.println("User with id " + updateUserId + " not found");
			return;
		}

		Utente u3 = optU3.get();
		u3.setRealname("Topolino");
		utenteService.save(u3);

		System.out.println("User with id " + updateUserId + " updated");
		System.out.println("-------------------------------------------------------");

		utenti = utenteService.findAll();
		utenti.forEach(System.out::println);
		System.out.println("-------------------------------------------------------");

		int updatePostId = 2;
		Optional<Post> optP2 = postService.findById(updatePostId);

		if (optP2.isEmpty()) {
			System.out.println("Post with id " + updatePostId + " not found");
			return;
		}

		Post p2 = optP2.get();
		p2.setTitle("Secondo post modificato");
		postService.save(p2);

		System.out.println("Post with id " + updatePostId + " updated");
		System.out.println("-------------------------------------------------------");

		posts = postService.findAll();
		posts.forEach(System.out::println);
		System.out.println("-------------------------------------------------------");

		posts = postService.findAll();
		utenti = utenteService.findAllWPosts();

		posts.forEach(p -> System.out.println("Author: " + p.getUtente().getRealname() + "\n" + p));
		System.out.println("-------------------------------------------------------");

		utenti.forEach(u -> {
			System.out.println("Utente: " + u.getRealname());

			u.getPosts().forEach(p -> System.out.println(p));
		});
		System.out.println("-------------------------------------------------------");
	}

	public void manyToManyTest() {

		List<Utente> utenti = utenteService.findAll();
		List<Post> posts = postService.findAll();

		utenti.forEach(System.out::println);
		System.out.println("-------------------------------------------------------");
		posts.forEach(System.out::println);
		System.out.println("-------------------------------------------------------");

		Tag tag1 = new Tag("Tag1");
		Tag tag2 = new Tag("Tag2");
		Tag tag3 = new Tag("Tag3");

		tagService.save(tag1);
		tagService.save(tag2);
		tagService.save(tag3);

		Optional<Post> optP1 = postService.findByIdWithTags(1);

		if (optP1.isEmpty()) {
			System.out.println("Post with id 1 not found");
			return;
		}

		System.out.println("-------------------------------------------------------");

		Post p1 = optP1.get();
		p1.addTag(tag1);
		p1.addTag(tag2);
		p1.addTag(tag3);
		postService.save(p1);

		p1.removeTag(tag1);
		postService.save(p1);

		System.out.println("Tag 1 removed from post 1");
	}
}
