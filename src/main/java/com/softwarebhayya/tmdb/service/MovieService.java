package com.softwarebhayya.tmdb.service;

import com.softwarebhayya.tmdb.model.Movie;
import com.softwarebhayya.tmdb.repo.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    // CRUD operation - Creat, Read, Update, Delete

    public Movie create(Movie movie) {

        if (movie == null) {
            throw new RuntimeException("Invalid movie");
        }

        return movieRepository.save(movie);
    }

    public Movie read(Long id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found"));
    }

    public void update(Long id, Movie update) {
        if (update == null || id == null) {
            throw new RuntimeException("Invalid movie");
        }

        // Check if exists
        if (movieRepository.existsById(id)) {
            Movie movie = movieRepository.getReferenceById(id);
            movie.setName(update.getName());
            movie.setDirector(update.getDirector());
            movie.setActors(update.getActors());
            movieRepository.save(movie);
        } else {
            throw new RuntimeException("Movie not found");
        }
    }

    public void delete(Long id) {
        if (movieRepository.existsById(id)) {
            movieRepository.deleteById(id);
        } else {
            throw new RuntimeException("Movie not found");
        }
    }
}
