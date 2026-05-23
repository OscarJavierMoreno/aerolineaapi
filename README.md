# ✈️ Api REST del taller aerolinea

Proyecto desarrollado en Spring Boot para la gestión de vuelos, pasajeros y reservas.

## 🚀 Evidencias de Funcionamiento (Pruebas en Swagger)

Para asegurar el cumplimiento de las rúbricas y criterios de aceptación, se realizaron las pruebas correspondientes directamente desde la interfaz interactiva de Swagger UI:

### 1. Creación de un Vuelo (Código 201 Created)
Se validó el endpoint `POST /vuelos` ingresando un nuevo vuelo de manera exitosa.
<img width="1920" height="1200" alt="Captura de pantalla 2026-05-22 192553" src="https://github.com/user-attachments/assets/ef58de74-3536-44b1-91cc-232ce7b9772c" />


### 2. Creación de un Pasajero (Código 201 Created)
Se validó el endpoint `POST /pasajeros` para el registro exitoso de los usuarios en el sistema.
<img width="1920" height="1200" alt="Captura de pantalla 2026-05-22 192724" src="https://github.com/user-attachments/assets/21848ad2-47a1-431f-adf5-3a7fcb9df615" />



### 3. Validación de Errores - Formato de Email (Código 400 Bad Request)
Se forzó el error de validación ingresando un correo inválido. El sistema respondió correctamente bloqueando la petición mediante el `GlobalExceptionHandler`.
<img width="1920" height="1200" alt="Captura de pantalla 2026-05-22 192910" src="https://github.com/user-attachments/assets/d19fc523-d4ee-42c6-936a-ccb1073e350c" />
