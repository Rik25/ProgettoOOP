package com.progetto.OOP.filtri;

import com.progetto.OOP.model.Record;
import com.progetto.OOP.other.Filtro;
import com.progetto.OOP.other.FiltroDoppio;

/** Rappresenta la classe che implemeta il filtro per il campo temp_min
 * con operatore: "non incluso tra" 
 * @author Riccardo Iobbi
 * @author Lorenzo Benenchia
*/

public class filterTempMinNotIncluded extends FiltroDoppio implements Filtro {
	
	public filterTempMinNotIncluded(Object parametri) {
		super(parametri);
	}
	
	public boolean filtra(Record record) {
		if(record.getT_min() <= parametro1 || record.getT_min() >= parametro2)
			return true;
		else
			return false;
	}

}
