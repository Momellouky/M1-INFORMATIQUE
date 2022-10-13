package main.java.hotel;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * Représente un hotel caractairisé par son nom et ses chambres.
 *
 * @author Mohamed MELLOUKY. Relecture par Ayoub QUAMAR
 * @version 0.1.0
 *
 */
public class Hotel {
	protected String nom;
	protected HashMap<Integer, Chambre> chambres;
	
	/**
	 * Permet de construire un hotel à partir de son nom, et un ensemble des chambres dont la taille
	 * est suppérieure ou égale à 2.
	 *
	 * @param nom :  représente le nom de l'hotel.
	 * @param chambres : représente les chambres déjà existantes dans l'hotel
	 */
	public Hotel(String nom, HashMap<Integer, Chambre> chambres) {
		if(chambres == null || chambres.size() < 2) {
			throw new Error("L'hotel doit contenir au moins deux chambres");
		}
		this.chambres = new HashMap<>(chambres.size()); 
		this.nom = nom;
		Set<Integer> keysSet = chambres.keySet(); 
		for (Iterator<Integer> it = keysSet.iterator(); it.hasNext();) {
			Integer numeroChambreCourant = it.next(); 
			this.chambres.put(numeroChambreCourant, chambres.get(numeroChambreCourant));
		}
	}
	
	/**
	 * Permet de récuperer une copie du nom de l'hotel.
	 * @return nom : une chaine de caractère qui représente le nom de l'hotel.
	 */
	public String getNomHotel() {
		return new String(nom); 
	}
	
	/**
	 * Permet de récuperer une copie de la liste des chambres disponible dans l'hotel.
	 * 
	 * @return La liste des chambres de l'hotel.
	 */
	@SuppressWarnings("unchecked")
	public HashMap<Integer, Chambre> getChambresHotel(){
		return (HashMap<Integer, Chambre>)this.chambres.clone(); 
	}
	
	/**
	 * Permet d'ajouter une nouvelle chambre à l'hotel. Il n'y a pas des contraintes sur 
	 * le nombre de chambre à ajouter. Par contre, le numero de la chambre doit etre 
	 * unique à la nouvelle chambre.
	 *
	 * @param nouvelleChambre : représente la nouvelle chambre à ajouter.
	 * @return <b>true</b> si la chambre a été bien ajoutée
	 * 			<b>false</b> sinon.
	 */
	public boolean ajouter(Chambre nouvelleChambre) {
		if (nouvelleChambre == null)
			return false;
		this.chambres.put(nouvelleChambre.getNumeroChambre(), nouvelleChambre);
		return true;
	}
	
	/**
	 * Permet de modifier le numero d'une chambre déjà existante. 
	 * La méthode ne permet pas de modifier le numero d'une chambre par un nouveau numero 
	 * associé d'une autre chambre déjà existante. 
	 *
	 * @param numeroChambre : représente l'ancien numero de la chambre.
	 * @param nouveauNumero : représente le nouveau numéro de la chambre.
	 * @return <b>true</b> si la modification est éffectuée avec succés
	 * 		<b>false</b> sinon.
	 */
	public boolean modifier(int numeroChambre, int nouveauNumero) {
		Chambre chambreModifier = this.chercherChambre(numeroChambre);
		if (chambreModifier == null) { // si le numero du chambre données ne correspend à aucune chambre.
			return false; 
		}
		if(this.chercherChambre(nouveauNumero) != null) { // Il existe une autre chambre qui porte le nouveau numero données en args.
			return false; 
		}
		chambreModifier.setNumeroChambre(nouveauNumero);
		return true;
	}
	
	/**
	 * Permet de supprimer une chambre de la liste des chambres de l'hotel 
	 * s'elle existe déjà dans cette liste. 
	 *
	 * @param numeroChambre : le numero de la chambre à supprimer
	 * @return <b>true</b> si la suppression est effectuée avec succés
	 * 		<b>false</b> sinon. 
	 */
	public boolean supprimer(int numeroChambre) {
		Object chambreSupprimer = this.chambres.remove(numeroChambre); 
		return chambreSupprimer != null; 
	}

	/**
	 * Permet de verifier l'existance d'une chambre dans la liste des chambres 
	 * de l'hotel.
	 * @param numeroChambre : le numero de la chambre à rechercher.
	 * @return La chambre correspendante à au numero de la chambre fournit en argument. 
	 * 		<b>null</b> si aucune chambre associé au numero de chambre fournit existe. 
	 */
	private Chambre chercherChambre(int numeroChambre) {
		return this.chambres.get(numeroChambre); 
	}
}
