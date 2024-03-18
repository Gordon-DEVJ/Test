package estructuradatos;

import static estructuradatos.EstructuraDatos.sc;

/**
 *
 * @author Carlos-Zarate
 */
public class ColaLogica {

    static int dato;
    static int n_Posiciones;
    static int n_Elementos;
    static int primero = 0;
    static int cola[];
    static int colaAUX[];

    public void MenuCola() {
        while (true) {
            System.out.println("\tCOLAS");
            System.out.println("\tMenu de Opciones");
            System.out.println("");
            System.out.println("1.\tCrear\t|\tCrear una cola");
            System.out.println("2.\tBorrar\t|\tBorrar cola creada");
            System.out.println("");
            System.out.println("3.\tQueue\t|\tAgregar dato");
            System.out.println("4.\tQueue*p\t|\tAgregar dato segun posicion");
            System.out.println("5.\tQueue*v\t|\tAgregar dato segun valor");
            System.out.println("");
            System.out.println("6.\tDequeue\t|\tQuitar dato");
            System.out.println("7.\tDequeue*p\t|\tQuitar dato segun posicion");
            System.out.println("8.\tDequeue*v\t|\tQuitar dato segun valor");
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
                        System.out.println("No existe cola para Queue");
                    } else {
                        queue();
                    }
                    break;
                case 4://Agregar dato por posicion
                    if (n_Posiciones == 0) {
                        System.out.println("No existe cola para Queue");
                    } else {
                        queuexposicion();
                    }
                    break;
                case 5://agregar dato por valor
                    if (n_Posiciones == 0) {
                        System.out.println("No existe cola para Queue");
                    } else {
                        queuexvalor();
                    }
                    break;
                case 6://quitar dato
                    if (n_Posiciones == 0) {
                        System.out.println("No existe pila para Push");
                    } else {
                        dequeue();
                    }
                    break;
                case 7://quitar dato por posicion
                    if (n_Posiciones == 0) {
                        System.out.println("No existe cola para Dequeue");
                    } else {
                        dequeuexposicion();
                    }
                    break;
                case 8://quitar dato por valor
                    if (n_Posiciones == 0) {
                        System.out.println("No existe cola para Dequeue");
                    } else {
                        dequeuexvalor();
                    }
                    break;
                case 9://mostrar pila
                    if (n_Posiciones == 0) {
                        System.out.println("No existe pila para Mostrar");
                    } else {
                        DibujarCola();
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
        cola = new int[n_Posiciones];
        n_Elementos = 0;
        System.out.println("Tamaño de pila creada: " + cola.length + " Posiciones");
    }

    public static void DibujarCola() {
        System.out.println("Cola:");
        if (Vacia()) {
            System.out.println("La cola está vacía.");
        } else {
            for (int i = primero; i < n_Elementos; i++) {
                System.out.println("| " + cola[i] + " |");
                System.out.println("-----");
            }
        }
    }

    public static void Borrar() {
        System.out.println("Borrando Pila...");
        cola = null;
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

    public static void queue() {
        if (Llena()) {
            System.out.println("Cola llena");
        } else {
            System.out.println("Digite nuevo dato");
            int dato = sc.nextInt();
            cola[n_Elementos] = dato;
            n_Elementos++;
        }
    }

    public static void queuexposicion() {
        if (Llena()) {
            System.out.println("Cola llena");
        } else {
            System.out.println("Digite nuevo dato");
            int dato = sc.nextInt();
            System.out.println("Digite la posición deseada");
            int posicion = sc.nextInt();

            if (posicion < 0 || posicion >= n_Posiciones) {
                System.out.println("Posición inválida");
            } else {
                for (int i = n_Elementos - 1; i >= posicion; i--) {
                    cola[i + 1] = cola[i];
                }
                cola[posicion] = dato;
                n_Elementos++;
                System.out.println("Dato agregado en la posición " + posicion);
            }
        }
    }

    public static void queuexvalor() {
        if (Llena()) {
            System.out.println("Cola llena");
        } else {
            System.out.println("Digite el nuevo dato a agregar:");
            int nuevoDato = sc.nextInt();
            System.out.println("Digite el valor del dato existente que desea reemplazar:");
            int valorReemplazar = sc.nextInt();

            boolean encontrado = false;
            for (int i = 0; i < n_Elementos; i++) {
                if (cola[i] == valorReemplazar) {
                    cola[i] = nuevoDato;
                    encontrado = true;
                    break;
                }
            }

            if (encontrado) {
                System.out.println("Dato reemplazado correctamente.");
            } else {
                System.out.println("El valor especificado no se encontró en la cola.");
            }
        }
    }

    public static void dequeue() {
        if (Vacia()) {
            System.out.println("Cola Vacia");
        } else {
            if (n_Elementos == 1) {
                primero = 0;
            }
            System.out.println("Dato a sacar: " + cola[primero]);
            for (int i = 0; i < n_Elementos - 1; i++) {
                cola[i] = cola[i + 1];
            }
            n_Elementos--;
        }
    }

    public static void dequeuexposicion() {
        if (Vacia()) {
            System.out.println("Cola vacía");
        } else {
            System.out.println("Digite la posición del elemento a quitar:");
            int posicion = sc.nextInt();

            if (posicion < 0 || posicion >= n_Elementos) {
                System.out.println("Posición inválida");
            } else {
                System.out.println("Dato a sacar en la posición " + posicion + ": " + cola[posicion]);
                for (int i = posicion; i < n_Elementos - 1; i++) {
                    cola[i] = cola[i + 1];
                }
                n_Elementos--;
                System.out.println("Dato eliminado correctamente");
            }
        }
    }

    public static void dequeuexvalor() {
        if (Vacia()) {
            System.out.println("Cola vacía");
        } else {
            System.out.println("Digite el valor del dato que desea eliminar:");
            int valorEliminar = sc.nextInt();

            boolean encontrado = false;
            for (int i = 0; i < n_Elementos; i++) {
                if (cola[i] == valorEliminar) {
                    for (int j = i; j < n_Elementos - 1; j++) {
                        cola[j] = cola[j + 1];
                    }
                    n_Elementos--;
                    encontrado = true;
                    System.out.println("Dato eliminado correctamente.");
                    break;
                }
            }

            if (!encontrado) {
                System.out.println("El valor especificado no se encontró en la cola.");
            }
        }
    }

    public static void inicio() {
        if (Vacia()) {
            System.out.println("No hay dato a mostrar");
        } else {
            System.out.println("El ultimo dato es: " + cola[primero]);
        }
    }
}
