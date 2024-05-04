package com.aluracursos.screenmatch.service;

public interface IConvierteDatos {

    <T> T obtenerDatos(String json, Class<T> clase);//se coloca "<T> T" para indicar q es un tipo de dato generico


}
