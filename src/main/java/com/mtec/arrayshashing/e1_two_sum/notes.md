Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.



Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]


debo mostrar los idices de los numeros que sumados den taget(9)
creo un map donde almacenare los numeros en cuestion
con un for recorro los numeros y con un if anidado compruebo si el numero actual es 
el complemento del numero indice que sumados me den 9. 
y si si es con e put lo guardo  y al final del for muestro

CORRECCCION
Objetivo: Dado un arreglo de números y un número target, devolver los índices de los dos números que suman exactamente target.

Pasos del Algoritmo:

1. Inicializar un Mapa: Crea un HashMap vacío. Este mapa servirá para almacenar los números que ya hemos visto y sus correspondientes índices. La estructura será (número,
   índice).

2. Recorrer el Arreglo: Itera sobre el arreglo de números (nums) desde el primer hasta el último elemento. En cada paso, tendrás acceso al número actual y a su índice i.

3. Calcular el Complemento: Para cada número en el arreglo (nums[i]), calcula el valor "complementario" que necesitas para alcanzar el target. La fórmula es:
   complemento = target - nums[i]

4. Buscar el Complemento en el Mapa: Comprueba si el complemento que acabas de calcular ya existe como una clave en el mapa.
    * Si existe: ¡Has encontrado la solución! Significa que el complemento (cuyo índice ya está guardado en el mapa) y el número actual suman target. Devuelve
      inmediatamente el índice del complemento (que obtienes con map.get(complemento)) y el índice del número actual (i).
    * Si no existe: Pasa al siguiente paso.

5. Guardar el Número Actual: Si no encontraste el complemento en el mapa, añade el número actual (nums[i]) y su índice (i) al mapa. Esto es clave para que en las
   siguientes iteraciones, los futuros números puedan encontrar a este como su complemento.

Este proceso se repite hasta que se encuentra el par. Como el problema garantiza que siempre hay una solución, el bucle encontrará una y retornará los índices.

Puntos clave de corrección sobre tu descripción:

* Tu idea: "...compruebo si el numero actual es el complemento..."
    * Ajuste: La lógica es sutilmente diferente. Calculas el complemento (target - numero_actual) y buscas ese complemento en el mapa.
* Tu idea: "y si si es con el put lo guardo..."
    * Ajuste: El put (guardar en el mapa) se hace cuando NO encuentras el complemento. Si SÍ lo encuentras, ya no necesitas guardar nada, simplemente devuelves el
      resultado y el algoritmo termina.

Tu intuición de usar un mapa y un bucle es la correcta para resolver este problema de manera eficiente. ¡Buen trabajo

### Eficiencia
1. Solución con dos bucles for (Fuerza Bruta)

    - Cómo funciona: Compara cada número con todos los demás números de la lista
      para ver si su suma es igual al objetivo.
    - Complejidad de tiempo: Si la lista tiene n elementos, haces aproximadamente
      n * n comparaciones. Esto se conoce como una complejidad de tiempo de O(n²)
      (cuadrática).
    - Ejemplo práctico: Si tu lista tiene 10,000 números, harías alrededor de
      100,000,000 de operaciones.

2. Solución con HashMap

- Cómo funciona: Recorres la lista una sola vez. Para cada número, calculas
  el "complemento" que necesitas (objetivo - número_actual). Luego, buscas si
  ese complemento ya existe en el HashMap.
- La magia del HashMap: Buscar una clave en un HashMap es una operación
  extremadamente rápida, casi instantánea (tiempo constante), sin importar
  cuántos elementos tenga.
- Complejidad de tiempo: Como solo recorres la lista una vez y cada búsqueda
  en el HashMap es súper rápida, la complejidad total es de O(n) (lineal).
- Ejemplo práctico: Para la misma lista de 10,000 números, solo harías 10,000
  operaciones.

Resumen de la Ventaja


┌────────────────┬────────────────┬────────────────────────┐
│ Característica │ Dos Bucles for │ Con HashMap            │
├────────────────┼────────────────┼────────────────────────┤
│ Tiempo         │ Lento (O(n²))  │ Muy Rápido (O(n))      │
│ Memoria        │ Mínimo (O(1))  │ Usa más memoria (O(n)) │
└────────────────┴────────────────┴────────────────────────┘


En resumen, la solución con HashMap sacrifica un poco de memoria para ganar
una enorme mejora en la velocidad. Para listas pequeñas, la diferencia no se
nota, pero para listas grandes, la solución con HashMap es drásticamente más
rápida y eficiente.

## truco
Ahí está el truco:

Algoritmo con dos for

Este algoritmo no recorre el array una vez. Lo recorre una vez por cada
elemento del array.

Para tu ejemplo de 1,000,000 de números:
1. Toma el primer número y lo compara con los otros 999,999 números. (1
   millón de comparaciones)
2. Toma el segundo número y lo compara con los otros 999,998 números. (~1
   millón de comparaciones)
3. Toma el tercer número y lo compara con los otros 999,997 números. (~1
   millón de comparaciones)
4. ...y así sucesivamente.

El total de operaciones no es 1 millón. ¡Es aproximadamente 1 millón
multiplicado por 1 millón, lo que da un billón (1,000,000,000,000) de
operaciones! Es una cantidad enorme que haría que el programa tardara
muchísimo tiempo.

Algoritmo con HashMap

Este algoritmo recorre el array una sola vez, de principio a fin.

Para tu ejemplo de 1,000,000 de números:
1. Toma el primer número. Calcula el complemento. Busca en el HashMap
   (operación instantánea). No está. Añade el primer número al HashMap.
2. Toma el segundo número. Calcula el complemento. Busca en el HashMap
   (instantáneo). No está. Añade el segundo número.
3. ...y así sucesivamente.

El número total de "pasos" a través del array es simplemente 1 millón. En cada
paso, la operación principal (buscar o añadir en el HashMap) es tan rápida que
casi no cuenta.

Analogía Final

Imagina que tienes una fila de 1 millón de personas y tienes que encontrar a
dos personas que midan juntas 3.50 metros.

- Dos `for`: Le preguntas la altura a la primera persona. Luego, vas y le
  preguntas su altura a cada una de las otras 999,999 personas para hacer la
  suma. Después, haces lo mismo con la segunda persona de la fila, y así
  sucesivamente. Terminarías haciendo un billón de preguntas.

- `HashMap`: Tienes una libreta (el HashMap). Le preguntas la altura a la
  primera persona (ej: 1.70m). Anotas en tu libreta "He visto a alguien de
  1.70m". Luego le preguntas a la segunda (ej: 1.80m) y piensas: "Necesito a
  alguien que mida 1.70m (3.50 - 1.80). ¿Está en mi libreta?". Miras tu
  libreta, ¡y sí está! Los has encontrado. Solo tuviste que recorrer la fila
  una vez.

Ambos algoritmos "recorren" la fila de personas, pero el segundo método es
infinitamente más inteligente y rápido.

## NO todos los casos 
entonces en una libreria al tener miles de libros lo eficiente para buscar
seria con hasmap. o habra una coso en elque no conviene?

✦ ¡Excelente pregunta! Has llegado al núcleo del diseño de algoritmos: entender
los "peros" y las concesiones.

Tienes toda la razón. En la mayoría de los casos de búsqueda en la biblioteca,
el HashMap (el índice digital) es el rey. Pero sí, existen escenarios
importantes donde no conviene o donde otras soluciones son mejores.

Aquí están los principales casos:

1. Cuando la memoria es un recurso muy limitado

- El problema: El HashMap necesita cargar el índice completo en la memoria
  RAM. Cada "entrada" en el índice (el título del libro y dónde encontrarlo)
  ocupa un pequeño espacio. Si tienes una cantidad gigantesca de libros
  (pensemos en miles de millones) y muy poca memoria (como en un dispositivo
  simple o un sistema embebido), podrías quedarte sin memoria RAM antes de
  terminar de construir el índice.
- Conclusión: Si la memoria es más valiosa que el tiempo, un HashMap gigante
  puede no ser viable.

2. Cuando solo vas a buscar una o muy pocas veces

- El problema: Crear el índice (HashMap) tiene un costo inicial: tienes que
  recorrer toda la colección de libros una vez para construirlo. Si solo vas
  a hacer una única búsqueda, podrías encontrar el libro con un bucle simple
  antes de que el otro método haya terminado de construir su índice.
- Ejemplo: Buscas un libro.
    - Método Bucle: Empiezas a mirar libros uno por uno. Si tienes suerte, el
      libro que buscas es el tercero de la lista. Lo encuentras y terminas.
      ¡Muy rápido!
    - Método HashMap: Primero, recorres los 10,000 libros para crear el
      índice. Después, haces tu búsqueda instantánea. El tiempo total fue
      (tiempo de indexar 10,000 libros) + (búsqueda instantánea).
- Conclusión: El HashMap es como estudiar para un examen. Si solo te van a
  hacer una pregunta, quizás no valga la pena estudiar el libro entero. Pero
  si te van a hacer muchas preguntas (muchas búsquedas), la inversión de
  estudiar (crear el índice) se paga con creces.

3. Cuando el tipo de búsqueda no es exacto (¡Este es el más importante!)

El HashMap es un campeón para búsquedas de clave exacta: ISBN -> Libro. Pero
es terrible para otros tipos de búsqueda muy comunes:

- Búsquedas por rango: "¿Qué libros se publicaron entre 1980 y 1990?". Un
  HashMap no puede responder a esto eficientemente. Tendrías que revisar
  todos los libros del mapa. Para esto, una lista ordenada por fecha sería
  mucho mejor.
- Búsquedas por prefijo: "¿Qué libros empiezan con 'El señor de...'?". El
  HashMap no sirve para esto. Necesitas una estructura de datos especializada
  llamada Trie (o árbol de prefijos).
- Búsquedas de "cercanía" o "similitud": "¿Cuáles son los 5 libros más
  parecidos a este?". Esto ya es terreno de algoritmos más complejos (machine
  learning, búsqueda semántica, etc.) y un HashMap no te ayuda en nada.

Tabla Resumen


┌───────────────────────────┬───────────────────────┬─────────────────────────
─┐
│ Situación                 │ ¿Conviene usar `Ha... │ Alternativa Mejor
│
├───────────────────────────┼───────────────────────┼─────────────────────────
─┤
│ **Buscar muchas veces ... │ **Sí, es la opción... │ Ninguna es más rápida.
│
│ **Poca memoria y mucho... │ No. Puede que no q... │ Buscar en disco (lent...
│
│ **Hacer solo una o dos... │ No necesariamente.    │ Un bucle simple puede...
│
│ **Buscar por rango (fe... │ No. Es muy inefici... │ Una lista ordenada o ...
│
│ **Buscar por inicio de... │ No. No está diseña... │ Un Trie (árbol de pre...
│
└───────────────────────────┴───────────────────────┴─────────────────────────
─┘

En conclusión: el HashMap es una herramienta superpoderosa, pero no es un
martillo para todos los clavos. Su punto fuerte es la aceleración masiva de
búsquedas exactas y repetitivas, a cambio de usar más memoria.
