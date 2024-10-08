# Spring Boot GraphQL

Este es una aplicación de Spring Boot que implementa una API GraphQL para gestionar estudiantes y cursos.

## Características

- **GraphQL API**: Soporte completo para consultas y mutaciones de estudiantes y cursos.
- **Gestión de Estudiantes**: Crear, leer, actualizar y eliminar estudiantes.
- **Gestión de Cursos**: Crear, leer, actualizar y eliminar cursos.

## Requisitos

- Java 17
- Maven
- Spring Boot 3

## Instalación

1. Clona el repositorio:
    ```bash
    git clone https://github.com/salvadorbravo09/springboot-graphql.git
    cd springboot-graphql
    ```
   
2. Ejecuta la aplicación:

## Uso

### Consultas GraphQL

- **Obtener todos los estudiantes:**
    ```graphql
    query {
        findAllStudents {
            id
            name
            lastName
            age
        }
    }
    ```

- **Obtener un estudiante por ID:**
    ```graphql
    query {
        findStudentById(studentId: "1") {
            id
            name
            lastName
            age
        }
    }
    ```

### Mutaciones GraphQL

- **Crear un nuevo estudiante:**
    ```graphql
    mutation {
        createStudent(inputStudent: {
            name: "Juan"
            lastName: "Pérez"
            age: 20
            courseId: "1"
        }) {
            id
            name
            lastName
            age
        }
    }
    ```

- **Eliminar un estudiante por ID:**
    ```graphql
    mutation {
        deleteStudentById(studentId: "1")
    }
    ```

## Agradecimientos

Este proyecto fue desarrollado con la guia de [Un Programador Nace](https://www.youtube.com/@unprogramadornace).
