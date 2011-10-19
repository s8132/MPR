package com.mpr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Music extends Multimedia {
	String artist;
	String album;
	String mark;
	String year;
	String number;
	String time;
	String type;
	String title;
	
	Music(){
		
	}
	
	Music(String artist, String album, String year, String title){
		this.artist = artist;
		this.album = album;
		this.year = year;
		this.title = title;
	}
	
	public ArrayList<Music> music = new ArrayList<Music>();
	
	public void addItem(String artist, String album, String year, String title){
		music.add(new Music(artist, album, year, title));
	}
	
	public void writeList(){
		System.out.println("Tytu³\t| Artysta\t| Album\t\t| Rok");
		System.out.println("----------------------------------------------------");
		for(Music track : music){
			System.out.println(track.getTitle() + "\t| " + track.getArtist()
					+ "\t| " + track.getAlbum() + "\t| " + track.getYear());
		}
	}
	
	public void removeItem(String title){

		int inter = 0;
		for(Music track : music){
			inter++;
			if(track.getAlbum().endsWith(title)){
				music.remove(inter);
			
			}
		}
		
	}
	
	public void removeAll(){
		music.clear();
	}
	
	public void edit(String oldTitle, String newTitle, String artist, String album, String year){
		int inter = 0;
		for(Music track : music){
			inter++;
			if(track.getTitle().equalsIgnoreCase(oldTitle)){
				music.set(inter, new Music(artist, album, year, newTitle));
			
			}
		}
	}
	
	public int getSize(){
		return music.size();
	}
	
	
	public String getArtist(){
		return this.artist;
	}
	
	public String getAlbum(){
		return this.album;
	}
	
	public String getYear(){
		return this.year;
	}
	
	public String getTitle(){
		return this.title;
	}
}
