package com.mpr;

public class Image extends Multimedia {
	String title;
	String mark;
	String resolution;
	String autor;
	
	Image(){
		
	}
	
	Image(String title, String mark, String resolution, String autor){
		this.title = title;
		this.mark = mark;
		this.resolution = resolution;
		this.autor = autor;
	}
	
	public String getTitle(){
		return this.title;
	}
}
