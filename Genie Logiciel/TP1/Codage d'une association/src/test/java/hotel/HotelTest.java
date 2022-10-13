package test.java.hotel;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import main.java.hotel.Chambre;
import main.java.hotel.Hotel;

class HotelTest {
	
	private Hotel hotelPourTest; 
	private final String messageErreurAttendu = new String("L'hotel doit contenir au moins deux chambres"); 
	private final boolean chambreCreer = true; 
	private final boolean erreurDeclanche = true;  
	
	@Before
	void setUp() {
		hotelPourTest = makeHotel(); // permet de créer un hotel avec deux chambre dedans
	}
	@Test
	void testHotel() {
		HashMap<Integer, Chambre> chambres = new HashMap<>(); 
		chambres.put(1,Chambre.creer(1)); 
		try {
			Hotel h = new Hotel("Sofia", chambres); 
			assertTrue(!chambreCreer); 
		}catch(Error er) {
			if(er.getMessage().equals(messageErreurAttendu)) {
				assertTrue(erreurDeclanche); 
			}else {
				assertTrue(!erreurDeclanche);
			}
		}
		chambres.put(2, Chambre.creer(2));
		try {
			Hotel h = new Hotel("Sofia", chambres); 
			assertTrue(chambreCreer); 
		}catch(Error er) {
			assertTrue(!chambreCreer);	
		}
		try {
			Hotel h = new Hotel("Sofia", null); 
			assertTrue(!chambreCreer); 
		}catch(Error er) {
			if(er.getMessage().equals(messageErreurAttendu)) {
				assertTrue(erreurDeclanche); 
			}else {
				assertTrue(!erreurDeclanche);
			}
		}
		
	}
	
	@Test
	void testAjouter() {
		if(hotelPourTest != null) {
			assertTrue(hotelPourTest.ajouter(Chambre.creer(5))); 
			// tester si la chambre est vraiment ajout�e
			try {
				assertTrue(hotelPourTest.ajouter(Chambre.creer(5))); 
				assertTrue(false); 
			}catch(Error er) {
				if(er.getMessage().equals(this.messageChambreDejaExiste(5))) {
					assertTrue(erreurDeclanche); 
				}else {
					System.out.println("Message d'erreur: " + er.getMessage());
					assertTrue(!erreurDeclanche); 
				}
			}
			//Tester l'ajout d'une valeur null
			assertTrue(hotelPourTest.ajouter(null) == false); 						
		}
	}
	
	private Hotel makeHotel() {
		HashMap<Integer, Chambre> chambres = new HashMap<>(); 
		chambres.put(3, Chambre.creer(3));
		chambres.put(4, Chambre.creer(4)); 
		try {
			Hotel hotel = new Hotel("Sofia", chambres); 
			return hotel; 
		}catch(Error er) {
			er.printStackTrace();
		}
		return null; 
	}
	
	private String messageChambreDejaExiste(int numeroChambre) {
		return "La chambre numero " + numeroChambre + " existe déjà"; 
	}
	
}
