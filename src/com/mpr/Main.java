package com.mpr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {


	public static void main(String[] args) {
	    /*
	     * Lista przygotowana tylko na jedn¹ klase Music, 
	     * poniewa¿ ju¿ powoli chce zaczac pracowac na bazie
	     * W Music mamy takie metody:
	     * addItem - dodawanie do listy
	     * writeList - wypisanie listy
	     * removeItem - usuniecie z listy elementu
	     * removeAll - usniecie wszystkiego
	     * edit - zmienia wybrany element
	     * getSize - pobieranie rozmiaru listy
	     */
		Music test = new Music();
		
		try {
			test.addItem("Artysta 55", "Album 45", "Year 1", "Tytu³ 1");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			test.addItem("Artysta 1", "Album 1", "Year 1", "Tytu³ 1");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			test.addItem("Artysta 2", "Album 2", "Year 2", "Tytu³ 2");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			test.addItem("Artysta 3", "Album 3", "Year 3", "Tytu³ 3");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			test.addItem("Artysta 4", "Album 4", "Year 4", "");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		System.out.println("Rozmiar tablicy: " + test.getSize());
		test.writeList();
		
		System.out.println("\n\nRezultat wyszukiwania:");
		test.searchResult("Tytu³ 1");
		
		System.out.println("\n\nEdytowanie wielu elementów: ");
		test.editMany("Tytu³ 1", "New Artist", "New Album", "New Year");
		test.writeList();
		
		System.out.println("\n\nEdytowanie jednego elementu:");
		test.edit("Tytu³ 1", "New Title1", "New Artist1", "New Album1", "New Year1");
		test.writeList();
		
		System.out.println("\n\nRezultat po usuniêciu");
		test.removeItem("Tytu³ 1");
		test.writeList();
		
		System.out.println("\n\nUsuwam wszystkie elementy");
		test.removeAll();
		test.writeList();
		
		
		//test.removeAll();
		
		
	
	}

}
