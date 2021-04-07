package WeatherTestAPI;

import java.time.LocalDateTime;

/**
 * Clase la cual contiene la data de una ciudad y el tiempo de creación para control de cache.
 * @author Daniel Varón
 */
public class WeatherKey {
    public String data;
    public LocalDateTime tiempoDeCreacion;

    /**
     * asigna la data y el tiempo de creación.
     * @param data data de la ciudad a crear cache.
     */
    public WeatherKey(String data){
        this.data = data;
        tiempoDeCreacion = LocalDateTime.now();
    }

    public String getData(){
        return data;
    }
}
