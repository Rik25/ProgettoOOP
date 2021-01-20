package com.progetto.OOP.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import com.progetto.OOP.archivio.ArchivioClass;
import com.progetto.OOP.model.Record;

public class APIService {
	//impostate di default per comodità
	private static String parCitta = "Ancona";
	private static String parLingua = "it";
	private static String parUnita = "metric";
	private static String percorsoFile = "FileConfig/key.txt";

	/**
	 * metodo che effettua la richiesta all'api
	 * @param citta della quale si vuole sapere il meteo
	 * @param lingua di formattazione dei dai
	 * @param unita di misura
	 * @return record parsato dal Json
	 */
	public static Record request(String citta, String lingua, String unita) {
		//mi salvo le informazioni per poter effettuare le richieste in futuro
		setParCitta(citta);
		setParLingua(lingua);
		setParUnita(unita);
		//recupero l'API key da file
		File file = new File(percorsoFile);
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String key = "";
		try {
			key = br.readLine();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
				
		URL url = null;
		try {
			url = new URL("http://api.openweathermap.org/data/2.5/weather?q="+citta+"&lang="+lingua+"&units="+unita+"&appid="+key);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		HttpURLConnection con = null;
		try {
			con = (HttpURLConnection) url.openConnection();
				
			try {
				con.setRequestMethod("GET");
				} catch (ProtocolException e) {
						e.printStackTrace();
				}
			int status = con.getResponseCode();
				} catch (IOException e) {
					e.printStackTrace();
				}
			String inputLine;
			String content = "";
			try {
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
						
						
				while ((inputLine = in.readLine()) != null) {
					    content = inputLine;
					}
					in.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
			con.disconnect();
			return Jsonparsingclass.jsonApiParse(content, citta, lingua, unita);
	}
	
	/**
	 * metodo che si occupa di effettuare la richiesta ogni tot di tempo
	 */
	public static void scheduledRequest() {

				String citta = getParCitta();
				String lingua = getParLingua();
				String unita = getParUnita();
				//recupero l'API key da file
				File file = new File(percorsoFile);
				BufferedReader br = null;
				try {
					br = new BufferedReader(new FileReader(file));
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				String key = "";
				try {
					key = br.readLine();
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
						
				URL url = null;
				try {
					url = new URL("http://api.openweathermap.org/data/2.5/weather?q="+citta+"&lang="+lingua+"&units="+unita+"&appid="+key);
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
				HttpURLConnection con = null;
				try {
					con = (HttpURLConnection) url.openConnection();
						
					try {
						con.setRequestMethod("GET");
						} catch (ProtocolException e) {
								e.printStackTrace();
						}
					int status = con.getResponseCode();
						} catch (IOException e) {
							e.printStackTrace();
						}
					String inputLine;
					String content = "";
					try {
						BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
								
								
						while ((inputLine = in.readLine()) != null) {
							    content = inputLine;
							}
							in.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
					con.disconnect();
					Record record = Jsonparsingclass.jsonApiParse(content, citta, lingua, unita);
					
	}
	
	public static String getParCitta() {
		return parCitta;
	}

	public static void setParCitta(String citta) {
		parCitta = citta;
	}

	public static String getParLingua() {
		return parLingua;
	}

	public static void setParLingua(String lingua) {
		parLingua = lingua;
	}

	public static String getParUnita() {
		return parUnita;
	}

	public static void setParUnita(String unita) {
		parUnita = unita;
	}
	
}
