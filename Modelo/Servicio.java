/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Modelo;
import Excepciones.*;
import java.time.LocalDate;

/**
 * Clase abstracta que representa un servicio genérico dentro del sistema.
 * Cada servicio tiene un código, un porcentaje de descuento y un estado de promoción.
 * Las clases que extienden de esta deberán implementar el cálculo del precio final.
 *
 * @author Agustín
 */

public abstract class Servicio {
    protected String codServicio;
    protected double porcentajeDescuento;
    protected boolean enPromocion;

    /**
     * Constructor de la clase Servicio.
     * Valida que el código del servicio tenga exactamente 6 caracteres.
     * 
     * @param codServicio El código único del servicio (debe tener 6 caracteres).
     * @param porcentajeDescuento El porcentaje de descuento aplicado al servicio.
     * @param enPromocion Indica si el servicio está en promoción.
     * @throws CodServicioDiferenteASeisException Si el código no tiene 6 caracteres.
     */
    public Servicio(String codServicio, double porcentajeDescuento, boolean enPromocion) throws CodServicioDiferenteASeisException {
        
        if (codServicio == null || codServicio.length() != 6) {
            throw new CodServicioDiferenteASeisException("El codigo del servicio debe tener 6 caracteres.");
        }
        
        this.codServicio = codServicio;
        this.porcentajeDescuento = porcentajeDescuento;
        this.enPromocion = enPromocion;
    }
    
    // Getters y Setters para los atributos de la clase

    public String getCodServicio() {
        return codServicio;
    }

    public void setCodServicio(String codServicio) {
        this.codServicio = codServicio;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public boolean isEnPromocion() {
        return enPromocion;
    }

    public void setEnPromocion(boolean enPromocion) {
        this.enPromocion = enPromocion;
    }
    
    /**
     * Método abstracto para calcular el precio final del servicio en función de la fecha.
     * Las clases concretas deben proporcionar su propia implementación.
     * 
     * @param dia La fecha en la que se desea calcular el precio.
     * @return El precio final del servicio.
     */
    public abstract double calcularPrecioFinal(LocalDate dia);

    /**
     * Representación en texto del servicio, mostrando el código, el porcentaje de descuento y su estado de promoción.
     * 
     * @return Una cadena que representa el servicio.
     */
    @Override
    public String toString() {
        return "Servicio {" + "codigo del servicio = " + codServicio + ", porcentaje de descuento = " + porcentajeDescuento + ", en promocion = " + enPromocion + "}";
    }
}