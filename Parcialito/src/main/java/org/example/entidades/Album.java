package org.example.entidades;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Albums")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int totalMiliSecond;


    @OneToMany(mappedBy = "album", fetch = FetchType.LAZY)
    private List<Track> tracks;






}
