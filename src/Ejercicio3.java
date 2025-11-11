import java.util.Scanner;

/*3. Realizar un programa que solicite una cantidad de números que van a introducirse por teclado.
Después, para cada uno de ellos que indique si el número es par o impar.
Si la cantidad de números introducida es 0 o negativa volverá a solicitarse el dato.
*/
public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int cantNum;
        int numero;

        do{
            System.out.println("Introduce la cantidad de números: ");
            cantNum = entrada.nextInt();
            if(cantNum <= 0){
                System.out.println("La cantidad introducida no es válida");
            }
        }while (cantNum <= 0);

        for(int i = 0; i < cantNum; i++){
            System.out.println("\nIntroduce el número " + (i+1));
            numero = entrada.nextInt();

            if(numero % 2 == 0){
                System.out.println("El número " + numero + " es par");
            }else {
                System.out.println("El número " + numero + " es impar");
            }
        }

    }
}