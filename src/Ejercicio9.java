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