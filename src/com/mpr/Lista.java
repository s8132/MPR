package com.mpr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lista {


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
		
		test.addItem("Artysta 1", "Album 1", "Year 1", "Tytu³ 1");
		test.addItem("Artysta 2", "Album 2", "Year 2", "Tytu³ 2");
		test.addItem("Artysta 3", "Album 3", "Year 3", "Tytu³ 3");
		System.out.println("Rozmiar tablicy: " + test.getSize());
		test.writeList();
		System.out.println("\n");
		//test.removeAll();
		test.removeItem("Tytu³ 2");
		test.writeList();
	
	}

}
