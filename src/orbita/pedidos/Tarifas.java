package orbita.pedidos;

/**
 * Gastos de envio segun la orbita de destino.
 *
 * OJO: este es el fichero que todos los equipos acaban tocando a la vez.
 * Es el candidato perfecto para provocar un conflicto en clase.
 */
public class Tarifas {

    public static final double ENVIO_BAJA = 15.00;
    public static final double ENVIO_MEDIA = 42.50;
    public static final double ENVIO_ALTA = 79.90;

    /** Devuelve los gastos de envio para la orbita indicada. */
    public static double gastosEnvio(String orbita) {
        switch (orbita.toUpperCase()) {
            case "LEO":
                return ENVIO_BAJA;
            case "MEO":
                return ENVIO_MEDIA;
            case "GEO":
                return ENVIO_ALTA;
            default:
                return ENVIO_MEDIA;
        }
    }

    public static double total(Pedido pedido) {
        return pedido.subtotal() + gastosEnvio(pedido.getOrbita());
    }
}
