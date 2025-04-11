package ConversionCoins2;

public interface ExchangeRateProvider {
    double obtenerTasaCambio(String monedaDestino);
}
