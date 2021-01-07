package com.progetto.OOP.archivio;

import java.io.InputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
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
		metadata.add(new Metadata("name","Città","String"));
		metadata.add(new Metadata("description","Meteo attuale","String"));
		metadata.add(new Metadata("language","Lingua di visualizzazione dati","String"));
		metadata.add(new Metadata("temp","Temperatura attuale","Double"));
		metadata.add(new Metadata("perc","Temperatura percepita","Double"));
		metadata.add(new Metadata("temp_min","Tempereatura minima del giorno","Double"));
		metadata.add(new Metadata("temp_max","Temperaura massima del giorno","Double"));
		metadata.add(new Metadata("units","Unità di misura per la visualizzazione dei dati","String"));
		metadata.add(new Metadata("date","Data e ora della richiesta","Date"));
		return metadata;
		
	}
	
	/**
	 * Set dei Record da file CSV
	 */
	
	public static void setRecordCSV(){
		records = CSVparsingclass.RunParsing("FileConfig/archivio.csv");
		
	}

}
