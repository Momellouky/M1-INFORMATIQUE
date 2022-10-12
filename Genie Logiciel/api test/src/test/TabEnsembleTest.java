package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ensemble.Comparateur;
import ensemble.ComparateurInteger;
import ensemble.TabEnsemble;

public class TabEnsembleTest {
	//////////////////////////////////
	// Tester la méthode remove 
	/////////////////////////////////
	private TabEnsemble tabAttenduSuppInexistante; 
	private TabEnsemble tabAttenduSuppExistante;
	private TabEnsemble tabAttenduSuppExReduceSize; 
	private TabEnsemble tabAttenduSuppEnsVide; 
	
	private TabEnsemble tabSuppInexistante;
	private TabEnsemble tabSuppExistante;
	private TabEnsemble tabSuppExReduceSize; 
	private TabEnsemble tabSuppEnsVide; 
	//////////////////////////////////
	// Tester la méthode remove 
	/////////////////////////////////
	private TabEnsemble tabMaxEnsVide; 
	private TabEnsemble tabMaxEnsNonVideObjComparable; 
	private TabEnsemble tabMaxEnsNonVideObjNonComparable; 

	@Before
	public void setUp() throws Exception {
		//////////////////////////////////
		// Tester la méthode remove 
		/////////////////////////////////
		this.tabAttenduSuppInexistante = new TabEnsemble(); 
		this.tabAttenduSuppInexistante.add(2);
		this.tabAttenduSuppInexistante.add(5);
		this.tabAttenduSuppInexistante.add(7);
		this.tabAttenduSuppInexistante.add(8);
		
		this.tabAttenduSuppExistante = new TabEnsemble(); 
		this.tabAttenduSuppExistante.add(2);
		this.tabAttenduSuppExistante.add(8);
		this.tabAttenduSuppExistante.add(7);
		
		this.tabAttenduSuppExReduceSize = new TabEnsemble(); 
		this.tabAttenduSuppExReduceSize.add(2);
		this.tabAttenduSuppExReduceSize.add(6);
		this.tabAttenduSuppExReduceSize.add(3);
		this.tabAttenduSuppExReduceSize.add(2);
		this.tabAttenduSuppExReduceSize.add(5);
		
		this.tabAttenduSuppEnsVide = new TabEnsemble(); 
		
		// Tableau du tests
		
		this.tabSuppInexistante = new TabEnsemble(); 
		this.tabSuppInexistante.add(2);
		this.tabSuppInexistante.add(5);
		this.tabSuppInexistante.add(7);
		this.tabSuppInexistante.add(8);
		
		this.tabSuppExistante = new TabEnsemble(); 
		this.tabSuppExistante.add(2);
		this.tabSuppExistante.add(5);
		this.tabSuppExistante.add(7);
		this.tabSuppExistante.add(8);
		
		this.tabSuppExReduceSize = new TabEnsemble(); 
		this.tabSuppExReduceSize.add(2);
		this.tabSuppExReduceSize.add(10);
		this.tabSuppExReduceSize.add(3);
		this.tabSuppExReduceSize.add(2);
		this.tabSuppExReduceSize.add(5);
		this.tabSuppExReduceSize.add(6);
		
		this.tabSuppEnsVide = new TabEnsemble(); 
		//////////////////////////////////
		// Tester la méthode max 
		/////////////////////////////////
		this.tabMaxEnsVide = new TabEnsemble(); 
		
		this.tabMaxEnsNonVideObjComparable = new TabEnsemble(); 
		this.tabMaxEnsNonVideObjComparable.add(10); 
		this.tabMaxEnsNonVideObjComparable.add(15);  
		this.tabMaxEnsNonVideObjComparable.add(5); 
		this.tabMaxEnsNonVideObjComparable.add(40); 
		this.tabMaxEnsNonVideObjComparable.add(0); 
		this.tabMaxEnsNonVideObjComparable.add(3); 
		
		this.tabMaxEnsNonVideObjNonComparable = new TabEnsemble(); 
		this.tabMaxEnsNonVideObjNonComparable.add(10);
		this.tabMaxEnsNonVideObjNonComparable.add("maitre");
		
		

	}
	
	///////////////////////////////////
	// Test de la méthode remove
	///////////////////////////////////
	
	@Test
	public void testRemoveInexistante() {
		this.tabSuppInexistante.remove(13);
		assertEquals(tabSuppInexistante.equals(tabAttenduSuppInexistante), true);
	}
	
	@Test 
	public void testRemoveExistante() {
		this.tabSuppExistante.remove(5);
		assertEquals(this.tabSuppExistante.equals(tabAttenduSuppExistante), true); 
	}
	
	@Test 
	public void testRemoveReduceSize() {
		this.tabSuppExReduceSize.remove(10);
		assertEquals(this.tabSuppExReduceSize.equals(tabAttenduSuppExReduceSize), true); 
		assertTrue(this.tabAttenduSuppExReduceSize.getLength() == this.tabSuppExReduceSize.getLength()); 
	}
	
	@Test 
	public void testRemoveDansEnsembleVide() {
		this.tabSuppEnsVide.remove(10);
		assertEquals(this.tabSuppEnsVide.equals(tabAttenduSuppEnsVide), true); 
	}
	
	///////////////////////////////////
	// Test de la méthode remove
	///////////////////////////////////
	
	@Test 
	public void testMaxEnsVide() {
		Comparateur c = new ComparateurInteger(); 
		assertEquals(this.tabMaxEnsVide.max(c), null); 
	}
	
	@Test 
	public void testMaxEnsNonVideObjectComparable() {
		Comparateur c = new ComparateurInteger(); 
		assertEquals(this.tabMaxEnsNonVideObjComparable.max(c), 40); 
	}
	
	@Test 
	public void testMaxEnsNonVideObjectNonComparable() {
		Comparateur c = new ComparateurInteger(); 
		assertEquals(this.tabMaxEnsNonVideObjNonComparable.max(c), null); 
	}
}
