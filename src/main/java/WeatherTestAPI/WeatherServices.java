package WeatherTestAPI;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

/**
 * @author Daniel Varón
 */
@Service
@Configuration
public class WeatherServices {
    @Autowired
    HttpConnectionService httpConnectionService = null;

    @Autowired
    WeatherCache weatherCache = null;

    /**
     * Busca en el cache y si se encuentra devuelve esa data, si no está obtiene la data del unirest y lo crea en cache.
     * @param city nombre de la ciudad a consultar.
     * @return la consulta en String
     * @throws Exception en caso de que la ciudad no se encuentre.
     */
    public String getWeatherByCity(String city) throws Exception{
        String data="";
        try{
            if(weatherCache.estaEnCache(city)){
                data=weatherCache.devolverCache(city).getData();
            }
            else{
                data=httpConnectionService.getWeatherByCity(city);
                weatherCache.cargarCache(city,data);
            }
        } catch (UnirestException e){
            throw new Exception("No se pudo encontrar la ciudad especificada.");
        }
        return data;
    }
}
