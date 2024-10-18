/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Excepciones;

/**
 * Excepción lanzada cuando un servicio de hospedaje ya existe en el sistema.
 * Esta excepción se utiliza para evitar duplicados en la lista de servicios de hospedaje.
 *
 * @author Agustín
 */

public class HospedajeYaExistenteException extends Exception {

    /**
     * Constructor que recibe un mensaje de error.
     * @param mensaje El mensaje que describe el error.
     */
    public HospedajeYaExistenteException(String mensaje) {
        super(mensaje);
    }
}