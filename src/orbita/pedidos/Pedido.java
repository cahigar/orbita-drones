package orbita.pedidos;

import orbita.catalogo.Dron;

/**
 * Un pedido de la tienda: un dron, una cantidad y una orbita de entrega.
 */
public class Pedido {

    private final Dron dron;
    private final int unidades;
    private final String orbita;

    public Pedido(Dron dron, int unidades, String orbita) {
        this.dron = dron;
        this.unidades = unidades;
        this.orbita = orbita;
    }

    public Dron getDron() {
        return dron;
    }

    public int getUnidades() {
        return unidades;
    }

    public String getOrbita() {
        return orbita;
    }

    /** Importe sin gastos de envio. */
    public double subtotal() {
        return dron.getPrecio() * unidades;
    }

    @Override
    public String toString() {
        return unidades + " x " + dron.getModelo() + "  ->  orbita " + orbita;
    }
}
