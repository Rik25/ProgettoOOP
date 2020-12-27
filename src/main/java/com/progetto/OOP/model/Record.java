package com.progetto.OOP.model;

import java.util.Date;
/** Rappresenta la classe i cui oggetti cotengono i dati di un 
 * record.
 * @author Riccardo Iobbi
 * @author Lorenzo Benenchia
*/
public class Record {
	
	private String citta;
	private String meteo;
	private String lingua;
	private double temp;
	private double perc;
	private double t_min;
	private double t_max;
	private String unita;
	private Date data;
	
	public Record() {}
	
	public Record(String citta, String meteo, String lingua, double temp, double perc, double t_min, double t_max, String unita) {
		this.citta = citta;
		this.meteo = meteo;
		this.lingua = lingua;
		this.temp = temp;
		this.perc = perc;
		this.t_min = t_min;
		this.t_max = t_max;
		this.unita = unita;
		data = new Date();
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getMeteo() {
		return meteo;
	}

	public void setMeteo(String meteo) {
		this.meteo = meteo;
	}

	public String getLingua() {
		return lingua;
	}

	public void setLingua(String lingua) {
		this.lingua = lingua;
	}

	public double getTemp() {
		return temp;
	}

	public void setTemp(double temp) {
		this.temp = temp;
	}

	public double getPerc() {
		return perc;
	}

	public void setPerc(double perc) {
		this.perc = perc;
	}

	public double getT_min() {
		return t_min;
	}

	public void setT_min(double t_min) {
		this.t_min = t_min;
	}

	public double getT_max() {
		return t_max;
	}

	public void setT_max(double t_max) {
		this.t_max = t_max;
	}

	public String getUnita() {
		return unita;
	}

	public void setUnita(String unita) {
		this.unita = unita;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	

}
