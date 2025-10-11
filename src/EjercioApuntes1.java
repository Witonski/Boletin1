import java.util.Scanner;

public class EjercioApuntes1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce un numero para ver sus divisores");
        int num = scanner.nextInt();

        int comprobar = 2;

        while (comprobar <= num / 2 && num % comprobar != 0){
            comprobar++;
        }
        if (num % comprobar ==0){
            System.out.println("El primer divisor de " + num + " es " + comprobar);
        }else{
            System.out.printf("El numero %d es primo", num);
        }
    }
}
/* import java.util.Scanner;

public class Practicar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce un número para ver su divisor: ");
        int numero = scanner.nextInt();

        int comprobar = 2;

        while (numero % comprobar !=0){
            comprobar++;
        }
        System.out.println("El primer divisor de: " + numero + " es " + comprobar);

    }
}

 */