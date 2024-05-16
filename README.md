# **FalkenMaze - Nathan Gonzalez Mercado - 1ºDAM**

## Introducción
Esta aplicación nos permite generar nuestros propios laberintos con distintos bloques. Al iniciar el programa, nos encotnraremos con la siguiente vista:

![Vista Principal del Programa](https://github.com/Nathan-GM/FalkenMazeNGM/assets/158311460/7df8e96b-245f-42e4-bdc7-26b3fe0469fb)

Aquí podremos ver que encontramos lo siguiente:

1. Menú
   - Archivo
     - Nuevo -> Permite crear nuestro laberinto de 0
     - Guardar -> Permite guardar nuestro laberinto en 3 formatos: XML, JSON y BIN
     - Abrir -> Nos permite abrir un laberitno desde un fichero con alguna de las 3 extensiones mencionadas.
     - Salir -> Cierra el programa
   - Options
     - Sound -> Nos permite ajustar un sonido para nuestro laberinto. Obligatoriamente debe tener uno.
     - Time -> Permite ajustar el tiempo que tenemos para resolver el mismo.
2. Panel con bloques (Lateral Izquierdo) -> Contiene todos los bloques disponibles para generar el laberinto así como un borrador (bloque con icono de basura).
3. Matriz de nuestro laberinto -> Matriz donde podremos crear nuestro laberinto haciendo uso de los bloques que encontramos en el panel.

## Crear Nuevo Maze
Para empezar a diseñar nuestro propio laberinto deberíamos darle a Archivo y ahí a nuevo. Al hacerlo, veremos la siguiente vista:

![Vista Creación Nuevo Maze](https://github.com/Nathan-GM/FalkenMazeNGM/assets/158311460/9a018eae-e85e-43a8-a2f3-eb80d89e996c)

En ella deberemos proporcionarle a nuestro Maze el tamaño considerado y al darle a Aceptar, el mismo se actualizará como se aprecia a continuación.

![Maze recien creado](https://github.com/Nathan-GM/FalkenMazeNGM/assets/158311460/3c40f982-a93d-4af5-abc2-2f8895ea7d01)


A partir de eso, podremos hacer click a cualquier bloque y generar nuestro propio Maze. En mi caso haré uno simple de muestra:

![Maze de Ejemplo](https://github.com/Nathan-GM/FalkenMazeNGM/assets/158311460/88fc24de-f875-4c17-bde8-ed324b209580)

En este caso el bloque con interrogación representa el punto final del laberinto.

## Guardar Maze

Si ahora quisieramos guardarlo en un fichero deberiamos primero asignarle un sonido, ya que sin sonidos el maze no se almacena. Para ello habría que acceder a Options -> Sound y elegir un sonido de nuestra preferencia. Para esta ocasión, usaré el primer fichero .mp3 que encontre en mi ordenador.

![Imagen que muestra como se agrega sonido al maze](https://github.com/Nathan-GM/FalkenMazeNGM/assets/158311460/fa22b5fa-d3d6-4672-86c0-acc7b33b9dc5)

Al darle a Abrir el sonido ya estará asignado a nuestro laberinto y por tanto podremos guardarlo. Para ello iremos a Archivo -> Guardar. Ahí seleccionaremos una ruta donde almacenar nuestro fichero y una extensión que debe ser de uno de los 3 formatos permitidos: XML, JSON y BIN. En esta ocasión lo guardaré como XML y en el escritorio.

![Fichero Maze.xml](https://github.com/Nathan-GM/FalkenMazeNGM/assets/158311460/404a68dd-9ece-4df8-8a40-f726b4030c57)

Podremos apreciar que el maze se guarda correctamente viendo el fichero xml que se guardó correctamente.

## Cargar Maze desde Fichero

A continuación crearemos un Maze nuevo del tamaño de preferencia.

![Nuevo maze](https://github.com/Nathan-GM/FalkenMazeNGM/assets/158311460/fc6f4c65-e262-4a08-8ed6-86ea29eae9db)

A continuación, probaremos que el fichero se abre correctamente dandole a Archivo -> Abrir y en mi caso elegire el anterior.

![Seleccion del fichero anterior](https://github.com/Nathan-GM/FalkenMazeNGM/assets/158311460/06f60417-2c6b-4e1b-874b-9ccca7965d92)


Una vez localizado le daremos a abrir y podremos apreciar que se carga el fichero anterior correctamente, aquí abajo dejo una foto de muestra con el fichero cargado nuevamente.

![Carga Fichero](https://github.com/Nathan-GM/FalkenMazeNGM/assets/158311460/69edf142-fce6-4f10-a84e-331f011ac666)

Esto sería una breve introducción del funcionamiento del Programa.



