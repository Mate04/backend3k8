package org.example.entities;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "composers")
public class Composer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "composer_id")
    private Integer id;
    @Column(unique = true, nullable = false)
    private String name;
    @ManyToMany(mappedBy = "composers")
    private List<Track> tracks;


    public Composer() {}
    public Composer(String name) {
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

    @Override
    public String toString() {
        return "Composer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
