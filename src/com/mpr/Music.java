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
	long id;
	
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
	
	/*Problem do rozwi�zania! - Usuwa tylko jeden element*/
	public void removeAlbum(String album){
				music.remove(this.searchByAlbum(album));
	}
	
	public void removeItem(String title){
		PropertyConfigurator.configure("logging.properties");
		music.remove(this.searchByTitle(title));
		logger.debug("Usunalem element");
	}
	
	
	
	public void removeArtist(String artist){
		//music.remove(this.searchByArtist(artist));
		
		for(Music track : music){
			if(this.searchByArtist(artist).getArtist()==track.getArtist()){
				music.remove(this.searchByArtist(artist));
			}
		}
	}
	
	public void removeYear(String year){
		music.remove(this.searchByYear(year));
	}
	
	public void removeAll(){
		PropertyConfigurator.configure("logging.properties");
			music.clear();
			logger.debug("Usunalem wszystko");
	}
	
	public void edit(String oldTitle, String newTitle, String artist, String album, String year){
		PropertyConfigurator.configure("logging.properties");
		music.set(music.indexOf(searchByTitle(oldTitle)), new Music(artist, album, year, newTitle));
		logger.debug("Edytowa�em element");
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
	
	public final Music searchByTitle(String title){
		for(Music track : music){
			if(track.getTitle().equalsIgnoreCase(title)){
				return track;
			}
		}
		return null;
	}
	
	public final Music searchByAlbum(String album){
		for(Music track : music){
			if(track.getAlbum().equalsIgnoreCase(album)){
				return track;
			}
		}
		return null;
	}
	
	public final Music searchByArtist(String artist){
		for(Music track : music){
			if(track.getArtist().equalsIgnoreCase(artist)){
				return track;
			}
		}
		return null;
	}
	
	public final Music searchByYear(String year){
		for(Music track : music){
			if(track.getYear().equalsIgnoreCase(year)){
				return track;
			}
		}
		return null;
	}
	
	public void writeListByArtist(Music c){
		PropertyConfigurator.configure("logging.properties");
		
		System.out.println("Tytu�\t| Artysta\t| Album\t\t| Rok");
		System.out.println("----------------------------------------------------");
			for(Music track : music){
				if(c.getArtist().equals(track.getArtist())){
					System.out.println(c.getTitle() + "\t| " + c.getArtist()
							+ "\t| " + c.getAlbum() + "\t| " + c.getYear());
				}
			}

		logger.debug("Wypisa�em list�!");
	}
	
	public void writeList(Music c){
		PropertyConfigurator.configure("logging.properties");
		
		System.out.println("Tytu�\t| Artysta\t| Album\t\t| Rok");
		System.out.println("----------------------------------------------------");
			for(Music track : music){
				if(c.getTitle().equals(track.getTitle())){
					System.out.println(c.getTitle() + "\t| " + c.getArtist()
							+ "\t| " + c.getAlbum() + "\t| " + c.getYear());
				}
			}

		logger.debug("Wypisa�em list�!");
	}
	
	
	/*GETY*/
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
	
	public long getId(){
		return id;
	}
	
	/*SETY*/
	
	public void setId(long id){
		this.id = id;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public void setArtist(String artist){
		this.artist = artist;
	}
	
	public void setAlbum(String album){
		this.album = album;
	}
	
	public void setYear(String year){
		this.year = year;
	}
}
