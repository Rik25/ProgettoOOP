package com.progetto.OOP.model;

public class Statistiche {
	public String field;
	
	public Statistiche() {}
	
	public Statistiche(String field) {
		this.field=field;
	}
	public String GetField() {
		return field;
	}
	public void SetField(String field) {
		this.field=field;
	}
}
