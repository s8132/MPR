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
	
	public Music(){
		
	}
	
	public Music(String artist, String album, String year, String title){
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
			logger.debug("Doda³e do listy!");
	}
	
	public void writeList(){
		PropertyConfigurator.configure("logging.properties");
		
		System.out.println("Tytu³\t| Artysta\t| Album\t\t| Rok");
		System.out.println("----------------------------------------------------");
		for(Music track : music){
			System.out.println(track.getTitle() + "\t| " + track.getArtist()
					+ "\t| " + track.getAlbum() + "\t| " + track.getYear());
		}
		logger.debug("Wypisa³em listê!");
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
		music.set(music.indexOf(search(oldTitle)), new Music(artist, album, year, newTitle));
		logger.debug("Edytowa³em element");
	}
	
	public void editMany(Music c, String artist, String album, String year){
		int inter = 0;
		for(Music track : music){
			if(c.getTitle().equalsIgnoreCase(track.getTitle())){
				music.set(inter, new Music(artist, album, year, c.getTitle()));
			}
			inter++;
		}
		
	}
	
	public final Music search(String title){
		for(Music track : music){
			if(track.getTitle().equalsIgnoreCase(title)){
				return track;
			}
		}
		return null;
	}
	
	public void writeList(Music c){
		PropertyConfigurator.configure("logging.properties");
		
		System.out.println("Tytu³\t| Artysta\t| Album\t\t| Rok");
		System.out.println("----------------------------------------------------");
			for(Music track : music){
				if(c.getTitle().equals(track.getTitle())){
					System.out.println(c.getTitle() + "\t| " + c.getArtist()
							+ "\t| " + c.getAlbum() + "\t| " + c.getYear());
				}
			}

		logger.debug("Wypisa³em listê!");
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
