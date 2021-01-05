package com.progetto.OOP.statistiche;

/**Rappresenta la classe che estente StatisticheSuperclasse
 * e implementa il calcolatore andando a restituire tramite 
 * il metodo run una descrizione del campo calcolato e il relativo
 * hashmap contenente il meteo e la percentuale delle volte che è uscito.
 * @author Lorenzo Benenchia
 * @author Riccardo Iobbi
 */

import java.util.ArrayList;
import java.util.HashMap;

import com.progetto.OOP.other.*;
import com.progetto.OOP.model.Record;
import com.progetto.OOP.model.StatisticheString;

public class StatisticheStringhe extends StatisticheSuperclasse implements StatisticheCalcolatore{
	
	public StatisticheStringhe(ArrayList<Record> ListaRecord) {
		super(ListaRecord);
	}
	
	public StatisticheString run() {
		
		StatisticheString statisticheSpecifiche = new StatisticheString();
		statisticheSpecifiche.SetField("Statistiche percentuale meteo");
		
		/**Creo un arraylist con le descrizioni meteo 
		 * che non si ripetono.
		 */
		
		ArrayList<String>list=new ArrayList();
		list.add(records.get(0).getMeteo());
		
		for(int i=1; i<records.size(); i++) {
			if (list.contains(records.get(i).getMeteo())) {
				continue;
			}
			else list.add(records.get(i).getMeteo());
		}
		
		/**Creo l'hashmap che passerò come parametro al set
		 * e che verrà popolato dalle descrizioni meteo(non ripetute)(key)
		 * e che avranno come value la percentuale delle volte in cui è uscita quella descrizione.
		 */
		
		HashMap<String,Integer>stats=new HashMap();
		
		for (int j=0; j<list.size(); j++) {
			
			int contatore=0;
			
			for(int k=0; k<records.size(); k++) {
				if(records.get(k).getMeteo()==list.get(j)) contatore++;
			}
			
			int percentuale = (int)(contatore/records.size())*100;
			
			stats.put(list.get(j), percentuale);
			
		}
		
		statisticheSpecifiche.SetStats(stats);
		return statisticheSpecifiche;
	}
}

