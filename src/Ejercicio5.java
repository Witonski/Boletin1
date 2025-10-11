import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
/*
5. Realizar un programa que solicite números hasta que se introduzca un número negativo.
Cuando termine informará de cuantos números positivos se han introducido.
En este programa el número 0 se considera positivo.
Ejemplo: Introduce un número (negativo para terminar): 4
Introduce un número (negativo para terminar): 8
Introduce un número (negativo para terminar): -2
Has introducido 2 números positivos
 */
        Scanner scanner = new Scanner(System.in);
        int numero;
        int contadorNumeros = 0;

        do {
            System.out.println("Introduce un número positivo (número negativo para finalizar): ");
            numero = scanner.nextInt();

            if (numero >= 0){
                contadorNumeros++; //contadorNumeros = contadorNumeros + 1
            }
        }while(numero >=0);

        System.out.println("Has introducido " + (contadorNumeros -1)+ " números positivos");

    }
}
