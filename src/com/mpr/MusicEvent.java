package com.mpr;

import java.util.EventObject;

public class MusicEvent extends EventObject {
	
	

	private Music _music;
	
	public Music getMusic(){
		return _music;
	}
	
	public MusicEvent(Object source, Music music){
		super(source);
		_music=music;
	}

}
