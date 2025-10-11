import java.util.Scanner;

public class Ejercicio8 {

    public static void main(String[] args) {

/*
Realizar un programa que solicite un conjunto de números. Después de introducir
cada número se realizará la pregunta: "¿Desea introducir más números (S/N)".
Si la respuesta es 'S' se solicitará otro número. Cuando no desee introducir más números
debe informar cual es el menor de los números introducidos.
NOTA: Debe comprobarse que la respuesta es 'S' o 'N' y si no lo es, volver a pedirla.
 */


                Scanner sc = new Scanner(System.in);
                int numero;
                int numMenor = Integer.MAX_VALUE;
                String continuar;

                do {
                    System.out.println("Introduce un número: ");
                    numero = sc.nextInt();

                    if (numero < numMenor) {
                        numMenor = numero;
                    }

                    sc.nextLine();

                    do {
                        System.out.println("Desea introducir más números (S/N)?");
                        continuar = sc.nextLine();

                        if (!continuar.equals("S") && !continuar.equals("N")) {
                            System.out.println("Introduce 'S' o 'N'");
                        }

                    } while (!continuar.equals("S") && !continuar.equals("N"));



                } while (continuar.equals("S"));

                System.out.println("El número menor introducido es " + numMenor);
            }
        }