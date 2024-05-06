package com.kodnest.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.entity.Playlist;
import com.kodnest.repository.PlaylistRepository;
import com.kodnest.service.PlaylistService;

@Service
public class PlaylistServiceImpl<Song> implements PlaylistService {

	@Autowired
	PlaylistRepository playlistRepository;


	@Override
	public void addPlaylist(Playlist playlist) {
		Playlist existplaylist =playlistRepository.findByName(playlist.getName());
			
		if(existplaylist == null) {
			playlistRepository.save(playlist);
		}
		else {
			System.out.println("duplicate playlist");
		}
	}




	@Override
	public List<Playlist> fetchAllPlaylists() {
		 List<Playlist> playlist = playlistRepository.findAll();
		 return playlist;
	}	

}
