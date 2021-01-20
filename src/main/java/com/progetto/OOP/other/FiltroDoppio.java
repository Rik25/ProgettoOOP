package com.progetto.OOP.other;

import java.util.ArrayList;
/**
 * Superclasse per i filtri che utilizzano due double
 * @author Riccardo Iobbi
 *@author Lorenzo Benenchia
 */
public class FiltroDoppio {
	
	protected double parametro1;
	protected double parametro2;
	
	/** Costruttore 
	 * @param parametri deve essere un ArrayList di Double di lunghezza 2.
	 * @throws IllegalArgumentException parametri non è del tipo richiesto. 
	*/
	
	public FiltroDoppio(Object parametri){

		if(parametri instanceof ArrayList<?>) {
				
			if( ((ArrayList<?>) parametri).size() != 2) {
				throw new IndexOutOfBoundsException("2 Double ") ;
			}
												
			if(((ArrayList<?>) parametri).get(0) instanceof Double) {
				parametro1 = (double) ((ArrayList<?>) parametri).get(0) ;
			}
			else {
				throw new IllegalArgumentException("Type: Double ");}
					
			if(((ArrayList<?>) parametri).get(1) instanceof Double) {
				parametro2 = (double) ((ArrayList<?>) parametri).get(1) ;
			}
			else{
				throw new IllegalArgumentException("Type: Double ");}			
					
					
		}else {
			throw new IllegalArgumentException("Type: Array of 2 Double ");
		}
		
		if(parametro2 < parametro1) {
			throw new IllegalArgumentException("Second Double must be greater than the first Double ");
		}
	}
	
	/** Set
	 * @param parametri deve essere un ArrayList di interi di lunghezza 2.
	 * @throws IllegalArgumentException parametri non è del tipo richiesto. 
	*/
	
	public void setParametri (Object parametri) {
		
		if(parametri instanceof ArrayList<?>) {
			
			if( ((ArrayList<?>) parametri).size() != 2) {
				throw new IndexOutOfBoundsException("2 Double ") ;
			} 
												
			if(((ArrayList<?>) parametri).get(0) instanceof Double) {
				parametro1 = (double) ((ArrayList<?>) parametri).get(0) ;
			} 
			else {
				throw new IllegalArgumentException("Type: Double ");}
					
			if(((ArrayList<?>) parametri).get(1) instanceof Integer) {
				parametro2 = (double) ((ArrayList<?>) parametri).get(1) ;
			} 
			else{
				throw new IllegalArgumentException("Type: Double ");}			
					
			
		}else {
			throw new IllegalArgumentException("Type: Array of 2 Double ");
		}
		
		if(parametro2 < parametro1) {
			throw new IllegalArgumentException("Second Double must be greater than the first Double ");
		}
	}
	
	public void setParametro1(double parametro1) {
		this.parametro1 = parametro1;
	}
	
	public void setParametro2(double parametro2) {
		this.parametro2 = parametro2;
	}
	
	public double getParametro1() {
		return parametro1;
	}
	
	public double getParametro2() {
		return parametro2;
	}

}
