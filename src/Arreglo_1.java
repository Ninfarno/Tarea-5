import java.util.Scanner;

public class Arreglo_1 {
    //El arreglo es de variables diferentes
    static String[] arreglo = {"1", "1", "a", "4", "5", "6", "5", "8", "9", "c"};
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            int opcion;
            while (true) { //Para que no se tenga que estar iniciando cada codigo por separado
                System.out.print("\nOpciones: \n" +
                        "1. Eliminar Elemento. \n" +
                        "2. Inserta un elemento al inicio. \n" +
                        "3. Inserta un elemento al medio. \n" +
                        "4. Buscar. \n" +
                        "5. Buscar y Cambiar. \n" +
                        "6. Salir. \n" +
                        "Ingrese una opcion: ");
                try { //Me pasa muy seguido y me enfade de tener que esperar a que vuelva a correr
                    opcion = sc.nextInt();
                    System.out.println();
                    sc.nextLine();
                    break;
                } catch (NumberFormatException e) { //La excepcion es si no es un numero
                    System.out.println("Error!! \nSolo se aceptan enteros");
                }
            }
            switch (opcion) {
                case 1: //El caso donde se eliminara un numero del arreglo de manera aleatoria y se remplazara por un 0
                    String[] a = CambioN();
                    Imprimir();
                    System.out.print("Arreglo nuevo:");
                    for (int i = 0; i < arreglo.length; i++) {
                        System.out.printf(" " + a[i]);
                    }
                    System.out.println();
                    break;
                case 2: //El caso preguntara un nuevo caracter y lo agregar al inicio eliminando el utlimo
                    String[] b = Agregar();
                    Imprimir();
                    System.out.print("Arreglo nuevo:");
                    for (int i = 0; i < arreglo.length; i++) {
                        System.out.printf(" " + b[i]);
                    }
                    break;
                case 3: //Pregunta una nueva variable para ingresar y luego pregunta en que posicion
                    String[] c = Ingresar();
                    Imprimir();
                    System.out.print("Arreglo Nuevo:");
                    for (int i = 0; i < arreglo.length; i++) {
                        System.out.printf(" " + c[i]);
                    }
                    break;
                case 4: //Pregunta un caracter y si esta te indicara en que parte del arreglo esta
                    String[] d = Buscar();
                    if (!(d == null)) {
                        Imprimir();
                        System.out.print("Arreglo Nuevo: ");
                        for (int i = 0; i < arreglo.length; i++) {
                            System.out.printf(" " + d[i]);
                        }
                    }
                    break;
                case 5: //Preguntara una variable y si esta en el arreglo Preguntara con que remplazarla
                    String[] e = Reemplazar();
                    if (!(e == null)) {
                        Imprimir();
                        System.out.print("Arreglo Nuevo: ");
                        for (int i = 0; i < arreglo.length; i++) {
                            System.out.printf(" " + e[i]);
                        }
                    }
                    break;
                case 6:
                    sc.close();
                    return;
                default:
                    System.out.println("Error!! \nOpcion no valida");
            }
        }
    }

    public static void Imprimir() { //Imprime el arreglo original
        System.out.print("Arreglo original:");
        for (int i = 0; i < arreglo.length; i++) {
            System.out.printf(" " + arreglo[i]);
        }
        System.out.println();
    }

    public static String[] CambioN() { //Hace el cambio a 0 de una posicion aleatoria
        String[] arreglo1 = arreglo.clone();
        int n = (int) (Math.random() * 10) + 1;
        for (int i = 0; i < arreglo.length; i++) {
            if (n == i) {
                arreglo1[i] = "0";
            }
        }
        return arreglo1;
    }

    public static String[] Agregar() { //Ingresa una variable en la primera posicion
        String N;
        String[] arreglo2 = new String[arreglo.length + 1];
        System.out.print("Ingrese el nuevo valor n: ");
        arreglo2[0] = sc.nextLine();
        for (int i = 0; i < arreglo.length; i++) {
            arreglo2[i + 1] = arreglo[i];
        }
        return arreglo2;
    }

    public static String[] Ingresar() { //Ingresa una variable a eleguir en una posicion a eleguir
        String[] arreglo3 = new String[arreglo.length + 1];
        System.out.print("Ingrese el nuevo valor n: ");
        String n = sc.nextLine();
        int N = -1;
        while (true) {
            System.out.print("Ingrese la posicion: ");
            try {
                N = Integer.parseInt(sc.nextLine());
                if (N >= arreglo.length || N < 1) {
                    System.out.println("la posicion debe de ser entre 1 y 10");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error!! \nIngresa un numero");
            }
        }

        for (int i = 0; i < arreglo.length; i++) {
            if (i < N - 1) {
                arreglo3[i] = arreglo[i];
            } else if (i == N - 1) {
                arreglo3[i] = n;
            } else {
                arreglo3[i] = arreglo[i - 1];
            }
        }
        return arreglo3;
    }

    public static String[] Buscar() { //Pregunta una variable y si esta en el arreglo lo indicara
        int N = -1;
        String[] arreglo4 = arreglo.clone();

        System.out.print("Ingrese un valor a buscar: "); //El valor puede ser alfanumerico
        N = Integer.parseInt(sc.nextLine());


        String Objetivo = Integer.toString(N);

        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i].equals(Objetivo)) {
                System.out.println("El valor esta en el arreglo");
                for (int j = 0; j < arreglo.length; j++) {
                    //En caso de estar reeplazara los valores por * en caso de no ser objetivo//
                    if (!arreglo[j].equals(Objetivo)) {
                        arreglo4[j] = "*";
                    }
                }
                return arreglo4;
            }
            if (i == (arreglo.length - 1)) {
                System.out.println("EL valor no esta en el arreglo");
            }
        }
        return null;
    }

    public static String[] Reemplazar() {

        int N = -1;
        System.out.print("Ingrese un valor a buscar: "); //El valor puede ser alfanumerico
        N = Integer.parseInt(sc.nextLine());

        String Objetivo = Integer.toString(N);
        String[] arreglo5 = arreglo.clone();

        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i].equals(Objetivo)) {
                System.out.println("El valor esta en el arreglo");
                System.out.print("Ingrese un valor o caracter para reemplazar: "); //El valor puede ser alfanumerico
                arreglo5[i] = sc.nextLine();
                return arreglo5;
            }

        }
        System.out.println("EL valor no esta en el arreglo");
        return null;
    }
}