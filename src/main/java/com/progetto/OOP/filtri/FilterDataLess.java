package com.progetto.OOP.filtri;

import com.progetto.OOP.other.Filtro;
import com.progetto.OOP.other.FiltroDataSingolo;

import java.text.ParseException;

import com.progetto.OOP.model.Record;

/**
 * Rappresenta la classe che si occupa d filtrare le date con operatore: "minore di / prima"
 * @author Riccardo Iobbi
 * @author Lorrenzo Benenchia
 *
 */

public class FilterDataLess extends FiltroDataSingolo implements Filtro{
	
	public FilterDataLess(Object parametro) throws ParseException {
		super(parametro);
	}
	
	public boolean filtra(Record record) {
		if(parametro.after(record.getData()))
			return true;
		else
			return false;
	}

}
