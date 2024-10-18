/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Excepciones;

/**
 * Excepción lanzada cuando el código del servicio es diferente a seis dígitos.
 * Esta excepción se utiliza para validar que el código de un servicio
 * cumpla con el requisito de tener exactamente seis caracteres.
 *
 * @author Agustín
 */

public class CodServicioDiferenteASeisException extends Exception {

    /**
     * Constructor que recibe un mensaje de error.
     * @param mensaje El mensaje que describe el error.
     */
    public CodServicioDiferenteASeisException(String mensaje) {
        super(mensaje);
    }
}