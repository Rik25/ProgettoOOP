package com.progetto.OOP.archivio;

import java.util.ArrayList;
import com.progetto.OOP.model.Record;
import com.progetto.OOP.service.CSVparsingclass;
import com.progetto.OOP.model.Metadata;

/**
 * Rappresenta la classe che gestisce la memoria dell'applicazione.
 * @author Riccardo Iobbi
 * @author Lorenzo Benenchia
 *
 */

public class ArchivioClass {
	private static ArrayList<Record> records = new ArrayList<Record>();
	private static ArrayList<Metadata> metadata = new ArrayList<Metadata>();
	static String csvFile = "FileConfig/archivio.csv";
	
	/**
	 * 
	 * @return ArrayList di tutti i record
	 */
	
	public static ArrayList<Record> getRecords(){
		return records;
	}
	
	/**
	 * Metodo che popola l'ArrayList di metadata
	 * @return ArrayList dei metadati
	 */
	
	public static ArrayList<Metadata> getMetadata() {
		metadata.add(new Metadata("citta","Città","String"));
		metadata.add(new Metadata("nazione","Nazione","String"));
		metadata.add(new Metadata("meteo","Meteo attuale","String"));
		metadata.add(new Metadata("lingua","Lingua di visualizzazione dati","String"));
		metadata.add(new Metadata("temp","Temperatura attuale","Double"));
		metadata.add(new Metadata("perc","Temperatura percepita","Double"));
		metadata.add(new Metadata("t_min","Tempereatura minima del giorno","Double"));
		metadata.add(new Metadata("t_max","Temperaura massima del giorno","Double"));
		metadata.add(new Metadata("unita","Unità di misura per la visualizzazione dei dati","String"));
		metadata.add(new Metadata("data","Data e ora della richiesta","Date"));
		return metadata;
		
	}
	
	public static void addRecord(Record record) {
		records.add(record);
	}
	
	/**
	 * Set dei Record da file CSV
	 */
	
	public static void setRecordCSV(){
		records = CSVparsingclass.runParsing(csvFile);
		
	}

}
