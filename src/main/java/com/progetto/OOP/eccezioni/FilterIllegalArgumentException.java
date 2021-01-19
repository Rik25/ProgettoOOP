package com.progetto.OOP.eccezioni;

/** Rappresenta un'eccezzione personalizzata di tipo IllegalArgumentException.
 * @author Riccardo Iobbi
 * @author Lorenzo Benenchia
*/

public class FilterIllegalArgumentException extends IllegalArgumentException{


	private static final long serialVersionUID = 4L;

	public FilterIllegalArgumentException() {
		super();
	}

	public FilterIllegalArgumentException(String message) {
		super(message);
	}
}
