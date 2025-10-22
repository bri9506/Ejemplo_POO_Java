// Archivo: Main.java

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Iniciando la aplicación con Interfaz Gráfica...");

        // Creación de Objetos de las Clases (Polimorfismo)
        Empleado[] personal = new Empleado[3];
        personal[0] = new EmpleadoAsalariado("Ana Torres", 101, 3500.00);
        personal[1] = new EmpleadoPorHoras("Luis Gomez", 102, 25.00, 160);
        personal[2] = new EmpleadoAsalariado("Carlos Ruiz", 103, 4200.00);

        // Iniciar la Interfaz Gráfica, pasándole el arreglo de Objetos
        // Se utiliza SwingUtilities.invokeLater para asegurar que la GUI
        // se cree en el hilo de despacho de eventos de Swing.
        SwingUtilities.invokeLater(() -> {
            // Creación del Objeto de la Clase GestorEmpleadosGUI
            new GestorEmpleadosGUI(personal);
        });
    }
}