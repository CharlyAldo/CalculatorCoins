package ConversionCoins2;

import java.util.Map;

public abstract class ApiResponseBase {
    public String base;
    public String date;
    public Map<String, Double> tasas;

    public abstract double getTasa(String moneda);
}