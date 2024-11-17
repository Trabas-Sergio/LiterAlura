# 📚 **LiterAlura Challenge**
Desarrollo de un Catálogo de Libros que ofrece interacción textual (vía consola) con los usuarios, proporcionando 5 opciones de interacción. Los libros se buscarán a través de una API específica.

## 🔑 **Funcionalidades principales**
- **Búsqueda avanzada de libros**: Realiza consultas desde la consola mediante **palabras clave**, **autores**, **géneros**, **temas**. 📖✨
- **Integración con Gutendex**: Accede a un **amplio catálogo de libros** actualizados a través de esta API pública. 🌐
- **Almacenamiento local**: Guarda y administra **información relevante** en una base de datos **PostgreSQL** para consultas recurrentes.
- **Interfaz de consola intuitiva**: Los comandos son fáciles de usar, ideales para usuarios y desarrolladores. ⚡

## 🔧 Tecnologías Utilizadas

- **Backend:**
  - **Java**: Lenguaje principal para el desarrollo de la aplicación. ☕
  - **Spring Boot**: Framework utilizado para estructurar el backend y gestionar la lógica de negocio. 🔥
  - **PostgreSQL**: Base de datos relacional utilizada para almacenar información sobre los libros y búsquedas realizadas.
- **API de terceros**
  - **Gutendex API**: Usada para buscar y obtener información sobre libros de dominio público de forma dinámica. 🌍

### DEMO
![ezgif-2-5bffefd870](https://github.com/user-attachments/assets/767c2805-0fde-403f-a7b6-d68c1bc29928)

### 📋 Pre-requisitos 
1. Instala en tu ordenador: Java JDK 17 o superior.

* Puedes descargarlo desde aqui:

  ```
  https://www.oracle.com/ar/java/technologies/downloads/#java17
  
  ```
  
2. Tener acceso a Internet para realizar las solicitudes a la API **Gutendex**.
3. Abre tu IDE o editor de codigo favorito.
   * Aunque el proyecto fue desarrollado en **IntelliJ IDEA**, puedes utilizar cualquier IDE o entorno de desarrollo de tu preferencia (como Eclipse, NetBeans, Visual Studio Code, etc.).
   * Si prefieres IntelliJ IDEA, puedes descargarlo aquí.
   
    ```
    https://www.jetbrains.com/es-es/idea/
    
    ```

4. **Librería Jackson DataBind**: Necesitas agregar la librería Jackson-Datatabind para el manejo de JSON.
* Puedes descargarla desde aqui:

  ```
  https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind/2.16.0

  ```

4. **Database PostGresql**: Necesitas tener una base de datos relacional.
* Puedes descargarla desde aqui:

  ```
  https://www.postgresql.org/download/

  ```

  Por ultimo configure los datos de su Base de Datos en el proyecto Spring.



