package com.progetto.OOP.service;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import com.progetto.OOP.eccezioni.StatisticaNonTrovata;
import com.progetto.OOP.other.StatisticheCalcolatore;
import com.progetto.OOP.eccezioni.EccezioneInterna;
import com.progetto.OOP.model.Record;


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
	 * @throws EccezioneInterna errori interni.
	 */
	
	public static StatisticheCalcolatore instanceStatisticheCalcolatore (String statistica, ArrayList<Record> records)
                                     throws StatisticaNonTrovata, EccezioneInterna {
		
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
		
		catch(NoClassDefFoundError e) {
			throw new StatisticaNonTrovata("Probabile errore di scrittura sulla seguente statistica:"
	    			+statistica);
		}
		
		catch ( NoSuchMethodException | SecurityException |IllegalArgumentException  
		    	   | InstantiationException | IllegalAccessException | InvocationTargetException e ) {
			e.printStackTrace(); //utilizzo printStackTrace per stampare anche la causa dell'errore.
	    	throw new EccezioneInterna("Errori interni");
	    }
		
		return  calcolatoreStatistiche;
		
	}

}