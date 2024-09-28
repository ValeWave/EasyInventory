import java.util.Scanner;

public class inventaryStore {
    
    public static void main(String [] args){

        //Declaro una constante para mínimo de productos en el inventario
        int numProducts = 5; 

        //Crear constante para impuestos/IVA
        final double TAX_RATE = 0.19;


         //arrays para almacenar los datos de los productos
         String[] productNames = new String[numProducts];
         int[] quantities = new int[numProducts];
         double[] prices = new double[numProducts];
        
        System.out.println("¡Bienvenido!");

        //Crear una variable de tipo entero con un número asignado para que el while se ejecute con la condición
        int option = 1; 
        while (option == 1 || option == 2 || option == 3 || option == 0) {

            System.out.println("Elija la opción que desea realizar");
            System.out.println("1. Agregar nuevos productos\n2. Actualizar inventario\n3. Ver inventario\n4. Salir");
            
        //Crear un Scanner que pedirá datos por teclado al usuario
        Scanner teclado = new Scanner(System.in);

        //A la variable inicial se le asignará el valor que el usuario ingrese (por lo que ya no toma su valor inicial 1)
        option = teclado.nextInt();

            //Desplegar un menú en el que dependiendo la opción del usuario realizará ciertos procedimientos
            switch (option) {
                case 1:

                 //utilizar un for para pedir la información por consola hasta que i sea menor a numProducts y acabe el bucle
                    for (int i = 0; i < numProducts; i++) {
                        System.out.println("Ingrese el nombre del producto #" + (i + 1) + ":");
                        productNames[i] = teclado.nextLine();
                        System.out.println("Ingrese la cantidad del producto #" + (i + 1) + ":");
                        quantities[i] = teclado.nextInt();
                        System.out.println("Ingrese el precio por unidad del producto #" + (i + 1) + ":");
                        prices[i] = teclado.nextDouble();
                        teclado.nextLine(); //limpiar buffer (salto de línea)
                        break;

                        }

                case 2:

                    System.out.println("Ingrese el nombre del producto a actualizar:");
                    String updateName = teclado.nextLine();
                
                    boolean found = false;
                    for (int i = 0; i < numProducts; i++) {
                        if (productNames[i].equalsIgnoreCase(updateName)) {
                            System.out.println("Ingrese la nueva cantidad:");
                            quantities[i] = teclado.nextInt();
                            System.out.println("Ingrese el nuevo precio por unidad:");
                            prices[i] = teclado.nextDouble();
                            teclado.nextLine(); // Limpiar el buffer
                            found = true;
                            break;
                    }
                }
                
                if (!found) {
                    System.out.println("Producto no encontrado.");
                }
                case 3:
                        
                // Calcular el valor total del inventario
                    double totalInventoryValue = 0.0;
                    System.out.println("\nReporte del Inventario:");
                    for (int i = 0; i < numProducts; i++) {
                    double productValue = quantities[i] * prices[i];
                    totalInventoryValue += productValue;
                    System.out.printf("Producto: %s, Cantidad: %d, Precio: %.2f, Valor Total: %.2f%n", 
                    productNames[i], quantities[i], prices[i], productValue);
                    break;
                
                }

                // Mostrar el valor total del inventario antes de impuestos
                    System.out.printf("\nValor total del inventario (sin impuestos): %.2f%n", totalInventoryValue);
        
                 // Calcular e incluir impuestos
                    double totalWithTax = totalInventoryValue * (1 + TAX_RATE);
                    System.out.printf("Valor total del inventario (con impuestos): %.2f%n", totalWithTax);

                case 0:
                    System.out.println("----------------Saliendo----------------\nHa salido exitosamente del programa.");
                    break;

                default:
                    System.out.println("Error 404: por favor, intentelo de nuevo.");
                    break;

            }
            teclado.close (); //cerramos el scanner
        }
        
    } 
               
}
        