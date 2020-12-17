Servicio de Busqueda por Rut
==============

Este proyecto implementa el servicio rest de busqueda por rut, que se conecta al front-end



## Maven

### Ejecutar con maven desde la linea de comando

1. Clonar este proyecto dentro del servidor
2. Levantar la aplicacion ejecutar el siguiente comando desde la consola dentro del servidor:
    
   ```bash
    $ mvn spring-boot:run
    ```


### Consumir el servicio
1. desde el cliente ejecutar una Consulta POST usando esta url  [localhost:8080/user/find_by_rut](localhost:8080/user/find_by_rut) 

    el body tiene que seguir este contrato

    ```json
        {
            "rut":"1234567"
        }
    ```



[Apache Maven]: http://maven.apache.org


