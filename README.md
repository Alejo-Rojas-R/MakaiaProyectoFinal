# API REST Evaluación y Perfilamiento (Microservicio)

Esta aplicación fue diseñada en el marco del proyecto integrador del Bootcamp de backend de Makaia como resultado de la implementación de los conocimientos adquiridos en la formación académica.

Esta API REST de Evaluación y Perfilamiento es un microservicio desarrollado con Spring Framework que permite a los usuarios gestionar la información de los aspirantes que se inscriben a los programas académicos del Bootcamp. La API utiliza el protocolo HTTP para permitir que los usuarios interactúen con el sistema a través de una serie URL definidos. Para diseñar esta solución se emplearon las siguientes tecnologías:

- Java 17 :coffee:
- Spring Boot :leaves:Versión de 3.2.1
- Gestor de dependecias con Maven  :elephant:
- Motor de base de datos en MySQL :dolphin: y persistencia de datos co JPA e Hibernate. 
- Integración Continua con Github Actions :octocat: 
- Despliegue con Railway :bullettrain_side:
- Pruebas unitarias con JUnit

Las principales dependencias utilizadas son: 👩‍💻

- Spring Data JPA (Persiste bases de datos SQL utilizando Java Persistence API mediante Spring Data y Hibernate.)
- Spring Web (Construye aplicaciones web, incluyendo RESTful, utilizando Spring MVC. Utiliza Apache Tomcat como contenedor integrado predeterminado.)
- Spring Security (Autenticación JWT)
- JUnit
- Swagger (Documentación de la API)

Esta API tambien se encuentra documentada con Swagger y se podrá probar la funcionalidad de cada uno de los Endpoints en el siguiente link: 

#### :link: [Documentación en Swagger - Evaluacion y perfilamiento](https://evaluacion-y-perfilamiento.up.railway.app/swagger-ui/index.html#/)



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

No olvidar tener a mano los permisos de acceso :closed_lock_with_key: de la aplicación:

Todas las acciones permitidas:
- userName: admin@gmail.com
- password: admin123

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

## 🖥️ Front-End:

Adicionalmente se desarrolló un Front-End con React.js para consumir los endpoints y simular el funcionamiento de la aplicación en un ambiente de producción.

#### :link: [Despliegue Front-End](https://evaluationandprofiling-production.up.railway.app/)

#### :link: [Codigo Front-End](https://github.com/Alejo-Rojas-R/evaluation_and_profiling)

## Colaboradores

<table width="100%">
    <thead>
        <tr>
            <th width="340px">Ingrid Piñerez</th>
            <th width="340px">Jennifer Maigual</th>
            <th width="340px">Alejandro Rojas</th>
        </tr>
    </thead>
    <tbody>
      <tr>
        <td align="center" style="width:33.33%;">
            <img src="https://github.com/IngridPinerez.png" alt="Image 1" style="width:100px;"/>
            <br/>
            Back-End Developer
            <br/>
            <br/>
            <a target="_blank" href="https://www.linkedin.com/in/ingridpinerez">
                <img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white" alt="" style="width:100px;"/>
            </a>
        </td>
        <td align="center" style="width:33.33%;">
            <img src="https://github.com/JenniferMaigual99.png" alt="Image 2" style="width:100px;">
            <br/>
            Back-End Developer <br/> & Tester
            <br/>
            <br/>
            <a target="_blank" href="https://www.linkedin.com/in/jennifer-daniela-maigual-alvarez/">
                <img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white" alt="" style="width:100px;"/>
            </a>
        </td>
        <td align="center" style="width:33.33%;">
            <img src="https://github.com/Alejo-Rojas-R.png" alt="Image 3" style="width:100px;">
            <br/>
            Full-Stack Developer <br/> & Scrum Master
            <br/>
            <br/>
            <a target="_blank" href="https://www.linkedin.com/in/alejandro-rojas-rodriguez/">
                <img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white" alt="" style="width:100px;"/>
            </a>
        </td>
      </tr>
    </tbody>
</table>
