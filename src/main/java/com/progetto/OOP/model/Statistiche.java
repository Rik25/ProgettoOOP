package com.progetto.OOP.model;

/**Questa è la superclasse contente il campo del quale
 * calcolare le statistiche.
 * @author Lorenzo Benenchia
 * @author Riccardo Iobbi
 */
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
