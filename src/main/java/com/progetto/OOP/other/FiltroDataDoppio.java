package com.progetto.OOP.other;

import java.util.ArrayList;
import java.util.Date;

/**
 * Superclasse per i filtri che utilizzano due Date
 * @author Riccardo Iobbi
 *@author Lorenzo Benenchia
 */

public class FiltroDataDoppio {
	
	protected Date parametro1;
	protected Date parametro2;
	
	/** Costruttore 
	 * @param parametri deve essere un ArrayList di Date di lunghezza 2.
	 * @throws IllegalArgumentException parametri non è del tipo richiesto. 
	*/
	
	public FiltroDataDoppio(Object parametri) {
		
		if(parametri instanceof ArrayList<?>) {
			
			if( ((ArrayList<?>) parametri).size() != 2) {
				throw new IndexOutOfBoundsException("2 Date ") ;
			}
												
			if(((ArrayList<?>) parametri).get(0) instanceof Date) {
				parametro1 = (Date) ((ArrayList<?>) parametri).get(0) ;
			}
			else {
				throw new IllegalArgumentException("Type: Date ");}
					
			if(((ArrayList<?>) parametri).get(1) instanceof Date) {
				parametro2 = (Date) ((ArrayList<?>) parametri).get(1) ;
			}
			else{
				throw new IllegalArgumentException("Type: Date ");}			
					
					
		}else {
			throw new IllegalArgumentException("Type: Array of 2 Date ");
		}
		
		if(parametro1.before(parametro2)) {
			throw new IllegalArgumentException("Second Date must be after the first Date ");
		}
		
	}
	/**
	 * set parametri
	 * @param parametri
	 */
	public void setParametri(Object parametri) {
		
	if(parametri instanceof ArrayList<?>) {
			
			if( ((ArrayList<?>) parametri).size() != 2) {
				throw new IndexOutOfBoundsException("2 Date ") ;
			}
												
			if(((ArrayList<?>) parametri).get(0) instanceof Date) {
				parametro1 = (Date) ((ArrayList<?>) parametri).get(0) ;
			}
			else {
				throw new IllegalArgumentException("Type: Date ");}
					
			if(((ArrayList<?>) parametri).get(1) instanceof Date) {
				parametro2 = (Date) ((ArrayList<?>) parametri).get(1) ;
			}
			else{
				throw new IllegalArgumentException("Type: Date ");}			
					
					
		}else {
			throw new IllegalArgumentException("Type: Array of 2 Date ");
		}
		
		if(parametro1.before(parametro2)) {
			throw new IllegalArgumentException("Second Date must be after the first Date ");
		}
		
	}
	public Date getParametro1() {
		return parametro1;
	}
	public void setParametro1(Date parametro1) {
		this.parametro1 = parametro1;
	}
	public Date getParametro2() {
		return parametro2;
	}
	public void setParametro2(Date parametro2) {
		this.parametro2 = parametro2;
	}

}
