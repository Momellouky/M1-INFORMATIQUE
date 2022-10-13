package main.java.hotel;

import java.util.HashSet;
import java.util.Set;

/**
 * Représente une chambre caractérisée par son nom. 
 * @author Mohamed Mellouky. Relecture par Ayoub QUAMAR. 
 *
 */
public class Chambre {
	protected int numeroChambre; 
	private static Set<Integer> chambresExistantes = new HashSet<>();  
	
	/**
	 * Permet d'initialiser les champs de la classe chambre. 
	 * 
	 * @param numeroChambre : représente le numero de la chambre
	 */
	private Chambre(int numeroChambre) {
		this.numeroChambre = numeroChambre; 
		chambresExistantes.add(this.numeroChambre);  
	}
	
	/**
	 * Permet de créer une chambre à partir de numero de chambre. Si le numero 
	 * de chambre fournit à la méthode est associé à une autre chambre, qui existe déjà 
	 * dans la liste des chambres. La création s'arrete avec l'affichage d'un message d'erreur.
	 * 
	 * @param numeroChambre : Le numero de la chambre. 
	 * @return un objet de la classe chambre qui représente la chambre créee.
	 * @throws Error : erreur au cas où le numero de la chambre fournit dans les 
	 * arguments est déjà associé à une autre chambre qui existe déjà dans liste des chambres.
	 */
	public static Chambre creer(int numeroChambre) {
		if(chambresExistantes.contains(numeroChambre))
			throw new Error("La chambre numero " + numeroChambre + " existe déjà"); 
		return new Chambre(numeroChambre);  
	}
	
	/**
	 * Permet de récuperer le numero de chambre associé à l'objet receveur.
	 *
	 * @return Le numero de la chambre sous forme d'objet de la classe Integer.
	 */
	public Integer getNumeroChambre() {
		return this.numeroChambre; 
	}
	
	/**
	 * Permet de donner une valeur au numero de chambre associé à l'objet receveur.
	 *
	 * @param numeroChambre : le numero de la chambre qu'on veut chercher.
	 */
	public void setNumeroChambre(int numeroChambre) {
		this.numeroChambre = numeroChambre; 
	}

	
}
