# Órbita Drones

Tienda de drones de reparto orbital. Proyecto de ejemplo de la **UD4 — Control de versiones**
del módulo de Entornos de Desarrollo (1.º DAM, IES Ataúlfo Argenta).

No es un proyecto serio: existe para que haya algo real sobre lo que hacer commits, ramas,
pull requests y conflictos.

---

## Qué hace

Muestra el catálogo de drones y calcula el total de un pedido, con los gastos de envío según
la órbita de destino.

```
Orbita Drones - entorno: local

=== CATALOGO ORBITA DRONES ===
  ORB-01 Mensajero Orbital       1299.00 EUR    120 km
  ORB-02 Carguero Ligero         2450.50 EUR     80 km
  ORB-03 Explorador Polar        3890.00 EUR    340 km
  ORB-04 Repartidor Urbano        899.95 EUR     45 km

=== PEDIDO ===
  2 x Explorador Polar  ->  orbita GEO
  Subtotal .......  7780.00 EUR
  Envio ..........    95.00 EUR
  TOTAL ..........  7875.00 EUR
```

## Cómo se ejecuta

```bash
javac -d bin $(find src -name "*.java")
java -cp bin orbita.Tienda ORB-03 2 GEO
```

En Windows, si `find` no te funciona:

```bat
javac -d bin src\orbita\*.java src\orbita\catalogo\*.java src\orbita\pedidos\*.java src\orbita\util\*.java
java -cp bin orbita.Tienda ORB-03 2 GEO
```

Argumentos: `[código de dron] [unidades] [órbita]`. Las órbitas son `LEO`, `MEO` y `GEO`.

## Configuración

El proyecto lee sus ajustes de un fichero `.env` en la raíz. **Ese fichero no está en el
repositorio y no debe estarlo nunca**, porque lleva claves.

Lo que sí está es `.env.example`. Para empezar:

```bash
cp .env.example .env
```

y rellena los valores. Si no existe `.env`, el programa avisa y sigue con los valores por
defecto.

## Estructura

```
src/orbita/
  Tienda.java            punto de entrada
  catalogo/
    Dron.java            un modelo de dron
    Catalogo.java        el catálogo completo
  pedidos/
    Pedido.java          un pedido
    Tarifas.java         gastos de envío por órbita
  util/
    Config.java          lectura del .env
```

## Cómo trabajamos aquí

1. Nadie empuja a `main`. `main` está protegida.
2. Una rama por tarea: `feature/catalogo-filtros`, `fix/envio-geo`.
3. Antes de empezar, `git pull` en `main`.
4. Los cambios entran por **Pull Request**, con al menos una revisión.
5. El PR enlaza su Issue: `closes #12`.
6. Una vez fusionado, se borra la rama.

## Equipo

| Rol | Persona |
|---|---|
| Mantenimiento | [@cahigar](https://github.com/cahigar) |
| Revisión | [@CHGsmr](https://github.com/CHGsmr) |
