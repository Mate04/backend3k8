package org.example.services;

import org.example.entities.Genre;
import org.example.repository.GenreRepository;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenreService {
    private final GenreRepository genreRepository = new GenreRepository();
    private List<Genre> genres;
    public GenreService() {
        genres = genreRepository.findAll();
    }
    public List<Genre> getGenres() {
        return genres;
    }

    public void save(Genre genre) {
        genreRepository.save(genre);
    }
    public void GenreCountTrackExportCsv(String filePath){
        Map<String, Integer> genreTrackCount = new HashMap<>();
        genres.stream().forEach(genre -> genreTrackCount.put(genre.getName(), genre.countTracks()));

        try (FileWriter writer = new FileWriter(filePath)){
            writer.write("Genre,Track Count\n");
            for(Map.Entry<String, Integer> entry:genreTrackCount.entrySet()){
                writer.write(entry.getKey() + "," + entry.getValue() + "\n");
            }
            System.out.println("generado con exito");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
