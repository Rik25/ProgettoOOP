package com.progetto.OOP.filtri;

import com.progetto.OOP.model.Record;
import com.progetto.OOP.other.Filtro;
import com.progetto.OOP.other.FiltroSingolo;

/** Rappresenta la classe che implemeta il filtro per il campo t_max
 * con operatore: "minore di" 
 * @author Riccardo Iobbi
 * @author Lorenzo Benenchia
*/

public class FilterTMaxLess extends FiltroSingolo implements Filtro {
	
	public FilterTMaxLess(Object parametro) {
		super(parametro);
	}
	
	public boolean filtra(Record record) {
		
		if (record.getT_max() < parametro)
			return true;
		else
			return false;
	}

}
