package org.java.spring_crud3.db.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 64)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    private int likeCount = 0;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Utente utente;

    public Post() {

    }

    public Post(String title, String content, Utente utente) {
        setTitle(title);
        setContent(content);
        setUtente(utente);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public void incLikeCount() {
        likeCount++;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    @Override
    public String toString() {

        return "Post{\n" +
                "id=" + id + ",\n" +
                "title='" + title + "',\n" +
                "content='" + content + "',\n" +
                "likeCount=" + likeCount + "\n" +
                "utente_id=" + utente.getId() + "\n" +
                "}";
    }
}
