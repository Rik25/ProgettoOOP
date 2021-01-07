package com.progetto.OOP.filtri;

import com.progetto.OOP.model.Record;
import com.progetto.OOP.other.Filtro;
import com.progetto.OOP.other.FiltroSingolo;

/** Rappresenta la classe che implemeta il filtro per il campo temp_min
 * con operatore: "minore di" 
 * @author Riccardo Iobbi
 * @author Lorenzo Benenchia
*/

public class filterTempMinLess extends FiltroSingolo implements Filtro{
	public filterTempMinLess(Object parametro) {
		super(parametro);
	}
	
	public boolean filtra(Record record) {
		if(record.getT_min() < parametro)
			return true;
		else
			return false;
	}

}
