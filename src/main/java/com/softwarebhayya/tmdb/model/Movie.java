package com.softwarebhayya.tmdb.model;

import lombok.Data;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Movie {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String director;

    @ElementCollection
    private List<String> actors = new ArrayList<>();

}
