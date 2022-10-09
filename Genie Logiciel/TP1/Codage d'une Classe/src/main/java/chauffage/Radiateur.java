package main.java.chauffage;
/**
 * Represente un radiateur caractairisé par son nom, son type
 * et son état (allumé ou eteint). 
 *
 * @author mohamed.mellouky. Relecture par Ayoub Quamar.
 * @version 0.1.0
 * 
 */
public class Radiateur {
	protected String nom; 
	protected String type; 
	protected boolean allume; 
	
	/**
	 * Construit un radiateur éteint à partir de son nom et de son type.
	 * 
	 * @param nom le nom du radiateur.
	 * @param type le type du radiateur.
	 */
	public Radiateur(String nom, String type) {
		this.nom = nom; 
		this.type = type; 
		this.allume = false; 
	}

	/**
	 * Construit un radiateur à partir de son nom et de son type.
	 * L'état du radiateur est définie par l'utilisateur à travers 
	 * le boolean <b>allume</b>.
	 * 
	 * @param nom : le nom du radiateur.
	 * @param type : le type du radiateur. 
	 * @param allume : L'état du radiateur.
	 */
	public Radiateur(String nom, String type, boolean allume) {
		this.nom = nom; 
		this.type = type; 
		this.allume = allume; 
	}
	/**
	 * @return le nom du radiateur.
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * @param nom : le nom du radiateur.
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * @return le type du radiateur
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * @param type : le type du radiateur.
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * @return true si le radiateur est allumé.
	 * 		   false sinon. 
	 */
	public boolean isAllume() {
		return allume;
	}
	
	/**
	 * Permet d'allumer un radiateur éteint.
	 * 
	 * @return <b>true</b> si la méthode allume le radiateur éteint. 
	 * 		   <b>false</b> si le radiateur est déja allumé.
	 */
	public boolean allumer() {
		if(this.isAllume() == true) return false; 
		this.allume = true; 
		return true; 
	}
	
	/**
	 * Permet d'eteindre un radiateur allumé.
	 * 
	 * @return <b>true</b> si la méthode eteint le radiateur allumé. 
	 * 		   <b>false</b> si le radiateur est déja eteint.
	 */
	public boolean eteindre() {
		if(this.isAllume() == false) return false; 
		this.allume = false; 
		return true; 
	}
	
}
