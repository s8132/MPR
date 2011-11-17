package com.event;



public class PauseMusic implements ProcessMusicListener {

	@Override
	public void processMusic(MusicEvent music){
		music.setStatus("ON, but not play");
		System.out.print("Pause song: " + music.getMusic().getTitle());
		System.out.println("\tSong stat: " + music.getStatus());
	}
}
