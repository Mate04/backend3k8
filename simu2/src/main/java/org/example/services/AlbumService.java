package org.example.services;

import org.example.entities.Album;
import org.example.repository.AlbumRepositry;

import java.util.HashMap;
import java.util.List;

public class AlbumService {
    private List<Album> albums;
    private final AlbumRepositry albumRepositry = new AlbumRepositry();

    public AlbumService() {
        albums = albumRepositry.findAll();
    }
    public List<Album> getAlbums() {
        return albums;
    }

    public Album cargarAlbum(String nombre) {
        Album album = albumRepositry.findByName(nombre);
        if (album == null) {
            album = new Album(nombre);
            albumRepositry.save(album);
            albums.add(album);
        }
        return album;
    }

}
