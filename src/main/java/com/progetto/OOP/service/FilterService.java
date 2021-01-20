package com.progetto.OOP.service;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import com.progetto.OOP.model.Record;
import com.progetto.OOP.archivio.ArchivioClass;
import com.progetto.OOP.other.Filtro;
import com.progetto.OOP.eccezioni.*;

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
	 * @throws FilterIllegalArgumentException 
	 * @throws EccezioneInterna 
	 */
	public static Filtro istanziaFiltro(String campo, String operatore, Object param)
			throws FiltroNonTrovato, FilterIllegalArgumentException, EccezioneInterna{
		
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
		//sbagliate maiuscole e minuscole
	    catch(NoClassDefFoundError e){
	    	throw new FiltroNonTrovato(
	    			"Error typing: '"+nomeFiltro+"' uppercase and lowercase error");
	    }

	    //costruttore chiamato da newInstance lancia un eccezione 
	   	catch (InvocationTargetException e) {  
	   		//genero una nuova eccezione 
	   		throw new FilterIllegalArgumentException(e.getTargetException().getMessage()
	   				+ " Expected in '"+campo+"'");
	   	}
		catch(LinkageError | NoSuchMethodException | SecurityException 
		    	   | InstantiationException | IllegalAccessException e ) {
		    	
		    	e.printStackTrace();
		    	throw new EccezioneInterna("try later");
		    }
		
	    return filtro;
		
	}
	
	/**
	 * Questo metodo filtra l'arraylist passato come parametro.
	 * @param filtro filtro da applicare.
	 * @param precedente ArrayList di record precedente.
	 * @return ArrayList di record filtrato.
	 */
	
	public static ArrayList<Record> runFiltroAND(Filtro filtro, ArrayList<Record> precedente){

		ArrayList<Record> filtrato = new ArrayList<Record>();
		
		for(Record record :  precedente) {

			if(filtro.filtra(record))
				filtrato.add(record);
		}				
		
		return filtrato;
	}
	
	/**
	 * Questo metodo restitusce un ArrayList di Record composto dai record precedenti
	 * con in aggiunta quelli che rispettano il filtro prendendoli dal database.
	 * @param     filtro 
	 * @param     precedente ArrayList di Record precedente. 
	 * @return    ArrayList filtrato.
	 */
	
	public static ArrayList<Record> runFiltroOR(Filtro filtro, ArrayList<Record> precedente){

		ArrayList<Record> filtrato = new ArrayList<Record>();
		
		for(Record record : records) {

			if(filtro.filtra(record))
				filtrato.add(record);
		}	
		
		precedente.removeAll(filtrato);
		precedente.addAll(filtrato);
		return precedente;
	}

}
