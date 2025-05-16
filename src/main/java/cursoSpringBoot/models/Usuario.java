package cursoSpringBoot.models;  // Crea esta clase en el paquete "models"

public class Usuario {
    private String nombre;
    private int edad;
    private String email;

    // Constructor (obligatorio)
    public Usuario(String nombre, int edad, String email) {
        this.nombre = nombre;
        this.edad = edad;
        this.email = email;
    }

    // Getters (obligatorios para que Jackson los convierta a JSON)
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getEmail() {
        return email;
    }
}