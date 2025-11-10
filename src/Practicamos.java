/* 2. Realizar un programa que lea un número entero entre 0 y 10
y visualice su tabla de multiplicar. Por ejemplo si el numero es 7
debe aparecer Tabla del 7 7*0=0 7*1=7 ….. 7*10=70*/

import java.util.Scanner;

public class Practicamos {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int numEnt;

        do{
            System.out.println("\nIntroduce un número entero del O al 10:");
            numEnt = entrada.nextInt();

            if(numEnt >= 0 && numEnt <= 10){
                System.out.println("\n Tabla del " + numEnt);
            }else {
                System.out.println("El número introducido no es válido ");
            }
        }while (numEnt <0 || numEnt > 10);

        for(int i = 0; i <= 10; i++){
            System.out.println(numEnt + " * " + i + " = " + (numEnt * i));
        }
    }
}