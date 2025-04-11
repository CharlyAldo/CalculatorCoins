package ConversionCoins2;

import java.util.Map;

public class ExchangeRateApiResponse extends ApiResponseBase {
    public String result;
    public Map<String, Double> conversion_rates;

    @Override
    public double getTasa(String moneda) {
        return conversion_rates.getOrDefault(moneda.toUpperCase(), -1.0);
    }
}