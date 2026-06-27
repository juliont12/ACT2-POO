/**
 * Clase que representa un producto individual en el inventario.
 * Define las propiedades básicas y los comportamientos de un artículo.
 */
public class Producto {
    // ATRIBUTOS (Propiedades privadas para proteger la integridad de los datos)
    private int id;
    private String nombre;
    private double precio;
    private int stock;

    /**
     * Constructor para inicializar un nuevo producto con todos sus datos.
     */
    public Producto(int id, String nombre, double precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    // MÉTODOS GETTERS Y SETTERS (Permiten acceder y modificar los atributos de forma segura)

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if (precio >= 0) { // Validación simple para evitar precios negativos
            this.precio = precio;
        }
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock >= 0) { // Validación para evitar stock negativo
            this.stock = stock;
        }
    }

    // MÉTODOS DE COMPORTAMIENTO

    /**
     * Incrementa o decrementa la cantidad de stock disponible.
     * @param cantidad Puede ser positiva (ingreso) o negativa (venta/salida).
     */
    public void ajustarStock(int cantidad) {
        if (this.stock + cantidad >= 0) {
            this.stock += cantidad;
        } else {
            System.out.println("Error: No hay suficiente stock para realizar la operación.");
        }
    }

    /**
     * Devuelve una cadena de texto con la información detallada del producto.
     */
    @Override
    public String toString() {
        return String.format("ID: %d | %-15s | Precio: $%6.2f | Stock: %d unidades", 
                id, nombre, precio, stock);
    }
}