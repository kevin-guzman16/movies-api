package com.movies.movies.entity;

import com.movies.movies.dto.TMovie;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="movie")
@Data
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne(cascade={CascadeType.MERGE,
        CascadeType.DETACH,
        CascadeType.PERSIST,
        CascadeType.REFRESH},
        fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User userMovie;

    @Column(name="title")
    private String title;

    @Column(name="synopsis")
    private String synopsis;

    @Column(name="year")
    private int year;

    @Column(name="cover")
    private String cover;

    public Movie(){
        
    }

    public Movie(int id, String title, String synopsis, int year, String cover) {
        this.id = id;
        this.title = title;
        this.synopsis = synopsis;
        this.year = year;
        this.cover = cover;
    }

    public TMovie toTransfer() {
        return new TMovie(this.id, this.userMovie.getId(), this.title, this.synopsis, this.year, this.cover);
    }


}
