package com.progetto.OOP.filtri;

import com.progetto.OOP.model.Record;
import com.progetto.OOP.other.Filtro;
import com.progetto.OOP.other.FiltroDoppio;

/** Rappresenta la classe che implemeta il filtro per il campo Temp
 * con operatore: "non incluso tra" 
 * @author Riccardo Iobbi
 * @author Lorenzo Benenchia
*/
public class FilterTempNotIncluded  extends FiltroDoppio implements Filtro{
	
	public FilterTempNotIncluded(Object parametri) {
		super(parametri);
	}
	
	public boolean filtra(Record record) {
		if(record.getTemp() <= parametro1 || record.getTemp() >= parametro2)
			return true;
		else
			return false;
	}

}
