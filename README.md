# Dasafío Navent

## General
- Se realizó una API Rest para el desafío
- Se utilizó java 8 para el desarrollo de la api.
- Se creo el proyecto con el manejador de dependencias maven.
- El IDE utilizado fue Spring Tool Suite 4.
- Se utilizó lombok para facilitar la creación de instancias de objetos (utilizando builder) y declaración de métodos setter, getter y constructores. Este se debe de instalar como plugin en el IDE: [lombok oficial](https://projectlombok.org/download).
- Se utilizó Swagger para documentar la api.
- Se utilizó ModelMapper para mapear dtos con entidades.
- La aplicación se ejecuta en el puerto 8090.

## 1

### Modelos
Se crearon DTOs para las consultas y respuestas del servivio ya que no sería correcto devolver la entidad de la base de datos. Se tomo el modelo Pedido como la clase entidad que representa a la tabla en la base de datos.

### DAO
Si bien en el enunciado comentaba que tanto las clases BumexMemcached como PedidosDAO no eran necesarias de implementar, realicé una pequeña implementación en BumexMemcached simulando el guardado en cache por medio de un atributo de tipo Map. Al mismo se le agregan, eliminan o modifican pedidos.
La clase BumexMemcached se la implementó con el patrón Singleton.

### Agregados
* Se argegó una carpeta util que contiene lo siguiete:
    - KeySimulate: Esta clase simula la generación de un id que se debería generar al insertar un registro en la tabla (por medio de jpa o de una secuencia en la base de datos).
    - ModelMapperUtils: Se creó una clase util que utiliza la librería ModelMapper para mapear las entidades con los dtos y viceversa. Se utiliza método estático para no instanciar el objeto.
* La api esta documentada por medio de Swagger:
    Al ejecutar la aplicación se puede ingresar al mismo atravez de http://localhost:8090/swagger-ui.html
* También se puede probar la aplicación con alguna herramienta para realizar peticiones a una api rest como puede ser Postman. Para estos, dejo los endpoints:
    - **POST** http://localhost:8090/pedidos -- Crea un Crea un pedido -- Code: 201 CREATED
        **Body**
        {
            "descuento": 0,
            "idPedido": 0,
            "monto": 0,
            "nombre": "string"
        }

    - **GET** http://localhost:8090/pedidos/{id} -- Obtiene un usuario específico -- Code: 200 OK
    - **DELETE** http://localhost:8090/pedidos/{id} -- Elimina un pedido -- Code: 200 OK
    - **PUT** http://localhost:8090/pedidos/{id} -- Actualiza un pedido -- Code: 200 OK
        **Body**
        {
            "descuento": 0,
            "idPedido": 0,
            "monto": 0,
            "nombre": "string"
        }

### Service
Se realizan las lógicas del negocio en estos. Se incluyen en el contexto de spring con la anotación @Service y en estos se puede ver la simualción del manejo de daptos con lo que sería el dao de pedidos (PedidosDAO). 

## 2
Teniendo en cuenta que la tabla Pedido tenga muchos registros y columnas habría que:
- Crear los índices necesarios para una búsqueda más eficiente de los datos.
- Normalizar la tabla hasta por lo menos segunda forma normal para no tener datos repetidos y poder desacoplar columnas en tablas relacionales.
- A nivel de aplicación, utilizar consultas SQL que obtenga las columnas que se necesitan para rendimiento en paginación.
- Crear constraints necesarias para validar correctamente los datos que guardarán las columnas y evitar guardar información basura.
- Para columnas de tipo blob, deben de estar en tablas separadas y deben de estar referenciados a través de FK, esto ayudará al rendimiento tanto de búsqueda como de backup.

## 3
### Ejecución
Desde el root del proyecto ejecutar:
- Desde windows: mvnw spring-boot:run
- Desde linux: mvn spring-boot:run
