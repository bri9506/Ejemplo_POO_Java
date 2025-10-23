// Herencia: 'extends Empleado' indica que hereda sus atributos y métodos.
public class EmpleadoAsalariado extends Empleado {
    private double salarioMensual; // Atributo específico

    // Constructor que llama al constructor de la clase base (super)
    public EmpleadoAsalariado(String nombre, int id, double salarioMensual) {
        super(nombre, id); // Llama a 'Empleado(nombre, id)'
        this.salarioMensual = salarioMensual;
    }

    // Polimorfismo: Sobreescribe el método abstracto de la clase Empleado.
    public double calcularSalario() {
        return salarioMensual;
    }

    // Se puede sobreescribir otro método (Polimorfismo)
    public void mostrarDatos() {
        super.mostrarDatos(); // Llama al método de la clase base primero
        System.out.println("  Tipo: Asalariado, Salario Mensual: $" + salarioMensual);
    }
}