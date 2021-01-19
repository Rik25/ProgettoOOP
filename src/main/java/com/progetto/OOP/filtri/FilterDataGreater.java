package com.progetto.OOP.filtri;

import com.progetto.OOP.other.Filtro;
import com.progetto.OOP.other.FiltroDataSingolo;

import java.text.ParseException;

import com.progetto.OOP.model.Record;

/**
 * Rappresenta la classe che si occupa d filtrare le date con operatore: "maggiore di / dopo"
 * @author Riccardo Iobbi
 * @author Lorrenzo Benenchia
 *
 */

public class FilterDataGreater extends FiltroDataSingolo implements Filtro{
	
	public FilterDataGreater(Object parametro) throws ParseException {
		super(parametro);
	}
	
	public boolean filtra(Record record) {
		if(parametro.before(record.getData()))
			return true;
		else
			return false;
	}

}
