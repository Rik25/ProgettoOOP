package com.progetto.OOP;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.progetto.OOP.eccezioni.FilterIllegalArgumentException;
import com.progetto.OOP.eccezioni.FiltroNonTrovato;
import com.progetto.OOP.service.FilterService;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Classe per test FilterService
 * @author Riccardo Iobbi
 * @author Lorenzo Benechia
 *
 */
public class FilterServiceTest {
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	/**
	 * test che controlla che venga lanciata l'eccezione FiltroNonTrovato
	 */
	@SuppressWarnings("restriction")
	@Test
	void test1()
	{  
		assertThrows(FiltroNonTrovato.class, ()->FilterService.istanziaFiltro("Provincia", "Greater", 4.0));
	}
	/**
	 * test che controlla che venga lanciata l'eccezione FilterIllegalArgumentException
	 */
	@SuppressWarnings("restriction")
	@Test
	void test2() {
		assertThrows(FilterIllegalArgumentException.class, ()->FilterService.istanziaFiltro("Citta", "In", 4.0));
	}
}
