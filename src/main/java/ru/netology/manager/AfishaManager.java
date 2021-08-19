package ru.netology.manager;

import ru.netology.domain.Movie;
import ru.netology.repository.AfishaRepository;

public class AfishaManager {
    private AfishaRepository repository;
    private int currenMovieLength = 10;
    private int newMoviesLength;

    public AfishaManager(AfishaRepository repository) {
        this.repository = repository;
    }

    public AfishaManager(AfishaRepository repository, int newMoviesLength) {
        this.repository = repository;
        this.newMoviesLength = newMoviesLength;
    }

    public void add(Movie movie) {
        repository.save(movie);
    }

    public Movie[] getAll() {
        Movie[] movies = repository.findAll();

        if (newMoviesLength <= 0 || newMoviesLength > currenMovieLength) {
            newMoviesLength = currenMovieLength;
        }
        if (movies.length < newMoviesLength) {
            newMoviesLength = movies.length;
        }

        Movie[] result = new Movie[newMoviesLength];

        for (int i = 0; i < result.length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    public void findById(int id) {
        repository.findById(id);
    }

    public void removeAll() {
        repository.removeAll();
    }
}