import java.util.Scanner;

public class ModificarArreglo_4 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] Arreglo = new int[10];
        String Linea;

        while (true) {
            System.out.print("Ingrese 10 numeros enteros: ");
            try {
                Linea = scanner.nextLine();
                break;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Error!! \nEl arreglo debe de ser igual o menor a 10");
            }
        }

        Transformador(Arreglo, Linea);

        for (int i = 0; i < (Arreglo.length / 2); i++) {
            System.out.println(Arreglo[i] + " y " + Arreglo[Arreglo.length - 1 - i] + " ");
        }
    }

    public static void Transformador(int[] Arreglo, String Linea) {
        String[] numeros = Linea.split(" "); //split es para realizar una separacion

        for (int i = 0; i < numeros.length; i++) {
            Arreglo[i] = Integer.parseInt(numeros[i]);
        }
    }
}