package com.mpr;

public class StopMusic implements ProcessMusicListener {

	@Override
	public void processMusic(MusicEvent music){
		System.out.println("Stop song: " + music.getMusic().getTitle());
	}
}
