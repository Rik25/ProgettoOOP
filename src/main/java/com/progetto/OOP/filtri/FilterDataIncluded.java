package com.progetto.OOP.filtri;


import com.progetto.OOP.other.Filtro;
import com.progetto.OOP.other.FiltroDataDoppio;

import java.text.ParseException;

import com.progetto.OOP.model.Record;

/**
 * Rappresenta la classe che si occupa d filtrare le date con operatore: "incluso tra"
 * @author Riccardo Iobbi
 * @author Lorrenzo Benenchia
 *
 */

public class FilterDataIncluded extends FiltroDataDoppio implements Filtro{
	
	public FilterDataIncluded(Object parametri) throws ParseException {
		super(parametri);
	}
	
	public boolean filtra(Record record) {
		if(parametro1.before(record.getData()) && parametro2.after(record.getData()))
			return true;
		else
			return false;
	}

}