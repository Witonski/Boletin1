import java.util.Scanner;

public class BucleDo_while {
    public static void main(String[] args) {
/*Escribe un programa que solicite una contraseña válida
usando un bucle do-while*/

        Scanner sc = new Scanner(System.in);
        String password;
        int longitud;

        do {
            System.out.println("Introduce una contraseña válida (mínimo 8 caracteres): ");
            password = sc.nextLine();
            longitud = password.length();


        }while (longitud < 8);

        System.out.println("La contraseña es válida");

    }
}
