package com.progetto.OOP.filtri;

import com.progetto.OOP.model.Record;
import com.progetto.OOP.other.Filtro;
import com.progetto.OOP.other.FiltroDoppio;

/** Rappresenta la classe che implemeta il filtro per il campo Perc
 * con operatore: "incluso tra" 
 * @author Riccardo Iobbi
 * @author Lorenzo Benenchia
*/
public class FilterPercIncluded extends FiltroDoppio implements Filtro {
	
	public FilterPercIncluded(Object parametri) {
		super(parametri);
	}
	
	public boolean filtra(Record record) {
		if(record.getPerc() >= parametro1 && record.getPerc() <= parametro2)
			return true;
		else
			return false;
	}

}
