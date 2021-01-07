package com.progetto.OOP.filtri;

import com.progetto.OOP.model.Record;
import com.progetto.OOP.other.Filtro;
import com.progetto.OOP.other.FiltroDoppio;

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
