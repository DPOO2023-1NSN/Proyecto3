--------------------------------------------------IMPORTANTE----------------------------------------

El archivo principal es inicio, este da dos opciones 1 pra la app principal y 2 para la app huespedes.

Los ususarios para entrar son:

Administrador
User: admin Clave: 1
Huesped
User: huesped Clave: 1
Empleado
User: empleado Clave: 1

En el momento hay dos habitaciones creadas (sin embargo se pueden crear nuevas):
Sus id son 6 y 7, se pueden consultar sus caracteristicas

Hay reservas creadas: id 7038
Se pueden crear nuevas reservas desde el huesped o empleado.

----RESPECTO A LAS PASARELAS-------------------
para implementar una nueva pasarela de pago:
1. agregar el nombre al archivo de la carpeta data/listapasarelas.txt
2. agregar un nuevo archivo de registro de cobros a la carpeta data/ Registro de cobro
3. Crear una nueva clase en modelo.pasarelas que herede de PasarelasGeneral
4. Crear un Jframe para dicha pasarela
5. A partir de aquí es libre, pero se recomienda que el JFrame recopile la info necesaria de cada pasarela y con ella invoque los métodos de la misma.
