package com.progetto.OOP.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import com.progetto.OOP.model.Record;

/**
 * Rappresenta la classe che si occupa di popolare l'ArrayList di record
 * prendendoli in input da un file CSV.
 * @author Riccardo Iobbi
 * @author Lorenzo Benenchia
 *
 */

public class CSVparsingclass {
	
	/**
	 * Effettua il parsing del file CSV in modo da salvare ogni riga come un oggetto Record.
	 * @param csvFile percorso del file da cui recuperare le informazioni.
	 * @return ArrayList di Record.
	*/
	//manca da gestire la data!!!
	public static ArrayList<Record> RunParsing(String csvFile){
		
		int riga = 1;
		String linea = "";
		ArrayList<Record> records = new ArrayList<>();
		
		BufferedReader bufferedReader = new BufferedReader(new FileReader(csvFile));
		bufferedReader.readLine(); //salto la prima riga in quanto rappresenta il nome delle colonne
		
		while((linea = bufferedReader.readLine()) != null) {
			String[] recuperato = linea.split(";");//Divido quando trovo ";"
			
			//Creo l'oggetto composto dai campi ottenuti dal file
			Record oggettoRecuperato = new Record(recuperato[0].replaceAll("^\\s+",""), recuperato[1].replaceAll("^\\s+",""), 
												recuperato[2].replaceAll("^\\s+",""), Double.parseDouble(recuperato[3]), 
												Double.parseDouble(recuperato[4]), Double.parseDouble(recuperato[5]), 
												Double.parseDouble(recuperato[6]), recuperato[7].replaceAll("^\\s+",""));
			
			records.add(oggettoRecuperato);
			riga++;
		}
		
		bufferedReader.close();
		
		return records;
		
	}
	

}

	

	
