package org.example.entities;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "tracks")
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "track_id")
    private Integer id;

    @Column(unique = true, nullable = false)
    private String title;

    @Column(unique = true, nullable = false)
    private int miliSeconds;


    @ManyToOne
    @JoinColumn(name = "album_id", nullable = true)
    private Album album;

    @ManyToOne
    @JoinColumn(name = "media_type_id", nullable = true)
    private MediaType mediaType;

    @ManyToOne
    @JoinColumn(name = "genre_id",nullable = true )
    private Genre genre;

    @ManyToMany(mappedBy = "tracks")
    private List<Composer> composers;

    @ManyToMany(mappedBy = "tracks")
    private List<Artist> artists;

    public Track() {}
    public Track(String title, int miliSeconds) {
        this.title = title;
        this.miliSeconds = miliSeconds;
    }
    public void addComposer(Composer composer) {
        this.composers.add(composer);
    }
    public void addArtist(Artist artist) {
        this.artists.add(artist);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public int getMiliSeconds() {
        return miliSeconds;
    }

    public void setMiliSeconds(int miliSeconds) {
        this.miliSeconds = miliSeconds;
    }

    public MediaType getMediaType() {
        return mediaType;
    }

    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public List<Composer> getComposers() {
        return composers;
    }

    public void setComposers(List<Composer> composers) {
        this.composers = composers;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }
}