package main.java.hotel;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * Repr�sente un hotel caractairis� par son nom et ses chambres.
 *
 * @author Mohamed MELLOUKY. Relecture par Ayoub QUAMAR
 * @version 0.1.0
 *
 */
public class Hotel {
	protected String nom;
	protected HashMap<Integer, Chambre> chambres;
	
	/**
	 * Permet de construire un hotel � partir de son nom, et un ensemble des chambres dont la taille
	 * est supp�rieure ou �gale � 2.
	 *
	 * @param nom :  repr�sente le nom de l'hotel.
	 * @param chambres : repr�sente les chambres d�j� existantes dans l'hotel
	 */
	public Hotel(String nom, HashMap<Integer, Chambre> chambres) {
		if(chambres == null || chambres.size() < 2) {
			throw new Error("L'hotel doit contenir au moins deux chambres");
		}
		this.chambres = new HashMap<>(chambres.size()); 
		this.nom = nom;
		Set<Integer> keysSet = chambres.keySet(); 
		for (Iterator<Integer> it = keysSet.iterator(); it.hasNext(); it.next()) {
			Integer numeroChambreCourant = it.next(); 
			this.chambres.put(numeroChambreCourant, chambres.get(numeroChambreCourant));
		}
	}
	/**
	 * Permet d'ajouter une nouvelle chambre � l'hotel. Il n'y a pas des contraintes sur 
	 * le nombre de chambre � ajouter. Par contre, le numero de la chambre doit etre 
	 * unique � la nouvelle chambre.
	 *
	 * @param nouvelleChambre : repr�sente la nouvelle chambre � ajouter.
	 * @return <b>true</b> si la chambre a �t� bien ajout�e
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
		chambreModifier.setNumeroChambre(nouveauNumero);
		return true;
	}

	public boolean supprimer(int numeroChambre) {
		Chambre chambreSupprimer = this.chercherChambre(numeroChambre); 
		if(chambreSupprimer == null) return false; 
		this.chambres.remove(chambreSupprimer); 
		return false; 
	}

	private Chambre chercherChambre(int numeroChambre) {
		return this.chambres.get(numeroChambre); 
	}
}
