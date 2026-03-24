import java.util.Scanner;

// Clase que representa un nodo del árbol
class Nodo {
    int valor;
    Nodo izquierdo, derecho;

    public Nodo(int item) {
        valor = item;
        izquierdo = derecho = null;
    }
}

// Clase principal que contiene la lógica del árbol
public class ArbolBinarioApp {
    Nodo raiz;

    // Constructor
    public ArbolBinarioApp() {
        raiz = null;
    }

    // 1. Método para insertar un número
    public void insertar(int valor) {
        raiz = insertarRecursivo(raiz, valor);
    }

    private Nodo insertarRecursivo(Nodo actual, int valor) {
        if (actual == null) {
            return new Nodo(valor);
        }
        if (valor < actual.valor) {
            actual.izquierdo = insertarRecursivo(actual.izquierdo, valor);
        } else if (valor > actual.valor) {
            actual.derecho = insertarRecursivo(actual.derecho, valor);
        }
        return actual;
    }

    // 2. Método para recorrido Inorden (Izquierda - Raíz - Derecha)
    public void recorridoInorden(Nodo nodo) {
        if (nodo != null) {
            recorridoInorden(nodo.izquierdo);
            System.out.print(nodo.valor + " ");
            recorridoInorden(nodo.derecho);
        }
    }

    // 3. Método para buscar un número
    public boolean buscar(int valor) {
        return buscarRecursivo(raiz, valor);
    }

    private boolean buscarRecursivo(Nodo actual, int valor) {
        if (actual == null) return false;
        if (actual.valor == valor) return true;

        return valor < actual.valor
            ? buscarRecursivo(actual.izquierdo, valor)
            : buscarRecursivo(actual.derecho, valor);
    }

    // MÉTODO MAIN PARA PRUEBAS EN CONSOLA
    public static void main(String[] args) {
        ArbolBinarioApp arbol = new ArbolBinarioApp();
        Scanner sc = new Scanner(System.in);
        int opcion, valor;

        System.out.println("--- SISTEMA DE ÁRBOL BINARIO ---");
        do {
            System.out.println("\n1. Insertar número\n2. Mostrar Inorden\n3. Buscar número\n4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el valor a insertar: ");
                    valor = sc.nextInt();
                    arbol.insertar(valor);
                    System.out.println("Insertado correctamente.");
                    break;
                case 2:
                    System.out.print("Recorrido Inorden: ");
                    arbol.recorridoInorden(arbol.raiz);
                    System.out.println();
                    break;
                case 3:
                    System.out.print("Ingrese valor a buscar: ");
                    valor = sc.nextInt();
                    if (arbol.buscar(valor)) {
                        System.out.println("¡Número encontrado en el árbol!");
                    } else {
                        System.out.println("El número no existe en el árbol.");
                    }
                    break;
            }
        } while (opcion != 4);
        sc.close();
    }
}eada.");
    }
}
