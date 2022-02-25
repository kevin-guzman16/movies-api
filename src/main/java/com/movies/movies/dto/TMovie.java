package com.movies.movies.dto;

import com.movies.movies.entity.Movie;
import lombok.Data;

@Data
public class TMovie {

    private int id;
    private int userID;
    private String title;
    private String synopsis;
    private int year;
    private String cover;

    public TMovie(){

    }

    public TMovie(int id, int userID, String title, String synopsis, int year, String cover) {
        this.id = id;
        this.userID = userID;
        this.title = title;
        this.synopsis = synopsis;
        this.year = year;
        this.cover = cover;
    }

}
