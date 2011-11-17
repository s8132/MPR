package com.event;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.mpr.Music;

public class MusicPlayer {
	
	private Music music;
	
	private List musicProcesses = new ArrayList();
	
	public synchronized void addMusicProcessListener( ProcessMusicListener l){
		musicProcesses.add(l);
	}
	public synchronized void removeMusicProcessListener(ProcessMusicListener l){
		musicProcesses.remove(l);
	}
	
	public synchronized void processMusic(){
		MusicEvent musicEvent = new MusicEvent(this, music);
		Iterator listeners = musicProcesses.iterator();
		while(listeners.hasNext()){
			( (ProcessMusicListener) listeners.next()).processMusic(musicEvent);
		}
	}
	
	public Music getMusic(){
		return music;
	}
	
	public void setMusic(Music music){
		this.music=music;
	}

}
