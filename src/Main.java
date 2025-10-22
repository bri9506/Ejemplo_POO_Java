public class Main {

    public static void main(String[] args) {
        System.out.println("--- Sistema de Gestión de Empleados ---");

        // Arreglo: Creamos un array de la clase base 'Empleado'.
        // Esto es posible gracias a la Herencia y prepara el escenario para el Polimorfismo.
        Empleado[] personal = new Empleado[3];

        // Llenamos el arreglo con diferentes tipos de empleados (Polimorfismo).
        personal[0] = new EmpleadoAsalariado("Ana Torres", 101, 3500.00);
        personal[1] = new EmpleadoPorHoras("Luis Gomez", 102, 25.00, 160);
        personal[2] = new EmpleadoAsalariado("Carlos Ruiz", 103, 4200.00);

        double costoTotalSalarios = 0;

        System.out.println("\n*** Listado de Empleados y Salarios ***");

        // Ciclo: Usamos un ciclo for-each para iterar sobre el arreglo.
        for (Empleado emp : personal) {
            // Se llama al método mostrarDatos()
            emp.mostrarDatos();

            /*
             Polimorfismo en acción:
             Aunque 'emp' es de tipo Empleado, Java llama automáticamente
             al método calcularSalario() correcto (del Asalariado o del PorHoras).
            */
            double salario = emp.calcularSalario();

            System.out.println("  Salario Calculado: $" + salario);
            System.out.println("------------------------------------");

            costoTotalSalarios += salario;
        }

        System.out.println("\nCosto Total de Salarios de la Empresa: $" + costoTotalSalarios);
    }
}