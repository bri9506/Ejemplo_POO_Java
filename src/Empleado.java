public abstract class Empleado {
    // Encapsulamiento: Los atributos son 'private' para protegerlos.
    private String nombre;
    private int id;

    // Constructor
    public Empleado(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }

    // Abstracción: Método 'abstract' que OBLIGA a las subclases a implementarlo.
    public abstract double calcularSalario();

    // Getters y Setters (Acceso controlado a los atributos privados - Encapsulamiento)
    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    // Método general que puede ser usado por todos (Herencia)
    public void mostrarDatos() {
        System.out.println("ID: " + id + ", Nombre: " + nombre);
    }
}