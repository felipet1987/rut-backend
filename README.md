Servicio de Busqueda por Rut
==============

Este proyecto implementa el servicio rest de busqueda por rut, que se conecta al front-end



## Maven

### Ejecutar con maven desde la linea de comando



- para levantar la aplicacion ejecutar el siguiente comando desde la consola dentro del servidor:
    
   ```bash
    $ mvn spring-boot:run
    ```

desde el cliente usar esta url  [localhost:8080/user/find_by_rut](localhost:8080/user/find_by_rut) 

para el request seguir este contrato

    ```json
        {
            "rut":"1234567"
        }
    ```



[Apache Maven]: http://maven.apache.org


