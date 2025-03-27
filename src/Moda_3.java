public class Moda_3 {
    public static void main(String[] args) {
        int[] Arreglo = {1, 32, 23, 1, 1, 2, 1, 1, 2, 12};
        int MaxConteo = Arreglo[0];
        int MaxCont = 0;

        for (int i = 0; i < Arreglo.length; i++) {
            int Contador = 0; //Contador de repeticiones

            for (int j = 0; j < Arreglo.length; j++) {
                if (Arreglo[i] == Arreglo[j]) { //Si el numero es igual el Contador aumentara
                    Contador++;
                }
            }
            if (Contador > MaxCont) {
                MaxCont = Contador; //Actualiza el MaxContador en caso de que este sea mayor
                MaxConteo = Arreglo[i]; //Se actualiza en numero mas frecuente
            }
        }

        System.out.println("Numero mas frecuente: " + MaxConteo);
        System.out.println("Aparece " + MaxCont + " veces");
    }
}