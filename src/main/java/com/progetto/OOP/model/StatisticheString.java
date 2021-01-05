package com.progetto.OOP.model;

import java.util.HashMap;

/** Rappresenta la classe i cui oggetti sono la risposta 
 * alla richiesta Statistiche su valori String.
 * @author Riccardo Iobbi
 * @author Lorenzo Benenchia
*/

public class StatisticheString extends Statistiche {
	HashMap<String,Integer> stats = new HashMap<String, Integer>();
	
	public StatisticheString() {
		super();
	}
	
	public StatisticheString(String field, HashMap<String,Integer> stats) {
		super (field);
		this.stats=stats;
	}
	
	public HashMap<String, Integer> GetStats() {
		return stats;
	}
	public void SetStats(HashMap<String,Integer>stats) {
		this.stats=stats;
	}

}	
