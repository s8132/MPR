package com.tests;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mpr.Music;

public class MusicTest {

	public static Music test;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		test = new Music();
		test.addItem("Artist", "Album", "Year", "Title");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		test.removeAll();
		
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testremoveAll() throws Exception{
		test.removeAll();
		assertTrue(test.getSize()==0);
		test.addItem("Artist", "Album", "Year", "Title");
	}
	
	@Test
	public void testsearch(){
		assertNotNull(test.searchByTitle("Title"));
		assertNull(test.searchByTitle("Tiitle"));
		
	}
	@Test
	public void testaddItem() throws Exception{
		assertEquals(test.getSize(), 1);
	}
	
	@Test
	public void testremoveItem() throws Exception{
		test.removeItem("Title");
		assertEquals(test.getSize(), 0);
		test.addItem("Artist", "Album", "Year", "Title");
	}
	
	@Test
	public void testeditItem(){
		test.edit("Title", "newTitle", "NewArtist", "NewAlbum", "NewYear");
		assertFalse(test.getTitle()=="Title");
	}
}
