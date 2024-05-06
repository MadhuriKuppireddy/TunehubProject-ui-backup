package com.kodnest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kodnest.entity.Song;
import com.kodnest.service.SongService;

@Controller
public class SongController {

	@Autowired
	SongService songService;

	@PostMapping("/addsongs")
	public String addSong(@ModelAttribute Song song) {
		//to check a user with a song is present or not in a form
		String name = song.getName();

		boolean songExists = songService.songExists(name);

		if(songExists == false) {
			songService.saveSong(song);
		}
		else {
			System.out.println("duplicate song");
		}
		return "adminhome";
	}

	//this end point is  for checking  customer premium pay
	@GetMapping("/playsongs")
	public String playSongs(Model model) {

		boolean premium=true;

		if(premium) {

			List<Song> songslist=songService.fetchAllSongs();
			model.addAttribute("songs", songslist);

			System.out.println(songslist);
			return "viewsongs";

		}else {
			return "pay";
		}
	}
	//this  end point is for admin
	@GetMapping("/viewsongs")
	public String viewSongs(Model model) {
		
		List<Song> songslist=songService.fetchAllSongs();
		model.addAttribute("songs", songslist);

		System.out.println(songslist);
		return "viewsongs";
		
	}

}