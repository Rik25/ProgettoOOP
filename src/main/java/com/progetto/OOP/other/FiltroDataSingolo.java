package com.progetto.OOP.other;

import java.util.Date;

/**
 * Rappresenta la superclasse per filtri che lavorano su double
 * @author Riccardo Iobbi
 * @author Lorenzo Benenchia
 */

public class FiltroDataSingolo {
	
	protected Date parametro;
	
	/**
	 * Costruttore della classe.
	 * @param parametro che deve essere di tipo Date.
	 * @throws IllegalArgumentException se il parametro non è del tipo richiesto.
	 */
	
	public FiltroDataSingolo(Object parametro) {
		
		if(parametro instanceof Date)
		{
			this.parametro = (Date) parametro;
		}
		else {
			throw new IllegalArgumentException("Type: Date ");
		}
	}
	/**
	 * set
	 * @param parametro
	 */
	public void setParametro(Object parametro) {
		
		if(parametro instanceof Date)
		{
			this.parametro = (Date) parametro;
		}
		else {
			throw new IllegalArgumentException("Type: Date ");
		}
	}
	/**
	 * get
	 * @return parametro
	 */
	public Date getParametro() {
		return parametro;
	}

}
