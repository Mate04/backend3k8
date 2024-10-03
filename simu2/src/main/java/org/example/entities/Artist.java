package org.example.entities;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "artistas")
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String name;

    @Override
    public String toString() {
        return "Artist{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    @ManyToMany(mappedBy = "artists")
    private List<Track> tracks;

    public Artist() {}
    public Artist(String name) {
        this.name = name;
    }
    public void addTrack(Track track) {
        this.tracks.add(track);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }
}
