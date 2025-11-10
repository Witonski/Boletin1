public class BucleFor2 {
    public static void main(String[] args) {
    /*calcular la suma de todos los números impares positivos
    comenzando en 1 y terminando en 99.*/

        int suma = 0;

        for (int i = 1; i < 100; i = i + 2){
            suma += i;

        }

        System.out.println("La suma de los números impares del 1 al 99 es: " + suma);

    }
}


