package WeatherTestAPI;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Daniel Varón
 */
@Service
public class WeatherCacheImp implements WeatherCache{
    private ConcurrentHashMap<String,WeatherKey> weatherCache;

    /**
     * Constructor del hash map que servirá de cache.
     */
    public WeatherCacheImp(){
        weatherCache = new ConcurrentHashMap<>();
    }

    /**
     * Valida si el valor esta en el cache.
     * @param key nombre de la ciudad a validar.
     * @return true si al obtener el dato de la llave es diferente a null, false de lo contario.
     */
    @Override
    public boolean estaEnCache(String key) {
        WeatherKey tmp = weatherCache.get(key);
        if (tmp!=null && LocalDateTime.now().isAfter(tmp.tiempoDeCreacion.plusMinutes(5))){
            weatherCache.remove(key);
        }
        return weatherCache.get(key)!=null;
    }

    /**
     * Carga un nuevo dato al cache.
     * @param key nombre de la ciudad a añadir.
     * @param data data de la ciudad a añadir.
     */
    @Override
    public void cargarCache(String key, String data) {
        weatherCache.put(key,new WeatherKey(data));
    }

    /**
     * busca el cache de una ciudad
     * @param key nombre de la ciudad a buscar.
     * @return
     */
    @Override
    public WeatherKey devolverCache(String key) {
        return weatherCache.get(key);
    }
}
