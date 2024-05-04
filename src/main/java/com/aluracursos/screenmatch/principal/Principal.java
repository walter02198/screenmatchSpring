package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.model.DatosEpisodio;
import com.aluracursos.screenmatch.model.DatosTemporadas;
import com.aluracursos.screenmatch.model.Episodios;
import com.aluracursos.screenmatch.service.ConsumoApi;
import com.aluracursos.screenmatch.service.ConvierteDatos;
import com.aluracursos.screenmatch.model.DatosDeSerie;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {

    private Scanner teclado = new Scanner(System.in);
    private ConsumoApi consumoApi = new ConsumoApi();

    private final String URL_BASE  = "https://www.omdbapi.com/?t=";

    private final String API_KEY = "&apikey=920f1efa";

    private ConvierteDatos conversor = new ConvierteDatos();

    public void muestraElMenu(){
        System.out.println("Por favor ingresa el nombre de la serie que deseas buscar");
        //Busca los datos generales de la serie
        var nombreSerie = teclado.nextLine();
        var json =consumoApi.obtenerDatos(URL_BASE+nombreSerie.replace(" ","+")+API_KEY);
        var datos=conversor.obtenerDatos(json,DatosDeSerie.class);
        System.out.println(datos);

        //Busca los datos de todas las temporadas

        List<DatosTemporadas> temporadas = new ArrayList<>();
        for (int i = 1; i < datos.totalDeTemporadas(); i++) {
            json = consumoApi.obtenerDatos(URL_BASE+nombreSerie.replace(" ","+")+"&Season="+i+API_KEY);
            var datosTemporada = conversor.obtenerDatos(json, DatosTemporadas.class);
            temporadas.add(datosTemporada);
        }
        //temporadas.forEach(System.out::println);

        //mostrar solo el titulo de los episodios para las temporadas

//        for (int i = 0; i < datos.totalDeTemporadas()-1; i++) {
//            List<DatosEpisodio> episodiosTemporada = temporadas.get(i).episodios();
//            for (int j = 0; j < episodiosTemporada.size(); j++) {
//                System.out.println(episodiosTemporada.get(j).titulo());
//
//            }
//        }
        //escribiendo el codigo de mostrar el titulo de los episodios por temporada con expresiones lambda
        //temporadas.forEach(t ->t.episodios().forEach(e-> System.out.println(e.titulo())));

        //Convertir todas las informaciones a una lista del tipo Datos episodio

        List<DatosEpisodio> datosEpisodios=temporadas.stream()
                .flatMap(t->t.episodios().stream())
                .collect(Collectors.toList());

        //top 5 episodios
//        System.out.println("Top 5 episodios:");
//        datosEpisodios.stream()
//                .filter(e->!e.evaluacion().equalsIgnoreCase("N/A"))
//                .peek(e-> System.out.println("primer filtro (N/A)"+e))
//                .sorted(Comparator.comparing(DatosEpisodio::evaluacion).reversed())
//                .peek(e-> System.out.println("Segundo Ordenacion (M>m)"+e))
//                .map(t->t.titulo().toUpperCase())
//                .peek(e-> System.out.println("Tercer Filtro Mayuscula (m>M)"+e))
//                .limit(5)
//                .forEach(System.out::println);



//Convirtiendo los datos a una lista de tipo episiodio

        List<Episodios> episodios=  temporadas.stream()
                .flatMap(t->t.episodios().stream()
                        .map(d->new Episodios(t.numero(),d)))
                .collect(Collectors.toList());

        //episodios.forEach(System.out::println);

        //Busqueda de episodios a partir de un año espècifico

//        System.out.println("Indica el año a partir del cual deseas ver los eipiodios");
//        var fecha= Integer.valueOf(teclado.nextLine());
//        LocalDate fechaBusqueda=LocalDate.of(fecha,1,1);

//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");//esta instanciacion de clase es para cambiar
//        // el orden de dia, mes y año de la fecha
//        episodios.stream().
//                filter(e -> e.getFechaDelanzamiento() != null && e.getFechaDelanzamiento()
//                        .isAfter(fechaBusqueda))
//                .forEach(e -> System.out.println(
//                        "Temporada " + e.getTemporada() +
//                                "Episodio " + e.getTitulo()
//                                + "Fecha de lanzamiento "+ e.getFechaDelanzamiento().format(dtf)
//                ));

        //Busca episodios por un pedazo del titulo
//        System.out.println("Por favor escriba el titulo del episodio que desea ver");
//        var pedazoDeTitulo = teclado.nextLine();
//        Optional<Episodios> episodiosBuscado=episodios.stream()
//                .filter(e->e.getTitulo().toUpperCase().contains(pedazoDeTitulo.toUpperCase()))
//                .findFirst();
//        if(episodiosBuscado.isPresent()){
//            System.out.println("Episodio encontrado");
//            System.out.println("Los datos buscado son: "+episodiosBuscado.get());
//        }else{
//            System.out.println("Episodio no encontrado");
//        }

        //Evaluaciones de episodios por temporada
        Map<Integer,Double> evaluacionesPorTemporada=episodios.stream()
                .filter(e->e.getEvaluacion()>0.0)
                .collect(Collectors.groupingBy(Episodios::getTemporada,
                        Collectors.averagingDouble(Episodios::getEvaluacion)));
        System.out.println(evaluacionesPorTemporada);

        //Estadisticas de nuestros episodios

        DoubleSummaryStatistics est=episodios.stream().
                filter(e->e.getEvaluacion()>0.0).
                collect(Collectors.summarizingDouble(Episodios::getEvaluacion));
        System.out.println("Media de las evaluaciones: "+est.getAverage());
        System.out.println("Episodio mejor evaluado: "+est.getMax());
        System.out.println("Episodio peor evaluado: "+est.getMin());
    }

}


