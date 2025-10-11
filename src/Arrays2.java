public class Arrays2 {
    public static void main(String[] args) {

        int[] listadoNum = { 4, -7, -10, 0, -5, 1 };

        int contNeg = 0;

        System.out.println("Revisando la lista de números...");

        for (int i = 0; i < listadoNum.length; i++) {

            int numero = listadoNum[i];

            if (numero < 0) {

                System.out.println("Número negativo es: " + numero);

                contNeg = contNeg + 1;
            }
        }


        System.out.println("La cantidad total de números negativos es: " + contNeg);
    }
}