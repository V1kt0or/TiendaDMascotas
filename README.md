# Backend Tienda de Mascotas
> Backen de la web de una Tienda de Mascotas.
## Table of Contents
* [Información importante](#información-importante)
* [Autorización en las apis](#autorización-en-las-apis)
* [Ruta Authenticacion](#ruta-authenticacion)
* [Ruta Usuarios](#ruta-usuarios)
<!-- * [License](#license) -->


## Información importante
- Es un poco obvio y tal vez redundante, pero está hecho en Spring
- Actualmente el backen permite generar tokens y las gestion de Usuarios(crear, ver, eliminar).
- La base de datos está en MySql, tienen que crear la tabla tiendamascotas, las tablas se generan autómaticamente al momento de cargar la aplicación.
- La aplicación tambien carga a la Base de Datos automaticamente en la Tabla Rol los roles ADMIN y NORMAL con los id 1 y 2 respectivamente.
- Why did you undertake it?
<!-- You don't have to answer all the questions - just the ones relevant to your project. -->


## Autorización en las apis
Las apis las podríamos dividir en 2 categorías: las que necesitan token y las que no.
Las que requieren token tienen que generarlo usando la Api para generar token, para esto es necesario que creen un usuario, no importa el rol. 
Una vez generado tendran que colocarlo en la parte de Autorización Bearer Token de su Postman, Insomnia o lo que usen.
- Apis que no requieren token
  - Generar token 
  - Añadir usuarios 
- Apis que requieren token
  - Ver usuario
  - Eliminar usuario



## Ruta Authenticacion
- **Generador de token**

  -Json enviado
  ```javascript
    {
    "username": "usuario",
    "password" :"contraseña"
    }
  ```
  -Respuesta
  ```javascript
    {
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyNCIsImV4cCI6MTY2OTM3MDkzMSwiaWF0IjoxNjY5MzM0OTMxfQ.BSq0jxD2w1LhdynaaowxmXcaaVaq_De4cWtt81iOUQU"
    }
  ```


## Ruta Usuarios

- **Crear usuario** (recordar que rol id 1 es ADMIN y rol id 2 es NORMAL)

  -Ruta
  ```javascript
    http://localhost:8080/usuarios/
  ```
  

  -Json enviado
  ```javascript
    {
    "nombre": "Luis",
    "username": "usuario",
    "password": "12345",
    "apellidoPaterno": "Montoya",
    "apellidoMaterno": "Peralta",
    "edad": "18",
    "correo": "zxcz@gmail.com",
    "fechaRegistro": "2015-12-10",
    "direccion": "mi casa",
    "rol":{
        "id": 1
    }
    }
  ```

  
- **Ver usuario**

  -Ruta
  ```javascript
    http://localhost:8080/usuarios/ElUsernameDeSuUsuario
  ```

  -Respuesta
  ```javascript
    {
    "id": 2,
    "username": "user4",
    "password": "12345",
    "apellidoPaterno": "Montoya",
    "apellidoMaterno": "Peralta",
    "edad": 18,
    "direccion": "mi casa",
    "correo": "zxcz@gmail.com",
    "fechaRegistro": "2015-12-10T00:00:00.000+00:00",
    "activo": true,
    "rol": {
        "id": 1,
        "rolNombre": "NORMAL"
    },
    "carrito": null,
    "enabled": true,
    "authorities": [
        {
            "authority": null
        }
    ],
    "accountNonLocked": true,
    "accountNonExpired": true,
    "credentialsNonExpired": true
    }
  ```
 
- **Eliminar usuario**: La eliminación es lógica, por lo que solo se cambiara su estado "Activo" a false

  -Ruta
  ```javascript
    http://localhost:8080/usuarios/ElIdDelUsuario
  ```

