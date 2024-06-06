CREATE DATABASE IF NOT EXISTS veterinaria;
USE veterinaria;

CREATE TABLE genero (
    genero_id INT AUTO_INCREMENT PRIMARY KEY,
    genero_descripcion VARCHAR(50) NOT NULL
);

CREATE TABLE tipo_mascota (
    tipo_mascota_id INT AUTO_INCREMENT PRIMARY KEY,
    tipo_mascota_descripcion VARCHAR(50) NOT NULL
);

CREATE TABLE dueno (
    dueno_id INT AUTO_INCREMENT PRIMARY KEY,
    dueno_rut VARCHAR(10) NOT NULL,
    dueno_nombre VARCHAR(100) NOT NULL,
    dueno_apellidos VARCHAR(100) NOT NULL,
    dueno_email VARCHAR(100) NOT NULL
);

CREATE TABLE mascota (
    mascota_id INT AUTO_INCREMENT PRIMARY KEY,
    mascota_nombre VARCHAR(50) NOT NULL,
    mascota_raza VARCHAR(50),
    dueno_id INT NOT NULL,
    genero_id INT NOT NULL,
    tipo_mascota_id INT NOT NULL,
    FOREIGN KEY (dueno_id) REFERENCES dueno(dueno_id),
    FOREIGN KEY (genero_id) REFERENCES genero(genero_id),
    FOREIGN KEY (tipo_mascota_id) REFERENCES tipo_mascota(tipo_mascota_id)
);

CREATE TABLE sucursal (
    sucursal_id INT AUTO_INCREMENT PRIMARY KEY,
    sucursal_nombre VARCHAR(100) NOT NULL,
    sucursal_direccion VARCHAR(100) NOT NULL,
    sucursal_telefono VARCHAR(100) NOT NULL
);

CREATE TABLE tipo_producto (
    tipo_producto_id INT AUTO_INCREMENT PRIMARY KEY,
    tipo_producto_descripcion VARCHAR(50) NOT NULL
);

CREATE TABLE inventario (
    inventario_id INT AUTO_INCREMENT PRIMARY KEY,
    inventario_nombre VARCHAR(100) NOT NULL,
    inventario_marca VARCHAR(100),
    tipo_producto_id INT NOT NULL,
    inventario_existencia INT NOT NULL,
    FOREIGN KEY (tipo_producto_id) REFERENCES tipo_producto(tipo_producto_id)
);

CREATE TABLE medico (
    medico_id INT AUTO_INCREMENT PRIMARY KEY,
    medico_rut VARCHAR(10) NOT NULL,
    medico_nombre VARCHAR(100) NOT NULL,
    medico_apellidos VARCHAR(100) NOT NULL,
    medico_email VARCHAR(100) NOT NULL
);

CREATE TABLE tipo_atencion (
    tipo_atencion_id INT AUTO_INCREMENT PRIMARY KEY,
    tipo_atencion_descripcion VARCHAR(50) NOT NULL
);

CREATE TABLE atencion (
    atencion_id INT AUTO_INCREMENT PRIMARY KEY,
    medico_id INT NOT NULL,
    sucursal_id INT NOT NULL,
    tipo_atencion_id INT NOT NULL,
    mascota_id INT NOT NULL,
    fecha_realizacion DATETIME NOT NULL,
    fecha_proxima_revision DATETIME,
    box_atencion VARCHAR(50),
    FOREIGN KEY (medico_id) REFERENCES medico(medico_id),
    FOREIGN KEY (sucursal_id) REFERENCES sucursal(sucursal_id),
    FOREIGN KEY (tipo_atencion_id) REFERENCES tipo_atencion(tipo_atencion_id),
    FOREIGN KEY (mascota_id) REFERENCES mascota(mascota_id)
);

CREATE TABLE medico_sucursal (
    medico_sucursal_id INT AUTO_INCREMENT PRIMARY KEY,
    medico_id INT NOT NULL,
    sucursal_id INT NOT NULL,
    titular TINYINT(1),
    FOREIGN KEY (medico_id) REFERENCES medico(medico_id),
    FOREIGN KEY (sucursal_id) REFERENCES sucursal(sucursal_id)
);

-- Poblando tablas con datos de ejemplo

INSERT INTO genero (genero_descripcion) VALUES ('Macho'), ('Hembra');

INSERT INTO tipo_mascota (tipo_mascota_descripcion) VALUES ('Perro'), ('Gato');

INSERT INTO dueno (dueno_rut, dueno_nombre, dueno_apellidos, dueno_email)
VALUES
('12345678-9', 'Juan', 'Perez', 'juan.perez@example.com'),
('98765432-1', 'Maria', 'Gonzalez', 'maria.gonzalez@example.com');

INSERT INTO mascota (mascota_nombre, mascota_raza, dueno_id, genero_id, tipo_mascota_id)
VALUES
('Firulais', 'Labrador', 1, 1, 1),
('Misu', 'Siames', 2, 2, 2);

INSERT INTO sucursal (sucursal_nombre, sucursal_direccion, sucursal_telefono)
VALUES
('Sucursal Centro', 'Av. Central 123', '555-1234'),
('Sucursal Norte', 'Calle Norte 456', '555-5678');

INSERT INTO tipo_producto (tipo_producto_descripcion) VALUES ('Medicamento'), ('Accesorio');

INSERT INTO inventario (inventario_nombre, inventario_marca, tipo_producto_id, inventario_existencia)
VALUES
('Antipulgas', 'Bayer', 1, 50),
('Collar', 'PetSafe', 2, 30);

INSERT INTO medico (medico_rut, medico_nombre, medico_apellidos, medico_email)
VALUES
('11111111-1', 'Ana', 'Martinez', 'ana.martinez@example.com'),
('22222222-2', 'Luis', 'Fernandez', 'luis.fernandez@example.com');

INSERT INTO tipo_atencion (tipo_atencion_descripcion) VALUES ('Consulta'), ('Cirugia');

INSERT INTO atencion (medico_id, sucursal_id, tipo_atencion_id, mascota_id, fecha_realizacion, fecha_proxima_revision, box_atencion)
VALUES
(1, 1, 1, 1, '2024-06-01 10:00:00', '2024-06-15 10:00:00', 'Box 1'),
(2, 2, 2, 2, '2024-06-02 11:00:00', '2024-06-16 11:00:00', 'Box 2');

INSERT INTO medico_sucursal (medico_id, sucursal_id, titular)
VALUES
(1, 1, 1),
(2, 2, 1);

-- Consultas SQL para reportes de interés

-- 1. Listar el nombre de una sucursal y sus médicos en base a su id.
SET @sucursal_id = 1; -- Asigna el valor deseado aquí
SELECT s.sucursal_nombre AS sucursal, m.medico_nombre AS medico
FROM sucursal s
JOIN medico_sucursal ms ON s.sucursal_id = ms.sucursal_id
JOIN medico m ON ms.medico_id = m.medico_id
WHERE s.sucursal_id = @sucursal_id;

-- 2. Listar los productos del inventario de una sucursal en base al id de la sucursal.
SET @sucursal_id = 1; -- Asigna el valor deseado aquí
SELECT i.inventario_nombre AS producto, i.inventario_marca AS marca, i.inventario_existencia AS stock
FROM inventario i
WHERE i.sucursal_id = @sucursal_id;

-- 3. Listar todas las mascotas indicando nombre, qué tipo de atención que tuvieron (médica o cirugía), y debe ser utilizado el id de la sucursal para filtrar la información.
SET @sucursal_id = 1; -- Asigna el valor deseado aquí
SELECT m.mascota_nombre AS mascota, ta.tipo_atencion_descripcion AS atencion
FROM mascota m
JOIN atencion a ON m.mascota_id = a.mascota_id
JOIN tipo_atencion ta ON a.tipo_atencion_id = ta.tipo_atencion_id
WHERE a.sucursal_id = @sucursal_id;

-- 4. Listar la cantidad de mascotas atendidas por tipo de mascota que tiene cada sucursal.
SELECT s.sucursal_nombre AS sucursal, tm.tipo_mascota_descripcion AS tipo_mascota, COUNT(m.mascota_id) AS cantidad
FROM sucursal s
JOIN mascota m ON s.sucursal_id = m.sucursal_id
JOIN tipo_mascota tm ON m.tipo_mascota_id = tm.tipo_mascota_id
GROUP BY s.sucursal_nombre, tm.tipo_mascota_descripcion;

-- 5. Agrupar la cantidad de cirugías que se han realizado en una sucursal determinada, mostrando cantidad, el nombre del médico y la sucursal, estableciendo el orden de forma descendiente por la cantidad de cirugías de los 10 médicos.
SET @sucursal_id = 1; -- Asigna el valor deseado aquí
SELECT s.sucursal_nombre AS sucursal, m.medico_nombre AS medico, COUNT(a.atencion_id) AS cantidad_cirugias
FROM atencion a
JOIN medico m ON a.medico_id = m.medico_id
JOIN sucursal s ON a.sucursal_id = s.sucursal_id
WHERE a.tipo_atencion_id = (SELECT tipo_atencion_id FROM tipo_atencion WHERE tipo_atencion_descripcion = 'Cirugia')
AND s.sucursal_id = @sucursal_id
GROUP BY s.sucursal_nombre, m.medico_nombre
ORDER BY cantidad_cirugias DESC
LIMIT 10;
