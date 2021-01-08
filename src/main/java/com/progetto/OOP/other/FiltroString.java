package com.progetto.OOP.other;

import java.util.ArrayList;

/**
 * Rappresenta la superclasse per i filtri che lavorano su stringhe
 * @author Riccardo Iobbi
 * @author Lorenzo Benenchia
 */

public class FiltroString {
	
	protected ArrayList<String> param = new ArrayList<String>();
	
	/**
	 * Costruttore classe
	 * @param parametri deve essere arraylist di String.
	 * @throws IllegalArgumentException parametri non è del tipo richiesto.
	 */
	
	public FiltroString(Object parametri) {

		if(parametri instanceof ArrayList<?>) {
			
			for(Object elemento : (ArrayList<?>)parametri) {
				
				if(elemento instanceof String) {
					param.add((String)elemento);
				}
				else {
					throw new IllegalArgumentException("Type: String ");
				}
			}

		}
		else {			
			throw new IllegalArgumentException("Type: Array ");
		}
	}
	
	/**
	 * Set
	 * @param parametri deve essere arraylist di String.
	 * @throws IllegalArgumentException parametri non è del tipo richiesto.
	 */
	
	public void setParam(Object parametri) {
		
		if(parametri instanceof ArrayList<?>) {
			
			for(Object elemento : (ArrayList<?>)parametri) {
				
				if(elemento instanceof String) {
					param.add((String)elemento);
				}
				else {
					throw new IllegalArgumentException("Type: String ");
				}
			}

		}
		else {			
			throw new IllegalArgumentException("Type: Array ");
		}
	}

}
