package com.progetto.OOP.filtri;

import com.progetto.OOP.model.Record;
import com.progetto.OOP.other.Filtro;
import com.progetto.OOP.other.FiltroString;

/** Rappresenta la classe che implemeta il filtro per il campo meteo
 * con operatore: "non corrisponde a"
 * @author Riccardo Iobbi
 * @author Lorenzo Benenchia
*/

public class FilterMeteoNin extends FiltroString implements Filtro {
	
	public FilterMeteoNin(Object parametri) {
		super(parametri);
	}
	
	public boolean filtra(Record record) {
		
		for(String s : param) {
			if(record.getMeteo().equals(s)) {
				return false;
			}
		}
		return true;
	}

}
