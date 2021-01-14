package com.progetto.OOP.eccezioni;

public class EccezioneInterna extends Exception {

	private static final long serialVersionUID = 1L;

	public EccezioneInterna() {
		super();
	}

	public EccezioneInterna(String message) {
		super(message);
	}
}