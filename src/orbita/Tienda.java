package orbita;

import orbita.catalogo.Catalogo;
import orbita.catalogo.Dron;
import orbita.pedidos.Pedido;
import orbita.pedidos.Tarifas;
import orbita.util.Config;

/**
 * Punto de entrada de Orbita Drones.
 *
 * Uso:  java -cp bin orbita.Tienda [codigo] [unidades] [orbita]
 * Ej.:  java -cp bin orbita.Tienda ORB-03 2 GEO
 */
public class Tienda {

    public static void main(String[] args) {
        System.out.println("Orbita Drones - entorno: "
                + Config.get("ORBITA_ENTORNO", "desarrollo"));
        System.out.println();

        Catalogo catalogo = new Catalogo();
        catalogo.mostrar();
        System.out.println();

        String codigo = args.length > 0 ? args[0] : "ORB-01";
        int unidades = args.length > 1 ? Integer.parseInt(args[1]) : 1;
        String orbita = args.length > 2 ? args[2] : "LEO";

        Dron dron = catalogo.buscar(codigo);
        if (dron == null) {
            System.out.println("No existe ningun dron con codigo " + codigo);
            return;
        }

        Pedido pedido = new Pedido(dron, unidades, orbita);
        System.out.println("=== PEDIDO ===");
        System.out.println("  " + pedido);
        System.out.printf("  Subtotal ....... %8.2f EUR%n", pedido.subtotal());
        System.out.printf("  Envio .......... %8.2f EUR%n", Tarifas.gastosEnvio(orbita));
        System.out.printf("  TOTAL .......... %8.2f EUR%n", Tarifas.total(pedido));
    }
}
