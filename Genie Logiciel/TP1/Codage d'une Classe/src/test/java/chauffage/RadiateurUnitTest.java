package test.java.chauffage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.java.chauffage.Radiateur;

class RadiateurUnitTest {

	@Test
	void testAllumer() {
		Radiateur radiateur = new Radiateur("Atlantic", "Electrique");
		assertTrue(radiateur.isAllume() == false); 
		assertEquals(radiateur.allumer(), true); 
		assertTrue(radiateur.isAllume() == true); 
		assertEquals(radiateur.allumer(), false); 
		assertEquals(radiateur.eteindre(), true); 
		assertTrue(radiateur.isAllume() == false); 
		assertEquals(radiateur.eteindre(), false); 
	}
	
	@Test
	void testAllumerTrue() {
		Radiateur radiateur = new Radiateur("Atlantic", "Electrique", true);
		assertTrue(radiateur.isAllume() == true); 
		assertEquals(radiateur.allumer(), false);  
		assertEquals(radiateur.eteindre(), true); 
		assertTrue(radiateur.isAllume() == false); 
		assertEquals(radiateur.eteindre(), false); 
		assertEquals(radiateur.allumer(), true);  
		assertTrue(radiateur.isAllume() == true); 
		assertEquals(radiateur.allumer(), false);  
	}
	
	@Test
	void testAllumerFalse() {
		Radiateur radiateur = new Radiateur("Atlantic", "Electrique", false);
		assertTrue(radiateur.isAllume() == false); 
		assertEquals(radiateur.allumer(), true);  
		assertTrue(radiateur.isAllume() == true); 
		assertEquals(radiateur.allumer(), false);  
		assertEquals(radiateur.eteindre(), true);   
		assertTrue(radiateur.isAllume() == false); 
		assertEquals(radiateur.eteindre(), false);   
		assertEquals(radiateur.allumer(), true);  
		assertTrue(radiateur.isAllume() == true); 
	}
	
	@Test
	void testEteindre() {
		Radiateur radiateur = new Radiateur("Atlantic", "Electrique");
		assertTrue(radiateur.isAllume() == false); 
		assertEquals(radiateur.eteindre(), false);
		assertEquals(radiateur.allumer(), true);
		assertTrue(radiateur.isAllume() == true); 
		assertEquals(radiateur.eteindre(), true);
		assertTrue(radiateur.isAllume() == false); 
		assertEquals(radiateur.eteindre(), false);
	}
	
	@Test
	void testEteindreAllumerTrue() {
		Radiateur radiateur = new Radiateur("Atlantic", "Electrique", true);
		assertTrue(radiateur.isAllume() == true); 
		assertEquals(radiateur.eteindre(), true);
		assertTrue(radiateur.isAllume() == false); 
		assertEquals(radiateur.eteindre(), false);
		assertEquals(radiateur.allumer(), true);
		assertTrue(radiateur.isAllume() == true); 
		assertEquals(radiateur.eteindre(), true);
		assertTrue(radiateur.isAllume() == false); 
		assertEquals(radiateur.eteindre(), false);
	}
	
	@Test
	void testEteindreAllumerFalse() {
		Radiateur radiateur = new Radiateur("Atlantic", "Electrique", false);
		assertTrue(radiateur.isAllume() == false); 
		assertEquals(radiateur.eteindre(), false); 
		assertEquals(radiateur.allumer(), true);
		assertTrue(radiateur.isAllume() == true); 
		assertEquals(radiateur.eteindre(), true);
		assertTrue(radiateur.isAllume() == false); 
		assertEquals(radiateur.eteindre(), false);
	}

}
