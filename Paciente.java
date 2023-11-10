/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.calificada.pkg2;

/**
 *
 * @author Alumno
 */
public class Paciente {
    String DNI;
    String nombre;
    String direccion;
    double peso;
    double temperatura;
    Médico medico;  // Relación: cada paciente es atendido por un solo médico

    public Paciente(String DNI, String nombre, String direccion, double peso, double temperatura, Médico medico) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.direccion = direccion;
        this.peso = peso;
        this.temperatura = temperatura;
        this.medico = medico;
    }
}
    

