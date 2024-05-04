package com.aluracursos.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)//esta "anotacion" es para ignorar los demas
                                            // datos(propiedades de la api que estamos llamando
                                            //de esta manera solo nos mostrara los datos que le estamos
                                            //q le estamos pidiendo en este caso Title,totalSeasons y imdbRating
                                            //asi no mapea todos los contenidos de la api
public record DatosDeSerie(@JsonAlias("Title") String titulo,
                           @JsonAlias("totalSeasons") Integer totalDeTemporadas,
                           @JsonAlias("imdbRating") String evaluacion) {
}
