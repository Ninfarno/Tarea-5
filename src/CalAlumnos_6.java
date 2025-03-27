import java.util.Scanner;

public class CalAlumnos_6 {
    static boolean Romper = true;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] Alumnos = new double[3][];

        for (int i = 0; i < 3; i++) {
            int Materias;

            //Establece las materias de cada alumno en la vuelta correspondiente
            if (i == 0) {
                Materias = 3;
            } else if (i == 1) {
                Materias = 4;
            } else {
                Materias = 5;
            }

            Alumnos[i] = new double[Materias];

            while(true) {
                System.out.print("Ingrese las " + Materias + " calificaciones del alumno " + (i + 1) + ": ");
                String DatosIn = scanner.nextLine();
                if (Transfomrador(DatosIn, Alumnos, i)){//En caso de que todos sean validos rompera el bucle
                    break;
                }
            }
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

    //Calcula el promedio de los 3 alumnos
    public static double[] Prom(double[][] Alumno) {
        double[] Promedio = new double[3];

        for (int i = 0; i < 3; i++) {
            double Sumatoria = 0;
            for (int j = 0; j < Alumno[i].length; j++) {
                Sumatoria += Alumno[i][j];
            }
            Promedio[i] = Sumatoria / Alumno[i].length;
        }
        return Promedio;
    }

    //Transfomra el arreglo de String a un arreglo de int
    public static boolean Transfomrador(String DatosIn, double[][] Alumnos, int k) {
        String[] Calificaciones = DatosIn.split(" ");
        for (int i = 0; i < Calificaciones.length; i++) {
            try {
                Alumnos[k][i] = Double.parseDouble(Calificaciones[i]);
            } catch (NumberFormatException e) {
                System.out.println("Error: '" + Calificaciones[i] + "' no es un número válido. Intente nuevamente.");
                return false;
            }
        }
        return true;
    }
}