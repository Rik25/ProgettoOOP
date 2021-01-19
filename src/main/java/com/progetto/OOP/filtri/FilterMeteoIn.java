package com.progetto.OOP.filtri;

import com.progetto.OOP.model.Record;
import com.progetto.OOP.other.Filtro;
import com.progetto.OOP.other.FiltroString;

/** Rappresenta la classe che implemeta il filtro per il campo meteo
 * con operatore: "corrisponde a"
 * @author Riccardo Iobbi
 * @author Lorenzo Benenchia
*/


public class FilterMeteoIn extends FiltroString implements Filtro {
	
	public FilterMeteoIn(Object parametri) {
		super(parametri);
	}
	
	public boolean filtra(Record record) {
		
		for(String s : param) {
			if(record.getMeteo().equals(s)) {
				return true;
			}
		}
		return false;
	}

}
