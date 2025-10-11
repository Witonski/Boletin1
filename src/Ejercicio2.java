import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {

/* 2. Realizar un programa que lea un número entero entre 0 y 10
y visualice su tabla de multiplicar. Por ejemplo si el numero es 7
debe aparecer Tabla del 7 7*0=0 7*1=7 ….. 7*10=70*/

        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce un numero: ");
        int numero = scanner.nextInt();

        if (numero >=0 && numero <=10){
            System.out.println("Tabla del " + numero);

            for (int i = 0; i <= 10; i++) {
                System.out.println(numero + " * " + i + " = " + (numero * i));

            }

        }else {
            System.out.println("El número debe estar entre 0 y 10");
        }
    }
}
