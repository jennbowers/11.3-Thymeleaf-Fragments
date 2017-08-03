package com.jennbowers.thymeleaffun.controllers;

import com.jennbowers.thymeleaffun.models.Playlist;
import com.jennbowers.thymeleaffun.models.Song;
import com.jennbowers.thymeleaffun.repositories.PlaylistRepository;
import com.jennbowers.thymeleaffun.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    PlaylistRepository playlistRepo;

    @Autowired
    SongRepository songRepo;

    @RequestMapping("/")
    public String index (Model model) {
        Iterable<Playlist> lists = playlistRepo.findAll();
        model.addAttribute("playlists", lists);
        return "index";
    }

    @RequestMapping("/createPlaylist")
    public String createPlaylist () {
        return "createPlaylist";
    }

    @RequestMapping(value = "/createPlaylist", method = RequestMethod.POST)
    public String createPlaylist(@RequestParam("title") String title,
                                 @RequestParam("owner") String owner,
                                 @RequestParam("order") int order) {
        Playlist playlist = new Playlist();
        playlist.setTitle(title);
        playlist.setOwner(owner);
        playlist.setOrder(order);
        playlistRepo.save(playlist);
        return "redirect:/";
    }

    @RequestMapping("/createSong")
    public String createSong(Model model){
        Iterable<Playlist> lists = playlistRepo.findAll();
        model.addAttribute("playlists", lists);
        return "createSong";
    }

    @RequestMapping(value = "/createSong", method = RequestMethod.POST)
    public String createSongPost(@RequestParam("title") String title,
                                 @RequestParam("artist") String artist,
                                 @RequestParam("album") String album,
                                 @RequestParam("playlist") String playlistId,
                                 Model model){

        Song song = new Song();
        song.setTitle(title);
        song.setArtist(artist);
        song.setAlbum(album);

        try {
            long listId = Long.parseLong(playlistId);
            Playlist playlist= playlistRepo.findOne(listId);
            song.setPlaylist(playlist);
        } catch (Exception ex) {

        }

        songRepo.save(song);
        return "redirect:/";
    }
}

