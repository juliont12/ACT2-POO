/**
 * Clase principal que sirve como punto de partida para ejecutar y probar la aplicación.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("--- Iniciando Sistema de Gestión de Productos ---");

        // 1. INSTANCIACIÓN del objeto gestor
        GestorProductos gestor = new GestorProductos();

        // 2. INSTANCIACIÓN de objetos de tipo Producto
        Producto prod1 = new Producto(101, "Laptop ZenBook", 899.99, 10);
        Producto prod2 = new Producto(102, "Mouse Inalámbrico", 25.50, 50);
        Producto prod3 = new Producto(103, "Teclado Mecánico", 75.00, 20);

        // 3. PRUEBA: Agregar productos al gestor
        System.out.println("\n--- Registrando Productos ---");
        gestor.agregarProducto(prod1);
        gestor.agregarProducto(prod2);
        gestor.agregarProducto(prod3);
        
        // Intentar agregar un producto con ID repetido para probar la validación
        Producto prodRepetido = new Producto(101, "Laptop Antigua", 400.00, 2);
        gestor.agregarProducto(prodRepetido);

        // 4. PRUEBA: Mostrar el estado inicial del inventario
        gestor.mostrarInventario();

        // 5. PRUEBA: Buscar un producto y modificar sus atributos directamente
        System.out.println("\n--- Simulando Movimientos de Stock y Ventas ---");
        Producto productoEncontrado = gestor.buscarPorId(102);
        
        if (productoEncontrado != null) {
            System.out.println("Producto encontrado: " + productoEncontrado.getNombre());
            
            // Simular una venta (restar 5 unidades)
            System.out.println("Vendiendo 5 unidades de " + productoEncontrado.getNombre() + "...");
            productoEncontrado.ajustarStock(-5);
            
            // Simular reabastecimiento (sumar 10 unidades)
            System.out.println("Recibiendo lote de 10 unidades de " + productoEncontrado.getNombre() + "...");
            productoEncontrado.ajustarStock(10);
        }

        // Prueba de validación de stock insuficiente
        if (prod1 != null) {
            System.out.println("\nIntentando vender 15 Laptops (Stock actual es 10)...");
            prod1.ajustarStock(-15); 
        }

        // 6. PRUEBA: Mostrar el inventario final reflejando los cambios
        gestor.mostrarInventario();
    }
}