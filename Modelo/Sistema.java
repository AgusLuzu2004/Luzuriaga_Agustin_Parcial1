/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Modelo;
import Excepciones.*;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

/**
 * Clase que gestiona un conjunto de servicios (gastronomía y hospedaje).
 * Permite agregar nuevos servicios, buscar servicios existentes y filtrar por promociones.
 * 
 * @author Agustín
 */

public class Sistema {
    private List<Servicio> listaServicio; // Lista que almacena todos los servicios

    /**
     * Constructor de la clase Sistema.
     * Inicializa la lista de servicios como un ArrayList.
     */
    public Sistema() {
        this.listaServicio = new ArrayList<>();
    }

    // Getters y Setters para la lista de servicios
    
    public List<Servicio> getListaServicio() {
        return listaServicio;
    }

    public void setListaServicio(List<Servicio> listaServicio) {
        this.listaServicio = listaServicio;
    }
    
    /**
     * Busca un servicio en la lista por su código.
     * 
     * @param codServicio El código del servicio a buscar.
     * @return El servicio encontrado, o null si no existe.
     */
    public Servicio traerServicio(String codServicio) {
        
        for (Servicio servicio : listaServicio) {
            
            if (servicio.getCodServicio().equals(codServicio)) {
                return servicio;
            }
        }
        
        return null; // Retorna null si no se encuentra el servicio
    }
    
    /**
     * Filtra y retorna los servicios según su estado de promoción.
     * 
     * @param enPromocion Indica si se buscan servicios en promoción o no.
     * @return Una lista de servicios que coinciden con el estado de promoción.
     */
    public List<Servicio> traerServicio(boolean enPromocion) {
        List<Servicio> serviciosEnPromocion = new ArrayList<>();
        
        for (Servicio servicio : listaServicio) {
            
            if (servicio.isEnPromocion() == enPromocion) {
                serviciosEnPromocion.add(servicio); // Agrega el servicio si coincide
            }
        }
        
        return serviciosEnPromocion;
    }
    
    /**
     * Filtra y retorna los servicios según su estado de promoción y la fecha.
     * 
     * @param enPromocion Indica si se buscan servicios en promoción o no.
     * @param dia La fecha en la que se desea calcular el precio final.
     * @return Una lista de servicios que coinciden con el estado de promoción y precio diferente.
     */
    public List<Servicio> traerServicio(boolean enPromocion, LocalDate dia) {
        List<Servicio> serviciosEnPromocion = new ArrayList<>();
        
        for (Servicio servicio : listaServicio) {
            
            if (servicio.isEnPromocion() == enPromocion) {
                
                // Verifica si el precio final en la fecha seleccionada es diferente al día anterior
                if (servicio.calcularPrecioFinal(dia) != servicio.calcularPrecioFinal(dia.minusDays(1))) {
                    serviciosEnPromocion.add(servicio); // Agrega el servicio si el precio es diferente
                }
            }
        }
        
        return serviciosEnPromocion;
    }
    
    /**
     * Agrega un nuevo servicio de gastronomía a la lista.
     * 
     * @param codServicio El código único del servicio (debe tener 6 caracteres).
     * @param porcentajeDescuento El porcentaje de descuento aplicado al servicio.
     * @param enPromocion Indica si el servicio está en promoción.
     * @param gastronomia El nombre del servicio de gastronomía.
     * @param precio El precio del servicio de gastronomía.
     * @param diaSemDesc El día de la semana (como número) en el que se aplica el descuento.
     * @return true si el servicio fue agregado exitosamente; false en caso contrario.
     * @throws GastronomiaYaExistenteException Si el servicio ya existe.
     * @throws CodServicioDiferenteASeisException Si el código no tiene 6 caracteres.
     */
    public boolean agregarGastronomia(String codServicio, double porcentajeDescuento, boolean enPromocion, String gastronomia, double precio, int diaSemDesc) throws GastronomiaYaExistenteException, CodServicioDiferenteASeisException {
        
        if (traerServicio(codServicio) != null) {
            throw new GastronomiaYaExistenteException("El servicio con el codigo " + codServicio + " ya existe.");
        }
        
        if (codServicio == null || codServicio.length() != 6) {
            throw new CodServicioDiferenteASeisException("El codigo del servicio debe tener 6 caracteres.");
        }
        
        Gastronomia nuevoServicio = new Gastronomia(codServicio, porcentajeDescuento, enPromocion, gastronomia, precio, diaSemDesc);
        return listaServicio.add(nuevoServicio); // Agrega el nuevo servicio a la lista
    }
    
    /**
     * Agrega un nuevo servicio de hospedaje a la lista.
     * 
     * @param codServicio El código único del servicio (debe tener 6 caracteres).
     * @param porcentajeDescuento El porcentaje de descuento aplicado al servicio.
     * @param enPromocion Indica si el servicio está en promoción.
     * @param hospedaje El nombre del servicio de hospedaje.
     * @param precioPorNoche El precio por noche del servicio de hospedaje.
     * @return true si el servicio fue agregado exitosamente; false en caso contrario.
     * @throws HospedajeYaExistenteException Si el servicio ya existe.
     * @throws CodServicioDiferenteASeisException Si el código no tiene 6 caracteres.
     */
    public boolean agregarHospedaje(String codServicio, double porcentajeDescuento, boolean enPromocion, String hospedaje, double precioPorNoche) throws HospedajeYaExistenteException, CodServicioDiferenteASeisException {
        
        if (traerServicio(codServicio) != null) {
            throw new HospedajeYaExistenteException("El servicio con el codigo " + codServicio + " ya existe.");
        }
        
        if (codServicio == null || codServicio.length() != 6) {
            throw new CodServicioDiferenteASeisException("El codigo del servicio debe tener 6 caracteres.");
        }
        
        Hospedaje nuevoServicio = new Hospedaje(codServicio, porcentajeDescuento, enPromocion, hospedaje, precioPorNoche);
        return listaServicio.add(nuevoServicio); // Agrega el nuevo servicio a la lista
    }
}