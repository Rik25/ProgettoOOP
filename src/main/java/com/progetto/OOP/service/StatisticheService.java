package com.progetto.OOP.service;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import com.progetto.OOP.eccezioni.StatisticaNonTrovata;
import com.progetto.OOP.other.StatisticheCalcolatore;


/**Rappresenta la classe che gestisce le statistiche
 * sui dataset.
 * @author Lorenzo Benencghia
 * @author Riccardo Iobbi
 */

public class StatisticheService {
	
	/**Costruisco un path di classi che andrà ad implementare
	 * l'interfaccia StatisticheCalcolatore
	 */
	
	private final static String path = "com.progetto.OOP.statistiche.";
	
	/**Creo un oggetto istanza di StatisticheCalcolatore dalle classi presenti
	 * nel package del path.
	 * 
	 * @param statistica campo su cui si vuol calcolare la statistica.
	 * @param records array su cui calcolare la statistica 
	 * @return un oggetto che implementa il calcolatoreStatistiche
	 * @throws StatisticaNonTrovata statistica non trovata nell'interfaccia.
	 */
	
	public static StatisticheCalcolatore instanceStatisticheCalcolatore (String statistica, ArrayList<Record> records)
                                     throws StatisticaNonTrovata {
		
		StatisticheCalcolatore calcolatoreStatistiche;
		String ClasseStatistica = path.concat("Statistiche"+statistica);
		
		try {
			Class<?> classe = Class.forName(ClasseStatistica);
			Constructor<?> costruttore = classe.getDeclaredConstructor(ArrayList.class);
			calcolatoreStatistiche = (StatisticheCalcolatore)costruttore.newInstance(records);
		}
		
		catch(ClassNotFoundException e) {
			throw new StatisticaNonTrovata("Statistica:" +statistica+ "non trovata");
		}
		
		return  calcolatoreStatistiche;
		
	}

}