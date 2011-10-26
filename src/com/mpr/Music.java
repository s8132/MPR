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
		try{
			music.add(new Music(artist, album, year, title));
		}catch (Exception e){
			new Exception("B³¹d dodawania! ", e);
		}
		
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
				try{
					music.remove(inter);
				}catch (Exception e){
					new Exception("B³¹d usuwania", e);
				}
			}
		}
		
	}
	
	public void removeAll(){
		
		try{
			music.clear();
		}catch (Exception e){
			new Exception("B³¹d czyszczenia ", e);
		}
		
		
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
