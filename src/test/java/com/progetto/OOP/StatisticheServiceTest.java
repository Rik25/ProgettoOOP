package com.progetto.OOP;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.progetto.OOP.model.Record;
import com.progetto.OOP.service.StatisticheService;
import com.progetto.OOP.archivio.ArchivioClass;
import com.progetto.OOP.eccezioni.StatisticaNonTrovata;
import static org.junit.jupiter.api.Assertions.*;
/**
 * Classe per test StatisticheService
 * @author Riccardo Iobbi
 * @author Lorenzo Benechia
 *
 */
public class StatisticheServiceTest {
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	/**
	 * test che controlla che venga lanciata l'eccezione StatisticaNonTrovata
	 */
	@SuppressWarnings("restriction")
	@Test
	void test() {
		ArrayList<Record> records = ArchivioClass.getRecords();
		assertThrows(StatisticaNonTrovata.class, ()->StatisticheService.instanceStatisticheCalcolatore("Double", records) );
	}
}
