package com.progetto.OOP.filtri;


import com.progetto.OOP.other.Filtro;
import com.progetto.OOP.other.FiltroDataDoppio;
import com.progetto.OOP.model.Record;

/**
 * Rappresenta la classe che si occupa d filtrare le date con operatore: "incluso tra"
 * @author Riccardo Iobbi
 * @author Lorrenzo Benenchia
 *
 */

public class filterDateIn extends FiltroDataDoppio implements Filtro{
	
	public filterDateIn(Object parametri) {
		super(parametri);
	}
	
	public boolean filtra(Record record) {
		if(parametro1.before(record.getData()) && parametro2.after(record.getData()))
			return true;
		else
			return false;
	}

}