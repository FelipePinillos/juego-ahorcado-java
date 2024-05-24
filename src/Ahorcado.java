import java.util.Scanner;

public class Ahorcado {
    public static void main(String[] args) {
        System.out.println("¡Bienvenido al Juego del Ahorcado!");
        Scanner scanner = new Scanner(System.in);

        // Palabras para elegir
        String[] palabras = {"ahorcado", "computadora", "programacion", "java"};

        // Elegir una palabra aleatoria del arreglo
        String palabraBuscada = palabras[(int) (Math.random() * palabras.length)];

        int intentosMaximos = 6;
        int intentos = 0;
        boolean palabraEncontrada = false;
        char[] letrasEncontradas = new char[palabraBuscada.length()];
        for (int i = 0; i < palabraBuscada.length(); i++) {
            letrasEncontradas[i] = '-';
        }

        while (!palabraEncontrada && intentos < intentosMaximos) {
            System.out.println("Palabra a adivinar: " + String.valueOf(letrasEncontradas) + " (" + palabraBuscada.length() + " letras), tienes " + (intentosMaximos - intentos) + " intentos restantes.");
            System.out.println("Ingresa una letra: ");
            char letra = scanner.next().charAt(0);

            // Validar que se ingrese solo una letra
            if (!Character.isLetter(letra)) {
                System.out.println("Por favor, ingresa solo una letra.");
                continue; // Saltar esta iteración del bucle y pedir otra letra
            }

            letra = Character.toLowerCase(letra); // Convertir a minúscula para comparación

            boolean letraCorrecta = false;
            for (int i = 0; i < palabraBuscada.length(); i++) {
                if (palabraBuscada.charAt(i) == letra) {
                    letrasEncontradas[i] = letra;
                    letraCorrecta = true;
                }
            }

            if (!letraCorrecta) {
                intentos++;
                System.out.println("¡Letra incorrecta! Te quedan " + (intentosMaximos - intentos) + " intentos.");
            }

            if (String.valueOf(letrasEncontradas).equals(palabraBuscada)) {
                palabraEncontrada = true;
                System.out.println("¡Felicidades, has adivinado la palabra! La palabra es: " + palabraBuscada);
            }
        }

        if (!palabraEncontrada) {
            System.out.println("¡Oh no! Te has quedado sin intentos. La palabra era: " + palabraBuscada);
        }

        scanner.close();
    }
}
