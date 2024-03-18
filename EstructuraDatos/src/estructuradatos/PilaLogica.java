package estructuradatos;

import static estructuradatos.EstructuraDatos.sc;

/**
 *
 * @author Carlos-Zarate
 */
public class PilaLogica {

    static int dato;
    static int n_Posiciones;
    static int n_Elementos;
    static int pila[];
    static int pilaAUX[];

    public void MenuPila() {
        while (true) {
            System.out.println("\tPILAS");
            System.out.println("\tMenu de Opciones");
            System.out.println("");
            System.out.println("1.\tCrear\t|\tCrear una pila");
            System.out.println("2.\tBorrar\t|\tBorrar pila creada");
            System.out.println("");
            System.out.println("3.\tPush\t|\tAgregar dato");
            System.out.println("4.\tPush*p\t|\tAgregar dato segun posicion");
            System.out.println("5.\tPush*v\t|\tAgregar dato segun valor");
            System.out.println("");
            System.out.println("6.\tPop\t|\tQuitar dato");
            System.out.println("7.\tPop*p\t|\tQuitar dato segun posicion");
            System.out.println("8.\tPop*v\t|\tQuitar dato segun valor");
            System.out.println("");
            System.out.println("9.\tMostrar\t|\tMostrar toda la pila");
            System.out.println("10.\tSalir");
            int opc = sc.nextInt();
            switch (opc) {
                case 1://crear la pila
                    Crear();
                    break;
                case 2://borrar la pila
                    if (n_Posiciones == 0) {
                        System.out.println("No existe pila para borrar");
                    } else {
                        Borrar();
                    }
                    break;
                case 3://Agregar dato
                    if (n_Posiciones == 0) {
                        System.out.println("No existe pila para Push");
                    } else {
                        push();
                    }
                    break;
                case 4://Agregar dato por posicion
                    if (n_Posiciones == 0) {
                        System.out.println("No existe pila para Push");
                    } else {
                        pushxposicion();
                    }
                    break;
                case 5://agregar dato por valor
                    if (n_Posiciones == 0) {
                        System.out.println("No existe pila para Push");
                    } else {
                        pushxvalor();
                    }
                    break;
                case 6://quitar dato
                    if (n_Posiciones == 0) {
                        System.out.println("No existe pila para Push");
                    } else {
                        pop();
                    }
                    break;
                case 7://quitar dato por posicion
                    if (n_Posiciones == 0) {
                        System.out.println("No existe pila para Push");
                    } else {
                        popxposicion();
                    }
                    break;
                case 8://quitar dato por valor
                    if (n_Posiciones == 0) {
                        System.out.println("No existe pila para Push");
                    } else {
                        popxvalor();
                    }
                    break;
                case 9://mostrar pila
                    if (n_Posiciones == 0) {
                        System.out.println("No existe pila para Mostrar");
                    } else {
                        DibujarPila();
                    }
                    break;
                case 10:
                    return;
            }
        }
    }

    public static void Crear() {
        System.out.println("Ingrese el numero de posiciones");
        n_Posiciones = sc.nextInt();
        pila = new int[n_Posiciones];
        pilaAUX = new int[n_Posiciones];
        n_Elementos = 0;
        System.out.println("Tamaño de pila creada: " + pila.length + "Posiciones");
    }

    public static void DibujarPila() {
        System.out.println("Pila:");
        if (Vacia()) {
            System.out.println("La pila está vacía.");
        } else {
            for (int i = n_Elementos - 1; i >= 0; i--) {
                System.out.println("| " + pila[i] + " |");
                System.out.println("-----");
            }
        }
    }

    public static void Borrar() {
        System.out.println("Borrando Pila...");
        pila = null;
        pilaAUX = null;
        System.out.println("Pila Borrada");

    }

    public static boolean Vacia() {
        if (n_Elementos == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean Llena() {
        if (n_Elementos == n_Posiciones) {
            return true;
        } else {
            return false;
        }
    }

    public static void push() {
        if (Llena()) {
            System.out.println("Pila llena");
        } else {
            System.out.println("Digite nuevo dato");
            int dato = sc.nextInt();
            pila[n_Elementos] = dato;
            n_Elementos++;
        }
    }

    public static void pushxposicion() {
        if (Llena()) {
            System.out.println("Pila llena");
        } else {
            System.out.println("Digite nuevo dato");
            int dato = sc.nextInt();
            System.out.println("Digite la posicion deseada");
            int posicion = sc.nextInt();

            if (posicion < 0 || posicion >= n_Posiciones) {
                System.out.println("Posición inválida");
            } else {
                for (int i = n_Elementos - 1; i >= posicion; i--) {
                    pilaAUX[i + 1] = pila[i];
                }
                pilaAUX[posicion] = dato;
                for (int i = 0; i <= n_Elementos; i++) {
                    pila[i] = pilaAUX[i];
                }
                n_Elementos++;
                System.out.println("Dato agregado en la posición " + posicion);
            }
        }
    }

    public static void pushxvalor() {
        if (Llena()) {
            System.out.println("Pila llena");
        } else {
            System.out.println("Digite el nuevo dato a agregar:");
            int nuevoDato = sc.nextInt();
            System.out.println("Digite el valor del dato existente que desea reemplazar:");
            int valorReemplazar = sc.nextInt();

            boolean encontrado = false;
            for (int i = 0; i < n_Elementos; i++) {
                if (pila[i] == valorReemplazar) {
                    pila[i] = nuevoDato;
                    encontrado = true;
                    break;
                }
            }

            if (encontrado) {
                System.out.println("Dato reemplazado correctamente.");
            } else {
                System.out.println("El valor especificado no se encontró en la pila.");
            }
        }
    }

    public static void pop() {
        if (Vacia()) {
            System.out.println("Pila Vacia");
        } else {
            System.out.println("Dato a sacar: " + pila[n_Elementos - 1]);
            n_Elementos--;
        }
    }

    public static void popxposicion() {
        if (Vacia()) {
            System.out.println("Pila Vacia");
        } else {
            System.out.println("Digite la posicion del elemento a borrar");
            int posicion = sc.nextInt();
            if (posicion < 0 || posicion >= n_Elementos) {
                System.out.println("Posición inválida");
            } else {
                System.out.println("Dato a sacar en la posición " + posicion + ": " + pila[posicion]);
                for (int i = posicion; i < n_Elementos - 1; i++) {
                    pila[i] = pila[i + 1];
                }
                n_Elementos--;
                System.out.println("Dato eliminado correctamente");
            }
        }
    }

    public static void popxvalor() {
        if (Vacia()) {
            System.out.println("Pila Vacia");
        } else {
            System.out.println("Digite el valor del dato que desea eliminar:");
            int valorEliminar = sc.nextInt();

            boolean encontrado = false;
            for (int i = 0; i < n_Elementos; i++) {
                if (pila[i] == valorEliminar) {
                    for (int j = i; j < n_Elementos - 1; j++) {
                        pila[j] = pila[j + 1];
                    }
                    n_Elementos--;
                    encontrado = true;
                    System.out.println("Dato eliminado correctamente.");
                    break;
                }
            }

            if (!encontrado) {
                System.out.println("El valor especificado no se encontró en la pila.");
            }
        }
    }

    public static void top() {
        if (Vacia()) {
            System.out.println("No hay dato a mostrar");
        } else {
            System.out.println("El ultimo dato es: " + pila[n_Elementos - 1]);
        }
    }
}
