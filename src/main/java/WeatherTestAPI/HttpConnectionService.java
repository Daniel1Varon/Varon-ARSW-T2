package WeatherTestAPI;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.stereotype.Service;

/**
 * @author Daniel Varón
 */
@Service
public class HttpConnectionService {
    /**
     *
     * @param city nombre de la ciudad a consultar.
     * @return la consulta en String
     * @throws UnirestException Es la excepción que lanza UniRest en caso de no encontrar la ciudad.
     */
    public String getWeatherByCity(String city) throws UnirestException {
        String url = String.format("http://api.openweathermap.org/data/2.5/weather?q=%s&appid=8ffd0606f44c447c1b92e7a22c2c1ea2", city);
        HttpResponse<String> response = Unirest
                .get(url)
                .asString();
        return response.getBody();
    }
}
