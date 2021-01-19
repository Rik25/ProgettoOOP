package com.progetto.OOP.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.progetto.OOP.eccezioni.*;
import com.progetto.OOP.model.Record;
import com.progetto.OOP.other.Filtro;
import org.json.*;

public class Jsonparsingclass {
	

	public static ArrayList<Record> jsonParserColonna(Object filtro) 
	throws FiltroNonTrovato, FilterIllegalArgumentException, EccezioneInterna{
		
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
	throws FiltroNonTrovato, FilterIllegalArgumentException, EccezioneInterna {
		
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
	/**
	 * Metodo che permette di creare un Record facendo il parsing della Stringa in input
	 * @param response Stringa da convertire
	 * @return Record
	 */
	public static Record jsonApiParse(String response, String citta, String lingua, String unita) {
		
		String jsonString = response ;
		JSONObject obj = new JSONObject(jsonString);
		//recupero le info che mi servono
		String nazione = obj.getJSONObject("sys").getString("country");
		double temp = obj.getJSONObject("main").getDouble("temp");
		double perc = obj.getJSONObject("main").getDouble("feels_like");
		double t_min = obj.getJSONObject("main").getDouble("temp_min");
		double t_max = obj.getJSONObject("main").getDouble("temp_max");
		//il campo description si trova in un Array
		JSONArray arr = obj.getJSONArray("weather");
		String meteo = arr.getJSONObject(0).getString("description");
		
		Record recuperato = new Record(citta, nazione, meteo, lingua, temp, perc, t_min, t_max, unita);
		return recuperato;
		    
	}

}
