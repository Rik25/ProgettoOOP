package com.progetto.OOP.eccezioni;

/**Classe che rappresenta un'estensione della superclasse
 * ClassNotFoundException per il non ritrovamento di filtri.
 * @author Lorenzo Benenchia
 * @author Riccardo Iobbi
 */

public class FiltroNonTrovato extends ClassNotFoundException {
	
	private static final long serialVersionUID = 1L;

	public FiltroNonTrovato() {
		super();
	}
	
	public FiltroNonTrovato(String message) {
		super(message);
	}

}
