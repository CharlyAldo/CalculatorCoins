import ConversionCoins2.Conversor;

import java.util.Scanner;

public class ConversorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Conversor conversor = new Conversor();

        while (true) {
            Conversor.mostrarMenu();
            int opcion = scanner.nextInt();

            if (opcion == 0) {
                System.out.println("👋 ¡Gracias por usar el conversor!");
                break;
            }

            String monedaDestino = Conversor.obtenerCodigoMoneda(opcion);
            if (monedaDestino.isEmpty()) {
                System.out.println("❌ Opción no válida.");
                continue;
            }

            System.out.println("╔══════════════════════════════════════╗");
            System.out.println("║     💵 Conversión desde Dólares USD  ║");
            System.out.println("╚══════════════════════════════════════╝");
            System.out.print("🔹 Ingrese la cantidad en USD: ");
            double cantidad = scanner.nextDouble();

            double resultado = conversor.convertir(cantidad, monedaDestino);
            if (resultado >= 0) {
                System.out.println("╔═════════════════════════════════════════════════╗");
                System.out.printf ("║ ✅ %.2f USD equivale a %.2f %s%-10s║\n", cantidad, resultado, monedaDestino, "");
                System.out.println("╚═════════════════════════════════════════════════╝\n");
            } else {
                System.out.println("❌ Conversión fallida.");
            }
        }
        scanner.close();
    }
}