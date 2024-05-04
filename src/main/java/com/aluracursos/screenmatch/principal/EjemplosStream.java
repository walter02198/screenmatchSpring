package com.aluracursos.screenmatch.principal;


import com.aluracursos.screenmatch.model.Episodios;

import java.util.Arrays;
import java.util.List;

public class EjemplosStream {

    public void muestraEjemplo() {
        List<String> nombres = Arrays.asList("Brenda", "Luis", "Maria Fernanda", "Genesys");
        nombres.stream()
                .sorted()
                .limit(2)
                .filter(n -> n.startsWith("B"))
                .map(n -> n.toUpperCase())
                .forEach(System.out::println);


    }
}
