package com.event;

import java.util.EventObject;

import com.mpr.Music;

public class MusicEvent extends EventObject {
	
	

	private Music _music;
	private String status;
	
	
	public MusicEvent(Object source, Music music){
		super(source);
		_music=music;
	}
	
	public Music getMusic(){
		return _music;
	}
	
	public String getStatus(){
		return status;
	}
	
	public void setStatus(String status){
		this.status = status;
	}

}
