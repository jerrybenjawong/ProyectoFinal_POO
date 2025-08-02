# Buscaminas

Juego clásico de Buscaminas desarrollado en Eclipse Java.

---

# Estructura del proyecto 
```
Buscaminas/
└── src/
    ├── module-info.java                   # Archivo de configuración del módulo (opcional en Java moderno)
    ├── controlador/                      # Controlador principal que gestiona el flujo del juego
    │   └── Controlador.java
    ├── main/                             # Punto de entrada del programa
    │   └── Main.java
    ├── modelo/                           # Lógica principal y entidades del juego
    │   ├── Casilla.java
    │   ├── Jugador.java
    │   ├── Tablero.java
    │   ├── excepciones/                 # Excepciones personalizadas del juego
    │   │   ├── CasillaMarcadaException.java
    │   │   ├── CasillaYaDescubiertaException.java
    │   │   └── CoordenadaInvalidaException.java
    │   └── persistencia/               # Manejo de guardado y carga desde archivos
    │       └── GestorArchivo.java
    ├── test/                             # Pruebas unitarias del sistema
    │   └── TableroTest.java
    └── vista/                            # Interfaz de usuario en consola
        └── Consola.java

```
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
```
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
```
---
## Diagrama de proyecto

![Diagrama del juego buscamina](https://github.com/jerrybenjawong/ProyectoFinal_POO/blob/f88e657ce57dcdd696db837ce6acca8bb090b807/Diagrama_Proyecto_Final.png)
