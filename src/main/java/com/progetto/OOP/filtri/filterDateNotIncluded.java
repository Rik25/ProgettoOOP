package com.progetto.OOP.filtri;


import com.progetto.OOP.other.Filtro;
import com.progetto.OOP.other.FiltroDataDoppio;
import com.progetto.OOP.model.Record;

/**
 * Rappresenta la classe che si occupa d filtrare le date con operatore: "non incluso tra"
 * @author Riccardo Iobbi
 * @author Lorrenzo Benenchia
 *
 */

public class filterDateNotIncluded extends FiltroDataDoppio implements Filtro{
	
	public filterDateNotIncluded(Object parametri) {
		super(parametri);
	}
	
	public boolean filtra(Record record) {
		if(parametro1.after(record.getData()) || parametro2.before(record.getData()))
			return true;
		else
			return false;
	}

}
