import java.util.Scanner;

public class Store {
    // Definir constantes, por ejemplo, para impuestos
    private static final double TAX_RATE = 0.19; // 19% de impuesto/IVA

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Definir el número mínimo de productos a ingresar
        final int NUM_PRODUCTS = 5;

        // Crear arrays para almacenar la información de los productos
        String[] productNames = new String[NUM_PRODUCTS];
        int[] quantityProducts = new int[NUM_PRODUCTS];
        double[] priceProducts = new double[NUM_PRODUCTS];

        //Declarar una constante para la cantidad de categorías que se ingresa por producto
        final int CATEGORY_PRODUCT = 2;
        // Declaración de la matriz bidimensional para almacenar las categorías de los productos
        String[][] categorias = new String[NUM_PRODUCTS][CATEGORY_PRODUCT];  // 5 productos y 2 categorías por producto

        // Llenar la información de los productos
        for (int i = 0; i < NUM_PRODUCTS; i++) {
            System.out.println("Ingrese el nombre del producto #" + (i + 1) + ":");
            productNames[i] = scanner.nextLine();
            System.out.println("Ingrese la cantidad del producto #" + (i + 1) + ":");
            quantityProducts[i] = scanner.nextInt();
            System.out.println("Ingrese el precio por unidad del producto #" + (i + 1) + ":");
            priceProducts[i] = scanner.nextDouble();
            scanner.nextLine(); // Limpiar el buffer del scanner

            // Solicitar al usuario las 2 categorías del producto
            System.out.print("Primera categoría: ");
            categorias[i][0] = scanner.nextLine();
            System.out.print("Segunda categoría: ");
            categorias[i][1] = scanner.nextLine();

            System.out.println();

        }

         // Mostrar la información en formato de tabla
         System.out.println("\nInventario de la tienda:");
         System.out.println("Producto   | Categorías               | Precio Unitario | Cantidad | Valor Total");
         System.out.println("------------------------------------------------------------------------------");
         for (int i = 0; i < productNames.length; i++) {
             double valorTotal = priceProducts[i] * quantityProducts[i];
             System.out.printf("%-10s | %-10s, %-10s | %-15.2f | %-8d | %-10.2f\n",
                               productNames[i], categorias[i][0], categorias[i][1], priceProducts[i], quantityProducts[i], valorTotal);
         }
 
        // Calcular el valor total del inventario
        double totalInventoryValue = 0.0;
        System.out.println("\nReporte del Inventario:");
        for (int i = 0; i < NUM_PRODUCTS; i++) {
            double productValue = quantityProducts[i] * priceProducts[i];
            totalInventoryValue += productValue;
        }
        
        // Valor total del inventario sin impuestos
        System.out.printf("\nValor total del inventario sin impuestos: %.2f%n", totalInventoryValue);
        
        // Valor total del inventario calculando e incluyendo impuestos
        double totalInventoryWithTax = totalInventoryValue * (1 + TAX_RATE);
        System.out.printf("Valor total del inventario con impuestos: %.2f%n", totalInventoryWithTax);

        // Opciones para agregar o actualizar productos del inventario
        while (true) {
            System.out.println("\n¿Desea agregar o actualizar un producto?\n1: agregar\n2: actualizar\n3: salir");
            String option = scanner.nextLine();

            switch (option) {
                // Crear un nuevo array para agregar más productos
                case "1": 
                System.out.println("Ingrese el nombre del nuevo producto:");
                String newName = scanner.nextLine();
                System.out.println("Ingrese la cantidad del nuevo producto:");
                int newQuantity = scanner.nextInt();
                System.out.println("Ingrese el precio por unidad del nuevo producto:");
                double newPrice = scanner.nextDouble();
                scanner.nextLine(); // Limpiar el buffer
                break;

                //
                case "2": 
                System.out.println("Ingrese el nombre del producto a actualizar:");
                String updateName = scanner.nextLine();
                
                boolean found = false;
                for (int i = 0; i < NUM_PRODUCTS; i++) {
                    if (productNames[i].equalsIgnoreCase(updateName)) {
                        System.out.println("Ingrese la nueva cantidad:");
                        quantityProducts[i] = scanner.nextInt();
                        System.out.println("Ingrese el nuevo precio por unidad:");
                        priceProducts[i] = scanner.nextDouble();
                        scanner.nextLine(); // Limpiar el buffer
                        found = true;
                        break;
                    }
                }
                
                if (!found) {
                    System.out.println("Producto no encontrado.");
                }

            //Salir del programa
            case "3": 
                System.out.println("Ha salido exitosamente del programa.");
                break;

            //Determinar acción si el usuario ingresa un número inválido
            default: 
                System.out.println("Error 404.\nInténtelo de nuevo.");
        
        scanner.close();
            }
        }   
    }
}