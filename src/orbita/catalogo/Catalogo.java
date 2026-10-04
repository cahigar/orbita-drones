package orbita.catalogo;

import java.util.ArrayList;
import java.util.List;

/**
 * Catalogo de drones disponibles en la tienda.
 */
public class Catalogo {

    private final List<Dron> drones = new ArrayList<>();

    public Catalogo() {
        drones.add(new Dron("ORB-01", "Mensajero Orbital", 1299.00, 120));
        drones.add(new Dron("ORB-02", "Carguero Ligero", 2450.50, 80));
        drones.add(new Dron("ORB-03", "Explorador Polar", 3890.00, 340));
        drones.add(new Dron("ORB-04", "Repartidor Urbano", 899.95, 45));
    }

    public List<Dron> getDrones() {
        return drones;
    }

    /** Devuelve los drones que llegan al menos a los km indicados. */
    public List<Dron> porAlcance(int kmMinimos) {
        List<Dron> salida = new ArrayList<>();
        for (Dron d : drones) {
            if (d.getAlcanceKm() >= kmMinimos) {
                salida.add(d);
            }
        }
        return salida;
    }

    /** Busca un dron por su codigo. Devuelve null si no existe. */
    public Dron buscar(String codigo) {
        for (Dron d : drones) {
            if (d.getCodigo().equalsIgnoreCase(codigo)) {
                return d;
            }
        }
        return null;
    }

    public void mostrar() {
        System.out.println("=== CATALOGO ORBITA DRONES ===");
        for (Dron d : drones) {
            System.out.println("  " + d);
        }
    }
}
