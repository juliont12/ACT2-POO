import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada de la lógica de negocio: gestionar la colección de productos.
 */
public class GestorProductos {
    // ATRIBUTO: Lista dinámica que almacenará objetos de tipo Producto
    private List<Producto> listaProductos;

    /**
     * Constructor que inicializa la lista de productos vacía.
     */
    public GestorProductos() {
        this.listaProductos = new ArrayList<>();
    }

    /**
     * Añade un nuevo producto al inventario.
     */
    public void agregarProducto(Producto producto) {
        // Validación básica para no repetir IDs
        if (buscarPorId(producto.getId()) == null) {
            listaProductos.add(producto);
            System.out.println("Producto '" + producto.getNombre() + "' agregado con éxito.");
        } else {
            System.out.println("Error: Ya existe un producto con el ID " + producto.getId());
        }
    }

    /**
     * Busca un producto específico utilizando su ID.
     * @return El objeto Producto si lo encuentra, o null si no existe.
     */
    public Producto buscarPorId(int id) {
        for (Producto p : listaProductos) {
            if (p.getId() == id) {
                return p; // Retorna el producto inmediatamente al encontrarlo
            }
        }
        return null; // Si termina el bucle y no lo encuentra
    }

    /**
     * Imprime en consola todos los productos registrados actualmente.
     */
    public void mostrarInventario() {
        System.out.println("\n========= INVENTARIO ACTUAL =========");
        if (listaProductos.isEmpty()) {
            System.out.println("El inventario está completamente vacío.");
        } else {
            for (Producto p : listaProductos) {
                System.out.println(p.toString()); // Llama automáticamente al método toString() de Producto
            }
        }
        System.out.println("=====================================");
    }
}