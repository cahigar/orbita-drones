package orbita.catalogo;

/**
 * Un dron del catalogo de Orbita Drones.
 *
 * @author 1 DAM
 */
public class Dron {

    private final String codigo;
    private final String modelo;
    private final double precio;
    private final int alcanceKm;

    public Dron(String codigo, String modelo, double precio, int alcanceKm) {
        this.codigo = codigo;
        this.modelo = modelo;
        this.precio = precio;
        this.alcanceKm = alcanceKm;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getModelo() {
        return modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public int getAlcanceKm() {
        return alcanceKm;
    }

    @Override
    public String toString() {
        return String.format("%-6s %-22s %8.2f EUR  %5d km", codigo, modelo, precio, alcanceKm);
    }
}
