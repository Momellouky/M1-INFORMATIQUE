package test.java.hotel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import main.java.hotel.Chambre;

class ChambreTest {
	
	private int numeroChambre; 
	private int numeroChambreAttendu;
	
	@Before
	void setup() {
		this.numeroChambre = 1; 
		this.numeroChambreAttendu = numeroChambre; 
	}
	@Test
	void testChambre() {
		
		try {
			Chambre chambre = Chambre.creer(numeroChambre);
			assertTrue(true); 
		}catch(Error er) {
			if(er.getMessage().equals("La chambre numero " + numeroChambreAttendu + " existe déjà")) {
				assertTrue(true);
			}else {
				assertTrue(false); 
			}
		}
		
		try {
			Chambre chambre = Chambre.creer(numeroChambre);
			assertTrue(true); 
		}catch(Error er) {
			if(er.getMessage().equals("La chambre numero " + numeroChambreAttendu + " existe déjà")) {
				assertTrue(true);
			}else {
				assertTrue(false); 
			}
		}
		
	}

}
