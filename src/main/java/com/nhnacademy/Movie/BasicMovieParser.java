package com.nhnacademy.Movie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BasicMovieParser implements MovieParser {

    @Override
    public List<Movie> parse() throws IOException {
        List<Movie> movies = new ArrayList<>();
        InputStream inputStream = getMovieFileAsStream();

        if (inputStream == null) {
            throw new IOException("Movies file not found.");
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            boolean isFirstLine = true;

            while ((line = reader.readLine()) != null) {
                // 첫 번째 줄은 헤더이므로 건너뜁니다.
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                // 각 줄을 쉼표로 나누어 파싱
                String[] fields = line.split(",", 3); // movieId, title, genres

                if (fields.length >= 3) {
                    long movieId = Long.parseLong(fields[0].trim());
                    String title = fields[1].trim();

                    // 장르를 '|'로 구분하여 Set에 저장
                    String[] genresArray = fields[2].split("\\|");
                    Set<String> genres = new HashSet<>();
                    for (String genre : genresArray) {
                        genres.add(genre.trim());
                    }

                    // Movie 객체 생성
                    Movie movie = new Movie(movieId, title, genres);
                    movies.add(movie);
                }
            }
        }

        return movies;
    }
}