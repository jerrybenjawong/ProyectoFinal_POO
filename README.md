# Estructura del proyecto                                                                                                                                   
Buscaminas/
├── .classpath                      # Archivo de configuración del proyecto (Eclipse)
├── .project                        # Archivo de proyecto (Eclipse)
├── .settings/                     # Preferencias del entorno Eclipse
│   ├── org.eclipse.core.resources.prefs
│   └── org.eclipse.jdt.core.prefs
├── bin/                           # Archivos compilados (.class)
│   ├── module-info.class
│   ├── controlador/               # Lógica del controlador principal del juego
│   │   └── Controlador.class
│   ├── main/                      # Punto de entrada principal (método main)
│   │   └── Main.class
│   ├── modelo/                    # Lógica del negocio y datos
│   │   ├── Casilla.class
│   │   ├── Jugador.class
│   │   ├── Tablero.class
│   │   ├── excepciones/          # Excepciones personalizadas del juego
│   │   │   ├── CasillaMarcadaException.class
│   │   │   ├── CasillaYaDescubiertaException.class
│   │   │   └── CoordenadaInvalidaException.class
│   │   └── persistencia/         # Gestión de archivos (guardar/cargar partidas)
│   │       └── GestorArchivo.class
│   ├── test/                      # Pruebas unitarias (JUnit)
│   │   └── TableroTest.class
│   └── vista/                     # Interfaz de usuario por consola
│       └── Consola.class
├── src/                           # Código fuente (.java)
│   ├── module-info.java
│   ├── controlador/
│   │   └── Controlador.java
│   ├── main/
│   │   └── Main.java
│   ├── modelo/
│   │   ├── Casilla.java
│   │   ├── Jugador.java
│   │   ├── Tablero.java
│   │   ├── excepciones/
│   │   │   ├── CasillaMarcadaException.java
│   │   │   ├── CasillaYaDescubiertaException.java
│   │   │   └── CoordenadaInvalidaException.java
│   │   └── persistencia/
│   │       └── GestorArchivo.java
│   ├── test/
│   │   └── TableroTest.java
│   └── vista/
│       └── Consola.java


---

# Buscaminas

Juego clásico de Buscaminas desarrollado en Eclipse Java.

---

## Descripción

En este proyecto se implemento el juego de Buscaminas con una consola para interacción este cuenta con la posibilidad de marcar casillas, descubrir minas y verificar si el jugador gana o pierde

---

## Requisitos

- Java SE 8 o superior
- Eclipse IDE 
- JUnit 4 o JUnit 5 para pruebas unitarias

---

## Instalación

1. Clona o descarga este repositorio.
2. Abre Eclipse o tu IDE Java favorito.
3. Importa el proyecto como un proyecto de Java existente o crea uno nuevo y añade las fuentes (`src` y `test`) al build path.
4. Asegúrate que JUnit 4 o JUnit 5 está agregado en el path de compilación.

---

## Cómo usar el juego

- Ejecuta la clase principal `main.Main` para iniciar el juego.
- El juego se inicia en la consola, donde se mostrará el tablero.
- Puedes usar los comandos para hacer los siguiente:

  - Marcar o desmarcar casillas
  - Descubrir casillas para encontrar minas o espacios vacíos
  - El juego termina al descubrir una mina o cuando se descubren todas las casillas sin minas.

---

## Ejemplos de ejecucion 
> java -cp bin main.Main  
Tablero inicial:  
[ ] [ ] [ ] [ ] [ ]  
[ ] [ ] [ ] [ ] [ ]  
[ ] [ ] [ ] [ ] [ ]  
[ ] [ ] [ ] [ ] [ ]  
[ ] [ ] [ ] [ ] [ ]  

> marcar 2 3  
Casilla en (2,3) marcada.  

> descubrir 1 1  
No hay mina en la casilla (1,1).  

> descubrir 0 0  
¡Boom! Has descubierto una mina. Juego terminado.
---
## Diagrama de proyecto

![Diagrama del juego buscamina](https://github.com/jerrybenjawong/ProyectoFinal_POO/blob/f88e657ce57dcdd696db837ce6acca8bb090b807/Diagrama_Proyecto_Final.png)
