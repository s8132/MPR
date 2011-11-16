package com.mpr;



public class PauseMusic implements ProcessMusicListener {

	@Override
	public void processMusic(MusicEvent music){
		System.out.println("Pause song: " + music.getMusic().getTitle());
	}
}
