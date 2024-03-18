/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuradatos;

import static estructuradatos.EstructuraDatos.sc;

/**
 *
 * @author Carlos-Zarate
 */
public class ListaLogica {

    public void MenuLista() {
        while (true) {
            System.out.println("\tLISTAS");
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
                    System.out.println("opcion 1");
                    break;
                case 2:
                    System.out.println("opcion 2");
                    break;
                case 3:

                    break;
                case 5:
                    return;
            }
        }
    }
}
