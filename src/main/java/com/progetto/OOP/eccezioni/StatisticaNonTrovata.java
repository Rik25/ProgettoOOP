package com.progetto.OOP.eccezioni;

/**Classe che rappresenta un'estensione della superclasse
 * ClassNotFoundException per il non ritrovamento di statistiche.
 * @author Lorenzo Benenchia
 * @author Riccardo Iobbi
 */

public class StatisticaNonTrovata extends ClassNotFoundException {
	
	/** serialVersion aggiunta di default
	 */
	
	private static final long serialVersionUID = 1L;

	public StatisticaNonTrovata() {
		super();
	}
	
	public StatisticaNonTrovata(String message) {
		super(message);
	}

}
