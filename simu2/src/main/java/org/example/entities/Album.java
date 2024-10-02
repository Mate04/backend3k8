package org.example.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "albums")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "album_id")
    private Integer id;

    @Column(nullable = false, unique = true)
    private String title;
    @Column(nullable = true)
    private int totalMs;

    @OneToMany(mappedBy = "album", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Track> tracks;

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

    public int getTotalMs() {
        return totalMs;
    }

    public void setTotalMs(int totalMs) {
        this.totalMs = totalMs;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    public Album() {}
    public Album( String title) {
        this.title = title;
    }
    public void addTrack(Track track) {
        this.tracks.add(track);
    }

    @Override
    public String toString() {
        return "Album{" +
                "title='" + title + '\'' +
                ", totalMs=" + totalMs +
                ", id=" + id +
                '}';
    }
}
