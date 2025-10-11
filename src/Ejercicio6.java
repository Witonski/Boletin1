import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {
/*6. Realizar un programa que lea dos números enteros cualesquiera
numeroA y numeroB, y calcule el producto los números   mediante sumas,
es decir, sin usar el operador
 */
        Scanner scanner = new Scanner(System.in);
        int producto = 0;

        System.out.println("Introduce el primer número A: ");
        int numeroA = scanner.nextInt();

        System.out.println("Introduce el segundo número B: ");
        int numeroB = scanner.nextInt();



        for (int i = 0; i < Math.abs(numeroB); i++) {
            producto += numeroA;
            }

            if (numeroB < 0) {
                producto = - producto;
            }
        System.out.println("El producto de " + numeroA + " y " + numeroB + " es: " + producto);

    }
}
