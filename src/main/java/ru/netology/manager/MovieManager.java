package ru.netology.manager;

import ru.netology.domain.Movie;

public class MovieManager {
    private Movie[] movies = new Movie[0];
    private int currentMoviesLenght=10;

    public MovieManager(int currentMoviesLenght) {
        this.currentMoviesLenght = currentMoviesLenght;
    }

    public MovieManager() {
    }

    public void add(Movie movie) {
        int length = movies.length + 1;
        Movie[] tmp = new Movie[length];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

    public Movie[] showMovies() {
        int count = currentMoviesLenght;
        if (movies.length < count)
            count = movies.length;
        Movie[] result = new Movie[count];
        for (int i = 0; i < count; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }
}

