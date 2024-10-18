/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Modelo;
import Excepciones.*;
import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * Clase que representa un servicio de hospedaje, heredando de la clase abstracta Servicio.
 * Cada hospedaje tiene un nombre y un precio por noche.
 * 
 * @author Agustín
 */

public class Hospedaje extends Servicio {
    private String hospedaje;
    private double precioPorNoche;

    /**
     * Constructor de la clase Hospedaje.
     * Inicializa los atributos del servicio de hospedaje y valida que el código tenga 6 caracteres.
     * 
     * @param codServicio El código único del servicio (debe tener 6 caracteres).
     * @param porcentajeDescuento El porcentaje de descuento aplicado al servicio.
     * @param enPromocion Indica si el servicio está en promoción.
     * @param hospedaje El nombre del hospedaje.
     * @param precioPorNoche El precio por noche del hospedaje.
     * @throws CodServicioDiferenteASeisException Si el código no tiene 6 caracteres.
     */
    public Hospedaje(String codServicio, double porcentajeDescuento, boolean enPromocion, String hospedaje, double precioPorNoche) throws CodServicioDiferenteASeisException {
        super(codServicio, porcentajeDescuento, enPromocion);
        this.hospedaje = hospedaje;
        this.precioPorNoche = precioPorNoche;
        
        if (codServicio == null || codServicio.length() != 6) {
            throw new CodServicioDiferenteASeisException("El codigo del servicio debe tener 6 caracteres.");
        }
    }

    // Getters y Setters para los atributos de la clase
    
    public String getHospedaje() {
        return hospedaje;
    }

    public void setHospedaje(String hospedaje) {
        this.hospedaje = hospedaje;
    }

    public double getPrecioPorNoche() {
        return precioPorNoche;
    }

    public void setPrecioPorNoche(double precioPorNoche) {
        this.precioPorNoche = precioPorNoche;
    }

    /**
     * Calcula el precio final del hospedaje en función de la fecha.
     * Si el hospedaje está en promoción y no es fin de semana, se aplica el descuento.
     * 
     * @param dia La fecha en la que se desea calcular el precio.
     * @return El precio final del hospedaje.
     */
    @Override
    public double calcularPrecioFinal(LocalDate dia) {
        DayOfWeek diaSemana = dia.getDayOfWeek();
        
        // Aplica descuento si está en promoción y no es sábado ni domingo
        if (isEnPromocion() && (diaSemana != DayOfWeek.SATURDAY && diaSemana != DayOfWeek.SUNDAY)) {
            return precioPorNoche - (precioPorNoche * getPorcentajeDescuento() / 100);
        }
        
        return precioPorNoche;
    }

    /**
     * Representación en texto del servicio de hospedaje.
     * Muestra el código, el porcentaje de descuento, el estado de promoción, el nombre del hospedaje y el precio por noche.
     * 
     * @return Una cadena que representa el hospedaje.
     */
    @Override
    public String toString() {
        return "Hospedaje {" + "codigo del servicio = " + getCodServicio() + ", porcentaje de descuento = " + getPorcentajeDescuento() + ", en promocion = " + isEnPromocion() + ", hospedaje = " + hospedaje + ", precio por noche = " + precioPorNoche + "}";
    }
}