// Archivo: GestorEmpleadosGUI.java

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestorEmpleadosGUI extends JFrame implements ActionListener {

    // ... (atributos existentes) ...
    private JTextArea areaSalida;
    private JButton botonListar, botonHorasExtra;
    private Empleado[] personal;

    // Constructor de la clase GUI
    public GestorEmpleadosGUI(Empleado[] personal) {
        this.personal = personal;

        // Configuración básica de la ventana
        setTitle("Gestión de Empleados POO");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Creación y configuración de Componentes
        areaSalida = new JTextArea();
        areaSalida.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaSalida);
        add(scrollPane, BorderLayout.CENTER);

        // Panel para los botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout());

        // Creación de Objetos JButton y sus Atributos
        // Renombramos el botón para que sea más claro lo que hace
        botonListar = new JButton("1. Mostrar Salarios Calculados");
        botonHorasExtra = new JButton("2. Registrar Horas Extra (Método con Parámetro)");

        // Conexión de los Métodos (Action Listeners)
        botonListar.addActionListener(this);
        botonHorasExtra.addActionListener(this);

        panelBotones.add(botonListar);
        panelBotones.add(botonHorasExtra);

        add(panelBotones, BorderLayout.SOUTH);

        // ¡NUEVO PASO CLAVE! Llamamos al método de inicialización aquí.
        inicializarSalida();

        setVisible(true);
    }
    private void registrarHorasExtraDemo() {
        areaSalida.setText("");

        // Llamada a un Método con Parámetro: personal[0] llama a su Método.
        String resultado1 = personal[0].registrarHorasExtra(10); // 10 es el PARÁMETRO

        // Llamada a otro Objeto: personal[1] llama a su Método.
        String resultado2 = personal[1].registrarHorasExtra(5); // 5 es el PARÁMETRO

        areaSalida.append("--- Demostración de Llamada a Método con Parámetro ---\n");
        areaSalida.append(resultado1 + "\n");
        areaSalida.append(resultado2 + "\n");
    }

    // Método principal que maneja los eventos de los botones
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonListar) {
            // Llamamos al nuevo método para calcular y listar salarios.
            listarEmpleadosConSalarios();
        } else if (e.getSource() == botonHorasExtra) {
            registrarHorasExtraDemo();
        }
    }

    // NUEVO MÉTODO: Muestra una lista simple de empleados (sin salarios) al inicio.
    private void inicializarSalida() {
        StringBuilder sb = new StringBuilder();
        sb.append("--- EMPLEADOS CARGADOS EN EL SISTEMA ---\n");
        sb.append("--------------------------------------\n");

        for (Empleado emp : personal) {
            sb.append("ID: ").append(emp.getId())
                    .append(", Nombre: ").append(emp.getNombre()).append("\n");
        }
        sb.append("\n**Pulsa 'Mostrar Salarios Calculados' para ver los montos.**");

        areaSalida.setText(sb.toString());
    }

    // MÉTODO MODIFICADO: Ahora muestra los salarios al hacer click.
    private void listarEmpleadosConSalarios() {
        StringBuilder sb = new StringBuilder();
        sb.append("--- LISTADO DE EMPLEADOS Y SALARIOS CALCULADOS ---\n");
        sb.append("------------------------------------------------\n");

        for (Empleado emp : personal) {
            // Se realiza la llamada polimórfica para calcular el salario
            double salario = emp.calcularSalario();

            sb.append("ID: ").append(emp.getId())
                    .append(", Nombre: ").append(emp.getNombre());

            // Usamos 'instanceof' para indicar el tipo (Polimorfismo)
            if (emp instanceof EmpleadoAsalariado) {
                sb.append(" (Asalariado)");
            } else if (emp instanceof EmpleadoPorHoras) {
                sb.append(" (Por Horas)");
            }

            sb.append("\n  Salario Calculado: $").append(String.format("%.2f", salario)).append("\n");
            sb.append("------------------------------------------------\n");
        }

        areaSalida.setText(sb.toString());
    }

    // ... (El método registrarHorasExtraDemo() permanece igual) ...
}