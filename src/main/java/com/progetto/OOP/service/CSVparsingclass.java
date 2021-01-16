package com.progetto.OOP.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import com.progetto.OOP.archivio.ArchivioClass;
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
	public static ArrayList<Record> runParsing(String csvFile){
		
		int riga = 1;
		String linea = "";
		ArrayList<Record> records = new ArrayList<>();
		
		try {
			
			BufferedReader bufferedReader = new BufferedReader(new FileReader(csvFile));
			bufferedReader.readLine(); //salto la prima riga in quanto rappresenta il nome delle colonne
			
			try {
				
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
				}
		} 
			catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("Row #"+riga+"  "+e.toString()
									  +" parametri inseriti. Aspettati 10");
		}
			catch(NumberFormatException e) {
				System.out.println("Row #"+riga+"  "+e.toString());
		} 
		riga++;
		
		
	try {
		bufferedReader.close();
    	} catch (IOException e) {
    	System.out.println(e.getClass().getCanonicalName()
	        	+"Errore in  com.progetto.OOP.service.CSVparsingclass.java: Chiusura File");
	        }
   
	
	}
		catch (FileNotFoundException e) {
		System.out.println(e.getClass().getCanonicalName()
				+"Errore in com.progetto.OOP.service.CSVparsingclass.java: File non trovato");
	}
		catch (IOException e) {
		System.out.println(e.getClass().getCanonicalName()
		+"Errore in com.progetto.OOP.service.CSVparsingclass.java: I/O interrotto");
	}

	return records;
		
	}
	
	/**
	 * Salva ogni record come riga in un file csv
	 * @param csvFile percorso del file su cui salvare le informazioni.
	*/
	
	public void saveToCSV(String csvFile) {
		
		ArrayList<Record> records = ArchivioClass.getRecords();
		ArrayList<String>rows = new ArrayList<String>();
		for(Record recuperato : records)
		{//Salvo le informazioni di ogni record come string su stringa unica e delimito con ";"
			String x =recuperato.getCitta()+";"+ recuperato.getNazione()+";"+ 
					recuperato.getMeteo()+";"+ recuperato.getLingua()+";"+ 
					String.valueOf(recuperato.getTemp())+";"+ String.valueOf(recuperato.getPerc())+";"+ 
					String.valueOf(recuperato.getT_min())+";"+ String.valueOf(recuperato.getT_max())+";"+
					recuperato.getUnita()+";"+ recuperato.getData().toString()+";" ;
			rows.add(x);
		}
		try {
			//Creo i nomi delle colonne per il file CSV
			FileWriter csvWriter = new FileWriter(csvFile);
			csvWriter.append("Citta");
			csvWriter.append(";");
			csvWriter.append("Nazione");
			csvWriter.append(";");
			csvWriter.append("Meteo");
			csvWriter.append(";");
			csvWriter.append("Lingua");
			csvWriter.append(";");
			csvWriter.append("Temp");
			csvWriter.append(";");
			csvWriter.append("Perc");
			csvWriter.append(";");
			csvWriter.append("t_min");
			csvWriter.append(";");
			csvWriter.append("t_max");
			csvWriter.append(";");
			csvWriter.append("unita");
			csvWriter.append(";");
			csvWriter.append("data");
			csvWriter.append("\n");
			
			String[] parti;
			for(String rowData : rows) {
				//divido la stringa record precedente dove trovo ";"
				parti=rowData.split(";");
				
				for (String dato : parti) {
					csvWriter.append(dato+";");//scrivo sul file
					
				}
				csvWriter.append("\n");
			}

			csvWriter.flush();//salvo per sicurezza in modo tale da non lasciare nulla sul buffer
			csvWriter.close();
		}
		
		catch (FileNotFoundException e) {
			System.out.println(e.getClass().getCanonicalName()
			+"Errore in com.progetto.OOP.service.CSVparsingclass.java: File non trovato");
		}
		
		catch (IOException e) {
			System.out.println(e.getClass().getCanonicalName()
			+"Errore in com.progetto.OOP.service.CSVparsingclass.java: I/O interrotto");
		}
    }

}

	

	
