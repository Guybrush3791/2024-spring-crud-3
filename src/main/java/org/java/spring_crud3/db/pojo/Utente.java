package org.java.spring_crud3.db.pojo;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = true, length = 128)
    private String realname;

    @Column(nullable = false, unique = true, length = 64)
    private String username;

    @Column(nullable = false, length = 32)
    private String password;

    @OneToMany(mappedBy = "utente", cascade = CascadeType.ALL)
    private List<Post> posts;

    public Utente() {
    }

    public Utente(String realname, String username, String password) {

        setRealname(realname);
        setUsername(username);
        setPassword(password);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {

        return "Utente{\n" +
                "id=" + id + ",\n" +
                "realname='" + realname + "',\n" +
                "username='" + username + "',\n" +
                "password='" + password + "'\n" +
                "}";
    }
}
