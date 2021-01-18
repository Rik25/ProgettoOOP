package com.progetto.OOP.controller;


import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.progetto.OOP.archivio.ArchivioClass;
import com.progetto.OOP.eccezioni.EccezioneInterna;
import com.progetto.OOP.eccezioni.FiltroNonTrovato;
import com.progetto.OOP.eccezioni.StatisticaNonTrovata;
import com.progetto.OOP.model.Metadata;
import com.progetto.OOP.model.Record;
import com.progetto.OOP.model.Statistiche;
import com.progetto.OOP.other.StatisticheCalcolatore;
import com.progetto.OOP.service.Jsonparsingclass;
import com.progetto.OOP.service.StatisticheService;

@RestController
public class ClasseController {
		
	@RequestMapping(value="metadata", method=RequestMethod.GET)
	public ArrayList<Metadata> getMetadata(){
		
		return ArchivioClass.getMetadata();
	}
	
	@RequestMapping(value="data", method=RequestMethod.GET)
	public ArrayList<Record> getRecord(){
		
		return ArchivioClass.getRecords();
	}
	
	@RequestMapping(value="statistiche", method=RequestMethod.GET)
	public Statistiche getStatistiche(@RequestParam(value = "field") String statistica) throws StatisticaNonTrovata, EccezioneInterna {
		
		ArrayList<Record> records = ArchivioClass.getRecords();
		StatisticheCalcolatore sc = StatisticheService.instanceStatisticheCalcolatore(statistica, records);
		return sc.run();
	}
	
	@RequestMapping(value="data", method=RequestMethod.POST )
	public ArrayList<Record> getDataPost (@RequestBody Object filtro) throws FiltroNonTrovato{
		
		return Jsonparsingclass.jsonParserColonna(filtro);
	}
	
	@RequestMapping(value="stats", method=RequestMethod.POST)
	public Statistiche getStatistichePost(@RequestParam(value = "field") String statistica,
			@RequestBody Object filtro) throws FiltroNonTrovato, StatisticaNonTrovata, EccezioneInterna{
		ArrayList<Record> filtrato = Jsonparsingclass.jsonParserColonna(filtro);
		StatisticheCalcolatore sc = StatisticheService.instanceStatisticheCalcolatore(statistica, filtrato);
		return sc.run();
	}
}
