package aventura.app;

import java.util.Scanner;

/**
 * Clase principal del juego "Tu Propia Aventura".
 * Esqueleto para la Misión 1 (UD1-UD3).
 * VUESTRO TRABAJO es rellenar todos los TODO
 */
public class Practicamos2 {

    // --- NÚCLEO: Definición de Datos (FASE 1) ---
    // Esta parte os la damos HECHA. Es el "contrato" del núcleo.

    private static String descripcionJuego = "Te has enterado de que el interior de un castillo que está por tu zona se encuentra un tesoro, y nadie sabe lo que contiene.\n" +
            " Decidiste ir a buscarlo, pero cuando consiguiste entrar todas las puertas y ventanas se cerraron, quedando atrapado.";
    // El mapa de habitaciones.
    // TODO: (Skin) ¡Rellenad esto con vuestras descripciones!
    private static String[] habitaciones = {
            "Estás en un salón grande. Todo está muy oscuro, pero ves lo suficiente para percatarte de que hay una lampara de aceite. La enciendes y ves una escalera DERECHA.",  // Posición 0
            "Ahora te encuentras en una habitación con mucha humedad. Escuchas un sonido estraño que proviene de una habitación que está a tu IZQUIERDA.", // Posición 1
            "Resulta que el ruido venía de un armario antigüo con mucha profundidad. Dentro hay una llave.", // Posición 2
            // Borra las habitaciones y escribe las tuyas
    };

    // Los objetos que hay en cada habitación.
    // TODO: (Skin) Rellenad esto con vuestros objetos
    private static String[][] objetosMapa = {
            {"lamparaDeAceite", null},           // Objetos en Habitación 0
            {null, null},           // Objetos en Habitación 1
            {"llave", null},      // Objetos en Habitación 2
    };

    // El inventario del jugador. Tamaño fijo.
    private static String[] inventario = new String[5];

    // Variable que guarda la posición actual del jugador
    private static int habitacionActual = 0; // Empezamos en la primera habitación

    // --- FIN DE LA DEFINICIÓN DE DATOS ---


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean jugando = true;

        System.out.println("¡Bienvenido a 'TU PROPIA AVENTURA'!");
        System.out.println("------------------------------------------");

        // TODO 1a: Muestra la descripción general del juego
        System.out.println(descripcionJuego);


        // TODO 1b: Muestra la descripción de la primera habitación
        // Pista: System.out.println(habitaciones[...]);
        System.out.println(habitaciones[0]); // Usamos habitacionActual

        // TODO 2: Iniciar el bucle principal del juego (game loop)
        while (jugando) {

            // TODO 3: Leer el comando del usuario por teclado
            System.out.print("\n> ");
            String comando = scanner.nextLine().toLowerCase().trim(); // Leer y normalizar

            /*
            TODO 4: Crear un 'switch' o una estructura 'if-else if'
              para procesar el 'comando' del usuario.
              Debe gestionar como mínimo: "ayuda", "mirar", "inventario",
              "ir derecha", "ir izquierda", "coger [objeto]" y "salir".
            */

            // Usamos un 'if-else if' para manejar comandos con o sin argumentos
            if (comando.equals("ayuda")) {
                mostrarAyuda();
            } else if (comando.equals("mirar")) {
                mostrarInfoHabitacion();
            } else if (comando.equals("inventario")) {
                mostrarInventario();
            } else if (comando.equals("ir derecha")) {
                mover(1); // Mover a la derecha (+1 en el array)
            } else if (comando.equals("ir izquierda")) {
                mover(-1); // Mover a la izquierda (-1 en el array)
            } else if (comando.startsWith("coger ")) {
                procesarComandoCoger(comando.substring(6).trim());
            } else if (comando.equals("salir")) {
                jugando = false;
            } else {
                System.out.println("Comando no reconocido. Escribe 'ayuda' para ver los comandos disponibles.");
            }
        }

        System.out.println("¡Gracias por jugar!");
        scanner.close();
    }

    // ------------------------------------------------------------------
    // Métodos para procesar comandos y lógica del juego (Opcional - Buenas Prácticas)
    // ------------------------------------------------------------------

    /**
     * Muestra la descripción actual de la habitación y los objetos visibles.
     */
    private static void mostrarInfoHabitacion() {
        System.out.println("\n" + habitaciones[habitacionActual]);

        System.out.print("Objetos visibles: ");
        boolean hayObjetos = false;
        for (String objeto : objetosMapa[habitacionActual]) {
            if (objeto != null) {
                System.out.print(objeto + " ");
                hayObjetos = true;
            }
        }
        if (!hayObjetos) {
            System.out.print("Ninguno.");
        }
        System.out.println();
    }

    /**
     * Intenta mover al jugador a una nueva habitación.
     * @param direccion +1 para derecha, -1 para izquierda.
     */
    private static void mover(int direccion) {
        int nuevaPosicion = habitacionActual + direccion;

        if (nuevaPosicion >= 0 && nuevaPosicion < habitaciones.length) {
            habitacionActual = nuevaPosicion;
            System.out.println("Te mueves a la siguiente zona.");
            mostrarInfoHabitacion(); // Muestra la info de la nueva habitación
        } else {
            System.out.println("No puedes ir en esa dirección. Hay un muro o no hay salida.");
        }
    }

    /**
     * Procesa el comando "coger [objeto]".
     * @param nombreObjeto El nombre del objeto a intentar coger.
     */
    private static void procesarComandoCoger(String nombreObjeto) {
        if (nombreObjeto.isEmpty()) {
            System.out.println("Debes especificar qué objeto quieres coger (Ej: coger llave).");
            return;
        }

        // 1. Buscar el objeto en la habitación actual
        int indiceObjetoEnMapa = -1;
        for (int i = 0; i < objetosMapa[habitacionActual].length; i++) {
            if (nombreObjeto.equals(objetosMapa[habitacionActual][i])) {
                indiceObjetoEnMapa = i;
                break;
            }
        }

        if (indiceObjetoEnMapa != -1) {
            // 2. Intentar añadir al inventario
            boolean añadido = false;
            for (int i = 0; i < inventario.length; i++) {
                if (inventario[i] == null) {
                    inventario[i] = nombreObjeto;
                    objetosMapa[habitacionActual][indiceObjetoEnMapa] = null; // Quitar de la habitación
                    System.out.println("Has cogido **" + nombreObjeto + "** y lo has guardado en tu inventario.");
                    añadido = true;
                    break;
                }
            }

            if (!añadido) {
                System.out.println("Tu inventario está lleno. No puedes coger más objetos.");
            }
        } else {
            System.out.println("No ves ningún **" + nombreObjeto + "** aquí.");
        }
    }

    /**
     * Muestra el contenido del inventario del jugador.
     */
    private static void mostrarInventario() {
        System.out.println("\n--- INVENTARIO ---");
        boolean vacio = true;
        for (String objeto : inventario) {
            if (objeto != null) {
                System.out.println("* " + objeto);
                vacio = false;
            }
        }
        if (vacio) {
            System.out.println("Tu inventario está vacío.");
        }
        System.out.println("------------------");
    }

    /**
     * Muestra la lista de comandos disponibles.
     */
    private static void mostrarAyuda() {
        System.out.println("\n--- COMANDOS DISPONIBLES ---");
        System.out.println("ayuda: Muestra esta lista de comandos.");
        System.out.println("mirar: Describe tu ubicación actual y los objetos visibles.");
        System.out.println("inventario: Muestra los objetos que llevas contigo.");
        System.out.println("ir derecha: Intenta moverse a la habitación de la derecha.");
        System.out.println("ir izquierda: Intenta moverse a la habitación de la izquierda.");
        System.out.println("coger [objeto]: Intenta recoger un objeto visible (ej: coger llave).");
        System.out.println("salir: Finaliza el juego.");
        System.out.println("--------------------------");
    }
}
