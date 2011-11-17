package com.event;

public class StopMusic implements ProcessMusicListener {

	@Override
	public void processMusic(MusicEvent music){
		music.setStatus("OFF");
		System.out.print("Stop song: " + music.getMusic().getTitle());
		System.out.println("\tSong stat: " + music.getStatus());
	}
}
