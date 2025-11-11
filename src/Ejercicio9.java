/*
9. Realizar un programa que lea un número entero positivo y averigüe si es perfecto.
Un número es perfecto cuando es igual a la suma de sus divisores excepto él mismo.
Diseñar el programa de forma que si algún dato es incorrecto vuelva a  solicitarse.
Ejemplos: El número 6 es perfecto porque es igual que 1+2+3=6
El número 8 no es perfecto porque 1+2+4=7
 */

import java.util.Scanner;

public class Ejercicio9 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numero;
        int suma = 0;

        System.out.println("Solicita un número entero positivo: ");
        numero = sc.nextInt();

        while (numero < 0){
            System.out.println("Solicita un número entero positivo: ");
            numero = sc.nextInt();
        }

        for (int i = 1; i < numero; i++){
            if (numero % i == 0){
                suma += i;
            }

        }
        if (suma == numero){
            System.out.println("El número " +numero+ " es perfecto ");
        }else {
            System.out.println("El número " + numero + " no es perfecto");
        }

    }
}