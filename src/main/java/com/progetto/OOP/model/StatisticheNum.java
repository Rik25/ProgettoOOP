package com.progetto.OOP.model;

/** Rappresenta la classe i cui oggetti sono la risposta 
 * alla richiesta Statistiche su valori numerici.
 * @author Lorenzo Benenchia
 * @author Riccardo Iobbi
*/

public class StatisticheNum extends Statistiche{
	
	public double media;
	public double minima;
	public double massima;
	public double varianza;
	
	public StatisticheNum() {
		super();
	}
	
	public StatisticheNum(String field, double media, double minima, double massima, double varianza) {
		
		super (field);
		this.media=media;
		this.minima=minima;
		this.massima=massima;
		this.varianza=varianza;
		
	}
	
	public double GetMedia() {
		return media;
	}
	public void SetMedia(double media) {
		this.media=media;	
	}
	public double GetMinima() {
		return minima;
	}
	public void SetMinima(double minima) {
		this.minima=minima;
	}
	public double GetMassima() {
		return massima;
	}
	public void SetMassima(double massima) {
		this.massima=massima;
	}
	public double GetVarianza() {
		return varianza;
	}
	public void SetVarianza(double varianza) {
		this.varianza=varianza;
	}
}
