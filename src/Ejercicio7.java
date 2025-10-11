import java.util.Scanner;

public class Ejercicio7 {

    public static void main(String[] args) {
/*Realizar un programa que solicite una cantidad de números que van a
pedirse por teclado. Una vez que solicite todos ellos debe informar de cual
es la media de los números. Diseñar el programa de forma que si la
cantidad es incorrecta vuelva a solicitarse.*/
        Scanner scanner = new Scanner(System.in);

        System.out.println("Cuantos números desea introducir?: ");
        int numerosAIntroducir = scanner.nextInt();
        double suma = 0;
        double numero;

        while (numerosAIntroducir < 0) {
            System.out.println("Introduce un número positivo");
            numerosAIntroducir = scanner.nextInt();
        }
        for (int i =0 ; i < numerosAIntroducir; i++){
            System.out.printf("Introduce el numero %d: ", (i + 1));
            numero = scanner.nextDouble();
            suma += numero;
        }
        double media = suma / numerosAIntroducir;

        System.out.println("media = " + media);
    }
}