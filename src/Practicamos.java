import java.util.Scanner;

/**
 * Clase principal del juego "Tu Propia Aventura".
 * Contiene la lógica del juego, el mapa y los comandos.
 */
public class Practicamos {

    // --- NÚCLEO: Definición de Datos ---

    private static String descripcionJuego = "Te has enterado de que el interior de un castillo que está por tu zona se encuentra un tesoro, y nadie sabe lo que contiene.\n" +
            "Decidiste ir a buscarlo, pero cuando conseguiste entrar todas las puertas y ventanas se cerraron, quedando atrapado.";

    // El mapa de habitaciones.
    private static String[] habitaciones = {
            "Estás en un salón grande. Todo está muy oscuro, pero ves lo suficiente para percatarte de que hay una lámpara de aceite. La enciendes y ves una escalera DERECHA.",  // Posición 0
            "Ahora te encuentras en una habitación con mucha humedad. Escuchas un sonido extraño que proviene de una habitación que está a tu IZQUIERDA.", // Posición 1
            "Resulta que el ruido venía de un armario antiguo con mucha profundidad. Dentro hay una llave.", // Posición 2
    };

    // Los objetos que hay en cada habitación.
    private static String[][] objetosMapa = {
            {"lámpara de aceite", null},   // Objetos en Habitación 0
            {"linterna", null},            // Objetos en Habitación 1
            {"llave", null},               // Objetos en Habitación 2
    };

    // El inventario del jugador. Tamaño fijo.
    private static String[] inventario = new String[5];

    // Variable que guarda la posición actual del jugador
    private static int habitacionActual = 0; // Empezamos en la primera habitación

    // --- FIN DE LA DEFINICIÓN DE DATOS ---


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean jugando = true;

        // Intro
        System.out.println("¡Bienvenido a 'TU PROPIA AVENTURA'!");
        System.out.println("------------------------------------------");

        // Descripción general del juego
        System.out.println(descripcionJuego);

        // Descripción de la primera habitación
        System.out.println("\n" + habitaciones[habitacionActual]);

        // Bucle principal (game loop)
        while (jugando) {
            // Leer el comando del usuario
            System.out.print("\n> ");
            String comando = scanner.nextLine().trim();
            if (comando.isEmpty()) continue;

            // Convertimos a minúsculas para comparar
            String comandoMinuscula = comando.toLowerCase();

            // Parser de comandos
            if (comandoMinuscula.equals("ayuda")) {
                mostrarAyuda();
            } else if (comandoMinuscula.equals("mirar")) {
                mirar();
            } else if (comandoMinuscula.equals("inventario")) {
                mostrarInventario();
            } else if (comandoMinuscula.equals("salir")) {
                jugando = false;
            } else if (comandoMinuscula.startsWith("ir ")) {
                String[] partes = comandoMinuscula.split("\\s+", 2);
                if (partes.length < 2) {
                    System.out.println("¿Hacia dónde? Usa: 'ir izquierda' o 'ir derecha'.");
                } else if (partes[1].equals("izquierda")) {
                    irIzquierda();
                } else if (partes[1].equals("derecha")) {
                    irDerecha();
                } else {
                    System.out.println("Dirección no válida. Usa: 'ir izquierda' o 'ir derecha'.");
                }
            } else if (comandoMinuscula.startsWith("coger ")) {
                String[] partes = comando.split("\\s+", 2); // mantenemos mayúsculas si las hubiera
                if (partes.length < 2 || partes[1].isBlank()) {
                    System.out.println("¿Qué quieres coger? Ej.: 'coger llave'");
                } else {
                    coger(partes[1].trim());
                }
            } else {
                System.out.println("No te entiendo. Escribe 'ayuda' para ver los comandos.");
            }
        }

        System.out.println("¡Gracias por jugar!");
        scanner.close();
    }

    // ======= Comandos =======
    private static void mostrarAyuda() {
        System.out.println("\nCOMANDOS DISPONIBLES:");
        System.out.println("  ayuda                -> Muestra este listado");
        System.out.println("  mirar                -> Describe la sala y sus objetos");
        System.out.println("  inventario           -> Muestra lo que llevas encima");
        System.out.println("  ir izquierda/derecha -> Te mueves por el mapa");
        System.out.println("  coger [objeto]       -> Coge un objeto de la sala si existe");
        System.out.println("  salir                -> Termina el juego");
    }

    private static void mirar() {
        System.out.println("\nEstás en: Habitación " + habitacionActual);
        System.out.println(habitaciones[habitacionActual]);
        String objetos = listarObjetosSala(habitacionActual);
        if (objetos.isEmpty()) {
            System.out.println("Objetos a la vista: (ninguno)");
        } else {
            System.out.println("Objetos a la vista: " + objetos);
        }
    }

    private static void irIzquierda() {
        if (habitacionActual == 0) {
            System.out.println("No hay nada a la izquierda. (Estás en el extremo del mapa)");
            return;
        }
        habitacionActual--;
        System.out.println("Te mueves a la izquierda…");
        mirar();
    }

    private static void irDerecha() {
        if (habitacionActual == habitaciones.length - 1) {
            System.out.println("No hay nada a la derecha. (Estás en el extremo del mapa)");
            return;
        }
        habitacionActual++;
        System.out.println("Te mueves a la derecha…");
        mirar();
    }

    private static void coger(String nombreObjeto) {
        int pos = buscarObjetoEnSala(habitacionActual, nombreObjeto);
        if (pos == -1) {
            System.out.println("No veo '" + nombreObjeto + "' aquí.");
            return;
        }
        int hueco = primerHuecoInventario();
        if (hueco == -1) {
            System.out.println("Tu inventario está lleno.");
            return;
        }
        inventario[hueco] = objetosMapa[habitacionActual][pos];
        objetosMapa[habitacionActual][pos] = null; // retiramos del suelo
        System.out.println("Has cogido '" + inventario[hueco] + "'.");
    }

    private static void mostrarInventario() {
        System.out.println("\nInventario:");
        boolean vacio = true;
        for (String item : inventario) {
            if (item != null) {
                System.out.println("  - " + item);
                vacio = false;
            }
        }
        if (vacio) System.out.println("  (vacío)");
    }

    // ======= Utilidades =======
    private static String listarObjetosSala(int idxSala) {
        StringBuilder sb = new StringBuilder();
        for (String obj : objetosMapa[idxSala]) {
            if (obj != null) {
                if (sb.length() > 0) sb.append(", ");
                sb.append(obj);
            }
        }
        return sb.toString();
    }

    private static int buscarObjetoEnSala(int idxSala, String nombre) {
        String nombreLower = nombre.toLowerCase();
        for (int i = 0; i < objetosMapa[idxSala].length; i++) {
            String obj = objetosMapa[idxSala][i];
            if (obj != null && obj.toLowerCase().equals(nombreLower)) return i;
        }
        return -1;
    }

    private static int primerHuecoInventario() {
        for (int i = 0; i < inventario.length; i++) {
            if (inventario[i] == null) return i;
        }
        return -1;
    }
}