package com.progetto.OOP.other;

import com.progetto.OOP.model.Statistiche;

/**Rappresenta l'interfaccia che calcola le statistiche.
 * @author Riccardo Iobbi
 * @author Lorenzo Benenchia
*/

public interface StatisticheCalcolatore {
	
	/** Metodo che calcola la statistica.
	 * @returns l'oggetto che rappresentala statistica
	 */
	
	public Statistiche run();
}