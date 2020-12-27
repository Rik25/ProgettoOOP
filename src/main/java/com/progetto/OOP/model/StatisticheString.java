package com.progetto.OOP.model;

/** Rappresenta la classe i cui oggetti sono la risposta 
 * alla richiesta Statistiche su valori String.
 * @author Riccardo Iobbi
 * @author Lorenzo Benenchia
*/

public class StatisticheString extends Statistiche {
	int percentuale;
	int contatore;
	
	public StatisticheString() {
		super();
	}
	
	public StatisticheString(String field, int percentuale, int contatore) {
		super (field);
		this.percentuale=percentuale;
		this.contatore=contatore;
	}
	
	public int GetPercentuale() {
		return percentuale;
	}
	public void SetPercentuale(int percentuale) {
		this.percentuale=percentuale;
	}
	public int GetContatore() {
		return contatore;
	}
	public void SetContatore(int contatore) {
		this.contatore=contatore;
	}

}
