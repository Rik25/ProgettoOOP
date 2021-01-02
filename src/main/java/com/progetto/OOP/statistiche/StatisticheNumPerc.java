package com.progetto.OOP.statistiche;

/** Rappresenta la classe che estende la superclasse
 *  prendendone la lista dei Record. Implementa il calcolatore
 *  tramite il metodo run() che calcola media, massima, minima, varianza 
 *  delle temperature percepite.
 *  @author Lorenzo Benenchia 
 *  @author Riccardo Iobbi
 */

import com.progetto.OOP.other.*;
import com.progetto.OOP.model.Record;
import java.util.ArrayList;
import java.util.Comparator;

import com.progetto.OOP.model.StatisticheNum;;

public class StatisticheNumPerc extends StatisticheSuperclasse implements StatisticheCalcolatore {
	
	public StatisticheNumPerc(ArrayList<Record> ListaRecord) {
		super(ListaRecord);
	}
	
	public StatisticheNum run() {
		
		StatisticheNum StatisticheSpecifiche = new StatisticheNum();
		StatisticheSpecifiche.SetField("Statistiche su temperature percepite");
		
		double somma = records.stream().mapToDouble(Record::getPerc).sum();
		double media = somma/records.size();
		
		Record massimo = records.stream().max(Comparator.comparing(Record::getPerc)).get();
		Record minimo = records.stream().min(Comparator.comparing(Record::getPerc)).get();
		
		double lista[] = new double [records.size()];
		
		for (int i=0; i<lista.length; i++) {
			lista[i] = Math.pow(records.get(i).getPerc(), 2);
		}
		
		double varianza=0;
		for(int j=0; j<lista.length; j++) {
			varianza+=lista[j];
		}
		
		StatisticheSpecifiche.SetMassima(massimo.getPerc());
		StatisticheSpecifiche.SetMedia(media);
		StatisticheSpecifiche.SetVarianza(varianza);
		StatisticheSpecifiche.SetMinima(minimo.getPerc());
		
		return StatisticheSpecifiche;
	}

}