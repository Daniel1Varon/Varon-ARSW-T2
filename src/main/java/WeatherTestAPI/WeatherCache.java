package WeatherTestAPI;

/**
 * @author Daniel Varón
 */
public interface WeatherCache {
    boolean estaEnCache(String key);

    void cargarCache(String key, String data);

    WeatherKey devolverCache(String key);
}
