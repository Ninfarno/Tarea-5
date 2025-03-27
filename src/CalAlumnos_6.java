import java.util.Scanner;

public class CalAlumnos_6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] Alumnos = new double[3][];

        for (int i = 0; i < 3; i++) {
            int Materias;

            if (i == 0) {
                Materias = 3;
            } else if (i == 1) {
                Materias = 4;
            } else {
                Materias = 5;
            }

            Alumnos[i] = new double[Materias];

            System.out.print("Ingrese las " + Materias + " calificaciones del alumno " + (i + 1) + ": ");
            String DatosIn = scanner.nextLine();
            Transfomrador(DatosIn, Alumnos, i);
        }

        double[] Promedio = Prom(Alumnos);

        for (int i = 0; i < 3; i++) {
            System.out.print("Alumno " + (i + 1) + "\nCalificaciones: ");
            for (int j = 0; j < Alumnos[i].length; j++) {
                System.out.print(Alumnos[i][j] + " ");
            }
            System.out.printf("| Promedio: %.2f \n\n", Promedio[i]);
        }
    }

    public static double[] Prom(double[][] Alumno) {
        double Sumatoria = 0;
        double[] Promedio = new double[3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < Alumno[i].length; j++) {
                Sumatoria += Alumno[i][j];
            }
            Promedio[i] = Sumatoria / Alumno[i].length;
        }
        return Promedio;
    }

    public static void Transfomrador(String DatosIn, double[][] Alumnos, int k) {
        String[] Calificaciones = DatosIn.split(" ");
        for (int i = 0; i < Calificaciones.length; i++) {
            Alumnos[k][i] = Double.parseDouble(Calificaciones[i]);
        }
    }
}
