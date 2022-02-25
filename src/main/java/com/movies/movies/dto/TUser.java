package com.movies.movies.dto;

import com.movies.movies.entity.Movie;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
public class TUser {

    private int id;
    private String email;
    private String name;
    private String password;
    private boolean enabled;
    private List<TMovie> movies;

    public TUser() {

    }

    public TUser(int id, String email, String name, String password, boolean enabled, List<TMovie> movies) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
        this.enabled = enabled;
        this.movies = movies;
    }

}
