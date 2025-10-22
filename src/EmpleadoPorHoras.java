// Herencia
public class EmpleadoPorHoras extends Empleado {
    private double tarifaPorHora;
    private int horasTrabajadas;

    public EmpleadoPorHoras(String nombre, int id, double tarifaPorHora, int horasTrabajadas) {
        super(nombre, id);
        this.tarifaPorHora = tarifaPorHora;
        this.horasTrabajadas = horasTrabajadas;
    }

    // Polimorfismo: Implementación diferente de calcularSalario()
    @Override
    public double calcularSalario() {
        return tarifaPorHora * horasTrabajadas;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("  Tipo: Por Horas, Tarifa: $" + tarifaPorHora + ", Horas: " + horasTrabajadas);
    }
}