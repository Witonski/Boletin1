import java.util.Scanner;

public class Ejercicio10 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numero;
        // Inicializamos a 1 porque 0! = 1 y 1! = 1.
        long factorial = 1;

        // Bucle do-while para validar la entrada (Debe ser entero >= 0)
        do {
            System.out.print("Introduce un número entero positivo o cero (N ≥ 0): ");

            if (scanner.hasNextInt()) {
                numero = scanner.nextInt();

                // Informa del error si el número es negativo
                if (numero < 0) {
                    System.out.println("El número debe ser POSITIVO o CERO. Inténtalo de nuevo.");
                }
            } else {
                // Manejo de entrada no entera (ej: texto)
                System.out.println("Entrada no válida. Introduce un número entero.");
                scanner.next(); // Limpia el buffer de entrada incorrecta
                numero = -1; // Asignamos -1 para garantizar que el bucle se repita
            }
        } while (numero < 0);
        // El bucle se repite si el número sigue siendo negativo.


        // Cálculo del factorial (Iterativo con bucle for)
        // La inicialización factorial = 1 cubre los casos base 0! y 1!
        // El bucle solo necesita ejecutarse de 2 hasta el número N.
        for (int i = 2; i <= numero; i++) {
            // Usamos el operador de asignación compuesta *= (factorial = factorial * i)
            factorial *= i;
        }

        // Resultado final
        System.out.println("El Factorial de " + numero + " es: " + factorial);

    }
}