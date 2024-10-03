package org.example;

import org.example.entities.*;
import org.example.repository.*;
import org.example.repository.context.DbContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GenreRepository genreRepository = new GenreRepository();
        ComposerRepository composerRepository = new ComposerRepository();
        MediaTypeRepository typeRepository = new MediaTypeRepository();
        cargarDatos();



    }


    public static void cargarDatos(){
        try {
                TrackRepository trackRepository = new TrackRepository();
                InputStream is = Main.class.getResource("/Tracks_Data.txt").openStream();
                Scanner scanner = new Scanner(is);
                //salteamos la primera linea
                if (scanner.hasNextLine()) {
                    scanner.nextLine();
                }
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] campos = line.split("\\|",-1);
                    String nameTrack = campos[1];
                    int milisecond = Integer.parseInt(campos[5]);
                    //cargamos cada valor
                    Album album = cargarAlbum(campos[2]);
                    Genre genre = cargaGenre(campos[6]);
                    MediaType mediaType = cargaMediaType(campos[7]);
                    Track track = cargaTrack(nameTrack, milisecond, album,mediaType,genre);
                    //relacion de mucho a mucho
                    String[] artistas = campos[3].split(",",-1);

                    for (String artista : artistas) {
                        track.addArtist(cargaArtist(artista));
                    }
                    String[] composes = campos[4].split(",",-1);
                    for (String compose : composes) {
                        track.addComposer(cargaComposer(compose));
                    }
                    trackRepository.update(track);


                }
        }catch (Exception e) {
            e.printStackTrace();
            DbContext.getInstance().getManager().getTransaction().rollback();
            DbContext.getInstance().getManager().getTransaction().begin();
        }

    }

    public static Album cargarAlbum(String title){
        AlbumRepositry albumRepositry = new AlbumRepositry();
        Album album = albumRepositry.findByName(title);
        if (album == null){
            album = new Album(title);
            albumRepositry.save(album);
        }
        return album;
    }

    public static Artist cargaArtist(String name){
        ArtistRepository artistRepository = new ArtistRepository();
        Artist artist = artistRepository.findByName(name);
        if (artist == null){
            artist = new Artist(name);
            artistRepository.save(artist);
        }
        return artist;
    }

    public static Composer cargaComposer(String name){
        ComposerRepository composerRepository = new ComposerRepository();
        Composer composer = composerRepository.findByName(name);
        if (composer == null){
            composer = new Composer(name);
            composerRepository.save(composer);
        }
        return composer;
    }

    public static Genre cargaGenre(String name){
        GenreRepository genreRepository = new GenreRepository();
        Genre genre = genreRepository.findByName(name);
        if (genre == null){
            genre = new Genre(name);
            genreRepository.save(genre);
        }
        return genre;
    }

    public static MediaType cargaMediaType(String name){
        MediaTypeRepository mediaTypeRepository = new MediaTypeRepository();
        MediaType mediaType = mediaTypeRepository.findByName(name);
        if (mediaType == null){
            mediaType = new MediaType(name);
            mediaTypeRepository.save(mediaType);
        }
        return mediaType;
    }

    public static Track cargaTrack(String title, int miliSeconds, Album album, MediaType mediaType, Genre genre){
        TrackRepository trackRepository = new TrackRepository();
        Track track = trackRepository.findByName(title);
        if (track == null){
            track = new Track(title, miliSeconds, album, mediaType, genre);
            trackRepository.save(track);
        }
        return track;
    }

}