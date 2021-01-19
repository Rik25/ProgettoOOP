package com.progetto.OOP;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.progetto.OOP.archivio.ArchivioClass;

@SpringBootApplication
public class AppprogettoApplication {

	public static void main(String[] args) {
		ArchivioClass.setRecordCSV();
		SpringApplication.run(AppprogettoApplication.class, args);
	}

}
