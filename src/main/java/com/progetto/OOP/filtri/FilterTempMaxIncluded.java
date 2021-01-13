package com.progetto.OOP.filtri;

import com.progetto.OOP.model.Record;
import com.progetto.OOP.other.Filtro;
import com.progetto.OOP.other.FiltroDoppio;

/** Rappresenta la classe che implemeta il filtro per il campo temp_max
 * con operatore: "incluso tra" 
 * @author Riccardo Iobbi
 * @author Lorenzo Benenchia
*/

public class FilterTempMaxIncluded extends FiltroDoppio implements Filtro{
	
	public FilterTempMaxIncluded(Object parametri) {
		super(parametri);
	}
	
	public boolean filtra(Record record) {
		if(record.getT_max() >= parametro1 && record.getT_max() <= parametro2)
			return true;
		else
			return false;
	}

}
