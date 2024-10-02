package org.example;

import org.example.entities.*;
import org.example.repository.*;
import org.example.repository.context.DbContext;

public class Main {
    public static void main(String[] args) {
        AlbumRepositry albumRepositry = new AlbumRepositry();
        ArtistRepository artistRepository = new ArtistRepository();
        GenreRepository genreRepository = new GenreRepository();
        ComposerRepository composerRepository = new ComposerRepository();
        MediaTypeRepository typeRepository = new MediaTypeRepository();
        TrackRepository trackRepository = new TrackRepository();
        Album album = albumRepositry.findById(1);
        Artist artist = artistRepository.findById(1);
        Artist artist2 = artistRepository.findById(2);
        Genre genre = genreRepository.findById(1);
        Composer composer = composerRepository.findById(1);
        MediaType mediaType = typeRepository.findById(1);
        Track track = new Track("Mato el mejor", 2);
        trackRepository.save(track);
        System.out.println(mediaType);
    }
}