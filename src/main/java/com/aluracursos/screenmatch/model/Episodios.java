package com.aluracursos.screenmatch.model;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Episodios {

    private Integer temporada;

    private String titulo;

    private Integer numeroDeEpisodio;

    private Double evaluacion;

    private LocalDate fechaDelanzamiento;

    public Episodios(Integer numero, DatosEpisodio d) {
        this.temporada=numero;
        this.titulo=d.titulo();
        this.numeroDeEpisodio=d.numeroDeEpisodio();
        try {
            this.evaluacion = Double.valueOf(d.evaluacion());
        }catch (NumberFormatException e){
            this.evaluacion=0.0;
        }
try{
    this.fechaDelanzamiento=LocalDate.parse(d.fechaDeLanzamiento());
}catch(DateTimeParseException e){
    this.fechaDelanzamiento=null;
}

    }

    public Integer getTemporada() {
        return temporada;
    }

    public void setTemporada(Integer temporada) {
        this.temporada = temporada;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getNumeroDeEpisodio() {
        return numeroDeEpisodio;
    }

    public void setNumeroDeEpisodio(Integer numeroDeEpisodio) {
        this.numeroDeEpisodio = numeroDeEpisodio;
    }

    public Double getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(Double evaluacion) {
        this.evaluacion = evaluacion;
    }

    public LocalDate getFechaDelanzamiento() {
        return fechaDelanzamiento;
    }

    public void setFechaDelanzamiento(LocalDate fechaDelanzamiento) {
        this.fechaDelanzamiento = fechaDelanzamiento;
    }

    @Override
    public String toString() {
        return
                "temporada=" + temporada +
                        ", titulo='" + titulo + '\'' +
                        ", numeroDeEpisodio=" + numeroDeEpisodio +
                        ", evaluacion=" + evaluacion +
                        ", fechaDelanzamiento=" + fechaDelanzamiento;
    }
}
