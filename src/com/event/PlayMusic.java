package com.event;

public class PlayMusic implements ProcessMusicListener{

	@Override
	public void processMusic(MusicEvent music){
		music.setStatus("ON");
		System.out.print("Play song: " + music.getMusic().getTitle());
		System.out.println("\tSong stat: " + music.getStatus());
		
	}
}
