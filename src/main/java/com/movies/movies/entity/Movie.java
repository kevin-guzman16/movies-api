package com.movies.movies.entity;

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

    public Movie(int id, User user_id, String title, String synopsis, int year, String cover) {
        this.id = id;
        this.userMovie = user_id;
        this.title = title;
        this.synopsis = synopsis;
        this.year = year;
        this.cover = cover;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return this.userMovie ;
    }

    public void setUser(User user) {
        this.userMovie = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    @Override
    public String toString() {
        return "Movie [cover=" + cover + ", id=" + id + ", synopsis=" + synopsis + ", title=" + title + ", user=" + userMovie
                + ", year=" + year + "]";
    }

    
}
