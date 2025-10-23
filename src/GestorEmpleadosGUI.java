// Archivo: GestorEmpleadosGUI.java

import javax.swing.*;
import java.awt.FlowLayout; // Usaremos un layout simple para no complicarnos

public class GestorEmpleadosGUI extends JFrame { // Ya no implementamos ActionListener

    // Atributos de la clase GUI
    private JTextArea areaSalida;
    private JButton botonListar;
    private JButton botonHorasExtra;
    private Empleado[] personal; // El arreglo de Objetos

    // Constructor
    public GestorEmpleadosGUI(Empleado[] personal) {
        // 1. Creación de Objetos (Ventana)
        super("Gestión de Empleados Simple POO"); // Llama al constructor de JFrame
        this.personal = personal;

        // Configuración básica
        setSize(550, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout()); // Layout simple, uno al lado del otro

        // 2. Creación de Objetos (Componentes)
        areaSalida = new JTextArea(15, 45); // 15 filas, 45 columnas
        areaSalida.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaSalida);

        botonListar = new JButton("1. Mostrar Salarios (Polimorfismo)");
        botonHorasExtra = new JButton("2. Registrar Horas Extra (Parámetro)");

        // Agregamos los componentes a la ventana
        add(scrollPane);
        add(botonListar);
        add(botonHorasExtra);

        // Inicializamos la salida al crear el Objeto GUI
        inicializarSalida();

        // 3. Llamada a Métodos: Conexión de Eventos

        // Opción 1: Listar Salarios
        // Usamos una clase anónima, que es una forma simple de manejar eventos.
        botonListar.addActionListener(e -> {
            listarEmpleadosConSalarios(); // Llama al método
        });

        // Opción 2: Horas Extra
        botonHorasExtra.addActionListener(e -> {
            registrarHorasExtraDemo(); // Llama al método
        });

        setVisible(true); // Mostrar la ventana
    }

    // Método 1: Inicializa la lista simple de empleados al inicio.
    private void inicializarSalida() {
        String salida = "--- EMPLEADOS CARGADOS ---\n";
        for (Empleado emp : personal) {
            // Llamada al método getNombre() del Objeto
            salida += "ID: " + emp.getId() + ", Nombre: " + emp.getNombre() + "\n";
        }
        salida += "\n**Pulsa 'Mostrar Salarios' para ver los montos.**";
        areaSalida.setText(salida);
    }

    // Método 2: Muestra los salarios (Demuestra Polimorfismo)
    private void listarEmpleadosConSalarios() {
        String salida = "--- SALARIOS CALCULADOS ---\n";

        for (Empleado emp : personal) {
            // Polimorfismo: Llamada al método, cada objeto ejecuta su propia versión.
            double salario = emp.calcularSalario();

            salida += emp.getNombre() + ": $" + String.format("%.2f", salario) + "\n";
        }
        areaSalida.setText(salida);
    }

    // Método 3: Demuestra la Llamada de Método con Parámetro
    private void registrarHorasExtraDemo() {
        areaSalida.setText("--- Registro de Horas Extra ---\n");

        // Llamada a Método con Parámetro: personal[0] llama a su método.
        String resultado1 = personal[0].registrarHorasExtra(10); // 10 es el PARÁMETRO
        areaSalida.append(resultado1 + "\n");

        // Llamada a otro Objeto.
        String resultado2 = personal[1].registrarHorasExtra(5); // 5 es el PARÁMETRO
        areaSalida.append(resultado2 + "\n");
    }
}