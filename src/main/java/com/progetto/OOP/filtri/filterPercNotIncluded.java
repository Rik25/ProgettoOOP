package com.progetto.OOP.filtri;

import com.progetto.OOP.model.Record;
import com.progetto.OOP.other.Filtro;
import com.progetto.OOP.other.FiltroDoppio;

/** Rappresenta la classe che implemeta il filtro per il campo Perc
 * con operatore: "non incluso tra" 
 * @author Riccardo Iobbi
 * @author Lorenzo Benenchia
*/

public class filterPercNotIncluded extends FiltroDoppio implements Filtro {
	
	public filterPercNotIncluded(Object parametri) {
		super(parametri);
	}
	
	public boolean filtra(Record record) {
		if(record.getPerc() <= parametro1 || record.getPerc() >= parametro2)
			return true;
		else
			return false;
	}

}
