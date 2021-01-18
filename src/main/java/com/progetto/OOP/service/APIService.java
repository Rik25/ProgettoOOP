package com.progetto.OOP.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.progetto.OOP.model.Record;

public class APIService {

	
	public static Record request(String citta, String lingua, String unita) {
		//recupero l'API key da file
		File file = new File("FileConfig/key.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String key = br.readLine();
		br.close();
		
		URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q="+citta+"&lang="+lingua+"&units="+unita+"&appid="+key);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		int status = con.getResponseCode();
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inputLine;
				String content = "";
				while ((inputLine = in.readLine()) != null) {
				    content = inputLine;
				}
				in.close();
				con.disconnect();
				return Jsonparsingclass.jsonApiParse(content, citta, lingua, unita);
	}
	
}
