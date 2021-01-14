package com.progetto.OOP.service;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import com.progetto.OOP.model.Record;
import com.esame.exception.FilterIllegalArgumentException;
import com.esame.exception.FilterNotFoundException;
import com.esame.exception.InternalGeneralException;
import com.esame.util.other.Filter;
import com.progetto.OOP.archivio.ArchivioClass;
import com.progetto.OOP.other.Filtro;
import com.progetto.OOP.eccezioni.FiltroNonTrovato;

/**
 * Classe che gestisce i filtraggi
 * @author Riccardo Iobbi
 * @author Lorenzo Benenchia
 *
 */
public class FilterService {
	
	private final static String percorso = "com.progetto.OOP.filtri.";//package dove trovare i filtri
	public static ArrayList<Record> records = ArchivioClass.getRecords(); //prendo i record salvati
	/**
	 * Metodo che permette di istanziare il filtro corretto ricavando il nome della classe dai dati in input
	 * @param campo su cui si vuole eseguire il filtro
	 * @param operatore di filtraggio (maggiore, minore...)
	 * @param param parametro d'ingresso per il filtro selezionato
	 * @return oggetto che implementa Filtro
	 * @throws FiltroNonTrovato
	 */
	public static Filtro istanziaFiltro(String campo, String operatore, Object param)
			throws FiltroNonTrovato{
		
		Filtro filtro;
		String nomeFiltro = new String("Filter"+campo+operatore);
		String ClasseNomeFiltro = percorso.concat(nomeFiltro);
	    
		try {
			
			Class<?> cl = Class.forName(ClasseNomeFiltro); //seleziono la classe
		
			Constructor<?> co = cl.getDeclaredConstructor(Object.class); //seleziono il costruttore
	    
			filtro =(Filtro)co.newInstance(param);  //istanzo oggetto filtro
		}
		
	    //nome filtro non corretto 
	    catch(ClassNotFoundException e){
	    	throw new FiltroNonTrovato("The filter in field: '"+campo+"' with operator: '"+
	                                          operatore +"' does not exist");
	    }

		
	    return filtro;
		
	}
	
	/**
	 * Questo metodo filtra l'arraylist passato come parametro.
	 * @param filtro filtro da applicare.
	 * @param nonFiltrato ArrayList di record da filtrare.
	 * @return ArrayList di record filtrato.
	 */
	
	public static ArrayList<Record> runFiltro(Filtro filtro, ArrayList<Record> nonFiltrato){

		ArrayList<Record> filtrato = new ArrayList<Record>();
		
		for(Record record :  nonFiltrato) {

			if(filtro.filtra(record))
				filtrato.add(record);
		}				
		
		return filtrato;
	}

}
