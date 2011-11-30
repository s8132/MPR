package com.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.mpr.Music;
import com.mpr.MusicManager;


public class MusicManagerTest {

	MusicManager musicManager = new MusicManager();
	
	private final static String TITLE = "Title 1";
	private final static String ARTIST = "Artist 1";
	private final static String ALBUM = "Album";
	private final static String YEAR = "000";
	
	@Test
	public void checkConnection(){
		assertNotNull(musicManager.getConnection());
	}
	
	@Test
	public void checkAdding(){
		Music music = new Music(ARTIST, ALBUM, YEAR, TITLE);
		
		musicManager.clearMusic();
		assertEquals(1, musicManager.addMusic(music));
		
		List<Music> tracks = musicManager.getAllMusic();
		Music tracksRetrieved = tracks.get(0);
		
		assertEquals(TITLE, tracksRetrieved.getTitle());
		assertEquals(ARTIST, tracksRetrieved.getArtist());
		assertEquals(ALBUM, tracksRetrieved.getAlbum());
	}
}
