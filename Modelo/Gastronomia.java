/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Modelo;
import Excepciones.*;
import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * Clase que representa un servicio de gastronomía, heredando de la clase abstracta Servicio.
 * Cada servicio de gastronomía tiene un nombre, un precio y un día de la semana en el que se aplica un descuento.
 * 
 * @author Agustín
 */

public class Gastronomia extends Servicio {
    private String gastronomia;
    private double precio;
    private int diaSemDesc;

    /**
     * Constructor de la clase Gastronomia.
     * Inicializa los atributos del servicio de gastronomía y valida que el código tenga 6 caracteres.
     * 
     * @param codServicio El código único del servicio (debe tener 6 caracteres).
     * @param porcentajeDescuento El porcentaje de descuento aplicado al servicio.
     * @param enPromocion Indica si el servicio está en promoción.
     * @param gastronomia El nombre del servicio de gastronomía.
     * @param precio El precio del servicio de gastronomía.
     * @param diaSemDesc El día de la semana (como número) en el que se aplica el descuento.
     * @throws CodServicioDiferenteASeisException Si el código no tiene 6 caracteres.
     */
    public Gastronomia(String codServicio, double porcentajeDescuento, boolean enPromocion, String gastronomia, double precio, int diaSemDesc) throws CodServicioDiferenteASeisException {
        super(codServicio, porcentajeDescuento, enPromocion);
        this.gastronomia = gastronomia;
        this.precio = precio;
        this.diaSemDesc = diaSemDesc;
        
        if (codServicio == null || codServicio.length() != 6) {
            throw new CodServicioDiferenteASeisException("El codigo del servicio debe tener 6 caracteres.");
        }
    }

    // Getters y Setters para los atributos de la clase
    
    public String getGastronomia() {
        return gastronomia;
    }

    public void setGastronomia(String gastronomia) {
        this.gastronomia = gastronomia;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getDiaSemDesc() {
        return diaSemDesc;
    }

    public void setDiaSemDesc(int diaSemDesc) {
        this.diaSemDesc = diaSemDesc;
    }

    /**
     * Calcula el precio final del servicio de gastronomía en función de la fecha.
     * Si el servicio está en promoción y es el día de la semana correspondiente, se aplica el descuento.
     * 
     * @param dia La fecha en la que se desea calcular el precio.
     * @return El precio final del servicio de gastronomía.
     */
    @Override
    public double calcularPrecioFinal(LocalDate dia) {
        DayOfWeek diaSemana = dia.getDayOfWeek();
        
        // Aplica descuento si está en promoción y es el día de la semana de descuento
        if (isEnPromocion() && diaSemana.getValue() == diaSemDesc) {
            return precio - (precio * getPorcentajeDescuento() / 100);
        }
        
        return precio;
    }

    /**
     * Representación en texto del servicio de gastronomía.
     * Muestra el código, el porcentaje de descuento, el estado de promoción, el nombre de la gastronomía, el precio y el día de semana del descuento.
     * 
     * @return Una cadena que representa el servicio de gastronomía.
     */
    @Override
    public String toString() {
        return "Gastronomia {" + "codigo del servicio = " + getCodServicio() + ", porcentaje de descuento = " + getPorcentajeDescuento() + ", en promocion = " + isEnPromocion() + ", gastronomia = " + gastronomia + ", precio = " + precio + ", descuento del dia de la semana = " + diaSemDesc + "}";
    }
}