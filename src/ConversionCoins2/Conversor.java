package ConversionCoins2;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;

public class Conversor implements ExchangeRateProvider {
    private static final String API_KEY = "409a3a6a7d60abb97fc884ab";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/USD";

    @Override
    public double obtenerTasaCambio(String monedaDestino) {
        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest solicitud = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL))
                .build();

        try {
            HttpResponse<String> respuesta = cliente.send(solicitud, HttpResponse.BodyHandlers.ofString());
            Gson gson = new Gson();
            ExchangeRateApiResponse datos = gson.fromJson(respuesta.body(), ExchangeRateApiResponse.class);

            if ("success".equals(datos.result) && datos.conversion_rates != null) {
                return datos.getTasa(monedaDestino);
            } else {
                System.out.println("❌ Error en la respuesta de la API.");
            }

        } catch (IOException | InterruptedException e) {
            System.out.println("❌ Error al conectar con la API: " + e.getMessage());
        }
        return -1.0;
    }

    public static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void mostrarMenu() {
        limpiarPantalla();
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║      🌎 Bienvenido/a al Conversor de Moneda    ║");
        System.out.println("╠════════════════════════════════════════════════╣");
        System.out.println("║  1 - ARS  - Peso argentino                     ║");
        System.out.println("║  2 - BOB  - Boliviano boliviano                ║");
        System.out.println("║  3 - BRL  - Real brasileño                     ║");
        System.out.println("║  4 - CLP  - Peso chileno                       ║");
        System.out.println("║  5 - COP  - Peso colombiano                    ║");
        System.out.println("║  6 - USD  - Dólar estadounidense               ║");
        System.out.println("║  0 - Salir                                     ║");
        System.out.println("╚════════════════════════════════════════════════╝");
        System.out.print("👉 Ingrese una opción: ");
    }

    public static String obtenerCodigoMoneda(int opcion) {
        return switch (opcion) {
            case 1 -> "ARS";
            case 2 -> "BOB";
            case 3 -> "BRL";
            case 4 -> "CLP";
            case 5 -> "COP";
            case 6 -> "USD";
            default -> "";
        };
    }

    public double convertir(double cantidad, String monedaDestino) {
        double tasa = obtenerTasaCambio(monedaDestino);
        if (tasa > 0) {
            return cantidad * tasa;
        } else {
            System.out.println("⚠ No se pudo obtener la tasa de conversión.");
            return -1;
        }
    }
}