package com.movies.movies.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="users")
public class User {

    @OneToMany(mappedBy = "userMovie")
    @JsonIgnore
    private List<Movie> movies;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="email")
    private String email;

    @Column(name="name")
    private String name;

    @Column(name="password")
    private String password;

    @Column(name="enabled")
    private boolean enabled;

    public User() {

    }

    public User(List<Movie> movies, int id, String email, String name, String password, boolean enabled) {
        this.movies = movies;
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
        this.enabled = enabled;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "User [email=" + email + ", enabled=" + enabled + ", id=" + id + ", movies=" + movies + ", name=" + name
                + ", password=" + password + "]";
    }

    public void add(Movie tmpMovie) {
        if (tmpMovie == null) {
            movies = new ArrayList<>();
        }

        movies.add(tmpMovie);
        tmpMovie.setUser(this);
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      User other = (User) obj;
      if (id != other.id)
        return false;
      return true;
    }

}
