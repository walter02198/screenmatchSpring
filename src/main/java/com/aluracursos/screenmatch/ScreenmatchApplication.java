package com.aluracursos.screenmatch;

import com.aluracursos.screenmatch.model.DatosDeSerie;
import com.aluracursos.screenmatch.model.DatosEpisodio;
import com.aluracursos.screenmatch.model.DatosTemporadas;
import com.aluracursos.screenmatch.principal.EjemplosStream;
import com.aluracursos.screenmatch.principal.Principal;
import com.aluracursos.screenmatch.service.ConsumoApi;
import com.aluracursos.screenmatch.service.ConvierteDatos;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.ArrayList;
import java.util.List;
@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		Principal principal=new Principal();
		principal.muestraElMenu();
//		EjemplosStream ejemplosStream = new EjemplosStream();
//		ejemplosStream.muestraEjemplo();
	}
}

