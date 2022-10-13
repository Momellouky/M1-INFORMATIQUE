package test.java.hotel;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.hotel.Chambre;
import main.java.hotel.Hotel;

class HotelTest {
	
	private static Hotel hotelPourTest; 
	private final String messageErreurAttendu = new String("L'hotel doit contenir au moins deux chambres"); 
	private final boolean HotelCreer = true; 
	private final boolean erreurDeclanche = true;  
	
	@BeforeEach
	public void setUp() throws Exception{
		if(HotelTest.hotelPourTest == null) {
			hotelPourTest = makeHotel(); 
		}
	}
	
	@Test
	void testHotel() {
		HashMap<Integer, Chambre> chambres = new HashMap<>(); 
		chambres.put(3,Chambre.creer(3)); 
		try {
			Hotel h = new Hotel("Sofia", chambres); 
			assertTrue(!HotelCreer); // L'hotel accepte au mois deux chambres 
		}catch(Error er) {
			if(er.getMessage().equals(messageErreurAttendu)) {
				assertTrue(erreurDeclanche); 
			}else {
				assertTrue(!erreurDeclanche);
			}
		}
		chambres.put(4, Chambre.creer(4));
		try {
			Hotel h = new Hotel("Sofia", chambres); 
			assertTrue(HotelCreer); 
		}catch(Error er) {
			assertTrue(!HotelCreer);	
		}
		try {
			Hotel h = new Hotel("Sofia", null); 
			assertTrue(!HotelCreer); 
		}catch(Error er) {
			if(er.getMessage().equals(messageErreurAttendu)) {
				assertTrue(erreurDeclanche); 
			}else {
				assertTrue(!erreurDeclanche);
			}
		}
		
	}
	
	@Test
	public void testAjouter() {
		//Hotel hotelPourTest = makeHotel(); // permet de créer un hotel avec deux chambre dedans
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
	
	@Test
	public void testModifierChambreExiste() {
		int ancienNumeroChambre = 6; // chambre numero 2 existe déjà dans l'hotel.
		int nouveauNumeroChambre = 7; 
		assertTrue(HotelTest.hotelPourTest.modifier(ancienNumeroChambre, nouveauNumeroChambre)); 
	}
	
	@Test
	public void testModifierChambreNonExistante() {
		int numeroChambreNonExistante = -300;
		int numeroNouvelleChambre = 10; 
		assertEquals(HotelTest.hotelPourTest.modifier(numeroChambreNonExistante, numeroNouvelleChambre), false); 
	}
	
	@Test
	public void testModifierChambreNouveauNumExiste() {
		int ancienNumeroChambre = 2; 
		int nouveauNumeroChambre = 1; // Chambre numero 1 on sait qu'elle existe déjà
		assertEquals(HotelTest.hotelPourTest.modifier(ancienNumeroChambre, nouveauNumeroChambre), false); 
	}
	
	@Test
	public void testSupprimerChambreExiste() {
		// Pour ne pas affecter les autres tests, on ajoute dans la liste 
		// la chambre à supprimer
		HotelTest.hotelPourTest.ajouter(Chambre.creer(7)); 
		int numeroChambreSupprimer = 7; // On est sur que la chambre numero 1 existe. 
		// Il faudra avoir une liste attendu des chambres. 
		// Le fait d'avoir la liste des chambres de la classe Chambre 
		// déclarée de facon statique empeche la création d'une liste attendu. 
		// Par contre, on peut récuperer la taille de la liste des chambres 
		// de l'hotel et comparer la taille avant et après la suppréssion
		int tailleAvantSuppression = HotelTest.hotelPourTest.getChambresHotel().size(); 
		assertEquals(HotelTest.hotelPourTest.supprimer(numeroChambreSupprimer), true); 
		int tailleApresSuppression = HotelTest.hotelPourTest.getChambresHotel().size(); 
		assertEquals(tailleAvantSuppression - tailleApresSuppression, 1); 
	}
	
	@Test 
	public void testSupprimerChambreInexistante() {
		int numeroChambreSupprimer = -100; 
		assertEquals(HotelTest.hotelPourTest.supprimer(numeroChambreSupprimer), false); 
	}
	
	private Hotel makeHotel() {
		HashMap<Integer, Chambre> chambres = new HashMap<>(); 
		Hotel hotel = null;
		chambres.put(1, Chambre.creer(1));
		chambres.put(2, Chambre.creer(2)); 
		chambres.put(6, Chambre.creer(6)); 
		try {
			hotel = new Hotel("Sofia", chambres); 
		}catch(Error er) {
			er.printStackTrace();
		}
		return hotel; 
	}
	
	private String messageChambreDejaExiste(int numeroChambre) {
		return "La chambre numero " + numeroChambre + " existe déjà"; 
	}
	
}
