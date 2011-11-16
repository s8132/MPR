package com.mpr;

public class PlayMusic implements ProcessMusicListener{

	@Override
	public void processMusic(MusicEvent music){
		System.out.println("Play song: " + music.getMusic().getTitle());
	}
}
