package com.progetto.OOP.controller;

import java.util.ArrayList;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.progetto.OOP.archivio.ArchivioClass;
import com.progetto.OOP.eccezioni.EccezioneInterna;
import com.progetto.OOP.eccezioni.FilterIllegalArgumentException;
import com.progetto.OOP.eccezioni.FiltroNonTrovato;
import com.progetto.OOP.eccezioni.StatisticaNonTrovata;
import com.progetto.OOP.model.Metadata;
import com.progetto.OOP.model.Record;
import com.progetto.OOP.model.Statistiche;
import com.progetto.OOP.model.StatisticheString;
import com.progetto.OOP.other.StatisticheCalcolatore;
import com.progetto.OOP.service.APIService;
import com.progetto.OOP.service.Jsonparsingclass;
import com.progetto.OOP.service.StatisticheService;

/**Rappresenta la classe che gestisce le chiamate al server
 * @author Lorenzo Benenchia
 * @author Riccardo Iobbi
 */

@RestController
public class ClasseController {
	
	/**
	 * metodo eseguito ogni ora per effettuare la richiesta di dati all'API,
	 * verrà eseguito per la prima volta dopo 15 min dall'avvio del programma.
	 * @throws InterruptedException
	 */
		@Scheduled(initialDelay = 900000, fixedRate = 3600000)
		public void scheduledRequest() throws InterruptedException{
			APIService.scheduledRequest();
			ArchivioClass.saveToCSV();
		}
		/**
		 * metodo che risponde alla richiesta GET /request
		 * @param citta citta di cui si vuole avere il meteo
		 * @param lingua lingua dei dati
		 * @param unita unita di misura
		 * @return record
		 */
		@RequestMapping(value="request", method=RequestMethod.GET)
		public Record getRequest(@RequestParam(value = "city") String citta,
								@RequestParam(value = "lang") String lingua, 
								@RequestParam(value = "unit") String unita) {
			
			return APIService.request(citta, lingua, unita);
			
		}
	
     /** Metodo che risponde alla richiesta GET /metadata
	 * @return un arrayList di metadata (object)
	 */
	
	@RequestMapping(value="metadata", method=RequestMethod.GET)
	public ArrayList<Metadata> getMetadata(){	
		return ArchivioClass.getMetadata();
	}
	
	/**Metodo che risponde alla richiesta GET /data
	 * @return un arrayList di Record (object)
	 */
	   
	@RequestMapping(value="data", method=RequestMethod.GET)
	public ArrayList<Record> getRecord(){
		
		return ArchivioClass.getRecords();
	}
	
	/**Metodo che risponde alla richiesta GET /statistiche
	 * @param statistica: campo sul quale si vuole eseguire la statistica (Es. NumPerc - statistiche numeriche sulle temperature percepite)
	 * @return oggetto statistiche contenente le statistiche specificate
	 * @throws StatisticaNonTrovata se la statistica inserita nel parametro non esiste
	 * @throws EccezioneInterna dovuta ad errori interni.
	 */
	
	@RequestMapping(value="statistiche", method=RequestMethod.GET)
	public Statistiche getStatistiche(@RequestParam(value = "field") String statistica) throws StatisticaNonTrovata, EccezioneInterna {
		
		ArrayList<Record> records = ArchivioClass.getRecords();
		StatisticheCalcolatore sc = StatisticheService.instanceStatisticheCalcolatore(statistica, records);
		return sc.run();
	}
	
	/**Metodo che risponde alla richiesta POST /data
	 * @param filtro: json che contiene i filtri da applicare 
	 * @return un ArrayList di Record filtrati secondo il filtro
	 * @throws FiltroNonTrovato: errore di filtro non trovato
	 * @throws EccezioneInterna 
	 * @throws FilterIllegalArgumentException 
	 */
	
	@RequestMapping(value="data", method=RequestMethod.POST )
	public ArrayList<Record> getDataPost (@RequestBody Object filtro) throws FiltroNonTrovato, FilterIllegalArgumentException, EccezioneInterna{
		
		return Jsonparsingclass.jsonParserColonna(filtro);
	}
	
	/** Metodo che risponde alla chiamata POST /statistiche
	 * @param statistica: campo sul quale si vuole eseguire la statistica
	 * @param filtro: json contenenti i filtri da appliccare alla statistica
	 * @return un oggi Statistiche contenente le statistiche specifiche filtrate
	 * @throws FiltroNonTrovato: errore di filtro non trovato.
	 * @throws StatisticaNonTrovata: errore di statistica non trovata
	 * @throws EccezioneInterna: errori interni
	 */
	
	@RequestMapping(value="statistiche", method=RequestMethod.POST)
	public Statistiche getStatistichePost(@RequestParam(value = "field") String statistica,
			@RequestBody Object filtro) throws FiltroNonTrovato, StatisticaNonTrovata, EccezioneInterna{
		ArrayList<Record> filtrato = Jsonparsingclass.jsonParserColonna(filtro);
		StatisticheCalcolatore sc = StatisticheService.instanceStatisticheCalcolatore(statistica, filtrato);
		return sc.run();
	}
}
