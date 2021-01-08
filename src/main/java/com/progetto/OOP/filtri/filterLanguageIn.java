package com.progetto.OOP.filtri;

import com.progetto.OOP.model.Record;
import com.progetto.OOP.other.Filtro;
import com.progetto.OOP.other.FiltroString;

/** Rappresenta la classe che implemeta il filtro per il campo language
 * con operatore: "corrisponde a"
 * @author Riccardo Iobbi
 * @author Lorenzo Benenchia
*/

public class filterLanguageIn extends FiltroString implements Filtro {
	
	public filterLanguageIn(Object parametri) {
		super(parametri);
	}
	
	public boolean filtra(Record record) {
		
		for(String s : param) {
			if(record.getLingua().equals(s)) {
				return true;
			}
		}
		return false;
	}

}
