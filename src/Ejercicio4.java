import java.util.Scanner;

/*
      Realizar un programa que lea un número estrictamente positivo N
      y muestre la suma de los N primeros números.
      Diseña el programa de forma que si N es incorrecto vuelva a solicitarse.
      Ejemplo: Introduce un número positivo: 4
      La suma de los 4 primeros números es: 10
        */
public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int numN;
        int suma = 0;

        do{
            System.out.println("Introduce un número positivo:");
            numN = entrada.nextByte();

            if(numN <= 0){
                System.out.println("El número introducido no es válido: ");
            }
        }while (numN <= 0);

        for (int i = 1; i <= numN; i= i+1){
            suma = suma + i;
        }
        System.out.println("La suma de los " + numN + " primeros números es " + suma);

    }
}