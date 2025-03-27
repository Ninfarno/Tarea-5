public class SumaMatr_5 {
    public static void main(String[] args) {
        int[][] A = {{8, -31}, {-6, 14}};
        int[][] B = {{41, 21}, {34, -5}};
        int[][] C = new int[2][2];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }

        System.out.println("Matriz A: ");
        Imprimir(A);
        System.out.println();
        System.out.println("Matriz B: ");
        Imprimir(B);
        System.out.println();
        System.out.println("Matriz C (Sumatoria): ");
        Imprimir(C);
    }

    public static void Imprimir(int[][] Matriz) {
        for (int i = 0; i < Matriz.length; i++) {
            for (int j = 0; j < Matriz[i].length; j++) {
                System.out.print(Matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}