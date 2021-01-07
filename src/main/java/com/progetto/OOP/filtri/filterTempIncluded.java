package com.progetto.OOP.filtri;

import com.progetto.OOP.model.Record;
import com.progetto.OOP.other.Filtro;
import com.progetto.OOP.other.FiltroDoppio;

/** Rappresenta la classe che implemeta il filtro per il campo Temp
 * con operatore: "incluso tra" 
 * @author Riccardo Iobbi
 * @author Lorenzo Benenchia
*/

public class filterTempIncluded extends FiltroDoppio implements Filtro{
	
	public filterTempIncluded(Object parametri) {
		super(parametri);
	}
	
	public boolean filtra(Record record) {
		
		if (record.getTemp() >= parametro1 && record.getTemp() <= parametro2)
			return true;
		else
			return false;
	}
	
}
