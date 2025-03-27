import java.util.Scanner;

public class Histograma_7 {
    static int[] Arreglo = new int[12];
    static int[] Recuerrencias = new int[6];
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Preguntar();
        /*Pregunta o solicita que el usuario ingrese 12 valores ya sean digitos o caracteres pero su ingresa menos de 12
          o mas, este no lo aceptara, inclusive que pueda leer caracteres no quiere decir que los aceptara, tampoco
          aceptara numeros decimales*/

        Evaluar();
        /*Solo verifica las recurrencias de cada digito desde el 1 al 6*/

        Imprimir();
        /*Imprimira las recurrencias de cada digito*/

        /*Nota: Me dio flojera documentar el resto del codigo  .-. */
    }

    public static void Preguntar() {
        while (true) {
            System.out.println("Ingrese 12 numeros enteros de 1-6: ");
            System.out.println(String.format("%23s", "|"));
            String arreglo = sc.nextLine();
            String[] VerificarNum = arreglo.split(" ");

            if (VerificarNum.length == 12) {
                Boolean Valido = true;
                for (int i = 0; i < VerificarNum.length; i++) {
                    try {
                        int Numv = Integer.parseInt(VerificarNum[i]);
                        if (Numv < 1 || Numv > 6) {
                            System.out.println(Numv + " Esta fuera del rango permitido");
                            Valido = false;
                            break;
                        } else {
                            Arreglo[i] = Numv;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println(VerificarNum[i] + " No esta permitido");
                        Valido = false;
                        break;
                    }
                }
                if (Valido) {
                    break;
                }
            } else {
                System.out.println("Debe ingresar exactamente 12 numeros");
            }
        }
    }

    public static void Evaluar() {
        for (int i = 0; i < Arreglo.length; i++) {
            Recuerrencias[Arreglo[i] - 1]++; //Investigando me encontre con esta logica que resulta practica
        }
    }

    public static void Imprimir() {
        System.out.println("Histograma de recurrencias: ");
        for (int i = 0; i < Recuerrencias.length; i++) {
            System.out.print((i + 1) + ": ");
            for (int j = 0; j < Recuerrencias[i]; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

}