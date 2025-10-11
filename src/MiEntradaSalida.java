import java.util.Scanner;

public class MiEntradaSalida {
    private static Scanner sc = new Scanner(System.in);

    /** ES PARA EVITAR UTILIZAR SCANNER
     * Leer un entero mostrando el mensjae pasado como parámetro
     * @param mensaje El mensqje a mostrar
     * @return el entero leido por teclado
     */


    public static int leerEntero(String mensaje) {
        System.out.println("Introduce un número: ");
        return sc.nextInt();


    }

    public static void main(String[] args) {
        int a = MiEntradaSalida.leerEntero("Introduce un número");
        System.out.printf("El número introducido es %d" , a);
    }

    public static int leerEnterPositivo(String mensaje) {
        System.out.println(mensaje);
        int a = sc.nextInt();
        while (a<=0){
            System.out.println("El número tiene que ser positivo");
            a = sc.nextInt();

        }

return a;
    }
}
