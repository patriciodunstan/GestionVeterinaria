# Veterinaria HappyPet

## Descripción

Este proyecto es una aplicación web para la gestión de una veterinaria, desarrollada con Spring Boot. Incluye funcionalidades de seguridad, controladores para manejo de reportes y un esquema básico de base de datos.

## Estructura del Proyecto

veterinaria/
│
├── src/
│ ├── main/
│ │ ├── java/
│ │ │ └── com/
│ │ │ └── happypet/
│ │ │ └── veterinaria/
│ │ │ ├── VeterinariaApplication.java
│ │ │ ├── config/
│ │ │ │ ├── JDBCConfig.java
│ │ │ │ └── SecurityConfig.java
│ │ │ ├── controller/
│ │ │ │ └── ReportController.java
│ │ │ ├── dto/
│ │ │ │ ├── CantidadMascotasDto.java
│ │ │ │ ├── CirugiaDto.java
│ │ │ │ ├── MascotaAtencionDto.java
│ │ │ │ ├── ProductoDto.java
│ │ │ │ └── SucursalMedicoDto.java
│ │ │ ├── model/
│ │ │ │ ├── Atencion.java
│ │ │ │ ├── Dueno.java
│ │ │ │ ├── Genero.java
│ │ │ │ ├── Inventario.java
│ │ │ │ ├── Mascota.java
│ │ │ │ ├── Medico.java
│ │ │ │ ├── MedicoSucursal.java
│ │ │ │ ├── Sucursal.java
│ │ │ │ ├── TipoAtencion.java
│ │ │ │ ├── TipoMascota.java
│ │ │ │ └── TipoProducto.java
│ │ │ ├── repository/
│ │ │ │ ├── AtencionRepository.java
│ │ │ │ ├── DuenoRepository.java
│ │ │ │ ├── GeneroRepository.java
│ │ │ │ ├── InventarioRepository.java
│ │ │ │ ├── MascotaRepository.java
│ │ │ │ ├── MedicoRepository.java
│ │ │ │ ├── SucursalRepository.java
│ │ │ │ ├── TipoAtencionRepository.java
│ │ │ │ ├── TipoMascotaRepository.java
│ │ │ │ └── TipoProductoRepository.java
│ │ │ ├── service/
│ │ │ │ └── ReportService.java
│ │ ├── resources/
│ │ │ ├── static/
│ │ │ ├── templates/
│ │ │ │ ├── index.html
│ │ │ │ ├── atenciones.html
│ │ │ │ └── login.html
│ │ │ ├── application.properties
│ │ │ └── schema.sql
│ ├── test/
│ │ └── java/
│ │ └── com/
│ │ └── happypet/
│ │ └── veterinaria/
│ │ └── service/
│ │ └── ReportServiceTest.java
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md


## Configuración del Proyecto

### Prerrequisitos

- JDK 22
- Maven
- MySQL

### Instalación

1. Clona el repositorio:

   ```bash
   git clone https://github.com/tuusuario/veterinaria.git
   cd veterinaria


2. Configura tu base de datos MySQL y actualiza las credenciales en src/main/resources/application.properties.

3. Crea la base de datos y las tablas necesarias ejecutando el script SQL proporcionado en src/main/resources/schema.sql.

4. Compila y ejecuta el proyecto:

./mvnw clean install
./mvnw spring-boot:run

### Pruebas
Para ejecutar las pruebas unitarias:

./mvnw test

### Uso
La aplicación web se puede acceder en http://localhost:8080.

Endpoints Principales
/api/reports/sucursal-medicos: Lista de sucursales y médicos.
/api/reports/productos-inventario: Lista de productos en inventario por sucursal.
/api/reports/atencion-branch: Lista de atenciones por sucursal.
/api/reports/all-pet-type: Cantidad de mascotas atendidas por tipo.
/api/reports/surgery-branch: Cantidad de cirugías por sucursal.

### Seguridad
La aplicación incluye autenticación básica con usuarios y roles almacenados en la base de datos.

Usuario de Prueba
- Username: admin
- Password: admin123