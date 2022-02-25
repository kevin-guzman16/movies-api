package com.movies.movies.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.movies.movies.dto.TMovie;
import com.movies.movies.dto.TUser;
import lombok.Data;


@Entity
@Table(name="users")
@Data
public class User {

    @OneToMany(mappedBy = "userMovie", cascade = CascadeType.ALL, orphanRemoval = true)
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

    public User(int id, String email, String name, String password, boolean enabled) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
        this.enabled = enabled;
    }

    public TUser toTransfer() {
        List<TMovie> listDTOMovies = new ArrayList<>();
        this.movies.forEach(movie -> listDTOMovies.add(movie.toTransfer()));
        return new TUser(this.id, this.email, this.name, this.password, this.enabled, listDTOMovies);
    }

}
