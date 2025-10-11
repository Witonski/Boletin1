import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numeros;

        do {
            System.out.println("Introduce la cantidad de números: ");
            numeros = scanner.nextInt();
        } while (numeros <= 0);

        for (int i = 0; i < numeros; i++) {
            System.out.println("Introduce el número " + (i + 1) + ":");
            int numero = scanner.nextInt();

            if (numero % 2 == 0 ){
                System.out.println("El número " + numero + " es par");
            }else{
                System.out.println("El número " + numero + " es impar");
            }
        }
    }
}