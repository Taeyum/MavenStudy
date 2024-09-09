package com.nhnacademy.Movie;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.ArrayList;

public class ApacheCommonsCsvMovieParser implements MovieParser {

    @Override
    public List<Movie> parse() throws IOException {
        InputStream inputStream = getMovieFileAsStream();
        if (inputStream == null) {
            throw new IOException("Movies file not found.");
        }

        List<Movie> movies = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            // CSV 파일을 파싱합니다
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader());

            // CSV 레코드를 리스트로 가져옵니다
            List<CSVRecord> csvRecordList = csvParser.getRecords();

            // CSVRecord를 기반으로 Movie 객체를 생성합니다
            for (CSVRecord csvRecord : csvRecordList) {
                long movieId = Long.parseLong(csvRecord.get(0).trim());
                String title = csvRecord.get(1).trim();
                Set<String> genres = Arrays.stream(csvRecord.get(2).split("\\|"))
                        .map(String::trim)
                        .collect(Collectors.toSet());

                // Movie 객체를 생성하고 리스트에 추가합니다
                movies.add(new Movie(movieId, title, genres));
            }
        }

        return movies;
    }
}