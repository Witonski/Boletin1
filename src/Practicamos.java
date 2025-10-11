import java.util.Scanner;

public class Practicamos {
    public static void main(String[] args) {

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