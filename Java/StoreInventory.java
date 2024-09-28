import java.util.Scanner;

public class StoreInventory {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        //Definición de variables y constantes
        
        //Definir el número mínimo de productos a ingresar
        final int MIN_PRODUCTS = 5;
        // Definir el número máximo de productos a ingresar
        final int MAX_PRODUCTS = 100; 
        // Definir constante para impuestos
        final double TAX_RATE = 0.19; // 19% de impuesto/IVA
        
        // Contador para el número de productos ingresados
        int numProducts = 0; 
        double totalInventoryValue = 0.0; // Valor total del inventario sin impuestos
        double totalInventoryWithTax = 0.0; // Valor total del inventario con impuestos

        // Crear arrays para almacenar la información de los productos
        String[] productNames = new String[MAX_PRODUCTS];
        int[] quantityProducts = new int[MAX_PRODUCTS];
        double[] priceProducts = new double[MAX_PRODUCTS];


        // Llenar la información de los productos
        
        for (int i = 0; i < MIN_PRODUCTS; i++) { 
            System.out.println("Ingrese el nombre del producto #" + (i + 1) + ":");
            productNames[i] = scanner.nextLine();
            System.out.println("Ingrese la cantidad del producto #" + (i + 1) + ":");
            quantityProducts[i] = scanner.nextInt();
            System.out.println("Ingrese el precio por unidad del producto #" + (i + 1) + ":");
            priceProducts[i] = scanner.nextDouble();
            // Limpiar el buffer del scanner
            scanner.nextLine(); 
            // Aumentar el contador de productos
            numProducts++; 
            System.out.println();
            
        }

        // Mostrar la información en formato de tabla
        System.out.println("\nInventario de la tienda:");
        System.out.println("Producto             | Precio Unitario | Cantidad   | Valor Total");
        System.out.println("---------------------------------------------------------------------");
        
        // Cambiar el límite a numProducts
        for (int i = 0; i < numProducts; i++) { 
            double totalValue = priceProducts[i] * quantityProducts[i];
            System.out.printf("%-20s | %-15.2f | %-10d | %-10.2f\n",
                              productNames[i], priceProducts[i], quantityProducts[i], totalValue);
                              
        }

        // Calcular el valor total del inventario
        System.out.println("\nReporte del Inventario:");
        // Cambiar el límite a numProducts
        for (int i = 0; i < numProducts; i++) { 
            double productValue = quantityProducts[i] * priceProducts[i];
            totalInventoryValue += productValue;
            
        }
        
        // Valor total del inventario sin impuestos
        System.out.printf("\nValor total del inventario sin impuestos: %.2f%n", totalInventoryValue);
        
        // Valor total del inventario calculando e incluyendo impuestos
        totalInventoryWithTax = totalInventoryValue * (1 + TAX_RATE);
        System.out.printf("Valor total del inventario con impuestos: %.2f%n", totalInventoryWithTax);


        // Opciones para agregar o actualizar productos del inventario
        while (true) {
            System.out.println("\n¿Desea agregar o actualizar un producto?\n1: agregar\n2: actualizar\n3: Ver inventario\n4: salir");
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    // Asegurar de que hay espacio
                    if (numProducts < MAX_PRODUCTS) { 
                        System.out.println("Ingrese el nombre del nuevo producto:");
                        String newName = scanner.nextLine();
                        System.out.println("Ingrese la cantidad del nuevo producto:");
                        int newQuantity = scanner.nextInt();
                        System.out.println("Ingrese el precio por unidad del nuevo producto:");
                        double newPrice = scanner.nextDouble();
                        scanner.nextLine(); // Limpiar el buffer

                        // Agregar el nuevo producto al inventario
                        productNames[numProducts] = newName;
                        quantityProducts[numProducts] = newQuantity;
                        priceProducts[numProducts] = newPrice;
                        numProducts++; // Incrementar el contador
                        System.out.println("Producto agregado.");
                        
                    } else {
                        System.out.println("No se puede agregar más productos. Límite alcanzado.");
                    }
                    break;

                case "2":
                    System.out.println("Ingrese el nombre del producto a actualizar:");
                    String updateName = scanner.nextLine();
                    
                    boolean found = false;
                    for (int i = 0; i < numProducts; i++) {
                        if (productNames[i].equalsIgnoreCase(updateName)) {
                            System.out.println("Ingrese la nueva cantidad de producto:");
                            quantityProducts[i] = scanner.nextInt();
                            System.out.println("Ingrese el nuevo precio por unidad:");
                            priceProducts[i] = scanner.nextDouble();
                            // Limpiar el buffer
                            scanner.nextLine(); 
                            
                            found = true;
                            System.out.println("Producto actualizado.");
                            break;
                        }
                    }
                    
                    if (!found) {
                        System.out.println("Producto no encontrado.");
                    }
                    break;
                
                case "3":
                // Mostrar la información en formato de tabla
                System.out.println("\nInventario de la tienda:");
                System.out.println("Producto             | Precio Unitario | Cantidad   | Valor Total");
                System.out.println("------------------------------------------------------------------------------");
                // Cambiar el límite a numProducts
                for (int i = 0; i < numProducts; i++) { 
                    double totalValue = priceProducts[i] * quantityProducts[i];
                System.out.printf("%-20s | %-15.2f | %-10d | %-10.2f\n",
                              productNames[i], priceProducts[i], quantityProducts[i], totalValue);
                }

                // Calcular el valor total del inventario actualizado con los nuevos productos
        
                System.out.println("\nReporte del Inventario:");
                // Cambiar el límite a numProducts
                for (int i = 0; i < numProducts; i++) { 
                    double productValue = quantityProducts[i] * priceProducts[i];
                    totalInventoryValue += productValue;
                }
        
                // Valor total del inventario sin impuestos
                    System.out.printf("\nValor total del inventario sin impuestos: %.2f%n", totalInventoryValue);
        
                // Valor total del inventario calculando e incluyendo impuestos
                    totalInventoryWithTax = totalInventoryValue * (1 + TAX_RATE);
                    System.out.printf("Valor total del inventario con impuestos: %.2f%n", totalInventoryWithTax);
        
                break;
                
                case "4":
                    System.out.println("Ha salido exitosamente del programa.");
                    scanner.close();
                    return; // Salir del programa

                default:
                    System.out.println("Error 404.\nInténtelo de nuevo.");
            }
        }   
    }
}
