# API REST Evaluación y Perfilamiento (Microservicio)

Esta aplicación fue diseñada en el marco del proyecto integrador del Bootcamp de backend de Makaia como resultado de la implementación de los conocimientos adquiridos en la formación académica.

Esta API REST de Evaluación y Perfilamiento es un microservicio desarrollado con Spring Framework que permite a los usuarios gestionar la información de los aspirantes que se inscriben a los programas académicos del Bootcamp. La API utiliza el protocolo HTTP para permitir que los usuarios interactúen con el sistema a través de una serie URL definidos. Para diseñar esta solución se emplearon las siguientes tecnologías:

- Java 17 :coffee:
- Spring Boot :leaves:Versión de 3.2.1
- Gestor de dependecias con Maven  :elephant:
- Motor de base de datos en MySQL :dolphin: y persistencia de datos co JPA e Hibernate. 
- Integración Continua con Github Actions :octocat: 
- Despliegue con Railway :bullettrain_side:

Las principales dependencias utilizadas son: 👩‍💻

- Spring Data JPA (Persiste bases de datos SQL utilizando Java Persistence API mediante Spring Data y Hibernate.)
- Spring Web (Construye aplicaciones web, incluyendo RESTful, utilizando Spring MVC. Utiliza Apache Tomcat como contenedor integrado predeterminado.)
- Spring Security (Autenticación JWT)
- JUnit (Testeo de pruebas unitarias)
- Swagger (Documentación de la API)

Adicionalmente esta API se encuentra documentada con Swagger y podrá probar la funcionalidad de cada una de las clases en los Endpoints disponibles en el siguiente link: 

#### :link:[ Documentación en Swagger - Evaluacion y perfilamiento](https://evaluacion-y-perfilamiento.up.railway.app/swagger-ui/index.html#/)

No olvidar tener a mano los permisos de acceso :closed_lock_with_key: de la aplicación:

Todas las acciones permitidas:
- userName: admin@gmail.com
- password: admin123

## :computer: UML Modelo:

![UML](https://github.com/Alejo-Rojas-R/MakaiaProyectoFinal/blob/main/diagramas/diagrama_de_clases_uml-UML.drawio.png)

## :space_invader: Patrones de diseño:

### DTO (Data Transfer Object):
Se utiliza este patrón para transferencia de datos entre diferentes capas de la aplicación, y para mejorar la seguridad de la aplicación al controlar qué datos se transfieren.

## :computer: Diagrama flujo:

![UML](https://github.com/Alejo-Rojas-R/MakaiaProyectoFinal/blob/main/diagramas/Diagrama%20de%20flujo%20evaluaci%C3%B3n%20y%20perfilamiento.png)

## :computer: Diagrama Entidad Relación:

![MER](https://github.com/Alejo-Rojas-R/MakaiaProyectoFinal/blob/main/diagramas/Actualizaci%C3%B3nER.png)

## :computer: Endpoints:

## Inicio de sesión 👨‍🔧

### GET: /public/login

🚪 Este endpoint permite dar acceso a la aplicación.

##### Parámetros de entrada:

- email: Email de autenticación (cadena de texto)
- contrasena: Contraseña de autenticación (cadena de texto)

Ejemplo de solicitud:

```https://evaluacion-y-perfilamiento.up.railway.app/public/login```

```java 
{
    "email": "admin@gmail.com",
    "contrasena": "admin123"
}
```

La API devolverá el JWT token que debera ser copiado para usarlo en los enpoints privados que realizan acciones en la aplicación:

```json
{
    "email": "admin@gmail.com",
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbkBnbWFpbC5jb20iLCJlbWFpbCI6ImFkbWluQGdtYWlsLmNvbSIsInJvbGVzIjoiVVNFUiIsImV4cCI6MTcwODExMTMyNH0.-ZwyywdhZmbcgln1FHHSYY3O_IRDSoEVXgTAUT08NMA"
}
```

## Creación de un aspirante :raising_hand:

### POST: /private/registrar_aspirante

🙍 Este endpoint permite **Crear** un nuevo aspirante en la base de datos con la información proporcionada en el cuerpo de la solicitud.

##### Parámetros de entrada:

- idAspirantePrueba: Clave auto incrementable (numero)
- programa: Formacion academica al que se quiere postular (cadena de texto)
- nombre: Nombre del aspirante (cadena de texto)
- tipoDocumento: Tipo de documento del aspirante (cadena de texto)
- numDocumento: Numero de documento del aspirante (numero)
- genero: Genero del aspirante (cadena de texto)
- edad: Edad del aspirante (numero)
- nacimiento: Fecha de nacimiento del aspirante (fecha)
- celular: Celular del aspirante (numero)
- email: Email del aspirante(cadena de texto)
- departamento: Departamento del aspirante (cadena de texto)
- ciudad: Ciudad del aspirante(cadena de texto)
- direccionResidencia: Dirección donde vive el aspirante (cadena de texto)
- estrato: Estrato socioeconomico del aspirante (cadena de texto)
- reconocimiento: Grupo etnico del aspirante (cadena de texto)
- discapacidad: Discapacidad del aspirante (cadena de texto)
- poblacion: Grupo poblacional del aspirante (cadena de texto)
- nivelEducativo: Nivel educativo del aspirante (cadena de texto)
- ocupacion: Ocupacion del aspirante (cadena de texto)
- ultimoTituloAcademico: Ultimo titulo académico obtenido del aspirante (cadena de texto)
- estudioTrabajo: El aspirante estudia o trabaja (cadena de texto)
- salario: Salario del aspirante (cadena de texto)
- tiempoLibre: tiempo libre del aspirante (cadena de texto)

Ejemplo de solicitud:

```https://evaluacion-y-perfilamiento.up.railway.app/private/registrar_aspirante```

```java 
{
  "idAspirantePrueba": String,
  "programa": String,
  "nombre": String,
  "tipoDocumento": String,
  "numDocumento": Integer,
  "genero": String,
  "edad": Integer,
  "nacimiento": Date,
  "celular": Integer,
  "email": String,
  "departamento": String,
  "ciudad": String,
  "direccionResidencia": String,
  "estrato": String,
  "reconocimiento": String,
  "discapacidad": String,
  "poblacion": String,
  "nivelEducativo": String,
  "ocupacion": String,
  "ultimoTituloAcademico": String,
  "estudioTrabajo": String,
  "salario": String,
  "tiempoLibre": String
}
```

La API devolverá el nuevo cliente creado en formato JSON:
```json
{
  "idAspirantePrueba": "string",
  "programa": "BACK_END",
  "nombre": "string",
  "tipoDocumento": "TARJETA_DE_IDENTIDAD",
  "numDocumento": 0,
  "genero": "MUJER",
  "edad": 0,
  "nacimiento": "2024-02-08T15:11:30.310Z",
  "celular": 0,
  "email": "string",
  "departamento": "AMAZONAS",
  "ciudad": "string",
  "direccionResidencia": "string",
  "estrato": "UNO",
  "reconocimiento": "NINGUN_GRUPO_ETNICO",
  "discapacidad": "NINGUNA",
  "poblacion": "DESPLAZADO",
  "nivelEducativo": "PRIMARIA",
  "ocupacion": "NO_ESTUDIO_NI_TRABAJO",
  "ultimoTituloAcademico": "string",
  "estudioTrabajo": "string",
  "salario": "NO_APLICA",
  "tiempoLibre": "string"
}
```

## Listar aspirantes registrados :raising_hand:

### GET: /private/listar_aspirantes

📋 Este endpoint permite listar a todos los aspirantes que se han registrado satisfactoriamente.

##### Sin parámetros de entrada.

Ejemplo de solicitud:

```https://evaluacion-y-perfilamiento.up.railway.app/private/listar_aspirantes```

La API devolverá los aspirantes encontrados en formato JSON:

```json
[
{
    "id": 0,
    "idAspirantePrueba": "string",
    "programa": "BACK_END",
    "nombre": "string",
    "tipoDocumento": "TARJETA_DE_IDENTIDAD",
    "numDocumento": 0,
    "genero": "MUJER",
    "edad": 0,
    "nacimiento": "2024-02-10T00:22:26.022Z",
    "celular": 0,
    "email": "string",
    "departamento": "AMAZONAS",
    "ciudad": "string",
    "direccionResidencia": "string",
    "estrato": "UNO",
    "reconocimiento": "NINGUN_GRUPO_ETNICO",
    "discapacidad": "NINGUNA",
    "poblacion": "DESPLAZADO",
    "nivelEducativo": "PRIMARIA",
    "ocupacion": "NO_ESTUDIO_NI_TRABAJO",
    "ultimoTituloAcademico": "string",
    "estudioTrabajo": "string",
    "salario": "NO_APLICA",
    "tiempoLibre": "string",
    "estadoAspirante": "PROCESO_DE_PRUEBA",
    "validadorDeTestGorilla": {
      "id": 0,
      "aspirante": "string",
      "pruebaTerminada": true,
      "puntajePromedio": 0
    },
    "perfilamientoAspirante": {
      "id": 0,
      "aspirante": "string",
      "perfilAspirante": "BECADO",
      "tipoDePerfilamiento": "AUTOMATICO",
      "responsablePerfilarManual": {
        "id": 0,
        "email": "string",
        "contrasena": "string",
        "rol": "ADMIN",
        "usuarioResponsable": [
          "string"
        ],
        "enabled": true,
        "password": "string",
        "username": "string",
        "authorities": [
          {
            "authority": "string"
          }
        ],
        "accountNonExpired": true,
        "accountNonLocked": true,
        "credentialsNonExpired": true
      }
    }
  }
]
```

## Listar aspirantes registrados por perfil :raising_hand:

### GET: /private/listar_por_perfil/{perfil}

🕵 Este endpoint permite listar a los aspirantes que tengan un perfil en particular (BECADO, COMERCIAL o PENDIENTE).

##### Parámetros de entrada:

- perfil : BECADO / COMERCIAL / PENDIENTE (string)

Ejemplo de solicitud:

```https://evaluacion-y-perfilamiento.up.railway.app/private/listar_por_perfil/BECADO```

La API devolverá los aspirantes encontrados en formato JSON:
```json
[
  {
    "id": 0,
    "aspirante": "string",
    "perfilAspirante": "BECADO",
    "tipoDePerfilamiento": "AUTOMATICO",
    "responsablePerfilarManual": {
      "id": 0,
      "email": "string",
      "contrasena": "string",
      "rol": "ADMIN",
      "usuarioResponsable": [
        "string"
      ],
      "enabled": true,
      "password": "string",
      "username": "string",
      "authorities": [
        {
          "authority": "string"
        }
      ],
      "accountNonExpired": true,
      "accountNonLocked": true,
      "credentialsNonExpired": true
    }
  }
]
```
## Listar aspirantes por tipo de perfilamiento :gear: :open_hands:

### GET: /private/listar_por_tipo_de_perfilamiento/{tipoDePerfil}

🕵 Este endpoint permite listar a los aspirantes por el tipo de perfilamiento aplicado al aspirante (AUTOMÁTICO O MANUAL).

##### Parámetros de entrada:

- tipoDePerfil : AUTOMATICO / MANUAL (string)

Ejemplo de solicitud:

```https://evaluacion-y-perfilamiento.up.railway.app/private/listar_por_tipo_de_perfilamiento/AUTOMATICO```

La API devolverá los aspirantes encontrados en formato JSON:
```json
[
  {
    "id": 0,
    "aspirante": {
      "id": 0,
      "idAspirantePrueba": "string",
      "programa": "BACK_END",
      "nombre": "string",
      "tipoDocumento": "TARJETA_DE_IDENTIDAD",
      "numDocumento": 0,
      "genero": "MUJER",
      "edad": 0,
      "nacimiento": "2024-02-20T15:43:25.841Z",
      "celular": 0,
      "email": "string",
      "departamento": "AMAZONAS",
      "ciudad": "string",
      "direccionResidencia": "string",
      "estrato": "UNO",
      "reconocimiento": "NINGUN_GRUPO_ETNICO",
      "discapacidad": "NINGUNA",
      "poblacion": "DESPLAZADO",
      "nivelEducativo": "PRIMARIA",
      "ocupacion": "NO_ESTUDIO_NI_TRABAJO",
      "ultimoTituloAcademico": "string",
      "estudioTrabajo": "string",
      "salario": "NO_APLICA",
      "tiempoLibre": "string",
      "estadoAspirante": "PROCESO_DE_PRUEBA",
      "validadorDeTestGorilla": {
        "id": 0,
        "aspirante": "string",
        "pruebaTerminada": true,
        "puntajePromedio": 0
      },
      "perfilamientoAspirante": "string"
    },
    "perfilAspirante": "BECADO",
    "tipoDePerfilamiento": "AUTOMATICO",
    "responsablePerfilarManual": {
      "id": 0,
      "email": "string",
      "contrasena": "string",
      "rol": "ADMIN",
      "usuarioResponsable": [
        "string"
      ],
      "enabled": true,
      "password": "string",
      "username": "string",
      "authorities": [
        {
          "authority": "string"
        }
      ],
      "accountNonExpired": true,
      "accountNonLocked": true,
      "credentialsNonExpired": true
    }
  }
]
```

## Listar aspirantes por programa :desktop_computer: :globe_with_meridians: :bar_chart: :cloud:

### GET:/private/listar_aspirante_por_programa/{programa}

📋 Este endpoint permite filtrar los aspirantes de acuerdo al programa asignado (BACK_END, FRONT_END, ANALISIS_DATOS, CLOUD).

##### Parámetros de entrada:
- programa: BACK_END / FRONT_END / ANALISIS_DATOS / CLOUD (string)

Ejemplo de solicitud:

```https://evaluacion-y-perfilamiento.up.railway.app/private/listar_aspirante_por_programa/BACK_END ```

La API devolverá los aspirantes encontrados en formato JSON:

```json
[
  {
    "id": 0,
    "idAspirantePrueba": "string",
    "programa": "BACK_END",
    "nombre": "string",
    "tipoDocumento": "TARJETA_DE_IDENTIDAD",
    "numDocumento": 0,
    "genero": "MUJER",
    "edad": 0,
    "nacimiento": "2024-02-20T16:34:46.466Z",
    "celular": 0,
    "email": "string",
    "departamento": "AMAZONAS",
    "ciudad": "string",
    "direccionResidencia": "string",
    "estrato": "UNO",
    "reconocimiento": "NINGUN_GRUPO_ETNICO",
    "discapacidad": "NINGUNA",
    "poblacion": "DESPLAZADO",
    "nivelEducativo": "PRIMARIA",
    "ocupacion": "NO_ESTUDIO_NI_TRABAJO",
    "ultimoTituloAcademico": "string",
    "estudioTrabajo": "string",
    "salario": "NO_APLICA",
    "tiempoLibre": "string",
    "estadoAspirante": "PROCESO_DE_PRUEBA",
    "validadorDeTestGorilla": {
      "id": 0,
      "aspirante": "string",
      "pruebaTerminada": true,
      "puntajePromedio": 0
    },
    "perfilamientoAspirante": "string"
  }
]
```

## :dizzy:  CI-Integración Continua:

Se utiliza GitHub Actions :octocat: para la integración continua. GitHub Actions es una herramienta de automatización que permite ejecutar flujos de trabajo automatizados en respuesta a eventos específicos, como la creación de una solicitud de merge. Con esta herramienta se automatiza la ejecución de pruebas, el empaquetado de la aplicación y la implementación en diferentes entornos, todo dentro del mismo flujo de trabajo. Esto permite ahorrar tiempo y reducir errores al asegurarme de que la aplicación se construya correctamente en cada cambio que se hace en el código. GitHub Actions permite personalizar las configuraciones para satisfacer las necesidades específicas del proyecto.

## :arrow_double_up:  CD-Despliegue Continuo:

Se utiliza Railway :bullettrain_side: para el despliegue continuo. La plataforma de alojamiento de aplicaciones proporciona una funcionalidad de despliegue continuo que permite implementar automáticamente cualquier cambio en el código en un entorno de producción. Al utilizar Github como fuente, Railway desencadena una construcción y despliegue automático en el entorno de producción en cada cambio en el repositorio sin la necesidad de intervención manual. 
