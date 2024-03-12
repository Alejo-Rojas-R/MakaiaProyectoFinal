# API RESTful Evaluation and Profiling (Microservice)

This application was designed within the framework of the Makaia backend Bootcamp integrative project implementing the knowledge acquired in the academic training.

This API RESTful is a microservice developed with Spring Framework that allows users to manage the information of applicants who enroll in the Bootcamp academic programs. The API uses the HTTP protocol to allow users to interact with the system through a series of defined URLs. To design this solution, the following technologies were used:

## 🖥️ Tech Stacks:

- Java 17 :coffee:
- Spring Boot 3.2.1 :leaves:
- Dependency manager with Maven :elephant:
- Database engine in MySQL :dolphin: and data persistence with JPA and Hibernate.
- Continuous Integration with GitHub Actions :octocat:
- Deployment with Railway :bullettrain_side:
- Unit testing with JUnit

The main dependencies used are: 👩‍💻

- Spring Data JPA (Persist SQL databases using Java Persistence API using Spring Data and Hibernate.)
- Spring Web (Build web applications, including RESTful, using Spring MVC. Use Apache Tomcat as the default built-in container.)
- Spring Security (JWT Authentication)
- JUnit
- Swagger (API Documentation)

This API is also documented with Swagger and you can test the functionality of each of the Endpoints in the following link:

#### :link: [Documentation in Swagger - Evaluation and profiling](https://evaluacion-y-perfilamiento.up.railway.app/swagger-ui/index.html#/)



## :computer: UML Model:

![UML](https://github.com/Alejo-Rojas-R/MakaiaProyectoFinal/blob/main/diagramas/diagrama_de_clases_uml-UML.drawio.png)

## :space_invader: Design patterns:

### DTO (Data Transfer Object):
This pattern is used to transfer data between different layers of the application, and to improve the security of the application by controlling what data is transferred.

## :computer: Flowchart:

![UML](https://github.com/Alejo-Rojas-R/MakaiaProyectoFinal/blob/main/diagramas/Diagrama%20de%20flujo%20evaluaci%C3%B3n%20y%20perfilamiento.png)

## :computer: Entity Relationship Diagram:

![MER](https://github.com/Alejo-Rojas-R/MakaiaProyectoFinal/blob/main/diagramas/Actualizaci%C3%B3nER.png)

## :computer: Endpoints:

Don't forget to have the access permissions :closed_lock_with_key: of the application on hand:

All actions allowed:
- userName: admin@gmail.com
- password: admin123

## Login 👨‍🔧

### GET: /public/login

🚪 This endpoint allows you to give access to the application.

##### No input parameters:

- email: Authentication email (text string)
- password: Authentication password (text string)

Request example:

```https://evaluacion-y-perfilamiento.up.railway.app/public/login```

```java
{
     "email": "admin@gmail.com",
     "password": "admin123"
}
```

The API will return the JWT token that should be copied to use it in the private enpoints that perform actions in the application:

```json
{
    "email": "admin@gmail.com",
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbkBnbWFpbC5jb20iLCJlbWFpbCI6ImFkbWluQGdtYWlsLmNvbSIsInJvbGVzIjoiVVNFUiIsImV4cCI6MTcwODExMTMyNH0.-ZwyywdhZmbcgln1FHHSYY3O_IRDSoEVXgTAUT08NMA"
}
```


## Aspirant creation endpoint :raising_hand:

### POST:/private/register_aspirant

🙍 **Create** a new applicant in the database with the information provided in the body of the application.

##### No input parameters:

Request example:

```https://evaluacion-y-perfilamiento.up.railway.app/private/registrar_aspirante```

The API will return the new registered candidate in JSON format:

```json
{
"id": 37,
  "idAspirantePrueba": "string",
  "programa": "BACK_END",
  "nombre": "string",
  "tipoDocumento": "TARJETA_DE_IDENTIDAD",
  "numDocumento": 0,
  "genero": "MUJER",
  "edad": 0,
  "nacimiento": "2024-02-22T23:39:11.477+00:00",
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
  "validadorDeTestGorilla": null,
  "perfilamientoAspirante": null
}
```

### PUT: /private/modify_applicant

♻ This endpoint allows you to **update** the data of an existing applicant in the database.

##### Input parameters:

- id: candidate id (integer)

Request example:

```https://evaluacion-y-perfilamiento.up.railway.app/private/modificador_aspirante?id=0```

The API will return the candidate with the updated information in JSON format

```json
{
  "id": 0,
  "idAspirantePrueba": "string",
  "programa": "BACK_END",
  "nombre": "string",
  "tipoDocumento": "TARJETA_DE_IDENTIDAD",
  "numDocumento": 0,
  "genero": "MUJER",
  "edad": 0,
  "nacimiento": "2024-02-22T23:58:14.145Z",
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
```

### PUT: /private/modify_applicant_profile/{id}

♻ This endpoint allows you to **update** an applicant's profile by ID.

##### Input parameters:

-id: id (integer)

-Userid: user id (integer)

-profile: SCHOLARSHIP/COMMERCIAL/PENDING

Request example:

```https://evaluacion-y-perfilamiento.up.railway.app/private/modificador_perfil_aspirante/0?idUsuario=1&Perfil=BECADO```

The API will return the applicant with their profile update in JSON format.

```json
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
```

## List registered applicants :raising_hand:

### GET: /private/list_aspirants

📋 This endpoint allows you to list all the candidates who have successfully registered.

##### No input parameters.

Request example:

```https://evaluacion-y-perfilamiento.up.railway.app/private/listar_aspirantes```

The API will return the found candidates in JSON format:

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

## List registered candidates by profile :raising_hand:

### GET: /private/list_by_profile/{profile}

🕵 This endpoint allows you to list applicants who have a particular profile (SCHOLARSHIP, COMMERCIAL or PENDING).

##### Input parameters:

- profile: SCHOLARSHIP / COMMERCIAL / PENDING (string)

Request example:

```https://evaluacion-y-perfilamiento.up.railway.app/private/listar_por_perfil/BECADO```

The API will return the found candidates in JSON format:
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
## List applicants by type of profiling :gear: :open_hands:

### GET: /private/list_by_profiling_type/{profiletype}

🕵 This endpoint allows applicants to be listed by the type of profiling applied to the applicant (AUTOMATIC OR MANUAL).

##### Input parameters:

- ProfileType: AUTOMATIC / MANUAL (string)

Request example:

```https://evaluacion-y-perfilamiento.up.railway.app/private/listar_por_tipo_de_perfilamiento/AUTOMATICO```

The API will return the found candidates in JSON format:
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

## List applicants by program :desktop_computer: :globe_with_meridians: :bar_chart: :cloud:

### GET:/private/list_aspirant_by_program/{program}

📋 This endpoint allows you to filter the candidates according to the assigned program (BACK_END, FRONT_END, ANALISIS_DATOS, CLOUD).

##### Input parameters:
- program: BACK_END / FRONT_END / DATA_ANALYSIS / CLOUD (string)

Request example:

```https://evaluacion-y-perfilamiento.up.railway.app/private/listar_aspirante_por_programa/BACK_END ```

The API will return the found candidates in JSON format:

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

## :dizzy: CI-Continuous Integration:

GitHub Actions :octocat: is used for continuous integration. GitHub Actions is an automation tool that allows you to run automated workflows in response to specific events, such as creating a merge request. This tool automates test execution, application packaging, and deployment to different environments, all within the same workflow. This saves time and reduces errors by ensuring the application is built correctly with every change made to the code. GitHub Actions allows you to customize configurations to meet your specific project needs.

## :arrow_double_up: CD-Continuous Deployment:

Railway :bullettrain_side: is used for the continuous deployment. The application hosting platform provides continuous deployment functionality that allows any code changes to be automatically deployed to a production environment. Using Github as a source, Railway triggers an automatic build and deployment to the production environment on every change to the repository without the need of manual intervention.

## 🖥️ Front-End:

Additionally, a front end was developed with React.js to consume the endpoints and simulate the operation of the application in a production environment.

#### :link: [Front-End Documentation](https://github.com/Alejo-Rojas-R/evaluation_and_profiling)

## Collaborators

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
