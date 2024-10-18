/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Excepciones;

/**
 * Excepción lanzada cuando un servicio de gastronomía ya existe en el sistema.
 * Esta excepción se utiliza para evitar duplicados en la lista de servicios de gastronomía.
 *
 * @author Agustín
 */

public class GastronomiaYaExistenteException extends Exception {

    /**
     * Constructor que recibe un mensaje de error.
     * @param mensaje El mensaje que describe el error.
     */
    public GastronomiaYaExistenteException(String mensaje) {
        super(mensaje);
    }
}