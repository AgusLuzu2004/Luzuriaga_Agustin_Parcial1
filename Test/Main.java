/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package Test;
import Excepciones.*;
import Modelo.*;
import java.util.List;
import java.time.LocalDate;

/**
 * Clase principal que ejecuta el sistema de gestión de servicios.
 * Permite agregar servicios y calcular precios, así como realizar búsquedas.
 * 
 * @author Agustín
 */

public class Main {

    public static void main(String[] args) throws GastronomiaYaExistenteException, HospedajeYaExistenteException, CodServicioDiferenteASeisException {
        Sistema sistema = new Sistema(); // Crea una instancia del sistema
        
        System.out.println("1-1");
        
        // Intento de agregar un servicio de gastronomía con código incorrecto
        try {
            sistema.agregarGastronomia("4892", 15.0, true, "Hamburguesa criolla", 180.0, 4);
            System.out.println("Servicio agregado.");
        }
        catch (CodServicioDiferenteASeisException e) {
            System.out.println(e.getMessage()); // Captura y muestra el mensaje de excepción
        }
        
        System.out.println("1-2");
        
        // Intento de agregar un servicio de gastronomía con código correcto
        try {
            sistema.agregarGastronomia("489235", 15.0, true, "Hamburguesa criolla", 180.0, 4);
            System.out.println("Servicio agregado.");
            
        }
        catch (CodServicioDiferenteASeisException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("1-3");
        
        // Intento de agregar un servicio de hospedaje con código incorrecto
        try {
            sistema.agregarHospedaje("2872", 10.0, true, "Cabaña 3 personas", 1500.0);
            System.out.println("Servicio agregado.");
        }
        catch (CodServicioDiferenteASeisException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("1-4");
        
        // Intento de agregar un servicio de hospedaje con código correcto
        try {
            sistema.agregarHospedaje("287282", 10.0, true, "Cabaña 3 personas", 1500.0);
            System.out.println("Servicio agregado.");
        }
        catch (CodServicioDiferenteASeisException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("2-1");
        
        // Cálculo del precio final de un servicio de gastronomía
        Gastronomia gastronomia = (Gastronomia) sistema.traerServicio("489235");
        double precioFinalGastronomia = gastronomia.calcularPrecioFinal(LocalDate.of(2020, 10, 28));
        System.out.println("Precio final Gastronomia: " + precioFinalGastronomia);
        
        System.out.println("2-2");
        
        // Cálculo del precio final de un servicio de hospedaje
        Hospedaje hospedaje = (Hospedaje) sistema.traerServicio("287282");
        double precioFinalHospedaje = hospedaje.calcularPrecioFinal(LocalDate.of(2020, 10, 27));
        System.out.println("Precio Final Hospedaje: " + precioFinalHospedaje);
        
        System.out.println("3");
        
        // Intento de agregar varios servicios
        try {
            sistema.agregarGastronomia("858297", 15.0, true, "Milanesa con pure", 350.0, 3);
            sistema.agregarHospedaje("489259", 10.0, true, "Habitacion triple", 2200.0);
            sistema.agregarGastronomia("182835", 20.0, false, "Gaseosa", 120.0, 3);
            sistema.agregarHospedaje("758972", 15.0, false, "Habitacion simple", 1000.0);
            System.out.println("Servicios agregados correctamente.");
        }
        catch (GastronomiaYaExistenteException | HospedajeYaExistenteException | CodServicioDiferenteASeisException e) {
            System.out.println(e.getMessage());
        }
        
        // Muestra todos los servicios en promoción
        for (Servicio servicio : sistema.traerServicio(true)) {
            System.out.println(servicio.getCodServicio() + ": " + servicio.getClass().getSimpleName());
        }
        
        System.out.println("4-1");
        
        // Lista de servicios en promoción
        List<Servicio> serviciosEnPromocion = sistema.traerServicio(true);
        
        for (Servicio servicio : serviciosEnPromocion) {
            System.out.println(servicio.getCodServicio() + " - En promocion");
        }
        
        System.out.println("4-2");
        
        // Lista de servicios en promoción en una fecha específica
        List<Servicio> serviciosEnPromocionYDia = sistema.traerServicio(true, LocalDate.of(2020, 10, 28));
        
        for (Servicio servicio : serviciosEnPromocionYDia) {
            System.out.println(servicio.getCodServicio() + " - En promocion el 2020-10-28");
        }
    }
}