import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
       /*
      Realizar un programa que lea un número estrictamente positivo N
      y muestre la suma de los N primeros números.
      Diseña el programa de forma que si N es incorrecto vuelva a solicitarse.
      Ejemplo: Introduce un número positivo: 4
      La suma de los 4 primeros números es: 10
        */


        Scanner scanner = new Scanner(System.in);
        int n;
        int suma = 0;

        //Bucle de validación para asegurar que N sea positivo
        do{
            System.out.println("Introduce un número positivo: ");
            n = scanner.nextInt();

            if (n < 0){
                System.out.println("El númoro debe ser mayor que 0. Inténtelo de nuev ");
            }
        }while (n <0);

        //Bucle parea sumar los primeros N números.
        for (int i = 1; i <= n; i++){
            suma = suma +i;

            System.out.println("La suma de los " + n + " primeros números es: " + suma);
        }
    }
}