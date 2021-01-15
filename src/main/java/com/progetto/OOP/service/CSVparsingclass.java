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
	
	@SuppressWarnings("deprecation")
	public static ArrayList<Record> RunParsing(String csvFile){
		
		int riga = 1;
		String linea = "";
		ArrayList<Record> records = new ArrayList<>();
		
		BufferedReader bufferedReader = new BufferedReader(new FileReader(csvFile));
		bufferedReader.readLine(); //salto la prima riga in quanto rappresenta il nome delle colonne
		
		while((linea = bufferedReader.readLine()) != null) {
			String[] recuperato = linea.split(";");//divido quando trovo ";"
			
			//creo l'oggetto composto dai campi ottenuti dal file
			Record oggettoRecuperato = new Record(recuperato[0].replaceAll("^\\s+",""), recuperato[1].replaceAll("^\\s+",""), 
												recuperato[2].replaceAll("^\\s+",""), recuperato[3].replaceAll("^\\s+",""), 
												Double.parseDouble(recuperato[4]), 
												Double.parseDouble(recuperato[5]), Double.parseDouble(recuperato[6]), 
												Double.parseDouble(recuperato[7]), recuperato[8].replaceAll("^\\s+",""));
			
			//parsing della data
			
			String s = recuperato[9]; //s conterrà la stringa con la data
			String[] x = s.split(" "); //divido la stringa in sotto stringhe quando incontro uno spazio
			String[] ora = x[3].split(":"); //divido la sottostringa "hh:mm:ss" in altre sottostringhe
			
			Date d = new Date(x[1] + "/" + x[2] + "/" + x[5]);// creo una nuova data con il mese, giorno e anno letti dal file
			d.setHours(Integer.parseInt(ora[0]));// set dell'ora
			d.setMinutes(Integer.parseInt(ora[1]));//set dei minuti
			d.setSeconds(Integer.parseInt(ora[2]));//set dei secondi
			
			oggettoRecuperato.setData(d);// passo la data creata all'oggetto di tipo Record
			
			records.add(oggettoRecuperato);
			riga++;
		}
		
		bufferedReader.close();
		
		return records;
		
	}
	

}

	

	
