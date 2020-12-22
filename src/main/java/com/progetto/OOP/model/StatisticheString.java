package com.progetto.OOP.model;

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
