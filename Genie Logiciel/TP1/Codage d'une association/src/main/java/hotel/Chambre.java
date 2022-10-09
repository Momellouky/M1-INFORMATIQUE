package main.java.hotel;

import java.util.HashSet;
import java.util.Set;

public class Chambre {
	protected int numeroChambre; 
	private static Set<Integer> chambresExistantes = new HashSet<>();  
	
	private Chambre(int numeroChambre) {
		this.numeroChambre = numeroChambre; 
		chambresExistantes.add(numeroChambre);  
	}
	
	public static Chambre creer(int numeroChambre) {
		if(chambresExistantes.contains(numeroChambre))
			throw new Error("La chambre numero " + numeroChambre + " existe déjà"); 
		return new Chambre(numeroChambre);  
	}
	
	public Integer getNumeroChambre() {
		return this.numeroChambre; 
	}
	
	public void setNumeroChambre(int numeroChambre) {
		this.numeroChambre = numeroChambre; 
	}

	
}
