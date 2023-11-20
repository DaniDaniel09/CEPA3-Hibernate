# Proyecto de Gestión de Autores y Libros

Este proyecto es una aplicación simple de gestión de autores y libros, implementada en Java y utilizando una base de datos SQL para almacenar la información.

## Estructura del Proyecto

El proyecto se organiza en tres capas principales:

1. **Capa de Datos (SQL):**
   - La base de datos se gestiona a través de SQL, con tablas para almacenar información sobre autores, detalles de autores, libros y la relación entre autores y libros.

2. **Capa de Lógica de Negocios (Java):**
   - La lógica de negocios se implementa en Java utilizando el framework Hibernate para la persistencia y mapeo objeto-relacional (ORM).

3. **Capa de Interfaz de Usuario (Java):**
   - La interfaz de usuario se implementa en Java, utilizando la consola para la interacción básica del usuario.

## Configuración del Proyecto

### Base de Datos

1. Crea una base de datos llamada `authors`.
2. Configura las credenciales de conexión en el archivo `hibernate.cfg.xml`.

### Estructura de la Base de Datos

```
-- Tabla de Autores
CREATE TABLE Author (
    author_id INT PRIMARY KEY AUTO_INCREMENT,
    author_name VARCHAR(255) NOT NULL
);

-- Tabla de Detalles de Autores
CREATE TABLE AuthorDetails (
    author_id INT PRIMARY KEY,
    is_alive BOOLEAN,
    FOREIGN KEY (author_id) REFERENCES Author(author_id)
);

-- Tabla de Libros
CREATE TABLE Books (
    book_id INT PRIMARY KEY AUTO_INCREMENT,
    book_title VARCHAR(255) NOT NULL,
    author_id INT,
    FOREIGN KEY (author_id) REFERENCES Author(author_id)
);

-- Tabla de Relación M:M entre Autores y Libros
CREATE TABLE Author_Books (
    author_id INT,
    book_id INT,
    PRIMARY KEY (author_id, book_id),
    FOREIGN KEY (author_id) REFERENCES Author(author_id),
    FOREIGN KEY (book_id) REFERENCES Books(book_id)
);
```

# Ejecución del Proyecto
Compila y ejecuta el código Java en tu entorno de desarrollo preferido.
Sigue las instrucciones de la consola para interactuar con la aplicación.
Puedes agregar autores y libros, asignar libros a autores y visualizar la información almacenada mencionada anteriormente.
