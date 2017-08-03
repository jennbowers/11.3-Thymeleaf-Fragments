package com.jennbowers.thymeleaffun.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "playlist")
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;

//    want it to be an accessible field for instances, but it will not go in the database
    @Transient
    private int numberOfSongs;

    @OneToMany(mappedBy = "playlist", cascade = CascadeType.ALL)
    private List<Song> songs;
    private String owner;
    private int order;

    public Playlist() {}

    public Playlist(String title, int numberOfSongs, List<Song> songs, String owner, int order) {
        this.title = title;
        this.numberOfSongs = numberOfSongs;
        this.songs = songs;
        this.owner = owner;
        this.order = order;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfSongs() {
        return numberOfSongs;
    }

    public void setNumberOfSongs(int numberOfSongs) {
        this.numberOfSongs = numberOfSongs;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
