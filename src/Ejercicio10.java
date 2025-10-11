import java.util.Scanner;

public class Ejercicio10 {
    public static void main(String[] args) {
/*
Realizar un programa que solicite un número entero positivo o cero y calcule su factorial.
Diseñar el programa de forma que si algún dato es incorrecto vuelva a solicitarse.
Factorial (0)=1
Factorial (1)=1
Factorial (N)=N* (N-1)* (N-2)* …......1
 */
        Scanner sc = new Scanner(System.in);


        System.out.println("Introduce un número entero positivo o cero: ");
        int num = sc.nextInt();

        while (num < 0){
            System.out.println("Introduce un número entero positivo o cero: ");
            num = sc.nextInt();
        }
        int factorial = 1;

        for (int i = 1; i <= num; i++){
            factorial = factorial * i;

        }
        System.out.println("El factorial del número " + num + " es " + factorial);
    }
}