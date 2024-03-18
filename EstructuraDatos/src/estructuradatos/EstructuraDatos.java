package estructuradatos;

import java.util.Scanner;

/**
 *
 * @author Carlos-Zarate
 */

public class EstructuraDatos {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        MenuPrincipal();
    }

    public static void MenuPrincipal() {
        while (true) {
            System.out.println("\tESTRUCTURA DE DATOS");
            System.out.println("\tMenu de Opciones");
            System.out.println("");
            System.out.println("1.\tPilas\t|\tUsar Pilas");
            System.out.println("2.\tColas\t|\tUsar Colas");
            System.out.println("3.\tListas\t|\tUsar Listas");
            System.out.println("");
            System.out.println("5.\tSalir");
            int opc = sc.nextInt();
            switch (opc) {
                case 1:
                    PilaLogica pila = new PilaLogica();
                    pila.MenuPila();
                    break;
                case 2:
                    ColaLogica cola = new ColaLogica();
                    cola.MenuCola();
                    break;
                case 3:
                    
                    break;
                case 5:
                    break;
            }
        }
    }
}
