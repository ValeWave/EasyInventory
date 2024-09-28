import java.util.Scanner;

public class prueba {

    // Definir constante para impuestos
    final double TAX_RATE = 0.19; // 19% de impuesto

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Definir el número de productos
        final int NUM_PRODUCTS = 5;

        // Crear arrays para almacenar la información de los productos
        String[] productNames = new String[NUM_PRODUCTS];
        int[] quantities = new int[NUM_PRODUCTS];
        double[] prices = new double[NUM_PRODUCTS];

        // Llenar la información de los productos
        for (int i = 0; i < NUM_PRODUCTS; i++) {
            System.out.println("Ingrese el nombre del producto #" + (i + 1) + ":");
            productNames[i] = scanner.nextLine();
            System.out.println("Ingrese la cantidad del producto #" + (i + 1) + ":");
            quantities[i] = scanner.nextInt();
            System.out.println("Ingrese el precio por unidad del producto #" + (i + 1) + ":");
            prices[i] = scanner.nextDouble();
            scanner.nextLine(); // Limpiar el buffer del scanner
        }

        // Calcular el valor total del inventario
        double totalInventoryValue = 0.0;
        System.out.println("\nReporte del Inventario:");
        for (int i = 0; i < NUM_PRODUCTS; i++) {
            double productValue = quantities[i] * prices[i];
            totalInventoryValue += productValue;
            System.out.printf("Producto: %s, Cantidad: %d, Precio: %.2f, Valor Total: %.2f%n", 
                              productNames[i], quantities[i], prices[i], productValue);
        }
        
        // Mostrar el valor total del inventario antes de impuestos
        System.out.printf("\nValor total del inventario (sin impuestos): %.2f%n", totalInventoryValue);
        
        // Calcular e incluir impuestos
        double totalWithTax = totalInventoryValue * (1 + TAX_RATE);
        System.out.printf("Valor total del inventario (con impuestos): %.2f%n", totalWithTax);

        // Opciones para agregar o actualizar productos
        while (true) {
            System.out.println("\n¿Desea agregar o actualizar un producto? (a: agregar, u: actualizar, s: salir)");
            String option = scanner.nextLine();

            if (option.equalsIgnoreCase("a")) {
                // Expandir el tamaño de los arrays para agregar más productos
                // Nota: En una implementación real, se recomienda usar estructuras dinámicas como ArrayList
                // Aquí se simplifica para el propósito del ejemplo
                System.out.println("Ingrese el nombre del nuevo producto:");
                String newName = scanner.nextLine();
                System.out.println("Ingrese la cantidad del nuevo producto:");
                int newQuantity = scanner.nextInt();
                System.out.println("Ingrese el precio por unidad del nuevo producto:");
                double newPrice = scanner.nextDouble();
                scanner.nextLine(); // Limpiar el buffer

                // Agregar al inventario
                // Nota: Aquí se debe hacer una validación adecuada para evitar el desbordamiento de arrays
                // y un manejo de errores más robusto en una implementación real
                // El siguiente código solo es para ilustrar el proceso

            } else if (option.equalsIgnoreCase("u")) {
                System.out.println("Ingrese el nombre del producto a actualizar:");
                String updateName = scanner.nextLine();
                
                boolean found = false;
                for (int i = 0; i < NUM_PRODUCTS; i++) {
                    if (productNames[i].equalsIgnoreCase(updateName)) {
                        System.out.println("Ingrese la nueva cantidad:");
                        quantities[i] = scanner.nextInt();
                        System.out.println("Ingrese el nuevo precio por unidad:");
                        prices[i] = scanner.nextDouble();
                        scanner.nextLine(); // Limpiar el buffer
                        found = true;
                        break;
                    }
                }
                
                if (!found) {
                    System.out.println("Producto no encontrado.");
                }
                
            } else if (option.equalsIgnoreCase("s")) {
                System.out.println("Saliendo...");
                break;
            } else {
                System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        }
        
    }
}

