package com.progetto.OOP.filtri;

import com.progetto.OOP.other.Filtro;
import com.progetto.OOP.other.FiltroDataSingolo;
import com.progetto.OOP.model.Record;

/**
 * Rappresenta la classe che si occupa d filtrare le date con operatore: "minore di / prima"
 * @author Riccardo Iobbi
 * @author Lorrenzo Benenchia
 *
 */

public class filterDateLess extends FiltroDataSingolo implements Filtro{
	
	public filterDateLess(Object parametro) {
		super(parametro);
	}
	
	public boolean filtra(Record record) {
		if(parametro.after(record.getData()))
			return true;
		else
			return false;
	}

}
