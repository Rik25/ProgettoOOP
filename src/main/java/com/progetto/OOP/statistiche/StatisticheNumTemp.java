package com.progetto.OOP.statistiche;

/** Rappresenta la classe che estende la superclasse
 *  prendendone la lista dei Record. Implementa il calcolatore
 *  tramite il metodo run() che calcola media, massima, minima, varianza 
 *  delle temperature reali.
 *  @author Lorenzo Benenchia 
 *  @author Riccardo Iobbi
 */

import com.progetto.OOP.other.*;
import java.util.ArrayList;
import java.util.Comparator;

import com.progetto.OOP.model.Record;
import com.progetto.OOP.model.StatisticheNum;

public class StatisticheNumTemp extends StatisticheSuperclasse implements StatisticheCalcolatore {
	
	public StatisticheNumTemp(ArrayList<Record> ListaRecord) {
		super(ListaRecord);
	}
	
	public StatisticheNum run() {
		
		StatisticheNum StatisticheSpecifiche = new StatisticheNum();
		StatisticheSpecifiche.SetField("Statistiche sulle temperature reali");
		
		double somma = records.stream().mapToDouble(Record::getTemp).sum();
		double media = somma/records.size();
		
		Record minimo = records.stream().min(Comparator.comparing(Record::getTemp)).get();
		Record massimo = records.stream().max(Comparator.comparing(Record::getTemp)).get();
		
		double lista[]=new double [records.size()];
		for(int i=0; i<lista.length; i++) {
			lista[i]=Math.pow(records.get(i).getTemp()-media, 2);
		}
		
		double varianza=0;
		for (int j=0; j<lista.length; j++) {
			varianza+=lista[j];
		}
		
		StatisticheSpecifiche.SetMassima(massimo.getTemp());
		StatisticheSpecifiche.SetMedia(media);
		StatisticheSpecifiche.SetMinima(minimo.getTemp());
		StatisticheSpecifiche.SetVarianza(varianza);
		
		return StatisticheSpecifiche;
	}
}
