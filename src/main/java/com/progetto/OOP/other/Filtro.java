package com.progetto.OOP.other;

import com.progetto.OOP.model.Record;

/**
 * Interfaccia per filtri
 * @author Riccardo Iobbi
 * @author Lorenzo Benenchia
 *
 */

public interface Filtro {
	
	/**
	 * Metodo che restituisce true se il Record passato rispetta il filtro.
	 * @param record da confrontare con il filtro.
	 * @return esito.
	 */
	public boolean filtra(Record record);

}
