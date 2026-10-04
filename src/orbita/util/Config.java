package orbita.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Lee la configuracion del fichero .env que hay en la raiz del proyecto.
 *
 * El .env REAL nunca se sube al repositorio: esta en .gitignore.
 * Lo que se sube es .env.example, con las claves vacias, para que
 * cualquiera que clone el proyecto sepa que variables necesita.
 */
public class Config {

    private static final Map<String, String> VALORES = new HashMap<>();

    static {
        cargar(".env");
    }

    private static void cargar(String ruta) {
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if (linea.isEmpty() || linea.startsWith("#") || !linea.contains("=")) {
                    continue;
                }
                int i = linea.indexOf('=');
                VALORES.put(linea.substring(0, i).trim(), linea.substring(i + 1).trim());
            }
        } catch (Exception e) {
            System.out.println("[config] No he encontrado .env. Copia .env.example y renombralo.");
        }
    }

    public static String get(String clave, String porDefecto) {
        return VALORES.getOrDefault(clave, porDefecto);
    }
}
