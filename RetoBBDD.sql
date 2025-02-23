ALTER USER 'root'@'localhost' IDENTIFIED BY 'Arn17032001';
DROP DATABASE IF EXISTS gestion_eventos;
CREATE DATABASE gestion_eventos;
USE gestion_eventos;

CREATE TABLE Usuario (
	id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(15) NOT NULL,
    apellidos VARCHAR(30) NOT NULL,
    correo VARCHAR(50) NOT NULL UNIQUE,
    contrasenia CHAR(15) NOT NULL,
    fecha_registro DATE NOT NULL DEFAULT(CURRENT_DATE)
);

CREATE TABLE Categoria (
	id_categoria INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE Organizador (
	id_organizador INT AUTO_INCREMENT PRIMARY KEY,
    nombre_organizador VARCHAR(100) NOT NULL,
    contacto VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE Evento (
	id_evento INT AUTO_INCREMENT PRIMARY KEY,
    nombre_evento VARCHAR(100) NOT NULL,
    fecha_evento DATE NOT NULL,
    duracion TIME NULL,
    ubicacion VARCHAR(150) NOT NULL,
    tipo_evento ENUM('Online', 'Presencial', 'Híbrido') NOT NULL,
    id_categoria INT NOT NULL,
    id_organizador INT NOT NULL,
    FOREIGN KEY (id_categoria) REFERENCES Categoria(id_categoria) ON DELETE CASCADE,
    FOREIGN KEY (id_organizador) REFERENCES Organizador(id_organizador) ON DELETE CASCADE
);

CREATE TABLE Inscripcion (
	id_inscripcion INT AUTO_INCREMENT PRIMARY KEY,
	fecha_inscripcion DATE NOT NULL DEFAULT (CURRENT_DATE),
    id_evento INT NOT NULL,
    id_usuario INT NOT NULL,
    FOREIGN KEY (id_evento) REFERENCES Evento(id_evento) ON DELETE CASCADE,
    FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario) ON DELETE CASCADE
);

CREATE TABLE Asistente (
	id_asistente INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    id_inscripcion INT NOT NULL,
    FOREIGN KEY (id_inscripcion) REFERENCES Inscripcion(id_inscripcion) ON DELETE CASCADE
);
