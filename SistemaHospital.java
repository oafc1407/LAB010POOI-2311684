
package practica.calificada.pkg2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SistemaHospital {
    private final ArrayList<Paciente> listaPacientes = new ArrayList<>();
    private final ArrayList<Médico> listaMedicos = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        SistemaHospital sistema = new SistemaHospital();
        sistema.menuPrincipal();
    }

     private void menuPrincipal() {
        int opcion;
        do {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Registrar datos de pacientes");
            System.out.println("2. Eliminar datos de un paciente");
            System.out.println("3. Modificar datos de un paciente");
            System.out.println("4. Mostrar el peso que más se repite");
            System.out.println("5. Mostrar cantidad de pacientes por peso");
            System.out.println("6. Mostrar peso mayor y menor");
            System.out.println("7. Mostrar cantidad de personas por rango de pesos");
            System.out.println("8. Mostrar lista de pacientes ordenados por apellidos");
            System.out.println("9. Indicar qué doctor atendió a un paciente");
            System.out.println("10. Buscar doctores por especialidad");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer de entrada

            switch (opcion) {
                case 1 -> registrarPaciente();
                case 2 -> eliminarPaciente();
                case 3 -> modificarPaciente();
                case 4 -> mostrarPesoMasRepetido();
                case 5 -> mostrarCantidadPacientesPorPeso();
                case 6 -> mostrarPesoMayorYMenor();
                case 7 -> mostrarCantidadPorRangoDePesos();
                case 8 -> mostrarListaPacientesOrdenados();
                case 9 -> indicarDoctorAtendioPaciente();
                case 10 -> buscarDoctoresPorEspecialidad();
                case 0 -> System.out.println("Saliendo del programa. ¡Hasta luego!");
                default -> System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 0);
    }

    private void registrarPaciente() {
        {
    System.out.println("\n--- Registrar Paciente ---");
    
    // Solicitar información del paciente al usuario
    System.out.print("Ingrese DNI del paciente: ");
    String dni = scanner.nextLine();
    System.out.print("Ingrese nombre del paciente: ");
    String nombre = scanner.nextLine();
    System.out.print("Ingrese dirección del paciente: ");
    String direccion = scanner.nextLine();
    System.out.print("Ingrese peso del paciente: ");
    double peso = scanner.nextDouble();
    System.out.print("Ingrese temperatura del paciente: ");
    double temperatura = scanner.nextDouble();
    scanner.nextLine();  // Consumir el salto de línea
    
    // Obtener el médico que atenderá al paciente
    System.out.print("Ingrese el número de colegiatura del médico que atenderá al paciente: ");
    String numeroColegiaturaMedico = scanner.nextLine();
    Médico medico = buscarMedicoPorColegiatura(numeroColegiaturaMedico);
    
    // Crear el paciente y agregarlo a la lista
    Paciente paciente = new Paciente(dni, nombre, direccion, peso, temperatura, medico);
    listaPacientes.add(paciente);
    
    System.out.println("Paciente registrado exitosamente.");
}
    }

    private void eliminarPaciente() {
       System.out.println("\n--- Eliminar Paciente ---");
    
    // Mostrar lista de pacientes para que el usuario elija cuál eliminar
    mostrarListaPacientes();
    
    System.out.print("Ingrese el número de la posición del paciente que desea eliminar: ");
    int posicion = scanner.nextInt();
    
    if (posicion >= 1 && posicion <= listaPacientes.size()) {
        listaPacientes.remove(posicion - 1);
        System.out.println("Paciente eliminado exitosamente.");
    } else {
        System.out.println("Posición inválida. No se ha eliminado ningún paciente.");
    }
    }

    private void modificarPaciente() {
       System.out.println("\n--- Modificar Paciente ---");
    
    // Mostrar lista de pacientes para que el usuario elija cuál modificar
    mostrarListaPacientes();
    
    System.out.print("Ingrese el número de la posición del paciente que desea modificar: ");
    int posicion = scanner.nextInt();
    
    if (posicion >= 1 && posicion <= listaPacientes.size()) {
        // Obtener el paciente seleccionado
        Paciente paciente = listaPacientes.get(posicion - 1);
        
        // Solicitar al usuario la nueva información del paciente
        scanner.nextLine();  // Consumir el salto de línea
        System.out.print("Ingrese nuevo nombre del paciente: ");
        paciente.nombre = scanner.nextLine();
        System.out.print("Ingrese nueva dirección del paciente: ");
        paciente.direccion = scanner.nextLine();
        System.out.print("Ingrese nuevo peso del paciente: ");
        paciente.peso = scanner.nextDouble();
        System.out.print("Ingrese nueva temperatura del paciente: ");
        paciente.temperatura = scanner.nextDouble();
        
        System.out.println("Paciente modificado exitosamente.");
    } else {
        System.out.println("Posición inválida. No se ha modificado ningún paciente.");
    }
    }

    private void mostrarPesoMasRepetido() {
        System.out.println("\n--- Peso que más se repite ---");

    if (listaPacientes.isEmpty()) {
        System.out.println("No hay pacientes registrados.");
        return;
    }

    Map<Double, Integer> frecuenciaPesos = new HashMap<>();

    // Contar la frecuencia de cada peso
    for (Paciente paciente : listaPacientes) {
        frecuenciaPesos.put(paciente.peso, frecuenciaPesos.getOrDefault(paciente.peso, 0) + 1);
    }

    // Encontrar el peso más repetido
    double pesoMasRepetido = Collections.max(frecuenciaPesos.entrySet(), Map.Entry.comparingByValue()).getKey();

    System.out.println("El peso que más se repite es: " + pesoMasRepetido);
}

    private void mostrarListaPacientes() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void mostrarCantidadPacientesPorPeso() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void mostrarPesoMayorYMenor() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void mostrarCantidadPorRangoDePesos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void mostrarListaPacientesOrdenados() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void indicarDoctorAtendioPaciente() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void buscarDoctoresPorEspecialidad() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private Médico buscarMédicoPorColegiatura(String numeroColegiaturaMédico) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    }


    private void mostrarCantidadPacientesPorPeso() {
        System.out.println("\n--- Cantidad de pacientes por peso ---");

    if (listaPacientes.isEmpty()) {
        System.out.println("No hay pacientes registrados.");
        return;
    }

    Map<Double, Integer> frecuenciaPesos = new HashMap<>();

    // Contar la frecuencia de cada peso
    for (Paciente paciente : listaPacientes) {
        frecuenciaPesos.put(paciente.peso, frecuenciaPesos.getOrDefault(paciente.peso, 0) + 1);
    }

    // Mostrar la cantidad de pacientes por cada peso
    for (Map.Entry<Double, Integer> entry : frecuenciaPesos.entrySet()) {
        System.out.println("Peso: " + entry.getKey() + "kg - Cantidad de pacientes: " + entry.getValue());
    }
    }

    private void mostrarPesoMayorYMenor() {
         System.out.println("\n--- Peso Mayor y Menor ---");

    if (listaPacientes.isEmpty()) {
        System.out.println("No hay pacientes registrados.");
        return;
    }

    // Encontrar peso mayor y menor
    double pesoMayor = listaPacientes.stream().mapToDouble(paciente -> paciente.peso).max().orElse(0);
    double pesoMenor = listaPacientes.stream().mapToDouble(paciente -> paciente.peso).min().orElse(0);

    System.out.println("Peso mayor: " + pesoMayor + "kg");
    System.out.println("Peso menor: " + pesoMenor + "kg");
    }

    private void mostrarCantidadPorRangoDePesos() {
        System.out.println("\n--- Cantidad de personas por rango de pesos ---");

    if (listaPacientes.isEmpty()) {
        System.out.println("No hay pacientes registrados.");
        return;
    }

    // Definir los rangos de pesos
    double pesoMinimo = listaPacientes.stream().mapToDouble(paciente -> paciente.peso).min().orElse(0);
    double pesoMaximo = listaPacientes.stream().mapToDouble(paciente -> paciente.peso).max().orElse(0);
    double rango = (pesoMaximo - pesoMinimo) / 4;

    // Contar la cantidad de personas en cada rango
    int[] cantidadPorRango = new int[4];
    for (Paciente paciente : listaPacientes) {
        double peso = paciente.peso;
        if (peso >= pesoMinimo && peso < pesoMinimo + rango) {
            cantidadPorRango[0]++;
        } else if (peso >= pesoMinimo + rango && peso < pesoMinimo + 2 * rango) {
            cantidadPorRango[1]++;
        } else if (peso >= pesoMinimo + 2 * rango && peso < pesoMinimo + 3 * rango) {
            cantidadPorRango[2]++;
        } else {
            cantidadPorRango[3]++;
        }
    }

    // Mostrar la cantidad de personas por cada rango
    for (int i = 0; i < cantidadPorRango.length; i++) {
        double rangoInicio = pesoMinimo + i * rango;
        double rangoFin = pesoMinimo + (i + 1) * rango;
        System.out.println("Rango " + (i + 1) + ": " + rangoInicio + "kg - " + rangoFin + "kg - Cantidad: " + cantidadPorRango[i]);
    }
    }

    private void mostrarListaPacientesOrdenados() {
         System.out.println("\n--- Lista de Pacientes Ordenados por Apellidos ---");

    if (listaPacientes.isEmpty()) {
        System.out.println("No hay pacientes registrados.");
        return;
    }

    // Ordenar la lista de pacientes por apellidos
    Collections.sort(listaPacientes, Comparator.comparing(paciente -> paciente.nombre.split(" ")[1]));

    // Mostrar la lista ordenada
    for (int i = 0; i < listaPacientes.size(); i++) {
        Paciente paciente = listaPacientes.get(i);
        System.out.println((i + 1) + ". " + paciente.nombre + " - " + paciente.DNI);
    }
    }

    private void indicarDoctorAtendioPaciente() {
       System.out.println("\n--- Indicar qué doctor atendió a un paciente ---");

    if (listaPacientes.isEmpty()) {
        System.out.println("No hay pacientes registrados.");
        return;
    }

    // Mostrar lista de pacientes para que el usuario elija cuál verificar
    mostrarListaPacientes();

    System.out.print("Ingrese el número de la posición del paciente: ");
    int posicion = scanner.nextInt();

    if (posicion >= 1 && posicion <= listaPacientes.size()) {
        Paciente paciente = listaPacientes.get(posicion - 1);
        Medico medico = paciente.medico;
        System.out.println("El paciente fue atendido por el doctor: " + medico.nombre);
    } else {
        System.out.println("Posición inválida. No se ha indicado el doctor.");
    }
    }

    private void buscarDoctoresPorEspecialidad() {
         System.out.println("\n--- Buscar Doctores por Especialidad ---");

    if (listaMedicos.isEmpty()) {
        System.out.println("No hay doctores registrados.");
        return;
    }

    // Solicitar al usuario la especialidad a buscar
    System.out.print("Ingrese la especialidad a buscar: ");
    String especialidadBuscada = scanner.nextLine();

    // Mostrar los doctores que tienen la especialidad buscada
    boolean encontrado = false;
    for (Medico medico : listaMedicos) {
        if (medico.especialidad.equalsIgnoreCase(especialidadBuscada)) {
            System.out.println("Doctor: " + medico.nombre + " - Especialidad: " + medico.especialidad);
            encontrado = true;
        }
    }

    if (!encontrado) {
        System.out.println("No se encontraron doctores con la especialidad ingresada.");
    }
    }

    private Médico buscarMedicoPorColegiatura(String numeroColegiaturaMedico) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    

    private void mostrarListaPacientes() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
}
}
