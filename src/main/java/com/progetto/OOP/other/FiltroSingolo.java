package com.progetto.OOP.other;
/**
 * Superclasse per filtri che lavorano su un double.
 * @author Riccardo Iobbi
 * @author Lorenzo Benenchia
 *
 */
public class FiltroSingolo {
	
	protected double parametro;
	/**
	 * Costruttore della classe.
	 * @param parametro che deve essere di tipo Double.
	 * @throws IllegalArgumentException se il parametro non è del tipo richiesto.
	 */
	
	public FiltroSingolo(Object parametro)
	{
		if(parametro instanceof Double)
		{
			this.parametro = (Double) parametro;
		}
		else {
			throw new IllegalArgumentException("Type: Double ");
		}
	}
	
	/** Set
	 * @param parametro che deve essere di tipo Double.
	 * @throws IllegalArgumentException se il parametro non è del tipo richiesto. 
	*/
	public void setParametro(Object parametro) {
		
		if(parametro instanceof Double ) { 
			this.parametro =(Double)parametro;
		}else {
			throw new IllegalArgumentException("Type: Interger ");
		}
	}
	/**
	 * set Overload
	 * @param parametro
	 */
	public void setParametro(double parametro) {
		this.parametro = parametro;
	}
	
	public double getParametro() {
		return parametro;
	}

}
