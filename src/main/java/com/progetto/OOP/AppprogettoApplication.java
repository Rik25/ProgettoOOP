package com.progetto.OOP;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.progetto.OOP.archivio.ArchivioClass;

@SpringBootApplication
@EnableScheduling
public class AppprogettoApplication {

	public static void main(String[] args) {
		ArchivioClass.setRecordCSV();
		SpringApplication.run(AppprogettoApplication.class, args);
	}

}
