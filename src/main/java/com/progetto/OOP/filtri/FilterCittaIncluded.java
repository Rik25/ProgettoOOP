package com.progetto.OOP.filtri;

import com.progetto.OOP.model.Record;
import com.progetto.OOP.other.Filtro;
import com.progetto.OOP.other.FiltroString;

/** Rappresenta la classe che implemeta il filtro per il campo citta
 * con operatore: "corrisponde a"
 * @author Riccardo Iobbi
 * @author Lorenzo Benenchia
*/

public class FilterCittaIncluded extends FiltroString implements Filtro {
	
	public FilterCittaIncluded(Object parametri) {
		super(parametri);
	}
	
	public boolean filtra(Record record) {
		
		for(String s : param) {
			if(record.getCitta().equals(s)) {
				return true;
			}
		}
		return false;
	}

}
