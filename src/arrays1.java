public class arrays1 {
    public static void main(String[] args) {

        int[] x = {1,2,3,4,7,8};

        int suma = 0;


        for (int i = 0; i < x.length; i = i + 2) {

            suma = suma + x[i];

        }

        System.out.println("La suma de las posiciones pares es: " + suma);

    }
}
