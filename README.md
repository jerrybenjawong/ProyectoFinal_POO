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

## Ejemplos de ejecución

```sh  
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
<img width="1820" height="933" alt="Diagrama_Proyecto_Final 1" src="https://github.com/user-attachments/assets/855da8e2-fc79-4c23-a29a-09e3693801a3" />
