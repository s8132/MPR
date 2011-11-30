package com.mpr;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MusicManager {
	
	/*
	 * SQL - CREATE TABLE:
	 * 
	 * "CREATE TABLE Music(
	 * id int auto_increm,
	 * title varchar(50),
	 * artist varchar(50),
	 * album varchar(50),
	 * year int,
	 * primary key(id));"
	 * 
	 * 
	 */
	
	private Connection connection;
	private String url = "jdbc:mysql://localhost:3306/test";
	private String user = "root";
	private String password = "";
	
	private PreparedStatement addMusicStmt;
	private PreparedStatement deleteAllMusicStmt;
	private PreparedStatement getAllMusicStmt;
	
	private Statement statement;
	
	public MusicManager(){
		try{
			connection = DriverManager.getConnection(url, user, password);
			
			ResultSet rs = connection.getMetaData().getTables(null, null, null, null);
			
			while(rs.next()){
				if("Music".equalsIgnoreCase(rs.getString("TABLE_NAME"))){
					break;
				}
			}
			
			addMusicStmt = connection.prepareStatement("INSERT INTO Music (title, artist, album, year) VALUES (?, ?, ?, ?)");
			deleteAllMusicStmt = connection.prepareStatement("DELETE FROM Music");
			getAllMusicStmt = connection.prepareStatement("SELECT id, title, artist, album, year FROM Music");
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public Connection getConnection(){
		return connection;
	}
	
	public int addMusic(Music music){
		int count = 0;
		try{
			addMusicStmt.setString(1, music.getTitle());
			addMusicStmt.setString(2, music.getArtist());
			addMusicStmt.setString(3, music.getAlbum());
			addMusicStmt.setString(4, music.getYear());
			
			count = addMusicStmt.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return count;
	}
	
	public void clearMusic(){
		try{
			deleteAllMusicStmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public List<Music> getAllMusic(){
		List<Music> tracks = new ArrayList<Music>();
		
		try{
			ResultSet rs = getAllMusicStmt.executeQuery();
			
			while(rs.next()){
				Music m = new Music();
				m.setId(rs.getInt("id"));
				m.setTitle(rs.getString("title"));
				m.setArtist(rs.getString("artist"));
				m.setAlbum(rs.getString("album"));
				m.setYear(rs.getString("year"));
				tracks.add(m);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return tracks;
	}
}
