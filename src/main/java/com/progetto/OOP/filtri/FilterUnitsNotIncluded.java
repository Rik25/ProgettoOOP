package com.progetto.OOP.filtri;

import com.progetto.OOP.model.Record;
import com.progetto.OOP.other.Filtro;
import com.progetto.OOP.other.FiltroString;

/** Rappresenta la classe che implemeta il filtro per il campo units
 * con operatore: "corrisponde a"
 * @author Riccardo Iobbi
 * @author Lorenzo Benenchia
*/

public class FilterUnitsNotIncluded extends FiltroString implements Filtro {
	
	public FilterUnitsNotIncluded(Object parametri) {
		super(parametri);
	}
	
	public boolean filtra(Record record) {
		
		for(String s : param) {
			if(record.getUnita().equals(s)) {
				return false;
			}
		}
		return true;
	}
}
