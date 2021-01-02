
package com.progetto.OOP.other;

/** Rappresenta la superclasse per i calcolatori di statistiche.
 * @author Lorenzo Benenchia
 * @author Riccardo Iobbi
 */

import java.util.ArrayList;
import com.progetto.OOP.model.Record;

public class StatisticheSuperclasse {
	protected ArrayList<Record> records;
	
	/**Al costruttore gli passiamo il
	 * @param ListaRecord (ArrayList) su cui calcolare la statistica.
	 */
	
	public StatisticheSuperclasse(ArrayList<Record> ListaRecord) {
		this.records=ListaRecord;
	}
}