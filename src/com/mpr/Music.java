package com.mpr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

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
	
	static Logger logger = Logger.getLogger(Music.class);
	
	
	public void addItem(String artist, String album, String year, String title) throws Exception{
		
		
		
		
		
		if (title == ""){
			PropertyConfigurator.configure("logError.properties");
			logger.error("Error title");
			throw new Exception("Title is null");
		}
		PropertyConfigurator.configure("logging.properties");
			music.add(new Music(artist, album, year, title));
			logger.debug("Doda�e do listy!");
	}
	
	public void writeList(){
		PropertyConfigurator.configure("logging.properties");
		
		System.out.println("Tytu�\t| Artysta\t| Album\t\t| Rok");
		System.out.println("----------------------------------------------------");
		for(Music track : music){
			System.out.println(track.getTitle() + "\t| " + track.getArtist()
					+ "\t| " + track.getAlbum() + "\t| " + track.getYear());
		}
		logger.debug("Wypisa�em list�!");
	}
	
	public void removeItem(String title){
		PropertyConfigurator.configure("logging.properties");
		
		music.remove(this.search(title));
		logger.debug("Usunalem element");
	}
	
	public void removeAll(){
		PropertyConfigurator.configure("logging.properties");
		
			music.clear();
			logger.debug("Usunalem wszystko");
	}
	
	public void edit(String oldTitle, String newTitle, String artist, String album, String year){
		PropertyConfigurator.configure("logging.properties");
		
		int inter = 0;
		for(Music track : music){
			inter++;
			if(track.getTitle().equalsIgnoreCase(oldTitle)){
				music.set(inter, new Music(artist, album, year, newTitle));
			}
		}
		logger.debug("Edytowa�em element");
	}
	
	
	public Music search(String title){
		for(Music track : music){
			if(track.getTitle().equalsIgnoreCase(title)){
				return track;
			}
		}
		return search(title);
	}
	
	
	public void searchResult(String ble){
		PropertyConfigurator.configure("logging.properties");
		
		for(Music track : music){
			if(this.search(ble).getTitle().equalsIgnoreCase(track.getTitle())){
				System.out.println(this.search(ble).getAlbum());
			}
		}
		logger.debug("Wypisalem rezultat");
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
