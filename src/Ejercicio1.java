public class Ejercicio1 {
    public static void main(String[] args) {
        /*1. Realizar un programa que muestre por pantalla todos los números
        comprendidos entre 1 y 100 que son múltiplos de 7 o de 13.
        Debe mostrar un mensaje indicando si el número es múltiplo de 7 o de 13.
        Si el número es múltiplo de 7 y de 13 a la vez, deben aparecer dos mensajes. */

        for (int i=1; i<=100; i++){
            if (i % 7 == 0){
                System.out.println("El número " + i + " es múltiplo de 7");
            }
            if (i % 13 == 0){
                System.out.println("El número " + i + " es múltiplo de 13");
            }
        }
    }
}
