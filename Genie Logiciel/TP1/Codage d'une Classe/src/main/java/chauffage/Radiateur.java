package main.java.chauffage;
/**
 * Represente un radiateur caractairis� par son nom, son type
 * et son �tat (allum� ou eteint). 
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
	 * Construit un radiateur �teint � partir de son nom et de son type.
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
	 * Construit un radiateur � partir de son nom et de son type.
	 * L'�tat du radiateur est d�finie par l'utilisateur � travers 
	 * le boolean <b>allume</b>.
	 * 
	 * @param nom : le nom du radiateur.
	 * @param type : le type du radiateur. 
	 * @param allume : L'�tat du radiateur.
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
	 * @return true si le radiateur est allum�.
	 * 		   false sinon. 
	 */
	public boolean isAllume() {
		return allume;
	}
	
	/**
	 * Permet d'allumer un radiateur �teint.
	 * 
	 * @return <b>true</b> si la m�thode allume le radiateur �teint. 
	 * 		   <b>false</b> si le radiateur est d�ja allum�.
	 */
	public boolean allumer() {
		if(this.isAllume() == true) return false; 
		this.allume = true; 
		return true; 
	}
	
	/**
	 * Permet d'eteindre un radiateur allum�.
	 * 
	 * @return <b>true</b> si la m�thode eteint le radiateur allum�. 
	 * 		   <b>false</b> si le radiateur est d�ja eteint.
	 */
	public boolean eteindre() {
		if(this.isAllume() == false) return false; 
		this.allume = false; 
		return true; 
	}
	
}
