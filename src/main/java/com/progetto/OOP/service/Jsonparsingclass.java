package com.progetto.OOP.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.progetto.OOP.eccezioni.*;
import com.progetto.OOP.model.Record;
import com.progetto.OOP.other.Filtro;

public class Jsonparsingclass {
	

	public static ArrayList<Record> jsonParserColonna(Object filtro) 
	throws FiltroNonTrovato{
		
		ArrayList<Record> precedente = new ArrayList<Record>();
		ArrayList<Record> filtrato = new ArrayList<Record>();
		HashMap<String, Object> risultato = new ObjectMapper().convertValue(filtro, HashMap.class);
		
		for(Map.Entry<String, Object> entry : risultato.entrySet()) {
			
			//ripulisco ArrayList "filtrato", il vecchio filtrato perde riferimento (garbage)
			filtrato = new ArrayList<Record>();
		    String colonna = entry.getKey();
		    Object paramFiltro = entry.getValue();
		    try {
				filtrato = jsonParserOperatore(colonna, paramFiltro, precedente);
			} catch (  SecurityException e) {

				//throw new InternalGeneralException("Error in parsing I/O operation");
				
			} 
		    //ripulisce "precedente" prima di riempirlo con "filtrato"
		    //il vecchio precedente diventa senza riferimento
		    precedente = new ArrayList<Record>();
		    precedente.addAll(filtrato);
		}
		return filtrato;		
	}
	
	public static ArrayList<Record> jsonParserOperatore(String colonna, 
													   Object paramFiltro, 
												       ArrayList<Record> precedente) 
	throws FiltroNonTrovato {
		
		String type="";
		Filtro filtro;
		ArrayList<Record> filtrato = new ArrayList<Record>();
		HashMap<String, Object> risultato = new ObjectMapper().convertValue(paramFiltro, HashMap.class);
		
		for(Map.Entry<String, Object> entry : risultato.entrySet()) {
			
		    String operatore = entry.getKey();
		    Object valore = entry.getValue();
		    // Se operatore è type allora guarda se il valore è 'and' o 'or'
		    // lancia il metodo runfilter corrispondente
		    if(operatore.equals("type") || operatore.equals("Type")) {
		    	type = (String) valore;
		    	if(!(valore.equals("and")) && !(valore.equals("or"))) {
		    		//throw new FilterIllegalArgumentException("'and' o 'or' expected after 'type'");
		    	}
		    	continue;
		    }
		    
		    filtro = FilterService.istanziaFiltro(colonna, operatore, valore);
		    switch(type) {
		    
			    case "and":
			    	filtrato = FilterService.runFiltroAND(filtro, precedente);
			    	break;
			    case "or":
			    	filtrato = FilterService.runFiltroOR(filtro, precedente);
			    	break;
			    default:
			    	filtrato = FilterService.runFiltroOR(filtro, precedente);		    	
		    }
		}
		return filtrato;	
	}

}
