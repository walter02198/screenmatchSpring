# Screenmatch

Aplicación de consola en Spring Boot que permite buscar series de TV usando la API de OMDb, analizar episodios, calcular estadísticas de calificaciones y generar rankings.

## 🛠️ Tecnologías

- Java 17
- Spring Boot 3.2.5
- Jackson Databind 2.17.0 (procesamiento JSON)
- Maven (wrapper incluido)

## 📋 Requisitos

- Java 17 o superior
- Maven (o usar el wrapper `./mvnw`)

## 🚀 Cómo ejecutar

```bash
# Clonar el repositorio
git clone <url>
cd screenmatchSpring

# Ejecutar con Maven Wrapper
./mvnw spring-boot:run

# o con Maven directo
mvn spring-boot:run
```

## 📁 Estructura del proyecto

```
src/main/java/com/aluracursos/screenmatch/
├── ScreenmatchApplication.java    # Punto de entrada
├── model/                         # DTOs y clases de dominio
│   ├── DatosDeSerie.java         # Datos generales de la serie
│   ├── DatosTemporadas.java      # Datos de temporadas
│   ├── DatosEpisodio.java        # Datos de episodios
│   └── Episodios.java            # Entidad de episodio
├── service/                       # Lógica de negocio
│   ├── ConsumoApi.java          # Cliente HTTP para OMDb
│   ├── ConvierteDatos.java       # Conversor JSON a objetos
│   └── IConvierteDatos.java      # Interfaz del conversor
└── principal/
    ├── Principal.java            # Menú principal y flujo
    └── EjemplosStream.java       # Ejemplos de Streams
```

## 🎯 Características

- Búsqueda de series por nombre en OMDb API
- Listado de episodios por temporada
- Cálculo de estadísticas (promedio, máximo, mínimo)
- Rankings de episodios por calificación
- Filtrado por año de lanzamiento

## Autor

Walter Valverde
