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

import com.progetto.OOP.model.Record;

public class APIService {

	
	public static Record request(String citta, String lingua, String unita) {
		//recupero l'API key da file
		File file = new File("FileConfig/key.txt");
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
	
}
