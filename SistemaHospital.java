
package practica.calificada.pkg2;

import java.util.*;

class Medico {
    int numColegiatura;
    String nombre;
    String especialidad;

    public Medico(int numColegiatura, String nombre, String especialidad) {
        this.numColegiatura = numColegiatura;
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    public int getNumColegiatura() {
        return numColegiatura;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }
}

class Paciente {
    int DNI;
    String nombre;
    String direccion;
    double peso;
    double temperatura;
    Medico medico;

    public Paciente(int DNI, String nombre, String direccion, double peso, double temperatura) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.direccion = direccion;
        this.peso = peso;
        this.temperatura = temperatura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public String getApellido() {
        return "";
    }

    public String getNombre() {
        return nombre;
    }
}

public class SistemaHospital {
    private List<Paciente> pacientes = new ArrayList<>();
    private List<Medico> medicos = new ArrayList<>();

    public static void main(String[] args) {
        SistemaHospital sistema = new SistemaHospital();
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("1. Registrar paciente");
            System.out.println("2. Eliminar paciente");
            System.out.println("3. Modificar datos de paciente");
            System.out.println("4. Mostrar peso más repetido");
            System.out.println("5. Mostrar cantidad de pacientes con peso más repetido");
            System.out.println("6. Mostrar peso mayor y menor");
            System.out.println("7. Dividir rango de pesos y mostrar cantidad de pacientes en cada rango");
            System.out.println("8. Mostrar lista de pacientes ordenados por nombre");
            System.out.println("9. Mostrar médico que atendió a un paciente");
            System.out.println("10. Buscar doctores");
            System.out.println("0. Salir");
            System.out.print("Ingrese opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    sistema.registrarPaciente();
                    break;
                case 2:
                    sistema.eliminarPaciente();
                    break;
                case 3:
                    sistema.modificarDatos();
                    break;
                case 4:
                    sistema.mostrarPeso();
                    break;
                case 5:
                    sistema.mostrarCantidadPesoRepetido();
                    break;
                case 6:
                    sistema.mostrarPesosMyM();
                    break;
                case 7:
                    sistema.mostrarRangoPesos();
                    break;
                case 8:
                    sistema.mostrarOrdenApellido();
                    break;
                case 9:
                    sistema.mostrarMedico();
                    break;
                case 10:
                    sistema.buscarDoctores();
                    break;
                case 0:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }

        } while (opcion != 0);
    }

    private void registrarPaciente() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese DNI del paciente:");
        int dni = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese nombre del paciente:");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese dirección del paciente:");
        String direccion = scanner.nextLine();

        System.out.println("Ingrese peso del paciente:");
        double peso = scanner.nextDouble();

        System.out.println("Ingrese temperatura del paciente:");
        double temperatura = scanner.nextDouble();

        Paciente nuevoPaciente = new Paciente(dni, nombre, direccion, peso, temperatura);
        pacientes.add(nuevoPaciente);

        System.out.println("Paciente registrado con éxito.");
    }

    private void eliminarPaciente() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese posición del paciente a eliminar:");
        int posicion = scanner.nextInt();

        if (posicion >= 0 && posicion < pacientes.size()) {
            pacientes.remove(posicion);
            System.out.println("Paciente eliminado con éxito.");
        } else {
            System.out.println("Posición no válida. No se pudo eliminar el paciente.");
        }
    }

    private void modificarDatos() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese posición del paciente a modificar:");
        int posicion = scanner.nextInt();

        if (posicion >= 0 && posicion < pacientes.size()) {
            Paciente paciente = pacientes.get(posicion);

            System.out.println("Ingrese nuevo peso del paciente:");
            double nuevoPeso = scanner.nextDouble();
            paciente.setPeso(nuevoPeso);

            System.out.println("Ingrese nueva temperatura del paciente:");
            double nuevaTemperatura = scanner.nextDouble();
            paciente.setTemperatura(nuevaTemperatura);

            System.out.println("Datos del paciente modificados con éxito.");
        } else {
            System.out.println("Posición no válida. No se pudo modificar los datos del paciente.");
        }
    }

    private void mostrarPeso() {
        Map<Double, Integer> frecuenciaPesos = new HashMap<>();

        for (Paciente paciente : pacientes) {
            double peso = paciente.getPeso();
            frecuenciaPesos.put(peso, frecuenciaPesos.getOrDefault(peso, 0) + 1);
        }

        double pesoMasRepetido = Collections.max(frecuenciaPesos.entrySet(), Map.Entry.comparingByValue()).getKey();

        System.out.println("Peso que más se repite: " + pesoMasRepetido);
    }

    private void mostrarCantidadPesoRepetido() {
        Map<Double, Integer> frecuenciaPesos = new HashMap<>();

        for (Paciente paciente : pacientes) {
            double peso = paciente.getPeso();
            frecuenciaPesos.put(peso, frecuenciaPesos.getOrDefault(peso, 0) + 1);
        }

        double pesoMasRepetido = Collections.max(frecuenciaPesos.entrySet(), Map.Entry.comparingByValue()).getKey();
        int cantidadPacientes = frecuenciaPesos.get(pesoMasRepetido);

        System.out.println("Peso que más se repite: " + pesoMasRepetido);
        System.out.println("Cantidad de pacientes con ese peso: " + cantidadPacientes);
    }

    private void mostrarPesosMyM() {
        double pesoMayor = Double.MIN_VALUE;
        double pesoMenor = Double.MAX_VALUE;

        for (Paciente paciente : pacientes) {
            double peso = paciente.getPeso();
            pesoMayor = Math.max(pesoMayor, peso);
            pesoMenor = Math.min(pesoMenor, peso);
        }

        System.out.println("Peso mayor en la lista: " + pesoMayor);
        System.out.println("Peso menor en la lista: " + pesoMenor);
    }

    private void mostrarRangoPesos() {
        int rango1 = 0, rango2 = 0, rango3 = 0, rango4 = 0;

        for (Paciente paciente : pacientes) {
            double peso = paciente.getPeso();

            if (peso >= 40 && peso < 60) {
                rango1++;
            } else if (peso >= 60 && peso < 80) {
                rango2++;
            } else if (peso >= 80 && peso < 100) {
                rango3++;
            } else if (peso >= 100 && peso <= 120) {
                rango4++;
            }
        }

        System.out.println("Pacientes en rango 40-60: " + rango1);
        System.out.println("Pacientes en rango 60-80: " + rango2);
        System.out.println("Pacientes en rango 80-100: " + rango3);
        System.out.println("Pacientes en rango 100-120: " + rango4);
    }

    private void mostrarOrdenApellido() {
        Collections.sort(pacientes, (p1, p2) -> p1.getApellido().compareTo(p2.getApellido()));

        System.out.println("Lista de pacientes ordenados por nombres:");
        for (Paciente paciente : pacientes) {
            System.out.println("Nombre: " + paciente.getNombre());
        }
    }

    private void mostrarMedico() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la posición del paciente:");
        int posicion = scanner.nextInt();

        if (posicion >= 0 && posicion < pacientes.size()) {
            Paciente paciente = pacientes.get(posicion);
            Medico medico = paciente.getMedico();

            System.out.println("El paciente fue atendido por el médico:");
            System.out.println("Nombre: " + medico.getNombre());
            System.out.println("Especialidad: " + medico.getEspecialidad());
        } else {
            System.out.println("Posición no válida. No se pudo obtener el médico que atendió al paciente.");
        }
    }

    private void buscarDoctores() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la especialidad a buscar:");
        String especialidadBuscada = scanner.nextLine();

        System.out.println("Doctores con la especialidad " + especialidadBuscada + ":");
        for (Medico medico : medicos) {
            if (medico.getEspecialidad().equalsIgnoreCase(especialidadBuscada)) {
                System.out.println("Nombre: " + medico.getNombre());
                System.out.println("Especialidad: " + medico.getEspecialidad());
                System.out.println("--------------------------");
            }
        }
    }
}

