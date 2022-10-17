package main.java.chaineSimple;
/**
 * Représente une liste simplement chainée 
 * par une valeur et une le maillon suivant
 * 
 * @author mohamed.mellouky
 * @version 0.1.0
 *
 */
public class ChaineSimple<E> {
	private E valeur ; 
	private ChaineSimple<E> suivant; 
	
	/**
	 * Permet de construire une chaine simple 
	 * à partir d'une valeur et le noeaud suivant. Le noeud 
	 * suivant peut etre une valeur null, dans ce cas, la chaine actuelle 
	 * représentera la fin de la chaine simple. 
	 *
	 * @param valeur : la valeur du la chaine courante.
	 * @param suivant : une réference vers la chaine suivante. 
	 */
	public ChaineSimple(E valeur, ChaineSimple<E> suivant) {
		this.valeur = valeur; 
		this.suivant = suivant; 
	}
	
	/**
	 * Permet de construire une chaine simple à partir
	 * seulement d'une valeur, la chaine suivante est
	 * automatiquement null. 
	 *
	 * @param valeur : la valeur de la chaine courante. 
	 */
	public ChaineSimple(E valeur ) {
		this(valeur, null); 
	}
	
	/**
	 * une version iterative de la méthode toString. 
	 * 
	 * @return une chaine de caractaire représentant la chaine
	 * simple. e.g la liste 2 -> 3 -> 7 est affichée de cette facon : 
	 * ( 2, 3, 7 )
	 */
	@Override
	public String toString() {
		String resultat = "( "; 
		for(ChaineSimple<E> courante = this; courante != null; courante = courante.suivant ) {
			resultat = courante.valeur + (courante.suivant == null ? " )" : ", ") ;
		}
		return resultat; 
	}
	
	/**
	 * Permet d'ajouter un element dans la chaine simple
	 * juste aprés le premier élément de la chaine. 
	 * 
	 * @param valeur : la valeur à ajouter.
	 * @return une nouvelle chaine simple, son début c'est l'élément 
	 * juste inséré. 
	 */
	public ChaineSimple<E> insererElementSuivant(E valeur){
		ChaineSimple<E> resultat = new ChaineSimple<>(valeur);
		resultat.suivant = this.suivant; 
		this.suivant = resultat; 
		return resultat; 
	}
	
	/**
	 * Permet de supprimer l'élément suivant le debut 
	 * de la chaine simple.
	 *
	 * @return une chaine simple réduite à un seule élément, celui supprimé. 
	 */
	public ChaineSimple<E> supprimerElementSuivant(){
		return null; // Pas encore implémentée.
	}
	
	/**
	 * Permet de verifier l'égalité de deux chaine simple.
	 * Une chaine simple égale une autre chaine simple o, 
	 * si et seulement s'elles ont les memes valeur, ou bien 
	 * elles désignent la meme chaine. 
	 * 
	 * @param o : la deuxième chaine avec laquelle on veut comparer. 
	 * @return true si les deux chaines sont égales.
	 * 			false sinon, ou bien si la chaine o est null. 
	 */
	public boolean equals(Object o) {
		if(o == null) return false; 
		if(this == o) return false; 
		if(!( o instanceof ChaineSimple)) return false; 
		ChaineSimple<E> temp = (ChaineSimple<E>) o ; 
		for(ChaineSimple<E> courent = this, oCourent = temp; courent != null, || oCourent != null; courent = courent.suivant) {
			if(courent.valeur != oCourent.valeur) return false; 
		}
		return true; 
	}
	
}
