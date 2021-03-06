package com.progetto.OOP.filtri;


import com.progetto.OOP.other.Filtro;
import com.progetto.OOP.other.FiltroDataDoppio;

import java.text.ParseException;

import com.progetto.OOP.model.Record;

/**
 * Rappresenta la classe che si occupa di filtrare le date con operatore: "non incluso tra"
 * @author Riccardo Iobbi
 * @author Lorrenzo Benenchia
 *
 */

public class FilterDataNotIncluded extends FiltroDataDoppio implements Filtro{
	
	public FilterDataNotIncluded(Object parametri) throws ParseException {
		super(parametri);
	}
	
	public boolean filtra(Record record) {
		if(parametro1.after(record.getData()) || parametro2.before(record.getData()))
			return true;
		else
			return false;
	}

}
