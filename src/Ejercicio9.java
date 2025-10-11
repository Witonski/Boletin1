import java.util.Scanner;

public class Ejercicio9 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numPositivo; // Inicializamos la variable

        // --- PARTE 1: Bucle de Validación (Asegurar que sea positivo) ---
        // Este bucle 'do-while' se ejecuta AL MENOS UNA VEZ, y se repite mientras
        // el número sea menor o igual a cero (es decir, sea inválido).
        do {
            System.out.println("Introduce un número entero positivo: ");

            // Verificamos si la entrada es un número
            if (sc.hasNextInt()) {
                numPositivo = sc.nextInt();
                sc.nextLine(); // Limpiamos el buffer (¡muy importante!)

                // Si el número es INVÁLIDO, mostramos el error
                if (numPositivo <= 0) {
                    System.out.println("❌ ERROR: El número tiene que ser mayor que cero (positivo). Vuelve a intentar.");
                }
            } else {
                // Si la entrada NO es un número, mostramos error y limpiamos la línea
                System.out.println("❌ ERROR: Eso no es un número válido. Vuelve a intentar.");
                sc.nextLine(); // Consumimos la entrada incorrecta (ej: si puso "hola")
                numPositivo = 0; // Forzamos a que se repita el bucle
            }

        } while (numPositivo <= 0);
        // El bucle se repite si el número NO ha sido un entero positivo.

        // Ya que el número es válido, procedemos a calcular.
        int sumaDivisores = 0; // Cambiamos el nombre de 'suma' a 'sumaDivisores' para más claridad

        // --- PARTE 2: Bucle de Cálculo de Divisores ---
        // Recorremos desde i=1 hasta un número ANTES del numPositivo (i < numPositivo)
        for (int i = 1; i < numPositivo; i++){

            // Si el resto de la división es 0, 'i' es un divisor.
            if (numPositivo % i == 0){
                sumaDivisores = sumaDivisores + i; // Lo sumamos a nuestro total
            }
        }

        // --- PARTE 3: Mostrar el Resultado ---
        System.out.println("------------------------------------");
        if (sumaDivisores == numPositivo){
            System.out.println("✅ ¡FELICIDADES! El número " + numPositivo + " es PERFECTO.");
            System.out.println("La suma de sus divisores (" + sumaDivisores + ") es igual al número.");
        }else{
            System.out.println("❌ El número " + numPositivo + " NO es perfecto.");
            System.out.println("La suma de sus divisores es " + sumaDivisores + ".");
        }
    }
}