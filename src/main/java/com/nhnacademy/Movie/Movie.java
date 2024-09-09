package com.nhnacademy.Movie;

import java.util.Set;

public class Movie {
    private final long movieId;
    private final String title;
    private final Set<String> generes;

    // 생성자 추가
    public Movie(long movieId, String title, Set<String> generes) {
        this.movieId = movieId;
        this.title = title;
        this.generes = generes;
    }

    @Override
    public String toString() {
        return movieId+ " " + title + " " + generes;
    }
}