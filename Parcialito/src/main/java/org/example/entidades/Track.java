package org.example.entidades;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tracks")
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int miliseconds;

    public Track(String name, int miliseconds) {
        this.name = name;
        this.miliseconds = miliseconds;
    }
    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album ;

    @OneToOne
    @JoinColumn(name = "genre_id")
    private  Genre genre;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMiliseconds() {
        return miliseconds;
    }

    public void setMiliseconds(int miliseconds) {
        this.miliseconds = miliseconds;
    }

    @Override
    public String toString() {
        return "Track{" +
                "name='" + name + '\'' +
                ", miliseconds=" + miliseconds +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Track track = (Track) o;
        return miliseconds == track.miliseconds && Objects.equals(name, track.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, miliseconds);
    }
}
