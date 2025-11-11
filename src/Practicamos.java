import java.util.Scanner;

/*
9. Realizar un programa que lea un número entero positivo y averigüe si es perfecto.
Un número es perfecto cuando es igual a la suma de sus divisores excepto él mismo.
Diseñar el programa de forma que si algún dato es incorrecto vuelva a  solicitarse.
Ejemplos: El número 6 es perfecto porque es igual que 1+2+3=6
El número 8 no es perfecto porque 1+2+4=7
 */
public  class Practicamos {
    public static void main(String[] args) {
      Scanner entrada = new Scanner(System.in);
      int numero;
      int suma = 0;

        System.out.println("Introduce un número entero positivo: ");
        numero = entrada.nextInt();

        while (numero < 0){
            System.out.println("Introduce un número entero positivo: ");
            numero = entrada.nextInt();
        }
        for(int i = 1; i < numero; i++){
            if(numero % i == 0){
                suma = suma + i;
            }
        }
        if(suma == numero){
            System.out.println("El número " + numero + " perfecto");
        }else {
            System.out.println("El número " + numero + " no es perfecto");
        }
    }
}